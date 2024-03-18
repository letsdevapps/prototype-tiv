package com.prototype.dto;

import java.time.LocalDate;
import java.util.List;

import com.prototype.dao.model.Documento;

import lombok.Data;

@Data
public class BeneficiarioDto {
	public Long id;
	public String nome;
	public String telefone;
	public LocalDate dataNascimento;
	public LocalDate dataInclusao;
	public LocalDate dataAtualizacao;

	public List<Documento> documentos;
}