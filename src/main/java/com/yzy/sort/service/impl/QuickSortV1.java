package com.yzy.sort.service.impl;

import com.yzy.sort.service.Sort;

/**
 * 快读排序:通过一趟排序将待排记录分隔成独立的两部分，其中一部分记录的关键字均比另一部分的关键字小，则可分别对这两部分记录继续进行排序，以达到整个序列有序。
 * 		如何解决栈帧问题
 * 
 * @author yzy
 *
 */
public class QuickSortV1 implements Sort {
	int count = 0;
	int[] source = null;

	@Override
	public void orderAsc(int[] sort) {
		source = sort;
		sort(0, source.length - 1);
	}

	public void sort(int begin, int end) {
		boolean swap = false;
		int base = source[begin];
		int i = begin + 1;
		int j = end;
		synchronized (source) {
			out: for (; j >= i; j--) {
				if (source[j] < base) {
					swap = true;
					for (; i <= j; i++) {
						// 大于base的数需要交换
						if (source[i] > base) {
							swap(source, i, j);
							continue out;
						}

						if (j <= i) {
							// 已经执行完
							swap(source, begin, j);
						} else {
							continue;
						}
					}
				} else {
					if (swap && j <= i) {
						swap(source, begin, j);
					}
				}

			}
			/*
			 * System.out.println("[ " + (count++) + " ] index=" + j + " begin="
			 * + begin + " end=" + end + " " + Arrays.toString(source));
			 */
		}

		j++;

		// 处理左侧数组
		if (j - begin > 1) {
			sort(begin, j - 1);
		}
		// 处理右侧数组
		if (end - j + 1 > 1) {
			sort(j, end);
		}

	}

	private void swap(int[] source, int left, int right) {
		int temp = source[left];
		source[left] = source[right];
		source[right] = temp;
	}

}
