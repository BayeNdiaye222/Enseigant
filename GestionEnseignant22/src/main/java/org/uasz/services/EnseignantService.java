package org.uasz.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.uasz.entities.Enseignant;
import org.uasz.repositories.EnseignantRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EnseignantService {

    @Autowired
    private EnseignantRepository enseignantRepository;

    public void add(Enseignant enseignant){
        enseignantRepository.save(enseignant);
    }

    public List<Enseignant> getAll(){
        return enseignantRepository.findAll();
    }

    public Optional<Enseignant> getById(Long id){
        return enseignantRepository.findById(id);
    }

    public void update(Long id, Enseignant enseignant){
        Optional<Enseignant> data = getById(id);
        Enseignant enseignantData= data.get();

        if(enseignantData != null){
            enseignantData.setMatricule(enseignant.getMatricule());
            enseignantData.setNom(enseignant.getNom());
            enseignantData.setPrenom(enseignant.getPrenom());
            enseignantData.setAdresse(enseignant.getAdresse());
            enseignantData.setStatut(enseignant.getStatut());
            enseignantData.setMail(enseignant.getMail());
            enseignantData.setTelephone(enseignant.getTelephone());
        }
        enseignantRepository.save(enseignantData);
    }

    public void delete(Long id){
        enseignantRepository.deleteById(id);
    }

}
