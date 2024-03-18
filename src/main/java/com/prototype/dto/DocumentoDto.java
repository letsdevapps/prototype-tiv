package com.prototype.dto;

import java.time.LocalDate;

import com.prototype.dao.model.Beneficiario;

public class DocumentoDto {
	public Long id;
	public String tipoDocumento;
	public String descricao;
	public Beneficiario beneficiario;
	public LocalDate dataInclusao;
	public LocalDate dataAtualizacao;
}