package modelo;

public class Contador {
	private int contador;

	public Contador() {
		super();
		this.contador = 0;
	}

	public int getContador() {
		return contador;
	}

	public void setContador(int contador) {
		this.contador = contador;
	}
	public void inc() {
		this.contador++;
	}

}


