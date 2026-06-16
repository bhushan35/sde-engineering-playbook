package com.bhushan.sde.dsa.tree;


import static com.bhushan.sde.dsa.tree.binarytree.BinaryTree.*;
public class TreeMain {
    public static void main(String[] args) {
        Integer[] numbers = {1, 2, 3, 4, 5, 6, 7};
        Node<Integer> intRoot = buildTree(numbers, 0);
        String[] names = {"A", "B", "C", "D", "E","G", "H", "I"};
        Node<String> stringRoot = buildTree(names, 0);
        inorder(intRoot);
        System.out.println();
        levelOrder(intRoot);
        System.out.println();
        System.out.println("Node Count " + nodeCount(intRoot));
        System.out.println("Node Sum " + nodeSum(intRoot));
        System.out.println("Tree Height " + nodeHeight(intRoot));
        inorder(stringRoot);
        System.out.println();
        System.out.println("Tree Height(String) " + nodeHeight(stringRoot));
        System.out.println("Tree diameter " + diameter(stringRoot));
        System.out.println("Tree diameter(O(N)) " + diameterTreeInfo(stringRoot).getDiameter());
    }
}
