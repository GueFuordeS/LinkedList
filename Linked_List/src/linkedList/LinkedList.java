package linkedList;

/**
 * Ainda por implementar, ainda pensando 
 * como posso fazer funcionar perfeitamente
 * 
 * @author Gabriel Fernandes
 * @param <T> Uso do generics-java
 */
public class LinkedList<T> {
	private T elemento;
	private LinkedList<T> proximo;
	
	public static void main(String[] args) {
		LinkedList<String> linked = new LinkedList<>("hyejeong");
		System.out.println(linked);
		linked.add("bomi");
		linked.add("chorong");
		System.out.println(linked);
		//linked.rem("chorong");
		System.out.println(linked.getIndice("chorong"));
		//System.out.println(linked);
		
	}
	
	//Talvez eu precise de um atributo size para facilitar o controle da lista
	public LinkedList(T elemento) {
		this.elemento = elemento;
		this.proximo = null;
	}

	public T getElemento() {
		return this.elemento;
	}

	public void setElemento(T elemento) {
		this.elemento = elemento;
	}

/*
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
	
	public int getIndice(T elemento) {
		if (this.elemento.equals(elemento)) {
			return 0;
		}
		else if (this.proximo == null) {
			return -1;
		}
		int placeHolder = this.proximo.getIndice(elemento);
		if (placeHolder == -1) {
			return -1;
		}
		else {
			return placeHolder + 1;
		}
	}

	public void add(T elemento) {
		if(!this.hasProximo()){
			this.proximo = new LinkedList<>(elemento);
			return;
		}
		this.proximo.add(elemento);
	}

	public void rem(T elemento) {
		if(this.elemento.equals(elemento) && this.proximo == null) {
			this.elemento = null;
			return;
		}
		if(this.elemento.equals(elemento)) {
			reorganize();
			return;
		}
			this.proximo.rem(elemento);
	}

	private void reorganize() {
		if (this.proximo != null) {
			if (!this.proximo.hasProximo()) {
				this.elemento = this.proximo.getElemento();
				this.proximo = null;				
				return;
			}
			this.elemento = this.proximo.getElemento();
			this.proximo.reorganize();
		}
	}

	public boolean hasProximo() {
		if(this.proximo == null) {
			return false;
		}
		return true;
	}

	public String toStringAux() {
		if (!this.hasProximo()) {
			return this.elemento.toString() + "]";
		}
		return this.elemento + ", " + this.proximo.toStringAux();
	}
	
	@Override
	public String toString() {
		if (this.elemento != null) {
			if(!this.hasProximo()){
				return "[" + this.elemento.toString() + "]";
			}
			return "[" + this.toStringAux();
		}
		return "[]";
	}
}