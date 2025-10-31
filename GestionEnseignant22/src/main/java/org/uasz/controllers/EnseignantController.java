package org.uasz.controllers;

import org.springframework.ui.Model;
import  org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.uasz.entities.Enseignant;
import org.uasz.services.EnseignantService;

import java.util.Optional;


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
    @RequestMapping("/edit")
    public String update(Long id ,Model model) {
        Enseignant enseignant = enseignantService.getById(id);
        model.addAttribute("enseignant",enseignant);
        return "enseignant-edit";

    }
    @RequestMapping("/update")
    public String update(Enseignant enseignant){
        enseignantService.update(enseignant.getId(),enseignant);
        return "redirect:index";
    }
    @RequestMapping("/delete")
    public String delete(Long id){
        enseignantService.delete(id);
        return "redirect:index";
    }
}
