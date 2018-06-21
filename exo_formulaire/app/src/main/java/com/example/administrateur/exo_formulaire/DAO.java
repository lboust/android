package com.example.administrateur.exo_formulaire;

import java.util.List;

/**
 * Created by Administrateur on 15/06/2018.
 */

public interface DAO {
    void ajouter(Personne personne);
    List<Personne> lister();
    void modifier(Personne personne);
    void supprimer(Personne personne);

}
