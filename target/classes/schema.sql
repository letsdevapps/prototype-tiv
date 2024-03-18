CREATE TABLE beneficiarios (
  id INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(255) NOT NULL,
  telefone VARCHAR(20),
  data_nascimento DATE,
  data_inclusao DATE,
  data_atualizacao DATE,
  PRIMARY KEY (id)
);

CREATE TABLE documentos (
  id INT NOT NULL AUTO_INCREMENT,
  tipo_documento VARCHAR(100) NOT NULL,
  descricao VARCHAR(255) NOT NULL,
  beneficiario_id INT NOT NULL,
  data_inclusao DATE,
  data_atualizacao DATE,
  PRIMARY KEY (id),
  CONSTRAINT fk_beneficiario_id FOREIGN KEY (beneficiario_id) REFERENCES beneficiarios(id)
);
