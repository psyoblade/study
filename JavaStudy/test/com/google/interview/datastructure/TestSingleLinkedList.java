package com.google.interview.datastructure;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

class SingleLinkedList {
	SingleLinkedList next;
	Object data;
	public SingleLinkedList(Object data) {
		this.data = data;
	}
}

public class TestSingleLinkedList {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPrintOneToTenUsingSingleLinkedList() {
		SingleLinkedList head = new SingleLinkedList(0);
		SingleLinkedList prev = head;
		SingleLinkedList node;
		for (int i = 1; i <= 10; i++) {
			node = new SingleLinkedList(i);
			prev.next = node;
			prev = node;
		}
		SingleLinkedList curr = head.next;
		while (curr.next != null) {
			System.out.println(curr.data);
			curr = curr.next;
		}
		System.out.println(curr.data);
	}

}
