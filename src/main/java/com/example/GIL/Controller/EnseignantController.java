package com.example.GIL.Controller;

import com.example.GIL.repository.EnseignantRepository;
import com.example.GIL.service.EnseignantService;
import com.example.GIL.modele.Enseignant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;

@Controller
public class EnseignantController {

    @Autowired
    private EnseignantRepository enseignantRepository;

    @Autowired
    private EnseignantService enseignantService;




    @GetMapping("/")
    public String  allEnseigant(Model model )
    {
        List<Enseignant> sans =enseignantRepository.findAll();
        model.addAttribute("ens", sans);
        return "/enseignant.html";
    }

    @GetMapping("/delete_enseignant/{id}")
    public String deleteEnseignant(@PathVariable("id") int id)
    {
        enseignantService.deleteEnseignant(id);
        return "redirect:/";
    }

    @PostMapping("/create_enseignant")
    public String  CreatEnseignant(
                                @RequestParam("nom") String nom,
                                @RequestParam("mail") String mail,
                                @RequestParam("password") String password) {
        enseignantService.saveEnseignantToDB(nom, mail, password);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public  String EditEnseignant(@PathVariable("id") int id,Model model)
    {
        Enseignant ens = enseignantService.SearchEnseignant(id);
        model.addAttribute("id", id);

        return "/index.html";
    }


    @PostMapping("/update/{id}")
    public  String updateEnseignant(@PathVariable("id") int id,
                                    @RequestParam("newnom") String nom,
                                    @RequestParam("newmail") String mail,
                                    @RequestParam("newpassword") String password) {
        enseignantService.updateinformation(id, nom, mail, password);

        return "redirect:/";
    }



}

