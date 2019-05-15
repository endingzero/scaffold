# scaffold

## 导出大数量excel优化
背景:随着报表数据的增多,全表导出造成OOM,需要对现有系统的导出excel功能做进一步优化.
现状:通过查询出所有数据data,再查询出对应的需要转换的字段的字典,对data进行for循环处理数据,采用的是poi的XSSFworkbook,再对data数据for循环处理写到workbook。
优化:
* 对data进行了太多次for循环处理,而且一次性加载太多数据容易造成OOM,mysql本身支持流式查询,上网查了下mybatis的流式处理可以使用ResultHandler来进行实现。多次的for循环处理数据可以直接在实现handleResult()方法中进行优化处理。
* poi的XSSFworkbook支持的数据量不大,网上支持大数据的大都通过SXSSFworkbook,在new的时候指定内存保留的数据条数,可以避免造成OOM,而且也可以把写到workbook的操作也写到handleResult中。

## 使用docker安装redis

## code生成器
###code规则
背景:大多数业务都要求生成编码来唯一识别每一条数据,根据需求有以下几种情况.
1. 固定长度补0的自增长编号
2. 不补0的自增长编号
3. 时间戳+第一种情况
4. 时间戳+第二种情况
5. 前缀+第一种情况
6. 前缀+第二种情况
7. 前缀+时间戳+第一种情况
8. 前缀+时间戳+第二种情况
根据情况,觉得比较适合策略模式,可以根据不同的策略选择不同的生成方式。
###采用本地缓存加redis缓存来存储和获取code,具体实现情况如下
设置缓存对象{
    id;
    name;
    max;
    maxValue;
    step;
    numLength;
    prefix;
    type;
    currentValue;
}
* 本地缓存和redis存储缓存对象
* currentValue + step > maxValue 的时候更新本地缓存和redis存储缓存对象以及更新到数据库(maxValue = currentValue + fetchSize)
* 每次获取之后更新本地缓存的currentValue
* 假设内存数据丢失的情况下,获取数据库currentValue + fetchSize作为当前的最大值

