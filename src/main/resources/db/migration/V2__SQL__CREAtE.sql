CREATE SEQUENCE SEQ_CONTATO
				START WITH 100
				INCREMENT BY 1
				NO MINVALUE
				NO MAXVALUE
				CACHE 1;;

CREATE TABLE CONTATO (
	ID BIGINT NOT NULL DEFAULT NEXTVAL('SEQ_CONTATO'::REGCLASS),
	TELEFONE VARCHAR(10) NOT NULL,
	EMAIL VARCHAR (50) NOT NULL
);
ALTER TABLE CONTATO ADD CONSTRAINT PK_CONTATO_ID PRIMARY KEY (ID);