package org.uasz.controllers;

import org.springframework.ui.Model;
import  org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.uasz.entities.Enseignant;
import org.uasz.services.EnseignantService;


@Controller
public class EnseignantController {
    private EnseignantService enseignantService;

    public EnseignantController(EnseignantService enseignantService) {
        this.enseignantService = enseignantService;
    }

    @RequestMapping("/index")
    public String index(Model model) {
        model.addAttribute("enseignants",enseignantService.getAll());

        return "enseignant-liste";
    }

    @RequestMapping("/create")
    public String addEnseignant(Model model){
        model.addAttribute("enseignant", new Enseignant());
        return "enseignant-ajout";
    }
    @RequestMapping("/save")
    public String save(Enseignant enseignant){
        enseignantService.add(enseignant);
        return "redirect:/enseignant/index";

    }
}
