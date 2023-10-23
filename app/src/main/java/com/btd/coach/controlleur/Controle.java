package com.btd.coach.controlleur;

import android.content.Context;

import com.btd.coach.modele.Profil;
import com.btd.coach.outils.Serializer;

public final class Controle {

    /**
     * constructeur prive
     */
    private static Controle instance=null;
    private static Profil profil;
    private static String nomFic="saveprofil";

    private Controle(){
        super();
    }

    /**
     * Creation de l'instance
     * @return instance
     */
    public static final Controle getInstance(Context context){
        if (Controle.instance==null){
            Controle.instance=new Controle();
            recupSerialize(context);
        }
        return Controle.instance;
    }

    /**
     * Creation du profil
     * @param poids
     * @param taille en cm
     * @param age
     * @param sexe 1-> homme 0-> Femme
     */
    public void creerProfil(Integer poids, Integer taille, Integer age, Integer sexe, Context context){
        profil=new Profil(poids, taille, age, sexe);
        Serializer.serialize(nomFic,profil,context);
    }

    /**
     * recuperation de img de profil
     * @return img
     */
    public float getImg(){
        return profil.getImg();
    }

    /**
     * recuperation message de profil
     * @return message
     */
    public String getMessage(){
        return profil.getMessage();
    }

    private  static void recupSerialize(Context context){
        profil=(Profil)(Serializer.deSerialize(nomFic,context));
    }

    public Integer getPoids(){
        if (profil==null){
            return null;
        }
        else return profil.getPoids();
    }
    public Integer getTaille(){
        if (profil==null){
            return null;
        }
        else return profil.getTaille();
    }
    public Integer getAge(){
        if (profil==null){
            return null;
        }
        else return profil.getAge();
    }
    public Integer getSexe(){
        if (profil==null){
            return null;
        }
        else return profil.getSexe();
    }


}
