
public class Carro {
	public String marca;
	public String modelo;
	
	public void atribuirValor(String marca, String modelo) {
		this.marca = marca;
		this.modelo = modelo;
	}
	
	public void retornarValor() {
		System.out.println("Marca: " + marca);
		System.out.println("Modelo: " + modelo);
	}

}
