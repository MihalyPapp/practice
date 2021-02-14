package com.mihalypapp.data_structures;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StackAsLinkedListTest {

	StackAsLinkedList stack;
	
	@BeforeEach
	void before() {
		stack = new StackAsLinkedList();
	}
	
	@Test
	void testSize() {
		assertEquals(0, stack.size());
	}
	
	@Test
	void testPush() {
		stack.push(244);
		assertEquals(1, stack.size());
		assertEquals(244, stack.pop());
		assertEquals(0, stack.size());
		stack.push(233);
		stack.push(2656);
		stack.push(276);
		stack.push(2);
		assertEquals(4, stack.size());
		assertEquals(2, stack.pop());
		assertEquals(276, stack.pop());
		assertEquals(2656, stack.pop());
		assertEquals(233, stack.pop());
		assertEquals(0, stack.size());
	}
	
	@Test
	void testPeek() {
		stack.push(244);
		assertEquals(244, stack.peek());
		assertEquals(1, stack.size());
	}


}
