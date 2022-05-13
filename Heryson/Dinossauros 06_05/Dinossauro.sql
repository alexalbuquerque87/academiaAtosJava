/*Criação banco de dados e tabelas Dinossauro*/
create database Dinossauro;

use Dinossauro;

CREATE TABLE [Grupo] (
  [id] int not null identity,
  [nome] varchar (50) not null,
  PRIMARY KEY ([id])
);

CREATE TABLE [Pais] (
  [id] int not null identity,
  [nome] varchar (50) not null,
  PRIMARY KEY ([id])
);

CREATE TABLE [Era] (
  [id] int not null identity,
  [nome] varchar (50) not null,
  [inicio] int not null,
  [fim] int not null,
  PRIMARY KEY ([id])
);

CREATE TABLE [Descobridor] (
  [id] int not null identity,
  [nome] varchar (100) not null,
  PRIMARY KEY ([id])
);

CREATE TABLE [Dinossauro] (
  [id] int not null identity,
  [nome] varchar (50) not null,
  [toneladas] int not null,
  [ano_descoberta] int not null,
  [fk_grupo] int not null,
  [fk_pais] int not null,
  [fk_era] int not null,
  [fk_descobridor] int not null,
  PRIMARY KEY ([id]),
  CONSTRAINT [FK_Dinossauro.fk_grupo]
    FOREIGN KEY ([fk_grupo])
      REFERENCES [Grupo]([id]),
  CONSTRAINT [FK_Dinossauro.fk_pais]
    FOREIGN KEY ([fk_pais])
      REFERENCES [Pais]([id]),
  CONSTRAINT [FK_Dinossauro.fk_era]
    FOREIGN KEY ([fk_era])
      REFERENCES [Era]([id]),
  CONSTRAINT [FK_Dinossauro.fk_descobridor]
    FOREIGN KEY ([fk_descobridor])
      REFERENCES [Descobridor]([id])
);

/*6. Crie o comando SQL para inserção de pelo menos 3 registros acima, em todas as tabelas necessárias*/

insert into Grupo (nome) values ('Anquilossauros');
insert into Grupo (nome) values ('Ceratopsídeos');
insert into Grupo (nome) values ('Estegossauros');
insert into Grupo (nome) values ('Terápodes');

insert into Pais (nome) values ('Mongólia');
insert into Pais (nome) values ('Canadá');
insert into Pais (nome) values ('Tanzânia');
insert into Pais (nome) values ('China');
insert into Pais (nome) values ('América do Norte');
insert into Pais (nome) values ('USA');

insert into Era (nome, inicio, fim) values ('Cretácio', 145, 66);
insert into Era (nome, inicio, fim) values ('Jurássico', 201, 145);

insert into Descobridor (nome) values ('Maryanska');
insert into Descobridor (nome) values ('John Bell Hatcher');
insert into Descobridor (nome) values ('Cientistas Alemães');
insert into Descobridor (nome) values ('Museu Americano de História Natural');
insert into Descobridor (nome) values ('Othniel Charles Marsh');
insert into Descobridor (nome) values ('Barnum Brown');

insert into Dinossauro (nome, toneladas, ano_descoberta, fk_grupo, fk_pais, fk_era, fk_descobridor) 
values ('Saichania', 4, 1977, 1, 1, 1, 1);
insert into Dinossauro (nome, toneladas, ano_descoberta, fk_grupo, fk_pais, fk_era, fk_descobridor) 
values ('Tricerátops', 6, 1887, 2, 2, 1, 2);
insert into Dinossauro (nome, toneladas, ano_descoberta, fk_grupo, fk_pais, fk_era, fk_descobridor) 
values ('Kentrossauro', 2, 1909, 3, 3, 2, 3);
insert into Dinossauro (nome, toneladas, ano_descoberta, fk_grupo, fk_pais, fk_era, fk_descobridor) 
values ('Pinacossauro', 6, 1999, 1, 4, 1, 4);
insert into Dinossauro (nome, toneladas, ano_descoberta, fk_grupo, fk_pais, fk_era, fk_descobridor) 
values ('Alossauro', 3, 1877, 4, 5, 2, 5);
insert into Dinossauro (nome, toneladas, ano_descoberta, fk_grupo, fk_pais, fk_era, fk_descobridor) 
values ('Torossauro', 8, 1891, 2, 6, 1, 2);
insert into Dinossauro (nome, toneladas, ano_descoberta, fk_grupo, fk_pais, fk_era, fk_descobridor) 
values ('Anquilossauro', 8, 1906, 1, 5, 1, 6);

