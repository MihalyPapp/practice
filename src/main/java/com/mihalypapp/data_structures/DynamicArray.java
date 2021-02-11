package com.mihalypapp.data_structures;

import java.util.Iterator;

public class DynamicArray<T> implements Iterable<T> {

	private T[] array;
	private int count;
	private int size;

	public DynamicArray() {
		clear();
	}
	
	@SuppressWarnings("unchecked")
	public void clear() {
		this.array = (T[]) new Object[1];
		this.count = 0;
		this.size = 1;
	}

	public int size() {
		return this.count;
	}

	public void add(T data) {
		if (count == size)
			doublesTheArraySize();
		array[count] = data;
		count++;
	}
	
	public void add(int pos, T data) {
		if (count == size || pos > count) {
			doublesTheArraySize();
			while(size < pos + 1)
				doublesTheArraySize();
		}
		for(int i = count; i > pos; i--) {
			array[i] = array[i - 1];
		}
		array[pos] = data;
		if(pos >= count)
			count = pos + 1;
		else
			count++;
	}

	public T get(int i) {
		if (i >= count)
			IndexOutOfBoundsExceptionAt(i);

		return array[i];
	}

	public void remove() {
		if (count == 0)
			IndexOutOfBoundsExceptionAt(0);

		array[count - 1] = null;
		count--;
	}

	public void removeAt(int pos) {
		if (count == 0 || pos >= count || pos < 0)
			IndexOutOfBoundsExceptionAt(pos);

		for (int i = pos; i < count - 1; i++) {
			array[i] = array[i + 1];
		}
		array[count - 1] = null;
		count--;
	}
		
	public int getAllocatedSize() {
		return size;
	}
	
	public void shrinkTheArraySize() {
		@SuppressWarnings("unchecked")
		T[] temp = (T[]) new Object[count];
		for (int i = 0; i < count; i++) {
			temp[i] = array[i];
		}
		array = temp;
		size = count;
	}

	private void doublesTheArraySize() {
		@SuppressWarnings("unchecked")
		T[] temp = (T[]) new Object[size * 2];
		for (int i = 0; i < size; i++) {
			temp[i] = array[i];
		}
		array = temp;
		size *= 2;
	}

	private void IndexOutOfBoundsExceptionAt(int i) {
		throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + count);
	}

	@Override
	public Iterator<T> iterator() {
		Iterator<T> iterator = new Iterator<T>() {
			int currentIndex = 0;

			@Override
			public boolean hasNext() {
				return currentIndex < count && currentIndex != size;
			}

			@Override
			public T next() {
				return array[currentIndex++];
			}
		};

		return iterator;
	}

	public T[] getArray() {
		shrinkTheArraySize();
		return this.array;
	} 

}
