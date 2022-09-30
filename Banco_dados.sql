create database parasemear;

use parasemear;

CREATE TABLE INSTITUICOES (
id_ins INTEGER PRIMARY KEY auto_increment,
cnpj_ins VARCHAR(15),
rS VARCHAR(70),
n_fant VARCHAR(50),
n_res VARCHAR(50),
tel_ins VARCHAR(15),
emai_ins VARCHAR(50),
senha_ins VARCHAR(30),
end_ins VARCHAR(50),
cid_ins VARCHAR(30),
uf_ins VARCHAR(2),
doc_ins VARCHAR(100)
);

CREATE TABLE COLABORADORES (
id_col INTEGER PRIMARY KEY auto_increment,
cpf_cnpj_col VARCHAR(15),
nome_col VARCHAR(30),
sn_col VARCHAR(50),
dn_col DATE,
sexo_col CHAR(1),
tel_col VARCHAR(15),
email_col VARCHAR(50),
senha_col VARCHAR(20),
end_col VARCHAR(50),
cid_col VARCHAR(10),
uf_col VARCHAR(2),
vol CHAR(1),
dis_col VARCHAR(50)
);

CREATE TABLE DOACAO (
id_doa INTEGER PRIMARY KEY auto_increment,
tipo_doa CHAR(1),
desc_doa VARCHAR(60),
data_doa DATETIME,
qt_doa DECIMAL(8,2),
anonimo CHAR(1),
com_doa VARCHAR(100),
id_col INTEGER,
id_ins INTEGER,
FOREIGN KEY(id_col) REFERENCES COLABORADORES (id_col),
FOREIGN KEY(id_ins) REFERENCES INSTITUICOES (id_ins)
);

CREATE TABLE RELATORIO (
id_rel INTEGER PRIMARY KEY auto_increment,
ano_rel INTEGER,
mes_rel INTEGER,
projetos VARCHAR(30),
mat_use_rel VARCHAR(50),
valor_rel DECIMAL(8,2),
num_cont_rel INTEGER,
qtd_vol INTEGER,
id_ins INTEGER,
FOREIGN KEY(id_ins) REFERENCES INSTITUICOES (id_ins)
);

CREATE TABLE PROJETOS (
id_pro INTEGER PRIMARY KEY auto_increment,
nome_proj VARCHAR(30),
desc_proj VARCHAR(500),
local_proj VARCHAR(100),
num_cont_proj INTEGER,
freq_proj VARCHAR(10),
sit_proj CHAR(1),
id_ins INTEGER,
FOREIGN KEY(id_ins) REFERENCES INSTITUICOES (id_ins)
);

CREATE TABLE VOLUNTARIADO (
id_ins INTEGER,
id_col INTEGER,
FOREIGN KEY(id_ins) REFERENCES INSTITUICOES (id_ins),
FOREIGN KEY(id_col) REFERENCES COLABORADORES (id_col)
);