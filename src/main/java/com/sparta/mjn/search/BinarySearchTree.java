package com.sparta.mjn.search;

import com.sparta.mjn.exceptions.ChildNotFoundException;

import java.util.LinkedList;

public class BinarySearchTree implements BinaryTree {

    private Node root;
    private int nodeCounter = 0;
    private int index = 0;

    public BinarySearchTree(int value) {
        root = new Node(value);
        nodeCounter++;
    }
    public BinarySearchTree(int[]array){
        root = new Node(array[0]);
        nodeCounter++;
        for(int i = 1; i < array.length;i++) {
            addElement(array[i]);
        }
    }

    @Override
    public int getRootElement() {
        return root.getValue();
    }

    @Override
    public int getNumberOfElements() {
        return nodeCounter;
    }

    @Override
    public void addElement(int element) {
        Node passedElement = new Node(element);
        Node checkingNode = root;
        while (passedElement != null) {
            if (passedElement.getValue() < root.getValue()) {
                if (checkingNode.getLeftChild() == null) {
                    checkingNode.setLeftChild(passedElement);
                    nodeCounter++;
                    return;
                } else {
                    checkingNode = checkingNode.getLeftChild();
                }
            } else {
                if (checkingNode.getRightChild() == null) {
                    checkingNode.setRightChild(passedElement);
                    nodeCounter++;
                    return;
                } else {
                    checkingNode = checkingNode.getRightChild();
                }
            }

        }
    }

    @Override
    public void addElements(int[] elements) {
        for (int element: elements) {
            addElement(element);
        }

    }

    @Override
    public boolean findElement(int value) {
       Node newElement=  findNode(root,value);
       if(newElement != null){
           return true;
       }
        return false;
    }

    private Node findNode(Node node,int value){

        while(node != null) {
            if (node.getValue() == value) {
                return node;
            } else if (value < node.getValue()) {
                return findNode(node.getLeftChild(), value);
            } else {
                return findNode(node.getRightChild(), value);
            }
        }

        return node;
    }

    @Override
    public int getLeftChild(int element) throws ChildNotFoundException {
        Node parent = findNode(root,element);
        Node leftChild = parent.getLeftChild();
        if(leftChild != null){
            return leftChild.getValue();
        }
        throw new ChildNotFoundException("No child found for " + element);
    }

    @Override
    public int getRightChild(int element) throws ChildNotFoundException {
        Node parent = findNode(root,element);
        Node rightChild = parent.getRightChild();
        if(rightChild != null){
            return rightChild.getValue();
        }
        throw new ChildNotFoundException("No child found for " + element);
    }

    private void ascendingBinaryTreeSorter(int[] unsortedArray,Node node){
        if(node != null){
                ascendingBinaryTreeSorter(unsortedArray,node.getLeftChild());
                unsortedArray[index++] = root.getValue();
                ascendingBinaryTreeSorter(unsortedArray,node.getRightChild());
                return;

        }
    }

    @Override
    public int[] getSortedTreeAsc() {
        index = 0;
        int[] sortedArray = new int[nodeCounter];
        ascendingBinaryTreeSorter(sortedArray,root);
        return sortedArray;
    }

    private void descendingBinaryTreeSorter(int[] unsortedArray,Node node){
        if(node != null){
            ascendingBinaryTreeSorter(unsortedArray,node.getRightChild());
            unsortedArray[index++] = root.getValue();
            ascendingBinaryTreeSorter(unsortedArray,node.getLeftChild());
            return;

        }
    }

    @Override
    public int[] getSortedTreeDesc() {
        index = 0;
        int[] sortedArray = new int[nodeCounter];
        descendingBinaryTreeSorter(sortedArray,root);
        return sortedArray;
    }


    private class Node {

        private final int value;
        private Node leftChild;
        private Node rightChild;

        Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public Node getRightChild() {
            return rightChild;
        }

        public void setRightChild(Node rightChild) {
            this.rightChild = rightChild;
        }

        public Node getLeftChild() {
            return leftChild;
        }

        public void setLeftChild(Node leftChild) {
            this.leftChild = leftChild;
        }

    }
}
