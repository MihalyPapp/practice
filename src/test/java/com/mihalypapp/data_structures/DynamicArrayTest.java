package com.mihalypapp.data_structures;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DynamicArrayTest {

	private DynamicArray<String> dynamicArray;

	@BeforeEach
	void beforeEach() {
		dynamicArray = new DynamicArray<>();
	}

	@Test
	void testAdd() {
		dynamicArray.add("One");
		dynamicArray.add("Two");
		dynamicArray.add("Three");
		assertArrayEquals(new String[] { "One", "Two", "Three" }, dynamicArray.getArray());
	}

	@Test
	void testAddAt() {
		dynamicArray.add(1, "One");
		dynamicArray.add(2, "Two");
		dynamicArray.add(3, "Three");
		dynamicArray.add(2, "Something");
		assertArrayEquals(new String[] { null, "One", "Something", "Two", "Three" }, dynamicArray.getArray());
	}

	@Test
	void testGet() {
		dynamicArray.add(0, "One");
		dynamicArray.add(2, "Two");
		dynamicArray.add("Three");
		assertEquals("Two", dynamicArray.get(2));
	}
	
	@Test
	void testGetThrowsException() {
		assertThrows(IndexOutOfBoundsException.class, () -> dynamicArray.get(0));
	}
	
	@Test
	void testRemove() {
		assertThrows(IndexOutOfBoundsException.class, () -> dynamicArray.remove());
		assertThrows(IndexOutOfBoundsException.class, () -> dynamicArray.removeAt(0));
		assertThrows(IndexOutOfBoundsException.class, () -> dynamicArray.removeAt(1));
		dynamicArray.add("One");
		dynamicArray.add("Two");
		dynamicArray.add("Three");
		dynamicArray.add("Four");
		dynamicArray.remove();
		dynamicArray.removeAt(1);
		assertArrayEquals(new String[] { "One", "Three" }, dynamicArray.getArray());
	}
	
	@Test
	void testAllocatedSize( ) {
		assertEquals(1, dynamicArray.getAllocatedSize());
		dynamicArray.add("Two");
		assertEquals(1, dynamicArray.getAllocatedSize());
		dynamicArray.add(4, "Two");
		assertEquals(8, dynamicArray.getAllocatedSize());
	}

	@Test
	void testSize() {

		assertEquals(0, dynamicArray.size());
	}

}
