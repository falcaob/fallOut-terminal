package com.iescantillana.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.iescantillana.models.Overseer;
import com.iescantillana.models.Survivor;
import com.iescantillana.services.OverseerServiceI;
import com.iescantillana.services.SurvivorService;

@Controller
@RequestMapping("/survivors")
public class SurvivorController {

	@Autowired
	private SurvivorService survivorService;

	@Autowired
	private OverseerServiceI overseerServiceI;

	@GetMapping("/list")
	public String listView(Model model) {
		System.out.println("Accediendo a templates/list");
		List<Survivor> listaSupervivientes = survivorService.getAllSurvivors();

		model.addAttribute("title", "Residentes del refugio");
		model.addAttribute("survivors", listaSupervivientes);

		return "list";
	}

	@GetMapping("/form")
	public String addSurvivor(Model model) {
		System.out.println("Accediendo a templates/form");

		model.addAttribute("title", "Registra un nuevo superviviente");
		model.addAttribute("survivor", new Survivor());

		return "form";
	}

	@PostMapping("/form")
	public String saveSurvivor(Survivor survivor, Long overseerId, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("title", "Formulario de Superviviente");
			return "form";
		}

		// Buscar y asignar el Overseer si se proporciona un ID
		if (overseerId != null) {
			Overseer overseer = overseerServiceI.findById(overseerId);
			if (overseer != null) {
				survivor.setOverseer(overseer);
			}
		}

		survivorService.save(survivor);

		return "redirect:/survivors/list";
	}

	@GetMapping("/form2/{id}")
	public String editSurvivor(@PathVariable(value = "id") Long id, Model model) {
		Survivor survivor = survivorService.findById(id);

		System.out.println("Accediendo a templates/form2 - edit");

		model.addAttribute("title", "Editar Superviviente");
		model.addAttribute("survivor", survivor);

		return "form2";
	}

	@GetMapping("/delete/{id}")
	public String deleteSurvivor(@PathVariable("id") Long id) {
		survivorService.delete(id);
		return "redirect:/survivors/list";
	}

	@GetMapping("/evacuation")
	public String evacuation() {
		return "evacuation";
	}

}
