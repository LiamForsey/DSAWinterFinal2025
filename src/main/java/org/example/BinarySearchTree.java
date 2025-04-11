package org.example;

import java.util.Arrays;

public class BinarySearchTree {
    private static class Node {
        int value;
        Node left, right;
        Node(int value) { this.value = value; }
    }

    private Node root;

    // Standard BST methods
    public void insert(int value) {
        root = insertRec(root, value);
    }

    private Node insertRec(Node root, int value) {
        if (root == null) return new Node(value);
        if (value < root.value) {
            root.left = insertRec(root.left, value);
        } else if (value > root.value) {
            root.right = insertRec(root.right, value);
        }
        return root;
    }

    // Visualization methods
    public String visualize() {
        return visualizeRec(root);
    }

    private String visualizeRec(Node root) {
        if (root == null) return "null";
        return root.value + " -> (" + visualizeRec(root.left) + ", " + visualizeRec(root.right) + ")";
    }

    public String visualizeFormatted() {
        return formatTree(root, 0);
    }

    private String formatTree(Node node, int level) {
        if (node == null) return "";
        String indent = "  ".repeat(level);
        return formatTree(node.right, level + 1) +
                indent + node.value + "\n" +
                formatTree(node.left, level + 1);
    }

    // Balanced tree methods
    public BinarySearchTree buildBalancedTree(int[] numbers) {
        Arrays.sort(numbers);
        BinarySearchTree tree = new BinarySearchTree();
        buildBalancedTreeRec(tree, numbers, 0, numbers.length - 1);
        return tree;
    }

    private void buildBalancedTreeRec(BinarySearchTree tree, int[] numbers, int start, int end) {
        if (start > end) return;
        int mid = (start + end) / 2;
        tree.insert(numbers[mid]);
        buildBalancedTreeRec(tree, numbers, start, mid - 1);
        buildBalancedTreeRec(tree, numbers, mid + 1, end);
    }
}