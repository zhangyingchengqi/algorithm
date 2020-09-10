package com.yc.bean3_datatype3.tree3.redblackTree;

import com.yc.bean3_datatype3.tree1.BinarySearchTree.BinaryNode;

public class RBNode<T extends Comparable<T>> extends BinaryNode {
    boolean color;//颜色

    RBNode<T> parent;//父节点

    public RBNode(boolean color, T key, RBNode<T> parent, RBNode<T> left, RBNode<T> right) {
        super(   key,left,right );
        this.color = color;
        this.parent = parent;
    }

    //获得节点的关键值
    public Comparable getKey() {
        return element;
    }

    //打印节点的关键值和颜色信息
    public String toString() {
        return "" + element + (this.color == true ? "R" : "B");
    }



}

