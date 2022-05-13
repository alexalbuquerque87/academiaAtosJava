/*Criação do banco e tabelas*/

create database Biblioteca;
use Biblioteca;

CREATE TABLE [Autor] (
  [id] int not null identity,
  [nome] varchar(100) not null,
  [nacionalidade] varchar(100),
  PRIMARY KEY ([id])
);

CREATE TABLE [Categoria] (
  [id] int not null identity,
  [tipo_categoria] varchar(50),
  PRIMARY KEY ([id])
);

CREATE TABLE [Editora] (
  [id] int not null identity,
  [nome] varchar(50),
  PRIMARY KEY ([id])
);

CREATE TABLE [Livro] (
  [ISBN] varchar(50) not null,
  [titulo] varchar (100) not null,
  [ano] int not null,
  [fk_editora] int not null,
  [fk_categoria] int not null,
  PRIMARY KEY ([ISBN]),
  CONSTRAINT [FK_Livro.fk_categoria]
    FOREIGN KEY ([fk_categoria])
      REFERENCES [Categoria]([id]),
  CONSTRAINT [FK_Livro.fk_editora]
    FOREIGN KEY ([fk_editora])
      REFERENCES [Editora]([id])
);

CREATE TABLE [LivroAutor] (
  [int] int not null identity,
  [fk_autor] int not null,
  [fk_livro] varchar(50) not null,
  PRIMARY KEY ([int]),
  CONSTRAINT [FK_LivroAutor.fk_autor]
    FOREIGN KEY ([fk_autor])
      REFERENCES [Autor]([id]),
  CONSTRAINT [FK_LivroAutor.fk_livro]
    FOREIGN KEY ([fk_livro])
      REFERENCES [Livro]([ISBN])
);

/*6. Inserção dos dados em todas as tabelas*/

insert into Autor (nome) values ('J.K. Rowling');
insert into Autor (nome, nacionalidade) values ('Clive Staples Lewis', 'Inglaterra');
insert into Autor (nome, nacionalidade) values ('Affonso Solaano', 'Brasil');
insert into Autor (nome, nacionalidade) values ('Marcos Piangers', 'Brasil');
insert into Autor (nome, nacionalidade) values ('Ciro Botelho', 'Brasil');
insert into Autor (nome, nacionalidade) values ('Bianca Mól', 'Brasil');

insert into Categoria (tipo_categoria) values ('Literatura Juvenil');
insert into Categoria (tipo_categoria) values ('Ficcção Científica');
insert into Categoria (tipo_categoria) values ('Humor');
insert into Categoria (tipo_categoria) values ('Ação');
insert into Categoria (tipo_categoria) values ('Romance');

insert into Editora (nome) values ('Rocco');
insert into Editora (nome) values ('Wmf Martins Fontes');
insert into Editora (nome) values ('Casa da Palavra');
insert into Editora (nome) values ('Belas Letras');
insert into Editora (nome) values ('Matrix');

insert into livro values ('8532511015','Harry Potter e a Pedra Filosofal','2000',1,1);
insert into livro values ('9788578270698','As Crônicas de Nárnia','2009',2,1);
insert into livro values ('9788577343348','O Espadachim de Carvão','2013',3,2);
insert into livro values ('9788581742458','O Papai é Pop','2015',4,3);
insert into livro values ('9788582302026','Pior Que Tá Não Fica','2015',5,3);
insert into livro values ('9788577345670','Garota Desdobrável','2015',3,1);
insert into livro values ('8532512062','Harry Potter e o Prisioneiro de Azkaban','2000',1,1);

insert into LivroAutor (fk_livro, fk_autor) values ('8532511015',1);
insert into LivroAutor (fk_livro, fk_autor) values ('9788578270698',2);
insert into LivroAutor (fk_livro, fk_autor) values ('9788577343348',3);
insert into LivroAutor (fk_livro, fk_autor) values ('9788581742458',4);
insert into LivroAutor (fk_livro, fk_autor) values ('9788582302026',5);
insert into LivroAutor (fk_livro, fk_autor) values ('9788577345670',6);
insert into LivroAutor (fk_livro, fk_autor) values ('8532512062',1);

/*7. Crie uma consulta para relacionar todos os dados disponíveis de todos os livros existentes na biblioteca em ordem alfabética de Título*/
select Livro.ISBN as 'ISBN', Livro.titulo as 'Título', Autor.nome as 'Autor', Livro.ano as 'Ano', Editora.nome as 'Editora', Categoria.tipo_categoria as 'Categoria'
from Autor, Livro, Editora, Categoria, LivroAutor
where Livro.fk_editora = Editora.id
and Livro.fk_categoria = Categoria.id
and LivroAutor.fk_autor = Autor.id
and LivroAutor.fk_livro = Livro.isbn
order by Livro.titulo;

/*8. Crie uma consulta para relacionar todos os dados disponíveis de todos os livros existentes na biblioteca em ordem alfabética de Autor*/
select Livro.ISBN as 'ISBN', Livro.titulo as 'Título', Autor.nome as 'Autor', Livro.ano as 'Ano', Editora.nome as 'Editora', Categoria.tipo_categoria as 'Categoria'
from Autor, Livro, Editora, Categoria, LivroAutor
where Livro.fk_editora = Editora.id
and Livro.fk_categoria = Categoria.id
and LivroAutor.fk_autor = Autor.id
and LivroAutor.fk_livro = Livro.isbn
order by Autor.nome;

/*9. Crie uma consulta para relacionar todos os dados disponíveis dos livros da categoria de literatura Juvenil em ordem de ano*/
select Livro.ISBN as 'ISBN', Livro.titulo as 'Título', Autor.nome as 'Autor', Livro.ano as 'Ano', Editora.nome as 'Editora', Categoria.tipo_categoria as 'Categoria'
from Autor, Livro, Editora, Categoria, LivroAutor
where Livro.fk_editora = Editora.id
and Livro.fk_categoria = Categoria.id
and LivroAutor.fk_autor = Autor.id
and LivroAutor.fk_livro = Livro.isbn
and Categoria.tipo_categoria like '%Juvenil%'
order by Livro.ano;

/*10. Crie uma consulta para relacionar todos os dados disponíveis dos livros de humor ou ficcão científica com ano entre 2000 e 2010*/
select Livro.ISBN as 'ISBN', Livro.titulo as 'Título', Autor.nome as 'Autor', Livro.ano as 'Ano', Editora.nome as 'Editora', Categoria.tipo_categoria as 'Categoria'
from Autor, Livro, Editora, Categoria, LivroAutor
where Livro.fk_editora = Editora.id
and Livro.fk_categoria = Categoria.id
and LivroAutor.fk_autor = Autor.id
and LivroAutor.fk_livro = Livro.isbn
and Categoria.tipo_categoria in ('Humor', 'Ficção Científica')
and Livro.ano between 2000 and 2015;