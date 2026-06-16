package com.bhushan.sde.dsa.tree.binarytree;

import com.bhushan.sde.dsa.tree.Node;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class BinaryTree {
    public static <T> Node<T> buildTree(T[] arr, int index) {
        if (index >= arr.length || arr[index] == null) {
            return null;
        }
        Node<T> node = new Node<>(arr[index]);

        node.setLeft(buildTree(arr, 2 * index + 1));
        node.setRight(buildTree(arr, 2 * index + 2));
        return node;
    }

    public static <T> void inorder(Node<T> root) {
        if (root == null) {
            return;
        }
        inorder(root.getLeft());
        System.out.print(root.getData() + " ");
        inorder(root.getRight());
    }

    public static <T> void preorder(Node<T> root) {
        if (root == null) {
            return;
        }
        System.out.print(root.getData() + " ");
        preorder(root.getLeft());
        preorder(root.getRight());
    }

    public static <T> void postorder(Node<T> root) {
        if (root == null) {
            return;
        }
        preorder(root.getLeft());
        preorder(root.getRight());
        System.out.print(root.getData() + " ");
    }

    public static <T> int nodeCount(Node<T> root) {
        if (root == null) {
            return 0;
        }
       return nodeCount(root.getLeft()) + nodeCount(root.getRight()) + 1;
    }

    public static int nodeSum(Node<Integer> root) {
        if (root == null) {
            return 0;
        }
        return nodeSum(root.getLeft()) + nodeSum(root.getRight()) + root.getData();
    }

    public static <T> int nodeHeight(Node<T> root) {
        if (root == null) {
            return 0;
        }
        return Math.max(nodeHeight(root.getLeft()), nodeHeight(root.getRight())) + 1;
    }

    // Time Complexity: O(n^2)
    public static <T> int diameter(Node<T> root) {
        if (root == null) {
            return 0;
        }
        int leftDiameter = diameter(root.getLeft());
        int rightDiameter = diameter(root.getRight());
        int diameter = nodeHeight(root.getLeft()) + nodeHeight(root.getRight()) + 1 ;
        return Math.max(diameter, Math.max(leftDiameter, rightDiameter));
    }

    // Time Complexity: O(n)
    public static <T> TreeInfo diameterTreeInfo(Node<T> root) {
        if (root == null) {
            return new TreeInfo(0,0);
        }
        TreeInfo left = diameterTreeInfo(root.getLeft());
        TreeInfo right = diameterTreeInfo(root.getRight());

        int height = Math.max(left.height, right.height)+1;
        int diameter = left.height+ right.height + 1 ;
        int myDiameter = Math.max(diameter, Math.max(left.diameter, right.diameter));
        return new TreeInfo(height, myDiameter);
    }

    public static <T> void levelOrder(Node<T> root) {
        if (Objects.isNull(root)) return;
        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()) {
            Node<T> current = queue.remove();
            if (Objects.isNull(current)) {
                if (queue.isEmpty()) {
                    break;
                }
                System.out.println();
                queue.add(null);
            } else {
                System.out.print(current.getData() + " ");
                if (Objects.nonNull(current.getLeft())) {
                    queue.add(current.getLeft());
                }
                if (Objects.nonNull(current.getRight())) {
                    queue.add(current.getRight());
                }
            }
        }
    }

}
