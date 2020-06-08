CREATE SEQUENCE SEQ_PESSOA
				START WITH 100
				INCREMENT BY 1
				NO MINVALUE
				NO MAXVALUE
				CACHE 1;;

CREATE TABLE PESSOA (
	ID BIGINT NOT NULL DEFAULT NEXTVAL('SEQ_PESSOA'::REGCLASS),
	NOME VARCHAR(255) NOT NULL,
	NASCIMENTO DATE NOT NULL
);
ALTER TABLE PESSOA ADD CONSTRAINT PK_PESSOA_ID PRIMARY KEY (ID);


CREATE SEQUENCE SEQ_CONTATO
				START WITH 100
				INCREMENT BY 1
				NO MINVALUE
				NO MAXVALUE
				CACHE 1;;

CREATE TABLE CONTATO (
	ID BIGINT NOT NULL DEFAULT NEXTVAL('SEQ_CONTATO'::REGCLASS),
	TELEFONE VARCHAR(10) NOT NULL,
	EMAIL VARCHAR (50) NOT NULL,
	PESSOA_ID BIGINT
);
ALTER TABLE CONTATO ADD CONSTRAINT PK_CONTATO_ID PRIMARY KEY (ID);

ALTER TABLE CONTATO ADD CONSTRAINT FK_PESSOA_ID FOREIGN KEY (PESSOA_ID) REFERENCES PESSOA(ID);


