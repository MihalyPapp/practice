package com.mihalypapp.algorithms;

public class HeapSort {

	public static void sort(int[] array) {
		buildMaxHeap(array);
		
		for(int i = array.length - 1; i > 0; i--) {
			int temp = array[i];
			array[i] = array[0];
			array[0] = temp;
			heapify(array, 0, i - 1);
		}
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
			int temp = array[i];
			array[i] = array[largest];
			array[largest] = temp;
			
			heapify(array, largest, n);
		}
	}

	
}
