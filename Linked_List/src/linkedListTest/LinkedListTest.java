package linkedListTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import linkedList.LinkedList;

/**
 * 
 * Esperando implementacao da classe 
 * para poder dar inicio aos testes
 * 
 * @author Gabriel Fernandes
 */
public class LinkedListTest {
	private LinkedList<String> linkedList;
	
	@Before
	public void setUp() {
		linkedList = new LinkedList<>("hyejeong");
	}
	
	@Test
	public void addTest() {
		linkedList.add("yuna");
		assertEquals("[hyejeong, yuna]",linkedList.toString());
		linkedList.add("seolhyun");
		assertEquals("[hyejeong, yuna, seolhyun]",linkedList.toString());
		linkedList.add("choa");
		assertEquals("[hyejeong, yuna, seolhyun, choa]",linkedList.toString());
		linkedList.add("chanmi");
		assertEquals("[hyejeong, yuna, seolhyun, choa, chanmi]",linkedList.toString());
		linkedList.add("jimin");
		assertEquals("[hyejeong, yuna, seolhyun, choa, chanmi, jimin]",linkedList.toString());
		linkedList.remByElem("yuna");
		assertEquals("[hyejeong, seolhyun, choa, chanmi, jimin]",linkedList.toString());
		linkedList.remByElem("seolhyun");
		assertEquals("[hyejeong, choa, chanmi, jimin]",linkedList.toString());
		linkedList.remByElem("choa");
		assertEquals("[hyejeong, chanmi, jimin]",linkedList.toString());
		linkedList.remByElem("chanmi");
		assertEquals("[hyejeong, jimin]", linkedList.toString());
		linkedList.remByElem("jimin"); // problemas quando o elemento a remover ja eh o ultimo, por resolver
		assertEquals("[hyejeong]",linkedList.toString());
	}
	
	@Test
	public void toStringTest() {
		assertEquals("[hyejeong]", linkedList.toString());
	}
	
	@Test
	public void getIndexTest() {
		linkedList.add("chorong");
		System.out.println(linkedList);
		System.out.println(linkedList.getIndex("chorong"));
	}
	
	@Test
	public void lengthTest() {
		assertEquals(1, linkedList.length());
		linkedList.add("chorong");
		assertEquals(2, linkedList.length());
		linkedList.remByElem("hyejeong");
		linkedList.remByElem("chorong");
		assertEquals(0, linkedList.length());
	}
}