import java.util.Scanner;
public class LocadoraVeiculos {

	public static void main(String[] args) {
		Scanner scanner = new Scanner (System.in);
		Carro carro = new Carro();
		Moto moto1 = new Moto();
		Moto moto2 = new Moto();
		
		System.out.println("Digite a marca do carro");
		String marcaCarro = scanner.next();
		System.out.println("Digite o modelo do carro");
		String modeloCarro = scanner.next();
		carro.atribuirValor(marcaCarro, modeloCarro);
				
		System.out.println("\nDigite a marca da 1ª moto");
		String marcaMoto1 = scanner.next();
		System.out.println("Digite o modelo da 1ª moto");
		String modeloMoto1 = scanner.next();
		System.out.println("Digite as cilindradas da 1ª moto");
		int cilindradasMoto1 = scanner.nextInt();
		moto1.atribuirValor(marcaMoto1, modeloMoto1, cilindradasMoto1);
				
		System.out.println("\nDigite a marca da 2ª moto");
		String marcaMoto2 = scanner.next();
		System.out.println("Digite o modelo da 2ª moto");
		String modeloMoto2 = scanner.next();
		System.out.println("Digite as cilindradas da 2ª moto");
		int cilindradasMoto2 = scanner.nextInt();
		moto2.atribuirValor(marcaMoto2, modeloMoto2, cilindradasMoto2);
		
		System.out.println("\nDados do carro:");		
		carro.retornarValor();
		System.out.println("\nDados da 1ª moto:");
		moto1.retornarValor();
		System.out.println("\nDados da 2ª moto:");
		moto2.retornarValor();

	}

}
