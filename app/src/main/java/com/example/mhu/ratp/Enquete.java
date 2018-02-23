package com.example.mhu.ratp;

import java.util.HashMap;

/**
 * Created by mhu on 22/02/18.
 */

public class Enquete {
    private static HashMap<String, Candidat> lesCandidats = new HashMap<String, Candidat>();

    public static void ajouterCandidat( Candidat unCandidat)
    {
        Enquete.lesCandidats.put(unCandidat.getNom(), unCandidat);
    }
    public static void ajouterReponse (String nom, String question ,int score)
    {
        Enquete.lesCandidats.get(nom).ajouterReponse(question,score);
    }
    public static float getLaMoyenneCandidat (String nom)
    {
        return Enquete.lesCandidats.get(nom).getMoyenne();
    }
    public static String getImageSmileyCandidat (String nom,String generique)
    {
        return Enquete.lesCandidats.get(nom).getImageSmiley(generique);
    }
}
