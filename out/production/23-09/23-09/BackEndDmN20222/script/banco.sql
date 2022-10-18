create database fateczsdmn20222;

create table fateczsdmn20222.usuarios (
  id BIGINT NOT NULL AUTO_INCREMENT,
  login VARCHAR(255),
  senha VARCHAR(255),
  status VARCHAR(255),
  tipo VARCHAR(255),
  primary key (id));
  
create table fateczsdmn20222.pessoas (
  id BIGINT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(255),
  rg VARCHAR(255),
  cpf VARCHAR(255),
  email VARCHAR(255),
  primary key (id));

create table fateczsdmn20222.usuarios_pessoas (
  id BIGINT NOT NULL AUTO_INCREMENT,
  idPessoa BIGINT,
  idUsuario BIGINT, 
  obs VARCHAR(255),
  primary key (id));
  
  
create table fateczsdmn20222.bancos (
  id BIGINT NOT NULL AUTO_INCREMENT,
  nome_banco VARCHAR(45),
  primary key (id));
  
  create table fateczsdmn20222.contas (
  id BIGINT NOT NULL AUTO_INCREMENT,
  agencia INT(5),
  numero VARCHAR(25),
  data_abertura DATE,
  status VARCHAR(25),
  saldo DOUBLE,
  primary key (id));
  
  create table fateczsdmn20222.clientes (
  id BIGINT NOT NULL AUTO_INCREMENT,
 nome VARCHAR(45),
 cpf VARCHAR(14),
 telefone VARCHAR(25),
 email VARCHAR (45),
 sexo VARCHAR (25),
 primary key (id));

create table fateczsdmn20222.logradouros (
  id BIGINT NOT NULL AUTO_INCREMENT,
 endereco VARCHAR(125),
 cep VARCHAR(25),
 Complemento VARCHAR(45),
 primary key (id));

create table fateczsdmn20222.bancos_contas (
  id BIGINT NOT NULL AUTO_INCREMENT,
  idBanco BIGINT,
  idConta BIGINT, 
  primary key (id));
  
  create table fateczsdmn20222.bancos_logradouros (
  id BIGINT NOT NULL AUTO_INCREMENT,
  idBanco BIGINT,
  idLogradouro BIGINT, 
  primary key (id));
  
    create table fateczsdmn20222.contas_clientes (
  id BIGINT NOT NULL AUTO_INCREMENT,
  idConta BIGINT,
  idCliente BIGINT, 
  primary key (id));
  
ALTER TABLE fateczsdmn20222.usuarios_pessoas ADD CONSTRAINT FK_PES_USU_ID FOREIGN KEY (IDPESSOA) REFERENCES fateczsdmn20222.PESSOAS (ID);

ALTER TABLE fateczsdmn20222.usuarios_pessoas ADD CONSTRAINT FK_USU_PES_ID FOREIGN KEY (IDUSUARIO) REFERENCES fateczsdmn20222.USUARIOS (ID);  


ALTER TABLE fateczsdmn20222.bancos_contas ADD CONSTRAINT FK_CON_BAN_ID FOREIGN KEY (IDCONTA) REFERENCES fateczsdmn20222.CONTAS (ID);

ALTER TABLE fateczsdmn20222.bancos_contas ADD CONSTRAINT FK_BAN_CON_ID FOREIGN KEY (IDBANCO) REFERENCES fateczsdmn20222.BANCOS (ID);  



ALTER TABLE fateczsdmn20222.bancos_logradouros ADD CONSTRAINT FK_LOG_BAN_ID FOREIGN KEY (IDLOGRADOURO) REFERENCES fateczsdmn20222.LOGRADOUROS (ID);

ALTER TABLE fateczsdmn20222.bancos_logradouros ADD CONSTRAINT FK_BAN_LOG_ID FOREIGN KEY (IDBANCO) REFERENCES fateczsdmn20222.BANCOS (ID);  


ALTER TABLE fateczsdmn20222.contas_clientes ADD CONSTRAINT FK_CLI_CON_ID FOREIGN KEY (IDCLIENTE) REFERENCES fateczsdmn20222.CLIENTES (ID);

ALTER TABLE fateczsdmn20222.contas_clientes ADD CONSTRAINT FK_CON_CLI_ID FOREIGN KEY (IDCONTA) REFERENCES fateczsdmn20222.CONTAS (ID);  


INSERT INTO `fateczsdmn20222`.`usuarios` (`login`, `senha`, `status`, `tipo`) VALUES ('Thiago', 'Deusbase1$', 'ATIVO', 'ADM');
INSERT INTO `fateczsdmn20222`.`usuarios` (`login`, `senha`, `status`, `tipo`) VALUES ('SCURACCHIO', 'ABFABF010101', 'ATIVO', 'VISITANTE');


