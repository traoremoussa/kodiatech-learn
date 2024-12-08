package com.kodiatech.learn.algorithm.arbre;

public class BinaryTree implements IBinaryTree {
    TreeNode root;

    @Override
    public void insert(int key) {
        root = insert(root, key);
    }

    @Override
    public void delete(int key) {
        root = delete(root, key);
    }


    @Override
    public TreeNode search(int key) {
        return search(root, key);
    }

    @Override
    public void afficher() {
        afficherRec(root);
        System.out.println();
    }

    @Override
    public int minValeur(TreeNode racine) {
        return 0;
    }

    //--------------------------------------------------------------------------------------------------------------
    private void afficherRec(TreeNode racine) {
        if (racine != null) {
            afficherRec(racine.left);
            System.out.print(racine.value + " ");
            afficherRec(racine.right);
        }
    }

    //----------------------------------------------------------------------------------------------------------------
    public TreeNode search(TreeNode root, int key) {
        if (root == null || root.value == key) {
            return root; // Trouvé ou atteint une feuille.
        }
        if (key < root.value) {
            return search(root.left, key); // Rechercher à gauche.
        }
        return search(root.right, key); // Rechercher à droite.
    }


    public TreeNode insert(TreeNode root, int key) {
        if (root == null) {
            return new TreeNode(key); // Crée un nouveau nœud.
        }
        if (key < root.value) {
            root.left = insert(root.left, key); // Insertion à gauche.
        } else if (key > root.value) {
            root.right = insert(root.right, key); // Insertion à droite.
        }
        return root;
    }

    public TreeNode delete(TreeNode root, int key) {
        if (root == null) return null; // Nœud non trouvé.

        if (key < root.value) {
            root.left = delete(root.left, key); // Chercher à gauche.
        } else if (key > root.value) {
            root.right = delete(root.right, key); // Chercher à droite.
        } else {
            // Cas 1 : Nœud feuille ou avec un enfant.
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            // Cas 2 : Nœud avec deux enfants.
            TreeNode minNode = findMin(root.right); // Trouver successeur.
            root.value = minNode.value; // Remplacer la valeur.
            root.right = delete(root.right, minNode.value); // Supprimer successeur.
        }
        return root;
    }

    private TreeNode findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left; // Trouver le plus petit.
        }
        return node;
    }

}
