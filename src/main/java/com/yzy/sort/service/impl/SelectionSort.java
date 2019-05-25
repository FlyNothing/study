package com.yzy.sort.service.impl;

import com.yzy.sort.service.Sort;

/**
 * 选择排序:在未排序序列选择最大或最小数放入最前面，重复操作直到所有序列均完成选择
 * 
 * @author yzy
 *
 */
public class SelectionSort implements Sort {

	@Override
	public void orderAsc(int[] source) {
		int length = source.length;
		int temp = 0;
		for (int i = 0; i < length; i++) {
			int minIndex = i;
			int minValue = source[i];
			for (int j = i + 1; j < length; j++) {
				if (source[j] < minValue) {
					minValue = source[j];
					minIndex = j;
				}
			}
			if (minIndex > i) {
				temp = source[i];
				source[i] = source[minIndex];
				source[minIndex] = temp;
			}
		}
//		System.out.println(Arrays.toString(source));
	}

}
