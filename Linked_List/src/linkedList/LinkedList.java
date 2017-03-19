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
	private int indice;
	
	//Talvez eu precise de um atributo size para facilitar o controle da lista
	public LinkedList(T elemento) {
		this.elemento = elemento;
		this.proximo = null;
		this.indice = 0;
	}
	
	public LinkedList(T elemento, int indice) {
		this.elemento = elemento;
		this.proximo = null;
	}

	public T getElemento() {
		return this.elemento;
	}

	public void setElemento(T elemento) {
		this.elemento = elemento;
	}
	
	public int getIndice() {
		return this.indice;
	}

	public void add(T elemento) {
		if(!this.hasProximo()){
			this.proximo = new LinkedList<>(elemento,this.indice+1);
			return;
		}
		this.proximo.add(elemento);
	}
	
	public void rem(T elemento) {
		if(this.elemento.equals(elemento)) {
			reorganize();
			return;
		}
		this.proximo.rem(elemento);
	}

	private void reorganize() {
		if(this.proximo != null) {
		if(!this.proximo.hasProximo()) {
			this.elemento = this.proximo.getElemento();
			this.proximo = null;				return;
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
		if(!this.hasProximo()){
			return this.elemento.toString() + "]";
		}
		return this.elemento + ", " + this.proximo.toStringAux();
	}
	
	@Override
	public String toString() {
		if(!this.hasProximo()){
			return "[" + this.elemento.toString() + "]";
		}
		return "[" + this.toStringAux();
	}
}