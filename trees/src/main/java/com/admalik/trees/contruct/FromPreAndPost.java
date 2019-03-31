package com.admalik.trees.contruct;

public class FromPreAndPost {

    class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    private int currentIndex;

    private Node buildTree(int[] pre, int[] post, int low, int high) {
        if (currentIndex >= pre.length || low > high) return null;
        Node node = new Node(pre[currentIndex++]);
        if (low == high || currentIndex == pre.length) return node;
        int midIndex = getMidIndex(pre, post, low, high);

        if (midIndex <= high) {
            node.left = buildTree(pre, post, low, midIndex);
            node.right = buildTree(pre, post, midIndex + 1, high);
        }
        return node;
    }

    private int getMidIndex(int[] pre, int[] post, int low, int high) {
        int index;
        for (index = low; index <= high; index++) {
            if (pre[currentIndex] == post[index]) break;
        }
        return index;
    }


    private Node convertTree(int[] pre, int[] post) {
        currentIndex = 0;
        if (pre.length == post.length)
            return buildTree(pre, post, 0, pre.length - 1);

        return null;
    }

    private void printTree(Node root) {
        if (root == null) return;

        printTree(root.left);
        System.out.print(root.data + " ");
        printTree(root.right);
    }

    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 8, 9, 5, 3, 6, 7},
                post = {8, 9, 4, 5, 2, 6, 7, 3, 1};

        FromPreAndPost fromPreAndPost = new FromPreAndPost();
        fromPreAndPost.printTree(fromPreAndPost.convertTree(pre, post));
    }
}
