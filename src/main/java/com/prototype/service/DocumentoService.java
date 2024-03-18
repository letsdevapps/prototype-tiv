package com.prototype.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prototype.dao.model.Documento;
import com.prototype.dao.repository.DocumentoRepository;

@Service
public class DocumentoService {

	@Autowired
	private DocumentoRepository documentoRepository;

	public List<Documento> findAll() {
		return documentoRepository.findAll();
	}

	public Documento save(Documento documento) {
		return documentoRepository.saveAndFlush(documento);
	}

	public List<Documento> findDocumentosByBeneficiarioId(Long id) {
		return documentoRepository.findAllByBeneficiarioId(id);
	}

	@Transactional
	public void deleteByBeneficiarioId(Long beneficiarioId) {
		documentoRepository.deleteByBeneficiarioId(beneficiarioId);
	}

	public List<Documento> findByBeneficiarioId(Long beneficiarioId) {
		return documentoRepository.findAllByBeneficiarioId(beneficiarioId);
	}
}