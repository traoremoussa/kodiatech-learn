package com.kodiatech.learn.algorithm.arbre;

public interface IBinaryTree {
    public void insert(int key);
    public void delete(int key);
    public int minValeur(TreeNode racine);
    public TreeNode search(int key);
    public void afficher() ;
}
