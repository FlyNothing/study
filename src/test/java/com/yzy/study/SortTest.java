package com.yzy.study;

import java.util.Random;

import org.junit.Test;

import com.yzy.sort.service.Sort;
import com.yzy.sort.service.impl.HeapSort;

public class SortTest {
	// int[] source = {9,8,7,6,5,4,3,2,1};
	// int[] source = {3,1,5,4,9,6,8,2,7};

	@Test
	public void test() {
		int n = 10;
		Random r = new Random();
		int[] source = new int[n];
		for (int i = 0; i < n; i++) {
			source[i] = r.nextInt(10) + 1;
		}

		// long nano1 = System.nanoTime();
		// Sort sort = new BubbleSort();
		// Sort sort = new SelectionSort();
		// Sort sort = new InsertionSort();
		// Sort sort = new ShellSort();
		// Sort sort = new MergeSort();
		// Sort sort = new QuickSort();
		Sort sort = new HeapSort();
		// Sort sort = new CountingSort();
		long millis1 = System.currentTimeMillis();
		sort.orderAsc(source);
		// int[] source1 = { 5, 6, 7, 8, 9 };
		// int[] source2 = { 4 };
		// System.out.println(Arrays.toString(sort.merge(source1, source2)));
		// long nano2 = System.nanoTime();
		long millis2 = System.currentTimeMillis();
		// System.out.println("-----" + (nano2 - nano1) + "-----");
		System.out.println("-----" + (millis2 - millis1) + "-----");

	}
}
