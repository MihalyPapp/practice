package com.mihalypapp.data_structures;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class QueueTest {

	Queue queue;
	
	@BeforeEach
	void init() {
		queue = new Queue();
	}
	
	@Test
	void test() {
		queue.enQueue(5);
		queue.enQueue(6);
		queue.enQueue(5);
		queue.enQueue(4);
		queue.enQueue(4);
		queue.enQueue(10);
		assertEquals(5, queue.deQueue());
		assertEquals(6, queue.deQueue());
		assertEquals(5, queue.deQueue());
		assertEquals(4, queue.deQueue());
		assertEquals(4, queue.deQueue());
		assertEquals(10, queue.deQueue());
	}


}
