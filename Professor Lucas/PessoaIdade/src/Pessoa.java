
public class Pessoa {
	public String nome;
	public int idade;
	
	public void atribuirNomeIdade(String nome, int idade) {
		this.nome = nome;
		this.idade = idade;
		System.out.println("Nome da pessoa: " + nome);
		System.out.println("Idade da pessoa: " + idade);
	}
	
	public void atribuirIdade(int idade) {
		this.idade = idade;
		System.out.println("Idade da pessoa: " + idade);
	}

}
