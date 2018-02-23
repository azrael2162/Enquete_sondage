package com.example.mhu.ratp;

import java.util.HashMap;
/**
 * Created by mhu on 22/02/18.
 */

public class Candidat {
    private String nom,prenom,frequence,age;
    private HashMap<String, Integer> lesReponses;

    public  Candidat(String prenom,String nom,String frequence,String age){
        this.prenom =prenom;
        this.nom =nom;
        this.frequence =frequence;
        this.age =age;
        this.lesReponses = new HashMap<String, Integer>();
    }
    public void ajouterReponse (String question, int score)
    {
        this.lesReponses.put(question, score);
    }
    public float getMoyenne()
    {
        float moyenne = 0;
        for (Integer score : this.lesReponses.values())
        {
            moyenne += score;
        }
        moyenne /= this.lesReponses.size();
        return moyenne;
    }

    public String getImageSmiley (String generique)
    {
        if (this.getMoyenne() < 8 )
            return generique +"1.png";
        else if (this.getMoyenne() < 14)
            return generique +"2.png";
        else return generique +"3.png";
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getFrequence() {
        return frequence;
    }

    public void setFrequence(String frequence) {
        this.frequence = frequence;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public HashMap<String, Integer> getLesReponses() {
        return lesReponses;
    }

    public void setLesReponses(HashMap<String, Integer> lesReponses) {
        this.lesReponses = lesReponses;
    }
}
