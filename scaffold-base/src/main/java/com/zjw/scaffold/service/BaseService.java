package com.zjw.scaffold.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @program scaffold
 * @description: 基础服务接口
 * @author: zhuangjiewei
 * @create: 2019/03/28 16:11
 */
public interface BaseService<T> extends IService<T> {


    default QueryWrapper<T> newQueryWrapper() {
        return new QueryWrapper();
    }

    default T unique(String column, String value) {
        return (T) this.selectOne((Wrapper)(new QueryWrapper()).eq(column, value));
    }

    default List<T> listByProperty(String column, Object value) {
        return this.selectList((Wrapper)(new QueryWrapper()).eq(column, value));
    }

    default List<T> selectList() {
        return this.list();
    }

    @Transactional(
            rollbackFor = {Exception.class}
    )
    default boolean insert(T entity) {
        return this.save(entity);
    }

    @Transactional(
            rollbackFor = {Exception.class}
    )
    default boolean insertAllColumn(T entity) {
        return this.save(entity);
    }

    @Transactional(
            rollbackFor = {Exception.class}
    )
    default boolean insertBatch(List<T> entityList) {
        return this.insertBatch(entityList, 30);
    }

    @Transactional(
            rollbackFor = {Exception.class}
    )
    default boolean insertBatch(List<T> entityList, int batchSize) {
        return this.saveBatch(entityList, batchSize);
    }

    @Transactional(
            rollbackFor = {Exception.class}
    )
    default boolean insertOrUpdateBatch(List<T> entityList) {
        return this.saveOrUpdateBatch(entityList, 30);
    }

    @Transactional(
            rollbackFor = {Exception.class}
    )
    default boolean insertOrUpdateBatch(List<T> entityList, int batchSize) {
        return this.saveOrUpdateBatch(entityList, batchSize);
    }

    @Transactional(
            rollbackFor = {Exception.class}
    )
    default boolean insertOrUpdateAllColumnBatch(List<T> entityList) {
        return this.insertOrUpdateBatch(entityList);
    }

    @Transactional(
            rollbackFor = {Exception.class}
    )
    default boolean insertOrUpdateAllColumnBatch(List<T> entityList, int batchSize) {
        return this.saveOrUpdateBatch(entityList, batchSize);
    }

    @Transactional(
            rollbackFor = {Exception.class}
    )
    default boolean deleteById(Serializable id) {
        return this.removeById(id);
    }

    @Transactional(
            rollbackFor = {Exception.class}
    )
    default boolean deleteByMap(Map<String, Object> columnMap) {
        return this.removeByMap(columnMap);
    }

    @Transactional(
            rollbackFor = {Exception.class}
    )
    default boolean delete(Wrapper<T> wrapper) {
        return this.remove(wrapper);
    }

    @Transactional(
            rollbackFor = {Exception.class}
    )
    default boolean deleteBatchIds(Collection<? extends Serializable> idList) {
        return this.removeByIds(idList);
    }

    @Transactional(
            rollbackFor = {Exception.class}
    )
    default boolean updateAllColumnById(T entity) {
        return this.updateById(entity);
    }

    @Transactional(
            rollbackFor = {Exception.class}
    )
    default boolean updateBatchById(List<T> entityList) {
        return this.updateBatchById(entityList, 30);
    }

    @Transactional(
            rollbackFor = {Exception.class}
    )
    default boolean updateAllColumnBatchById(List<T> entityList) {
        return this.updateBatchById(entityList);
    }

    @Transactional(
            rollbackFor = {Exception.class}
    )
    default boolean updateAllColumnBatchById(List<T> entityList, int batchSize) {
        return this.updateBatchById(entityList, 30);
    }

    @Transactional(
            rollbackFor = {Exception.class}
    )
    default boolean insertOrUpdate(T entity) {
        return this.saveOrUpdate(entity);
    }

    @Transactional(
            rollbackFor = {Exception.class}
    )
    default boolean insertOrUpdateAllColumn(T entity) {
        return this.saveOrUpdate(entity);
    }

    default T selectById(Serializable id) {
        return this.getById(id);
    }

    default List<T> selectBatchIds(Collection<? extends Serializable> idList) {
        return new ArrayList(this.listByIds(idList));
    }

    default List<T> selectByMap(Map<String, Object> columnMap) {
        return new ArrayList(this.listByMap(columnMap));
    }

    default T selectOne(Wrapper<T> wrapper) {
        return this.getOne(wrapper, false);
    }

    default T selectOne(T entity) {
        return (T) this.selectOne((Wrapper)(new QueryWrapper(entity)));
    }

    default Map<String, Object> selectMap(Wrapper<T> wrapper) {
        return this.getMap(wrapper);
    }

    default Object selectObj(Wrapper<T> wrapper) {
        return this.getOne(wrapper);
    }

    default int selectCount(Wrapper<T> wrapper) {
        return this.count(wrapper);
    }

    default List<T> selectList(Wrapper<T> wrapper) {
        return this.list(wrapper);
    }

    default IPage<T> selectPage(IPage<T> page) {
        return this.page(page);
    }

    default List<Map<String, Object>> selectMaps(Wrapper<T> wrapper) {
        return this.listMaps(wrapper);
    }

    default List<Object> selectObjs(Wrapper<T> wrapper) {
        return this.listObjs(wrapper);
    }

    default IPage<T> selectPage(IPage<T> page, Wrapper<T> wrapper) {
        return this.page(page, wrapper);
    }
}
