package com.yzy.sort.service.impl;

import com.yzy.sort.service.Sort;

/**
 * 冒泡排序:通过与相邻元素的大小比较和交换来把数交换到最前面
 * 
 * @author yzy
 *
 */
public class BubbleSort implements Sort {

	@Override
	public void orderAsc(int[] source) {
		int length = source.length;
		int temp = 0;
		// 大的往后
		for (int i = 0; i < length; i++) {
			for (int j = 1; j < length - i; j++) {
				if (source[j] < source[j - 1]) {
					temp = source[j];
					source[j] = source[j - 1];
					source[j - 1] = temp;
				}
			}
		}

		/*// 小的往前
		for (int i = length; i > 0; i--) {
			for (int j = length - 1; j > length - i; j--) {
				if (source[j] < source[j - 1]) {
					temp = source[j];
					source[j] = source[j - 1];
					source[j - 1] = temp;
				}
			}
		}*/
		// System.out.println(Arrays.toString(source));

	}

}
