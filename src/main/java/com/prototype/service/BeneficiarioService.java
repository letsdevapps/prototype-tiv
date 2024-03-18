package com.prototype.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prototype.dao.model.Beneficiario;
import com.prototype.dao.repository.BeneficiarioRepository;

@Service
public class BeneficiarioService {

	@Autowired
	private BeneficiarioRepository beneficiarioRepository;

	public List<Beneficiario> findAll() {
		return beneficiarioRepository.findAll();
	}

	public Beneficiario findById(Long id) {
		return beneficiarioRepository.findById(id).orElse(null);
	}

	public Beneficiario save(Beneficiario beneficiario) {
		return beneficiarioRepository.saveAndFlush(beneficiario);
	}

	public void deleteById(Long id) {
		beneficiarioRepository.deleteById(id);
	}
}