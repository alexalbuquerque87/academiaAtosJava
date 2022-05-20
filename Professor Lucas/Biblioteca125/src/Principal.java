import java.sql.SQLException;

public class Principal {

	public static void main(String[] args) throws SQLException {
		// Cria��o da Classe BancoDados
		BancoDados bd = new BancoDados();
		// Conex�o com BD
		System.out.println(bd.conectar());
		
		// Insere dados do Autor no BD
		bd.inserirAutor("J.K. Rowling", null);
		bd.inserirAutor("Clive Staples Lewis", "Inglaterra");
		bd.inserirAutor("Affonso Solaano", "Brasil");
		bd.inserirAutor("Marcos Piangers", "Brasil");
		bd.inserirAutor("Ciro Botelho", "Brasil");
		bd.inserirAutor("Bianca M�l", "Brasil");		
		//Exibe dados da tabela Autor
		bd.exibirAutor();
		
		// Insere dados da Categoria no BD
		bd.inserirCategoria("Literatura Juvenil");
		bd.inserirCategoria("Ficc��o Cient�fica");
		bd.inserirCategoria("Humor");
		bd.inserirCategoria("A��o");
		bd.inserirCategoria("Romance");		
		//Exibe dados da tabela Categoria
		bd.exibirCategoria();
		
		// Insere dados da Editora no BD
		bd.inserirEditora("Rocco");
		bd.inserirEditora("Wmf Martins Fontes");
		bd.inserirEditora("Casa da Palavra");
		bd.inserirEditora("Belas Letras");
		bd.inserirEditora("Matrix");				
		//Exibe dados da tabela Editora
		bd.exibirEditora();
		
		// Insere dados do Livro no BD
		bd.inserirLivro("8532511015", "Harry Potter e a Pedra Filosofal", 2000, 1, 1);
		bd.inserirLivro("9788578270698", "As Cr�nicas de N�rnia", 2009, 2, 1);
		bd.inserirLivro("9788577343348", "O Espadachim de Carv�o", 2013, 3, 2);
		bd.inserirLivro("9788581742458", "O Papai � Pop", 2015, 4, 3);
		bd.inserirLivro("9788582302026", "Pior Que T� N�o Fica", 2015, 5, 3);
		bd.inserirLivro("9788577345670", "Garota Desdobr�vel", 2015, 3, 1);
		bd.inserirLivro("8532512062", "Harry Potter e o Prisioneiro de Azkaban", 2000, 1, 1);						
		//Exibe dados da tabela Livro
		bd.exibirLivro();
		
		//Insere dados do LivroAutor no BD
		bd.inserirLivroAutor("8532511015",1);
		bd.inserirLivroAutor("9788578270698",2);
		bd.inserirLivroAutor("9788577343348",3);
		bd.inserirLivroAutor("9788581742458",4);
		bd.inserirLivroAutor("9788582302026",5);
		bd.inserirLivroAutor("9788577345670",6);
		bd.inserirLivroAutor("8532512062",1);
		//Exibe dados da tabela LivroAutor
		bd.exibirLivroAutor();
		
		//Exibe todos os dados dispon�veis de todos os livros existentes na biblioteca em ordem alfab�tica de t�tulo
		System.out.println("\nTodos os dados dispon�veis de todos os livros existentes na biblioteca em ordem alfab�tica de t�tulo:");
		bd.exibirLivroOrdenado();
		
		//Encerra conex�o com o BD
		bd.encerrarConexao();
	}

}
