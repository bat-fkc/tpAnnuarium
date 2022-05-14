package org.isj.ing.annuarium.webapp.presentation.controller;

import lombok.extern.slf4j.Slf4j;
import org.isj.ing.annuarium.webapp.model.dto.ActeDto;
import org.isj.ing.annuarium.webapp.services.IActe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@Slf4j
public class ActeController {

	@Autowired
	IActe iActe;

	@GetMapping("/")
	public String pageAcceuil() {
		return "index";
	}

	@GetMapping("/listeactes")
	public String pageListeActes(Model model) {
		//appel de la couche service
		List<ActeDto>  acteDtos = iActe.listActes();
		model.addAttribute("acteDtos", acteDtos);
		return "liste";
	}

	@GetMapping("/details")
	public String pageDetail(@RequestParam(name = "numero") String numero, Model model) {
		ActeDto acteDto = iActe.searchActeByNumero(numero);
		model.addAttribute("acteDto", acteDto);
		return "details";
	}

	@GetMapping("/supprimer")
	public String pageSupprimer(@RequestParam(name = "numero") String numero) {
		iActe.deleteActe(numero);
		return "redirect:/listeactes";
	}

}