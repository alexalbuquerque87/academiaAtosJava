
public class Pessoa {
	public String nome;
	public int idade;
	
	public Pessoa(String nome, int idade) {
		this.nome = nome;
		this.idade = idade;
		System.out.println("Nome da pessoa: " + nome);
		System.out.println("Idade da pessoa: " + idade);
	}
	
	public Pessoa(int idade) {
		this.idade = idade;
		System.out.println("Idade da pessoa: " + idade);
	}

}
