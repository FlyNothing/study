package com.yzy.sort.service.impl;

import com.yzy.sort.service.Sort;

/**
 * 插入排序: 构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。
 * 
 * @author yzy
 *
 */
public class InsertionSort implements Sort {

	@Override
	public void orderAsc(int[] source) {
		int length = source.length;
		int temp = 0;
		int tempIndex = 0;
		for (int i = 1; i < length; i++) {
			temp = source[i];
			for (int j = i - 1; j >= 0; j--) {
				if (temp < source[j]) {
					source[j + 1] = source[j];
					tempIndex = j;
				} else {
					tempIndex = j + 1;
					break;
				}
			}

			source[tempIndex] = temp;
		}
//		System.out.println(Arrays.toString(source));
	}

}
