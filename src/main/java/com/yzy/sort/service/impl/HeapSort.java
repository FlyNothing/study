package com.yzy.sort.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.yzy.sort.service.Sort;
import com.yzy.utils.SortUtils;

/**
 * 堆排序: 　　 a.将无需序列构建成一个堆，根据升序降序需求选择大顶堆或小顶堆; b.将堆顶元素与末尾元素交换，将最大元素"沉"到数组末端;
 * c.重新调整结构，使其满足堆定义，然后继续交换堆顶元素与当前末尾元素，反复执行调整+交换步骤，直到整个序列有序
 * 
 * @author yzy
 *
 */
public class HeapSort implements Sort {
	// 数组长度
	private int length = 0;
	// 二叉树深度
	private int depth = 0;
	// 非叶子节点最大长度
	private int maxParentLength = 0;
	// 数组
	private int[] source;
	// 已经完成排序的数量
	private int sortCnt;

	@Override
	public void orderAsc(int[] param) {
		// 初始化数据
		source = param;
		length = source.length;
		depth = getDepth(length + 1);
		maxParentLength = (int) Math.pow(2, depth - 1) - 1;
		sortCnt = 0;

		// 生成小碓顶
		while (sortCnt < length) {
			genMinHeapTop();
			SortUtils.swap(source, 0, length - 1 - sortCnt);
			sortCnt++;
		}
	}

	/**
	 * 生成小碓顶[所有非叶子节点]
	 * 
	 * @param calCnt
	 */
	private void genMinHeapTop() {
		for (int j = maxParentLength - 1; j >= 0; j--) {
			int lIndex = 2 * j + 1;
			if (lIndex < length - sortCnt) {// 存在左孩子
				if (source[lIndex] < source[j]) {
					// 交换父节点和左孩子
					swap(j, lIndex);
				}

				int rIndex = 2 * j + 2;
				if (rIndex < length - sortCnt) { // 存在右孩子
					if (source[rIndex] < source[j]) {
						// 交换父节点和右孩子
						swap(j, rIndex);
					}
				}
			}
		}
	}

	/**
	 * 交互并重排交换节点的所有子树
	 * 
	 * @param pIndex
	 *            父节点下标
	 * @param cIndex
	 *            子节点下标
	 */
	private void swap(int pIndex, int cIndex) {
		SortUtils.swap(source, pIndex, cIndex);
		// 交换叶子节点，无需处理
		if (cIndex >= maxParentLength) {
			return;
		}

		// 交换节点非叶子节点，需要重排子树
		List<Integer> calcList = new ArrayList<Integer>();
		calcList.add(cIndex);
		while (calcList.size() > 0) {
			calcList = rearrange(calcList);
		}
	}

	private List<Integer> rearrange(List<Integer> calcList) {
		List<Integer> rtList = new ArrayList<>();
		int maxLength = length - sortCnt;
		for (int j = 0; j < calcList.size() && j < maxParentLength; j++) {
			int lIndex = 2 * calcList.get(j) + 1;

			if (lIndex < maxLength) {// 存在左孩子
				if (source[lIndex] < source[calcList.get(j)]) {
					// 交换父节点和左孩子
					SortUtils.swap(source, lIndex, calcList.get(j));
					rtList.add(lIndex);
				}

				int rIndex = 2 * calcList.get(j) + 2;
				if (rIndex < maxLength) { // 存在右孩子
					if (source[rIndex] < source[calcList.get(j)]) {
						// 交换父节点和右孩子
						SortUtils.swap(source, rIndex, calcList.get(j));
						rtList.add(rIndex);
					}
				}
			}
		}
		return rtList;
	}

	public int getDepth(int length) {
		double maxDindex = Math.log10(length) / Math.log10(2);
		int maxIindex = (int) maxDindex;
		int depth = maxIindex == maxDindex ? maxIindex : maxIindex + 1;
		return depth;
	}

}
