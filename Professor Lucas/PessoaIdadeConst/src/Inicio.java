import java.util.Scanner;
public class Inicio {

	public static void main(String[] args) {
		Scanner scanner = new Scanner (System.in);
		String opcao;
		
		System.out.println("Digite 1 para inserir Nome e Idade ou 2 para inserir somente idade");
		opcao = scanner.nextLine();
		
		if(opcao.equals("1")) {
			
			System.out.println("Digite o nome da pessoa:");
			String nome = scanner.next();
			System.out.println("Digite a idade da pessoa");
			int idade = scanner.nextInt();
			Pessoa pessoa = new Pessoa(nome, idade);
			pessoa.mostrarNomeIdade();

		}
		
		else if(opcao.equals("2")) {
			System.out.println("Digite a idade da pessoa");
			int idade = scanner.nextInt();
			Pessoa pessoa = new Pessoa(idade);
			pessoa.mostrarIdade();
		}
		
		else {
			System.out.println("Opção incorreta.");
		}
		

	}

}
