package linkedList;

/**
 * Ainda por implementar, ainda pensando 
 * como posso fazer funcionar perfeitamente
 * 
 * @author Gabriel Fernandes
 * @param <T> Uso do generics-java
 */
public class LinkedList<T> {
	private T element;
	private LinkedList<T> next;
	
	public static void main(String[] args) {
		LinkedList<String> linked = new LinkedList<>();
		
		linked.add("Hyejeong");
		linked.add("Hayoung");

		linked.remByInd(1);
		//linked.remByElem("Hyejeong");
		linked.add("Chorong");
		linked.remByElem("Chorong");
		
		linked.add("Bomi");
		System.out.println(linked);
		linked.remByInd(1);
		System.out.println(linked);
		System.out.println(linked.length());
		System.out.println(linked.getElement(0));
		linked.remByInd(0);
		System.out.println(linked);
	}
	
	//Talvez eu precise de um atributo size para facilitar o controle da lista
	public LinkedList() {
		this.element = null;
		this.next = null;
	}
	
	public LinkedList(T elemento) {
		this.element = elemento;
		this.next = null;
	}
	
	private T getElement() {
		return this.element;
	}
	
	public T getElement(int index) {
		return this.getElement(index, 0);
	}
	
	private T getElement(int index, int incr) {
		if (index == incr) {
			return this.element;
		}
		else if (this.next != null) {
			return this.next.getElement(index, incr += 1);
		}
		return null;
	}
	
	public int length() {
		if (this.hasNext()) {
			return 1 + this.next.length();
		}
		if (this.element != null) {
			return 1;
		}
		return 0;
	}

/* Another way to implement #getIndex
	public int getIndice(T elemento) {
		return this.getIndice(elemento, 0);
	}

	private int getIndice(T elemento, int index) {
		if (this.elemento.equals(elemento)) {
			return index;
		}
		else if (this.proximo == null) {
			return -1;
		}
		return this.proximo.getIndice(elemento, index+1);
	}
*/

	public int getIndex(T element) {
		if (this.element != null) {
			if (this.element.equals(element)) {
				return 0;
			}
			else if (this.next == null) {
				return -1;
			}
			int placeHolder = this.next.getIndex(element);
			if (placeHolder == -1) {
				return -1;
			}
			else {
				return placeHolder + 1;
			}
		}
		return -1;
	}

	public void add(T elemento) {
		if (this.element == null) {
			this.element = elemento;
			return;
		}
		
		if (!this.hasNext()) {
			this.next = new LinkedList<>(elemento);
			return;
		}
		this.next.add(elemento);
	}

	public void remByInd(int index) {
		final int LENGTH = this.length();
		if (LENGTH >= 1) {
			if (LENGTH == 1) {
				if (index == 0) {
					this.element = null;
				}
				else {
					throw new IndexOutOfBoundsException();
				}
			}
			else {
				this.remByInd(index, 0);
			}
		}
		else {
			throw new IndexOutOfBoundsException();
		}
	}
	
	private void remByInd(int index, int incr) {
		if (index == incr+1 && !this.next.hasNext()) {
			this.next = null;
		}
		else if (index == incr) {
			this.reorganize();
		}
		else if (this.next != null) {
			this.next.getElement(index, incr += 1);
		}
	}

	public void remByElem(T element) {
		if (this.element != null) {
			if (!this.hasNext() && this.element.equals(element)) {
				this.element = null;
			}
			if (this.hasNext()) {
				if (this.next.getElement().equals(element) && !this.next.hasNext()) {
					this.next = null;
				}
				else {
					if (this.element.equals(element)) {
						this.reorganize();
					}
					else {
						this.next.remByElem(element);
					}
				}
			}
		}
	}
	
	private void reorganize() {
		if (this.next != null) {
			if (!this.next.hasNext()) {
				this.element = this.next.getElement();
				this.next = null;				
				return;
			}
			this.element = this.next.getElement();
			this.next.reorganize();
		}
	}

	/**
	 * Ensure that the next node of the LinkedList whether is a non-null element or a null
	 * element
	 * 
	 * @return	true if LinkedList node has a valid next element, no if a null next node
	 */
	private boolean hasNext() {
		if(this.next == null) {
			return false;
		}
		return true;
	}

	private String toStringAux() {
		if (!this.hasNext()) {
			return this.element.toString() + "]";
		}
		return this.element + ", " + this.next.toStringAux();
	}
	
	@Override
	public String toString() {
		if (this.element != null) {
			if(!this.hasNext()) {
				return "[" + this.element.toString() + "]";
			}
			return "[" + this.toStringAux();
		}
		return "[]";
	}
}