package com.mihalypapp.algorithms;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class HeapSortTest {

	@Test
	void sort() {
		int array[] = { 1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17 };
		HeapSort.sort(array);
		assertArrayEquals(new int[] { 1, 3, 4, 5, 6, 8, 9, 10, 13, 15, 17 }, array);
	}

}
