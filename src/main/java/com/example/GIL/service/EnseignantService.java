package com.example.GIL.service;

import com.example.GIL.repository.EnseignantRepository;
import com.example.GIL.modele.Enseignant;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class EnseignantService {
    @Autowired
    private EnseignantRepository enseignantRepository;


    public Enseignant saveEnseignantToDB(String name, String email, String password)
    {
        Enseignant enseignant = new Enseignant();

        enseignant.setEmail(email);
        enseignant.setPassword(password);

        enseignant.setNom(name);


        enseignantRepository.save(enseignant);
        return enseignant;
    }




    public void deleteEnseignant (int id){
        try {
            enseignantRepository.deleteById(id);
        } catch (Exception e){

        }
    }



    public void updateinformation(int id, String name, String email, String password)
    {
        Enseignant ens=new Enseignant();
        ens=enseignantRepository.findById(id).get();
        ens.setNom(name);
        ens.setEmail(email);
        ens.setPassword(password);

        enseignantRepository.save(ens);
    }


public Enseignant SearchEnseignant(int id)
    {
        Enseignant enseignant = new Enseignant();
        enseignant = enseignantRepository.findById(id).get();
        return enseignant;
    }


}
