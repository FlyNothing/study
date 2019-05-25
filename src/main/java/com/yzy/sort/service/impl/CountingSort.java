package com.yzy.sort.service.impl;

import com.yzy.sort.service.Sort;

/**
 * 计数排序: 计数排序是一个非基于比较的排序算法，该算法于1954年由 Harold H. Seward
 * 提出。它的优势在于在对一定范围内的整数排序时，它的复杂度为Ο(n+k)（其中k是整数的范围），快于任何比较排序算法。 当然这是一种牺牲空间换取时间的做法
 * ，而且当O(k)>O(n*log(n))的时候其效率反而不如基于比较的排序（基于比较的排序的时间复杂度在理论上的下限是O(n*log(n)),
 * 如归并排序，堆排序）
 * 
 * @author yzy
 *
 */
public class CountingSort implements Sort {

	@Override
	public void orderAsc(int[] source) {
		int length = source.length, min = source[0], max = source[0];
		// 获取最大值最小值
		for (int i = 1; i < length; i++) {
			if (source[i] < min) {
				min = source[i];
			}
			if (source[i] > max) {
				max = source[i];
			}
		}

		// 从最小到最大值计数
		int[] count = new int[max - min + 1];
		for (int i = 0; i < length; i++) {
			count[source[i] - min]++;
		}

		// 计算小于i的数量order[i]
		for (int i = 1; i < count.length; i++) {
			count[i] += count[i - 1];
		}

		// 开始排序
		int[] sortSource = new int[length];
		for (int i = 0; i < length; i++) {
			sortSource[count[source[i] - min] - 1] = source[i];
			count[source[i] - min]--;
		}

		// 排序完成
		source = sortSource;

	}

}
