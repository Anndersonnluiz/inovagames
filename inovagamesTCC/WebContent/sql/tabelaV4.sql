CREATE DATABASE  IF NOT EXISTS `locadora`;
USE `locadora`;

CREATE TABLE `cliente` (
  `idcliente` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(80) NOT NULL,
  `cpf` varchar(14) NOT NULL,
  `rg` varchar(15) NOT NULL,
  `dataNascimento` date NOT NULL,
  `endereco` varchar(200) NOT NULL,
  PRIMARY KEY (`idcliente`)
);

CREATE TABLE `modelo` (
  `idmodelo` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  PRIMARY KEY (`idmodelo`)
);

CREATE TABLE `veiculo` (
  `idveiculo` int(11) NOT NULL AUTO_INCREMENT,
  `montadora` varchar(50) NOT NULL,
  `ano` int(11) NOT NULL,
  `quilometragem` double NOT NULL,
  `placa` varchar(8) NOT NULL,
  `valor` double NOT NULL,
  `idmodelo` int(11) NOT NULL,
  PRIMARY KEY (`idveiculo`),
  KEY `fk_modelo` (`idmodelo`),
  CONSTRAINT `fk_modelo` FOREIGN KEY (`idmodelo`) REFERENCES `modelo` (`idmodelo`)
);

CREATE TABLE `locacao` (
  `idlocacao` int(11) NOT NULL AUTO_INCREMENT,
  `dataLocacao` date NOT NULL,
  `dataDevolucao` date NOT NULL,
  `quilometragemInicial` double NOT NULL,
  `quilometragemFinal` double NOT NULL,
  `valorTotal` double NOT NULL,
  `idveiculo` int(11) NOT NULL,
  `idcliente` int(11) NOT NULL,
  PRIMARY KEY (`idlocacao`),
  KEY `FK_veiculo_idx` (`idveiculo`),
  KEY `FK_cliente_idx` (`idcliente`),
  CONSTRAINT `FK_cliente` FOREIGN KEY (`idcliente`) REFERENCES `cliente` (`idcliente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_veiculo` FOREIGN KEY (`idveiculo`) REFERENCES `veiculo` (`idveiculo`) ON DELETE NO ACTION ON UPDATE NO ACTION
);