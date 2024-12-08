package com.kodiatech.learn.algorithm.arbre;

public class Main {
    public static void main(String[] args) {
        IBinaryTree  tree = new BinaryTree();

        // Insertion
        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(20);
        tree.insert(40);
        tree.insert(60);
        tree.insert(80);

        // Recherche
        TreeNode result = tree.search(50);
        System.out.println(result != null ? "Trouvé : " + result.value : "Non trouvé");


        System.out.println("Arbre avant suppression:");
        tree.afficher();

        // Suppression d'un nœud
        tree.delete(20);  // Suppression d'une feuille
        tree.delete(30);  // Suppression d'un nœud avec un enfant
        tree.delete(50);  // Suppression d'un nœud avec deux enfants

        System.out.println("Arbre après suppression:");
        tree.afficher();
        // Suppression
        tree.delete(50);
    }
}
