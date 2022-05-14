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
	public String pageAcceuil(Model model) {
		return "index";
	}

	@GetMapping("/listactes")
	public String pageList(Model model) {
		//appel de la couche service
		List<ActeDto>  acteDtos = iActe.listActes();
		model.addAttribute("acteDtos", acteDtos);
		return "liste";
	}

}