/*7. Crie uma consulta para relacionar todos os dados disponíveis de todos os dinossauros existentes no catálogo em ordem alfabética por nome*/
select Dinossauro.nome as 'Nome', Grupo.nome as 'Grupo',Dinossauro.toneladas as 'Toneladas', Dinossauro.ano_descoberta as 'Ano Descoberta', Descobridor.nome as 'Descobridor', Era.nome as 'Era', Era.inicio as 'Início', Era.fim as 'Fim',Pais.nome as 'País' 
from Dinossauro, Grupo, Descobridor, Era, Pais 
where Dinossauro.fk_grupo = Grupo.id 
and Dinossauro.fk_descobridor = Descobridor.id 
and Dinossauro.fk_pais = Pais.id 
and Dinossauro.fk_era = Era.id 
order by Dinossauro.nome;

/*8. Crie uma consulta para relacionar todos os dados disponíveis de todos os dinossauros existentes em ordem alfabética de Descobridor*/
select Dinossauro.nome as 'Nome', Grupo.nome as 'Grupo',Dinossauro.toneladas as 'Toneladas', Dinossauro.ano_descoberta as 'Ano Descoberta', Descobridor.nome as 'Descobridor', Era.nome as 'Era', Era.inicio as 'Início', Era.fim as 'Fim',Pais.nome as 'País' 
from Dinossauro, Grupo, Descobridor, Era, Pais 
where Dinossauro.fk_grupo = Grupo.id 
and Dinossauro.fk_descobridor = Descobridor.id 
and Dinossauro.fk_pais = Pais.id 
and Dinossauro.fk_era = Era.id 
order by Descobridor.nome;

/*9. Crie uma consulta para relacionar todos os dados disponíveis dos dinossauros do grupo anquilossauros em ordem de ano de descoberta*/
select Dinossauro.nome as 'Nome', Grupo.nome as 'Grupo',Dinossauro.toneladas as 'Toneladas', Dinossauro.ano_descoberta as 'Ano Descoberta', Descobridor.nome as 'Descobridor', Era.nome as 'Era', Era.inicio as 'Início', Era.fim as 'Fim',Pais.nome as 'País' 
from Dinossauro, Grupo, Descobridor, Era, Pais 
where Dinossauro.fk_grupo = Grupo.id 
and Dinossauro.fk_descobridor = Descobridor.id 
and Dinossauro.fk_pais = Pais.id 
and Dinossauro.fk_era = Era.id 
and Grupo.nome like '%Anquilossauros%'
order by Dinossauro.ano_descoberta;

/*10. Crie uma consulta para relacionar todos os dados disponíveis dos dinossauros Ceratopsídeos ou anquilossauros com ano de descoberta entre 1900 e 1999*/
select Dinossauro.nome as 'Nome', Grupo.nome as 'Grupo',Dinossauro.toneladas as 'Toneladas', Dinossauro.ano_descoberta as 'Ano Descoberta', Descobridor.nome as 'Descobridor', Era.nome as 'Era', Era.inicio as 'Início', Era.fim as 'Fim',Pais.nome as 'País' 
from Dinossauro, Grupo, Descobridor, Era, Pais 
where Dinossauro.fk_grupo = Grupo.id 
and Dinossauro.fk_descobridor = Descobridor.id 
and Dinossauro.fk_pais = Pais.id 
and Dinossauro.fk_era = Era.id 
and Grupo.nome in ('Ceratopsídeos', 'Anquilossauros') 
and Dinossauro.ano_descoberta between 1900 and 1999;
