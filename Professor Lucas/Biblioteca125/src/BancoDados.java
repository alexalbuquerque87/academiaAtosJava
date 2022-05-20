import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BancoDados {
	Connection conexao;
	PreparedStatement ps;
	ResultSet rs;

	public String conectar() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexao = (Connection) DriverManager
					.getConnection("jdbc:mysql://localhost:3306/biblioteca?user=root&password=");
			return "Conectado!\n";
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return "Não foi Possível Conectar";
		}

	}

	public void encerrarConexao() {
		try {
			conexao.close();
			System.out.println("\nConexão com o banco de dados encerrada.");
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Falha ao encerrar conexão.");
		}
	}

	public void inserirAutor(String nome, String nacionalidade) {
		try {
			ps = conexao.prepareStatement("insert into Autor (nome, nacionalidade) values (?,?);");
			ps.setString(1, nome);
			ps.setString(2, nacionalidade);
			ps.executeUpdate();
			System.out.println("Dados inseridos na tabela Autor");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void exibirAutor() {
		try {
			ps = conexao.prepareStatement("select * from Autor;");
			rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println("ID: " + rs.getString("id") + "\tNome: " + rs.getString("nome") + "\tNacionalidade: "
						+ rs.getString("nacionalidade"));
			}

		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Falha ao exibir dados da tabela Autor.");
		}
	}

	public void inserirCategoria(String categoria) {
		try {
			ps = conexao.prepareStatement("insert into Categoria (tipo_categoria) values (?);");
			ps.setString(1, categoria);
			ps.executeUpdate();
			System.out.println("Dados inseridos na tabela Categoria");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void exibirCategoria() {
		try {
			ps = conexao.prepareStatement("select * from Categoria;");
			rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println("ID: " + rs.getString("id") + "\tCategoria: " + rs.getString("tipo_categoria"));
			}

		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Falha ao exibir dados da tabela Categorias.");
		}
	}

	public void inserirEditora(String editora) {
		try {
			ps = conexao.prepareStatement("insert into Editora (nome) values (?);");
			ps.setString(1, editora);
			ps.executeUpdate();
			System.out.println("Dados inseridos na tabela Editora");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void exibirEditora() {
		try {
			ps = conexao.prepareStatement("select * from Editora;");
			rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println("ID: " + rs.getString("id") + "\tEditora: " + rs.getString("nome"));
			}

		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Falha ao exibir dados da tabela Editora.");
		}
	}

	public void inserirLivro(String isbn, String titulo, int ano, int fkcategoria, int fkeditora) {
		try {
			ps = conexao.prepareStatement("insert into livro values (?,?,?,?,?);");
			ps.setString(1, isbn);
			ps.setString(2, titulo);
			ps.setInt(3, ano);
			ps.setInt(4, fkcategoria);
			ps.setInt(5, fkeditora);
			ps.executeUpdate();
			System.out.println("Dados inseridos na tabela Livro");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void exibirLivro() {
		try {
			ps = conexao.prepareStatement("select * from Livro;");
			rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println("ISBN: " + rs.getString("ISBN") + "\tTitulo: " + rs.getString("titulo") + "\tAno: " + rs.getString("ano") + "\tEditora: " + rs.getString("fk_editora") + "\tCategoria: " + rs.getString("fk_categoria"));
			}

		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Falha ao exibir dados da tabela Livro.");
		}
	}
	
	public void inserirLivroAutor(String fklivro, int fkautor) {
		try {
			ps = conexao.prepareStatement("insert into LivroAutor (fk_livro, fk_autor) values (?,?);");
			ps.setString(1, fklivro);
			ps.setInt(2, fkautor);
			ps.executeUpdate();
			System.out.println("Dados inseridos na tabela LivroAutor");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void exibirLivroAutor() {
		try {
			ps = conexao.prepareStatement("select * from LivroAutor;");
			rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println("ID: " + rs.getString("id") + "\tAutor: " + rs.getString("fk_autor") + "\tLivro: " + rs.getString("fk_livro"));
			}

		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Falha ao exibir dados da tabela Autor.");
		}
	}
	
	public void exibirLivroOrdenado() {
		try {
			ps = conexao.prepareStatement("select Livro.ISBN as 'ISBN', Livro.titulo as 'Título', Autor.nome as 'Autor', Livro.ano as 'Ano', Editora.nome as 'Editora', Categoria.tipo_categoria as 'Categoria'\r\n"
					+ "from Autor, Livro, Editora, Categoria, LivroAutor\r\n"
					+ "where Livro.fk_editora = Editora.id\r\n"
					+ "and Livro.fk_categoria = Categoria.id\r\n"
					+ "and LivroAutor.fk_autor = Autor.id\r\n"
					+ "and LivroAutor.fk_livro = Livro.isbn\r\n"
					+ "order by Livro.titulo;");
			rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println("ISBN: " + rs.getString("ISBN") + "\tTítulo: " + rs.getString("Título") + "\tAutor: " + rs.getString("Autor") + "\tAno: " + rs.getString("Ano") + "\tEditora: " + rs.getString("Editora") + "\tCategoria: " + rs.getString("Categoria"));
			}

		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Falha ao exibir dados da tabela Livro.");
		}
	}

}
