package com.prototype.api;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prototype.dao.model.Beneficiario;
import com.prototype.dao.model.Documento;
import com.prototype.dto.BeneficiarioDto;
import com.prototype.service.BeneficiarioService;
import com.prototype.service.DocumentoService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.apachecommons.CommonsLog;

@CommonsLog
@RestController
@RequestMapping("/api/beneficiario")
public class BeneficiarioApi {

	@Autowired
	private BeneficiarioService beneficiarioService;

	@Autowired
	private DocumentoService documentoService;

	@ApiOperation(value = "Listar todos os Beneficiarios", response = Beneficiario.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successo", response = Beneficiario.class),
			@ApiResponse(code = 404, message = "Não Encontrado") })
	@GetMapping("/beneficiarios")
	public ResponseEntity<List<BeneficiarioDto>> searchBeneficiarios() {
		log.info("----- API RESTful | Search Beneficiarios -----");
		List<BeneficiarioDto> beneficiarios = new ArrayList<BeneficiarioDto>();

			for (Beneficiario b : beneficiarioService.findAll()) {
				BeneficiarioDto dto = new BeneficiarioDto();
				
				dto.setId(b.getId());
				dto.setNome(b.getNome());
				dto.setTelefone(b.getTelefone());
				dto.setDataNascimento(b.getDataNascimento());
				dto.setDataInclusao(b.getDataInclusao());
				dto.setDataAtualizacao(b.getDataAtualizacao());
				dto.setDocumentos(new ArrayList<Documento>());

				for (Documento d : documentoService.findDocumentosByBeneficiarioId(b.getId())) {
					dto.getDocumentos().add(d);
				}
				beneficiarios.add(dto);
			}

			return ResponseEntity.ok(beneficiarios);
	}

	@ApiOperation(value = "Buscar Beneficiario por Id", response = Beneficiario.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successo", response = Beneficiario.class),
			@ApiResponse(code = 404, message = "Não Encontrado") })
	@GetMapping("/{id}")
	public ResponseEntity<Beneficiario> getBeneficiarioById(@PathVariable Long id) {
		log.info("----- API RESTful | Find Beneficiario Id -----");
		Beneficiario beneficiario = beneficiarioService.findById(id);
		return ResponseEntity.ok(beneficiario);
	}

	@ApiOperation(value = "Buscar Documentos por Beneficiario Id", response = Beneficiario.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successo", response = Beneficiario.class),
			@ApiResponse(code = 404, message = "Não Encontrado") })
	@GetMapping("/documentos/{id}")
	public ResponseEntity<List<Documento>> getDocumentosByBeneficiarioId(@PathVariable Long id) {
		log.info("----- API RESTful | Find Documentos By Beneficiario Id -----");
		Beneficiario existingBeneficiario = beneficiarioService.findById(id);
		if (existingBeneficiario == null) {
			return ResponseEntity.notFound().build();
		}
		List<Documento> documentos = documentoService.findByBeneficiarioId(id);
		for (Documento d : documentos) {
			d.setBeneficiario(existingBeneficiario);
		}
		return ResponseEntity.ok(documentos);
	}

	@ApiOperation(value = "Criar um Beneficiario", response = Beneficiario.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successo", response = Beneficiario.class),
			@ApiResponse(code = 404, message = "Não Encontrado") })
	@PostMapping
	public ResponseEntity<?> createBeneficiario(@RequestBody BeneficiarioDto beneficiarioDto) {
		log.info("----- API RESTful | Create Beneficiario -----");
		beneficiarioDto.setDataInclusao(LocalDate.now());
		beneficiarioDto.setDataAtualizacao(LocalDate.now());

		Beneficiario savedBeneficiario = new Beneficiario();
		savedBeneficiario.setNome(beneficiarioDto.getNome());
		savedBeneficiario.setTelefone(beneficiarioDto.getTelefone());
		savedBeneficiario.setDataNascimento(beneficiarioDto.getDataNascimento());
		savedBeneficiario.setDataInclusao(beneficiarioDto.getDataInclusao());
		savedBeneficiario.setDataAtualizacao(beneficiarioDto.getDataAtualizacao());

		savedBeneficiario = beneficiarioService.save(savedBeneficiario);

		for(Documento d : beneficiarioDto.getDocumentos()) {
			Documento savedDocumento = new Documento();

			savedDocumento.setTipoDocumento(d.getTipoDocumento());
			savedDocumento.setDescricao(d.getDescricao());
			savedDocumento.setBeneficiario(savedBeneficiario);
			savedDocumento.setDataInclusao(LocalDate.now());
			savedDocumento.setDataAtualizacao(LocalDate.now());

			documentoService.save(savedDocumento);
		}

		List<Documento> ld = documentoService.findDocumentosByBeneficiarioId(savedBeneficiario.getId());
		beneficiarioDto.setId(savedBeneficiario.getId());
		beneficiarioDto.setDocumentos(ld);

		return ResponseEntity.status(HttpStatus.CREATED).body(beneficiarioDto);
	}

	@ApiOperation(value = "Atualizar um Beneficiario", response = Beneficiario.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successo", response = Beneficiario.class),
			@ApiResponse(code = 404, message = "Não Encontrado") })
	@PutMapping("/{id}")
	public ResponseEntity<Beneficiario> updateBeneficiario(@PathVariable Long id,
			@RequestBody Beneficiario beneficiario) {
		Beneficiario existingBeneficiario = beneficiarioService.findById(id);
		if (existingBeneficiario == null) {
			return ResponseEntity.notFound().build();
		}

		beneficiario.setDataInclusao(existingBeneficiario.getDataInclusao());
		beneficiario.setDataAtualizacao(LocalDate.now());

		Beneficiario updatedBeneficiario = beneficiarioService.save(beneficiario);
		return ResponseEntity.ok(updatedBeneficiario);
	}

	@ApiOperation(value = "Remover um Beneficiario", response = Void.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successo", response = Void.class),
			@ApiResponse(code = 404, message = "Não Encontrado") })
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteBeneficiario(@PathVariable Long id) {
		log.info("----- API RESTful | Delete Beneficiario By Id -----");
		documentoService.deleteByBeneficiarioId(id);
		beneficiarioService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}