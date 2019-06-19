package com.zjw.scaffold;

/**
 * @program scaffold
 * @description:二分查找法（有序的数组）
 * @author: zhuangjiewei
 * @create: 2019/06/19 20:05
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {1,3,5,7,9,11};
        int result = binarySearch(arr,3,arr.length);
        System.out.printf(String.valueOf(result));

    }

    public static int binarySearch(int[] arr, long searchKey, int n) {
        int low = 0;
        int high = n;
        int mid;

        while(true) {
            mid = (high + low) / 2;
            if(arr[mid] == searchKey) {
                return mid;
            }else if(low > high) {
                return -1;
            }else{
                if(arr[mid] > searchKey) {
                    high = mid - 1;
                }
                if(arr[mid] < searchKey) {
                    low = mid + 1;
                }
            }
        }
    }
}
