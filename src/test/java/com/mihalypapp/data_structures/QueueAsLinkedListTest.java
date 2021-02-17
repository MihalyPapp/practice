package com.mihalypapp.data_structures;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class QueueAsLinkedListTest {

	QueueAsLinkedList queue;
	
	@BeforeEach
	void init() {
		queue = new QueueAsLinkedList();
	}
	
	@Test
	void test() {
		queue.enQueue(10);
		assertEquals(10, queue.deQueue());
		queue.enQueue(10);
		queue.enQueue(12);
		queue.enQueue(14);
		assertEquals(10, queue.deQueue());
		assertEquals(12, queue.deQueue());
		queue.enQueue(13);
		queue.enQueue(14);
		queue.enQueue(15);
		queue.enQueue(12);
		assertEquals(14, queue.deQueue());
		assertEquals(13, queue.deQueue());
		assertEquals(14, queue.deQueue());
		assertEquals(15, queue.deQueue());
		assertEquals(12, queue.deQueue());
	}

}
