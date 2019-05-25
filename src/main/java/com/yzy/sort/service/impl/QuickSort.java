package com.yzy.sort.service.impl;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import com.yzy.sort.service.Sort;
import com.yzy.utils.SortUtils;

/**
 * 快读排序:通过一趟排序将待排记录分隔成独立的两部分，其中一部分记录的关键字均比另一部分的关键字小，则可分别对这两部分记录继续进行排序，以达到整个序列有序。
 * 如何解决栈帧问题
 * 
 * @author yzy
 *
 */
public class QuickSort implements Sort {
	int count = 0;
	int[] source = null;
	BlockingQueue<String> queue = new ArrayBlockingQueue<>(1000000, true);

	@Override
	public void orderAsc(int[] sort) {
		source = sort;
		queue.offer(0 + "," + (source.length - 1));

		while (!queue.isEmpty()) {
			String poll = queue.poll();
			String[] split = poll.split(",");
			int begin = Integer.parseInt(split[0]);
			int end = Integer.parseInt(split[1]);
			sort(begin, end);
		}
	}

	public void sort(int begin, int end) {
		boolean swap = false;
		int base = source[begin];
		int i = begin + 1;
		int j = end;

		out: for (; j >= i; j--) {
			if (source[j] < base) {
				swap = true;
				for (; i <= j; i++) {
					// 大于base的数需要交换
					if (source[i] > base) {
						SortUtils.swap(source, i, j);
						continue out;
					}

					if (j <= i) {
						// 已经执行完
						SortUtils.swap(source, begin, j);
					} else {
						continue;
					}
				}
			} else {
				if (swap && j <= i) {
					SortUtils.swap(source, begin, j);
				}
			}

		}
		j++;

		// 处理左侧数组
		if (j - begin > 1) {
			queue.offer(begin + "," + (j - 1));
		}
		if (end - j + 1 > 1) {
			queue.offer(j + "," + end);
		}

	}

}
