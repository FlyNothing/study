package com.yzy.sort.service.impl;

import com.yzy.sort.service.Sort;

/**
 * 归并排序:将已有序的子序列合并，得到完全有序的序列；即先使每个子序列有序，再使子序列段间有序。若将两个有序表合并成一个有序表，称为2-路归并
 * 
 * @author yzy
 *
 */
public class MergeSort implements Sort {

	@Override
	public void orderAsc(int[] source) {
		int length = source.length;
		int step = 1;
		while (true) {
			for (int i = 0; i < length; i += 2 * step) {
				int[] left = null;
				int[] right = null;
				if (i + step * 2 <= length - 1) {
					left = new int[step];
					right = new int[step];
					System.arraycopy(source, i, left, 0, step);
					System.arraycopy(source, i + step, right, 0, step);
				} else if (i + step <= length - 1) {
					left = new int[step];
					int rightLength = length - (i + step);
					right = new int[rightLength];
					System.arraycopy(source, i, left, 0, step);
					System.arraycopy(source, i + step, right, 0, rightLength);
				} else if (i + step > length - 1) {
					int leftLength = length - i;
					left = new int[leftLength];
					System.arraycopy(source, i, left, 0, leftLength);
					right = new int[0];
				}
				System.arraycopy(merge(left, right), 0, source, i, left.length
						+ right.length);
			}
			step *= 2;
			if (step >= length) {
				break;
			}
		}
	}

	/**
	 * 合并两个有序数组
	 * 
	 * @param left
	 * @param right
	 * @return
	 */
	public int[] merge(int[] left, int[] right) {
		int leftLength = left.length;
		if (leftLength == 0) {
			return left;
		}

		int rightLength = right.length;
		int[] ret = new int[leftLength + rightLength];

		try {

			int rightIndex = 0;
			int retIndex = -1;
			for (int i = 0; i <= leftLength;) {
				retIndex++;
				if (i >= leftLength) {
					ret[retIndex] = right[rightIndex];
					rightIndex++;
					continue;
				}

				if (rightIndex < rightLength) {
					if (left[i] <= right[rightIndex]) {
						// 取left[i]
						ret[retIndex] = left[i];
						i++;
						continue;
					} else {
						ret[retIndex] = right[rightIndex];
						rightIndex++;
						continue;
					}
				}
				ret[retIndex] = left[i];
				i++;
			}

			return ret;
		} catch (Exception e) {
			return ret;
		}
	}

}
