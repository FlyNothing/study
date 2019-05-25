package com.yzy.sort.service.impl;

import com.yzy.sort.service.Sort;

/**
 * 希尔排序:简单插入排序的改进版。它与插入排序的不同之处在于，它会优先比较距离较远的元素。希尔排序又叫缩小增量排序。
 * 增量选择：
 * 	 	n/(2^i)
 * 	 	2^-1
 * 		(3**(t-k)-1)/2
 * 		9*4^i-9*2^i+1 或者是 4^i-3*2^i+1
 * @author yzy
 *
 */
public class ShellSort implements Sort {

	@Override
	public void orderAsc(int[] source) {
		int length = source.length;
		double maxDindex = Math.log10(length + 1) / Math.log10(2);
		int index = (int) maxDindex;
		while (index > 0) {
			int step = (int) Math.pow(2,index) - 1;
			for (int i = 0; i < step; i++) {
				for (int j = i + step; j < length; j += step) {
					int temp = source[j];
					int tempIndex = -1;
					for (int k = j - step; k >= i; k -= step) {
						if (temp < source[k]) {
							source[k + step] = source[k];
							tempIndex = k;
						} else {
							tempIndex = k + step;
							break;
						}
					}
					source[tempIndex] = temp;
				}
			}
			index--;
		}
//		System.out.println(Arrays.toString(source));
	}

}
