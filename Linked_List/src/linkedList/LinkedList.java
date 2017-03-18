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
	
	//Talvez eu precise de um atributo size para facilitar o controle da lista
	public LinkedList() {
		this.elemento = null;	
	}
	
	public T getElemento() {
		return this.elemento;
	}
	
	public void add(T elemento) {
		if(this.elemento == null) {
			this.elemento = elemento;
		}
		else {
			proximo = new LinkedList<T>();
			proximo.add(elemento);
		}
	}

	public void rem(T elemento) {
		if(this.elemento.equals(elemento)) {
			this.elemento = null;
		}
		else {
			proximo.rem(elemento);
		}
	}
	
	public T pegaElemento(T elemento) {
		if(this.elemento.equals(elemento)) {
			return this.elemento;
		}
		else {
			return this.proximo.pegaElemento(elemento);
		}
	}
	
	public boolean hasProximo() {
		try {
			if(proximo.getElemento() == null) {
				return false;
			}
			return true;
		}
		catch(NullPointerException e) {
			return false;
		}
	}
	
	@Override
	public String toString() {
		if(this.elemento == null) {
			return "sem mais elementos";
		}
		else {
			if(this.hasProximo()) {
				return this.elemento + " " + proximo.toString();
			}
			else {
				return this.elemento.toString();
			}
		}
	}
}