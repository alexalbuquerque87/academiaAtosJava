
public class Moto {
	public String marca;
	public String modelo;
	public int cilindradas;
	
	public void atribuirValor(String marca, String modelo, int cilindradas) {
		this.marca = marca;
		this.modelo = modelo;
		this.cilindradas = cilindradas;
	}
	
	public void retornarValor() {
		System.out.println("Marca: " + marca);
		System.out.println("Modelo: " + modelo);
		System.out.println("Cilindradas: " + cilindradas);
	}

}
