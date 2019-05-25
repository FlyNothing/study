package com.yzy.utils;

public class SortUtils {
	public static void swap(int[] source, int left, int right) {
		int temp = source[left];
		source[left] = source[right];
		source[right] = temp;
	}
}
