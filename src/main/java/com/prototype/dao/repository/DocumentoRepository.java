package com.prototype.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prototype.dao.model.Documento;

@Repository
public interface DocumentoRepository extends JpaRepository<Documento, Long> {

	List<Documento> findAllByBeneficiarioId(Long beneficiarioId);

	void deleteByBeneficiarioId(Long beneficiarioId);
}