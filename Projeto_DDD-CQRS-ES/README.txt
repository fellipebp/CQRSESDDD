Esta aplicação foi construída usando o padrão de projeto CQRS (Command Query Responsability Segregation) e da técnica ES (Event Sourcing).
Além disso utilizamos da metodologia DDD (Domain Driven Design) para tratar das questões relacionadas ao domínio do sistema.
Em relação a este domínio, a aplicação tem por finalidade ser um aplicativo de músicas, aonde o usuário poderá gerenciar suas playlists,
selecionar músicas favoritas, escutar músicas, etc.

Em relação ao armazenamento das informações, utilizamos um banco de dados MySQL com dois SCHEMAS diferentes. Um para a base de escrita
e outro para a base de leitura. Para o correto funcionamento da aplicação, além de arrumar as configurações de acesso (url, usuario, senha) 
da base de dados na classe "projeto.tcc.infraestrutura.Conexao", são necessários rodas os seguinte scripts nesta base MySQL
:

------------Scripts para a base de escrita-----------------------


CREATE DATABASE `eventsource` /*!40100 DEFAULT CHARACTER SET latin1 */;


CREATE TABLE eventsource.aggregates (
  `aggregate_id` varchar(40) DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  KEY `aggregate_id_idx` (`aggregate_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE eventsource.eventstore (
  `ideventstore` int(11) NOT NULL AUTO_INCREMENT,
  `aggregate_id` varchar(40) DEFAULT NULL,
  `events` blob NOT NULL,
  `version` bigint(20) DEFAULT NULL,
  `groupVersion` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ideventstore`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;


-------------------------------------------------------------------------------------------

-----------------------Scripts para a base de leitura----------------

CREATE DATABASE `baseleitura` /*!40100 DEFAULT CHARACTER SET utf8 */;

CREATE TABLE baseleitura.dadosusuario (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(20) NOT NULL,
  `senha` varchar(100) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `CPF` varchar(11) NOT NULL,
  `email` varchar(40) NOT NULL,
  `dataNascimento` date DEFAULT NULL,
  `sexo` varchar(1) DEFAULT NULL,
  `aggregateID` varchar(40) DEFAULT NULL,
  `dataUltimoLogin` date DEFAULT NULL,
  `cdPerfil` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

CREATE TABLE baseleitura.musicasusuario (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `duracao` varchar(45) DEFAULT NULL,
  `aggregateId` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

CREATE TABLE baseleitura.playlistsusuario (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `aggregateIDUsuario` varchar(45) NOT NULL,
  `aggregateIDPlayList` varchar(45) NOT NULL,
  `nome` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

