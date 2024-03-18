package com.prototype.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prototype.dao.model.Beneficiario;
import com.prototype.dao.model.Documento;
import com.prototype.service.DocumentoService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.apachecommons.CommonsLog;

@CommonsLog
@RestController
@RequestMapping("/api/documento")
public class DocumentoApi {

	@Autowired
	private DocumentoService documentoService;

	@ApiOperation(value = "Listar todos os Documentos", response = Beneficiario.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successo", response = Beneficiario.class),
			@ApiResponse(code = 404, message = "Não Encontrado") })
	@GetMapping("/documentos")
	public ResponseEntity<List<Documento>> searchDocumentos() {
		log.info("----- API RESTfull | Search Documentos -----");
		return ResponseEntity.status(HttpStatus.OK).body(documentoService.findAll());
	}
}