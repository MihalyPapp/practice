package com.mihalypapp.data_structures;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class QueueAsCircularArrayTest {

	QueueAsCircularArray queue;
	
	@BeforeEach
	void init() {
		queue = new QueueAsCircularArray(4);
	}
	
	@Test
	void test() {
		queue.enQueue(5);
		queue.enQueue(6);
		queue.enQueue(5);
		queue.enQueue(3);
		assertEquals(5, queue.deQueue());
		assertEquals(6, queue.deQueue());
		assertEquals(5, queue.deQueue());
		assertEquals(3, queue.deQueue());
		queue.enQueue(5);
		queue.enQueue(4);
		assertEquals(5, queue.deQueue());
		queue.enQueue(7);
		queue.enQueue(8);
		queue.enQueue(9);
		assertEquals(4, queue.deQueue());
		assertEquals(7, queue.deQueue());
		assertEquals(8, queue.deQueue());
		assertEquals(9, queue.deQueue());
		queue.enQueue(7);
		queue.enQueue(8);
		queue.enQueue(3);
		assertEquals(7, queue.deQueue());
		assertEquals(8, queue.deQueue());
		queue.enQueue(5);
		queue.enQueue(4);
		queue.enQueue(5);
		assertEquals(3, queue.deQueue());
		assertEquals(5, queue.deQueue());
		assertEquals(4, queue.deQueue());
		assertEquals(5, queue.deQueue());
	}

}
