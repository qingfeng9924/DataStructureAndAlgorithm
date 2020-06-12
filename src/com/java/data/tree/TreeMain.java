package com.java.data.tree;

/**
 * Created by zhangyuan on 2020/6/11 0011.
 */
public class TreeMain {
    public static void main(String []args){
        int []array = {3,2,11,4,2,55,43,23,66,57};
        BinaryTree binaryTree = new BinaryTree();
        for(int i = 0; i < array.length; i ++){
            binaryTree.generateBinaryTree(null,array[i]);
        }
        binaryTree.middleOrderPrint();
    }
}
