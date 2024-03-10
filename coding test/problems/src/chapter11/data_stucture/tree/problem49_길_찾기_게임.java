package chapter11.data_stucture.tree;

import java.util.ArrayList;
import java.util.List;

public class problem49_길_찾기_게임 {

    private static List<Node> nodeList = new ArrayList<>();

    public int[][] solution(int[][] nodeinfo) {
        for (int i = 0; i < nodeinfo.length; i++) {
            Node node = new Node(i + 1, nodeinfo[i][0], nodeinfo[i][1]);
            nodeList.add(node);
        }

        nodeList.sort((o1, o2) -> o2.y - o1.y);

        Node root = createBinaryTree(nodeList);
        List<Integer> preOrder = pre(root);
        List<Integer> postOrder = post(root);

        List<List<Integer>> result = new ArrayList<>();
        result.add(preOrder);
        result.add(postOrder);

        return new int[][]{
                preOrder.stream().mapToInt(Integer::intValue).toArray(),
                postOrder.stream().mapToInt(Integer::intValue).toArray()
        };
    }

    private List<Integer> post(Node node) {
        List<Integer> postOrder = new ArrayList<>();
        if(node == null) return postOrder;

        postOrder.addAll(post(node.left));
        postOrder.addAll(post(node.right));
        postOrder.add(node.value);

        return postOrder;
    }

    private List<Integer> pre(Node node) {
        List<Integer> preOrder = new ArrayList<>();
        if(node == null) return preOrder;

        preOrder.add(node.value);
        preOrder.addAll(pre(node.left));
        preOrder.addAll(pre(node.right));
        return preOrder;
    }

    private Node createBinaryTree(List<Node> nodeList) {
        Node root = nodeList.get(0);

        for (int i = 1; i < nodeList.size(); i++) {
            insert(root, nodeList.get(i));
        }

        return root;
    }

    private void insert(Node root, Node node) {
        if (node.x < root.x) {
            if (root.left == null) {
                root.left = node;
            } else {
                insert(root.left, node);
            }
        } else {
            if (root.right == null) {
                root.right = node;
            } else {
                insert(root.right, node);
            }
        }
    }

    private static class Node {
        final int value;
        final int x;
        final int y;
        Node left;
        Node right;

        public Node(int value, int x, int y) {
            this.value = value;
            this.x = x;
            this.y = y;
        }
    }
}
