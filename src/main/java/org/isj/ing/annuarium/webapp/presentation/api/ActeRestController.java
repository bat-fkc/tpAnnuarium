package org.isj.ing.annuarium.webapp.presentation.api;

import org.isj.ing.annuarium.webapp.model.dto.ActeDto;
import org.isj.ing.annuarium.webapp.services.IActe;
import lombok.extern.slf4j.Slf4j;
import org.isj.ing.annuarium.webapp.model.dto.ActeDto;
import org.isj.ing.annuarium.webapp.services.IActe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/acte")
@Slf4j
public class ActeRestController {

	@Autowired
	private IActe iActe;


	@PostMapping (value = "/save")
	public void enregistrer(@RequestBody ActeDto create) {
		ActeRestController.log.info("enregistrer-acte");
		iActe.saveActe(create);
	}


	@GetMapping("/{numero}/data")
	public ResponseEntity<ActeDto> getMaterielByReference(@PathVariable String numero) {

		return ResponseEntity.ok(iActe.searchActeByNumero(numero));
	}


	@GetMapping("/all")
	public ResponseEntity<List<ActeDto>> getAllMateriels() {

		return ResponseEntity.ok(iActe.listActes());
	}

	@GetMapping("/{numero}/delete")
	public void deteleActe(@PathVariable String numero) {
		iActe.deleteActe(numero);
	}

}