package com.bhushan.sde.dsa.tree;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Node<T> {
    T data;
    Node<T> left;
    Node<T> right;

    public Node(T data) {
        this.data = data;
        this.left = this.right = null;
    }
}