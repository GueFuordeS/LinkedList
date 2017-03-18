package linkedListTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import linkedList.LinkedList;

public class LinkedListTest {
	private LinkedList<Integer> linkedList;
	
	@Before
	public void setUp() {
		new LinkedList<>();
	}
	
	@Test
	public void addTest() {
		//linkedList.add(4);
		System.out.println(linkedList);
	}

}
