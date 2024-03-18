package com.prototype.dao.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "documentos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Documento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "tipo_documento", nullable = false)
	private String tipoDocumento;

	@Column(name = "descricao", nullable = false)
	private String descricao;

	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "beneficiario_id")
	private Beneficiario beneficiario;

	@Column(name = "data_inclusao")
	private LocalDate dataInclusao;

	@Column(name = "data_atualizacao")
	private LocalDate dataAtualizacao;
}