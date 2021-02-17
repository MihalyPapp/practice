package com.mihalypapp.data_structures;

import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;

public class QueueAsCircularArray {

	private int array[];
	private int front;
	private int rear;
	private int count;
	
	public QueueAsCircularArray(int N) {
		array = new int[N];
		front = 0;
		rear = -1;
		count = 0;
	}
	
	public void enQueue(int value) {
		if(isFull()) throw new BufferOverflowException();
		rear = ++rear % array.length;
		array[rear] = value;
		count++;
	}

	public int deQueue() {
		if(isEmpty()) throw new BufferUnderflowException();
		int value = array[front];
		if(rear == front) {
			front = 0;
			rear = -1;
		} else {
			front = ++front % array.length;
		}
		count--;
		return value;
	}
	
	private boolean isEmpty() {
		return count == 0;
	}

	private boolean isFull() {
		return count == array.length;
	}

	public void print() {
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	
}
