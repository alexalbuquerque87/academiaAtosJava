import java.util.Scanner;
public class Inicio {

	public static void main(String[] args) {
		Scanner scanner = new Scanner (System.in);
		Pessoa pessoa = new Pessoa();
		String opcao;
		
		System.out.println("Digite 1 para inserir Nome e Idade ou 2 para inserir somente idade");
		opcao = scanner.nextLine();
		
		if(opcao.equals("1")) {
			
			System.out.println("Digite o nome da pessoa:");
			String nome = scanner.next();
			System.out.println("Digite a idade da pessoa");
			int idade = scanner.nextInt();
			pessoa.atribuirNomeIdade(nome, idade);
		}
		
		else if(opcao.equals("2")) {
			System.out.println("Digite a idade da pessoa");
			int idade = scanner.nextInt();
			pessoa.atribuirIdade(idade);
		}
		
		else {
			System.out.println("Opção incorreta.");
		}
		

	}

}
