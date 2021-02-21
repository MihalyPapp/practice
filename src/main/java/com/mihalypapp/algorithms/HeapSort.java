package com.mihalypapp.algorithms;

public class HeapSort {

	public static void sort(int[] array) {
		buildMaxHeap(array);

		for(int i = array.length - 1; i > 0; i--) {
			swap(array, i, 0);
			heapify(array, 0, i);
		}
	}

	private static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
 
	private static void buildMaxHeap(int[] array) {
		for (int i = array.length / 2 - 1; i >= 0; i--)
			heapify(array, i, array.length);
	}

	private static void heapify(int[] array, int i, int n) {
		int left = i * 2 + 1;
		int right = i * 2 + 2;
		int largest = i;
		
		if(left < n && array[left] > array[largest])
			largest = left;
		if(right < n && array[right] > array[largest])
			largest = right;
		
		if(largest != i) {
			swap(array, i, largest);
			heapify(array, largest, n);
		}
	}

	
}
