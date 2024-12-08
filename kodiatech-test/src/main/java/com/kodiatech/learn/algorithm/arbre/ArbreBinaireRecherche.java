package com.kodiatech.learn.algorithm.arbre;

import java.util.*;

public class ArbreBinaireRecherche {
    // Utilisation d'un TreeSet pour implémenter un arbre binaire de recherche
    private Set<Integer> arbre;  // Set pour stocker les éléments

    public ArbreBinaireRecherche() {
        // TreeSet maintient les éléments dans un ordre naturel (ordre croissant pour Integer)
        arbre = new TreeSet<>();
    }

    // Méthode pour insérer un élément dans l'arbre
    public boolean inserer(int valeur) {
        return arbre.add(valeur);  // add() retourne true si l'élément est ajouté, sinon false si déjà présent
    }

    // Méthode pour rechercher un élément dans l'arbre
    public boolean rechercher(int valeur) {
        return arbre.contains(valeur);  // contains() retourne true si l'élément est trouvé
    }

    // Méthode pour supprimer un élément de l'arbre
    public boolean supprimer(int valeur) {
        return arbre.remove(valeur);  // remove() retourne true si l'élément a été supprimé
    }

    // Méthode d'affichage de l'arbre
    public void afficher() {
        System.out.println("Arbre (éléments en ordre croissant) : " + arbre);
    }

    public static void main(String[] args) {
        ArbreBinaireRecherche arbre = new ArbreBinaireRecherche();

        // Insertion des éléments
        arbre.inserer(50);
        arbre.inserer(30);
        arbre.inserer(20);
        arbre.inserer(40);
        arbre.inserer(70);
        arbre.inserer(60);
        arbre.inserer(80);

        // Affichage de l'arbre
        arbre.afficher();

        // Recherche d'éléments
        int rechercheValeur = 40;
        if (arbre.rechercher(rechercheValeur)) {
            System.out.println("L'élément " + rechercheValeur + " a été trouvé dans l'arbre.");
        } else {
            System.out.println("L'élément " + rechercheValeur + " n'a pas été trouvé dans l'arbre.");
        }

        // Suppression d'un élément
        int suppressionValeur = 30;
        if (arbre.supprimer(suppressionValeur)) {
            System.out.println("L'élément " + suppressionValeur + " a été supprimé.");
        } else {
            System.out.println("L'élément " + suppressionValeur + " n'a pas été trouvé.");
        }

        // Affichage après suppression
        arbre.afficher();
    }
}
