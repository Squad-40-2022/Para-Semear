create database parasemear;

CREATE TABLE INSTITUICOES (
tel_ins VARCHAR(15),
senha_ins VARCHAR(30),
emai_ins VARCHAR(50),
cnpj_ins VARCHAR(15),
n_res VARCHAR(50),
n_fant VARCHAR(50),
rS VARCHAR(70),
end_ins VARCHAR(50),
doc_ins VARCHAR(100),
uf_ins VARCHAR(2),
cid_ins VARCHAR(30),
id_ins INTEGER PRIMARY KEY auto_increment
);

CREATE TABLE COLABORADORES (
id_cli INTEGER PRIMARY KEY auto_increment,
cpf_cnpj_col VARCHAR(15),
nome_col VARCHAR(30),
dn_col DATE,
email_col VARCHAR(50),
senha_col VARCHAR(20),
uf_col VARCHAR(2),
sn_col VARCHAR(50),
sexo_col CHAR(1),
tel_col VARCHAR(15),
end_col VARCHAR(50),
vol CHAR(2),
dis_col VARCHAR(50),
cid_col VARCHAR(10)
);

CREATE TABLE DOACAO (
id_doa INTEGER PRIMARY KEY auto_increment,
tipo_doa CHAR(1),
Oque VARCHAR(60),
qt_doa DECIMAL(8,2),
com_doa VARCHAR(100),
data_doa DATETIME,
anonimo CHAR(1),
id_cli INTEGER,
id_ins INTEGER,
FOREIGN KEY(id_cli) REFERENCES COLABORADORES (id_cli),
FOREIGN KEY(id_ins) REFERENCES INSTITUICOES (id_ins)
);

CREATE TABLE RELATORIO (
qde_vol INTEGER,
valor_rell DECIMAL(8,2),
num_cont_rel INTEGER,
projetos VARCHAR(30),
id_rel INTEGER PRIMARY KEY auto_increment,
mes_rel INTEGER,
ano_rel INTEGER,
mat_use_rel VARCHAR(50),
id_ins INTEGER,
FOREIGN KEY(id_ins) REFERENCES INSTITUICOES (id_ins)
);

CREATE TABLE PROJETOS (
idProjeto INTEGER PRIMARY KEY auto_increment,
nome_proj VARCHAR(30),
local_proj VARCHAR(100),
num_cont_proj INTEGER,
sit_proj CHAR(1),
freq_proj VARCHAR(10),
desc_proj VARCHAR(500),
id_ins INTEGER,
FOREIGN KEY(id_ins) REFERENCES INSTITUICOES (id_ins)
);

CREATE TABLE VOLUNTARIADO (
id_ins INTEGER,
id_cli INTEGER,
FOREIGN KEY(id_ins) REFERENCES INSTITUICOES (id_ins),
FOREIGN KEY(id_cli) REFERENCES COLABORADORES (id_cli)
);