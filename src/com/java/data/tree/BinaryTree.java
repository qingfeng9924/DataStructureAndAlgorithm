package com.java.data.tree;

import java.util.Objects;

/**
 * 二叉检索树
 *
 * Created by zhangyuan on 2020/6/11 0011.
 */

public class BinaryTree {

    private TreeNode root;

    public BinaryTree(){

    }

    public void generateBinaryTree(TreeNode currentNode, int nodeValue){
//        int length = array.length;
//        if(length < 1){
//            return;
//        }
//        for(int i = 0; i < length; i++){
//            if(!Objects.isNull(this.root)){
//
//            }
//        }
        if(Objects.isNull(this.root)){
            this.root = new TreeNode(nodeValue);
        } else {
            if(Objects.isNull(currentNode)){
                currentNode = this.root;
            }
            Integer currentNodeVal = currentNode.getValue();
            if(currentNodeVal > nodeValue){
                if(Objects.isNull(currentNode.getLeftChild())){
                    currentNode.setLeftChild(new TreeNode(nodeValue));
                } else {
                    generateBinaryTree(currentNode.getLeftChild(),nodeValue);
                }
            } else {
                if(Objects.isNull(currentNode.getRightChild())){
                    currentNode.setRightChild(new TreeNode(nodeValue));
                } else {
                    generateBinaryTree(currentNode.getRightChild(),nodeValue);
                }
            }
        }
    }

    public void middleOrderPrint(){
        if(Objects.isNull(this.root)){
            return;
        } else {
            middleOrder(this.root);
        }
    }

    public void preOrderPrint(){
        if(Objects.isNull(this.root)){
            return;
        } else {
            preOrder(this.root);
        }
    }

    public void afterOrderPrint(){
        if(Objects.isNull(this.root)){
            return;
        } else {
            afterOrder(this.root);
        }
    }

    /**
     * 中序遍历
     *
     * @param treeNode
     */
    private void middleOrder(TreeNode treeNode){
        if(Objects.isNull(treeNode)){
            return;
        }
        middleOrder(treeNode.getLeftChild());
        System.out.print(treeNode.getValue());
        System.out.print("-");
        middleOrder(treeNode.getRightChild());

    }

    /**
     * 先序遍历
     *
     * @param treeNode
     */
    private void preOrder(TreeNode treeNode){
        if(Objects.isNull(treeNode)){
            return;
        }
        System.out.print(treeNode.getValue());
        preOrder(treeNode.getLeftChild());
        preOrder(treeNode.getRightChild());
    }

    /**
     * 后续遍历
     *
     * @param treeNode
     */
    private void afterOrder(TreeNode treeNode){
        if(Objects.isNull(treeNode)){
            return;
        }
        preOrder(treeNode.getLeftChild());
        preOrder(treeNode.getRightChild());
        System.out.print(treeNode.getValue());
    }

    class TreeNode {

        private Integer value;

        private TreeNode leftChild;

        private TreeNode rightChild;

        public TreeNode(Integer value){
            this.value = value;
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }

        public TreeNode getLeftChild() {
            return leftChild;
        }

        public void setLeftChild(TreeNode leftChild) {
            this.leftChild = leftChild;
        }

        public TreeNode getRightChild() {
            return rightChild;
        }

        public void setRightChild(TreeNode rightChild) {
            this.rightChild = rightChild;
        }

    }

}
