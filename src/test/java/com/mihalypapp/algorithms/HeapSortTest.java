package com.mihalypapp.algorithms;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;

import org.junit.jupiter.api.Test;

class HeapSortTest {

	@Test
	void sort() {
		int array[] = { 355, 222, 886, 989, 21, 866, 242, 765, 387, 337, 141, 613, 576, 85, 284, 930, 144, 840, 804, 336, 667, 638, 413, 487 };
		HeapSort.sort(array);
		assertArrayEquals(new int[] { 21, 85, 141, 144, 222, 242, 284, 336, 337, 355, 387, 413, 487, 576, 613, 638, 667, 765, 804, 840, 866, 886, 930, 989 }, array);
	}

}
