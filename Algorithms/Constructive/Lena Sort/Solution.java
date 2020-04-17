import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // This sort is similar to a binary tree,, in which key is a node and group of value less than key belong to
    // sub-left tree and group of value greater than key belong to sub-right tree.

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

    int nr = sc.nextInt();
    for (int i = 0; i < nr; i++) {
        long len = sc.nextInt();
        long c = sc.nextInt();
        String rs = solve(len, c);
        System.out.println(rs);
    }
    sc.close();
  }

  static long lowerbound(long n) {
        if (n == 1 || n == 0) {
            return 0;
        }
        if (n % 2 == 0) {
            return n - 1 + lowerbound(n / 2) + lowerbound(n/2 -1);
        } else {
            return n - 1 + 2 * lowerbound(n/2);
        }
    }

    private static String solve(long len, long c) {
        if (c > len * (len - 1) / 2 || c < lowerbound(len)) {
            return "-1";
        }
        // Build a full tree whose count + max possible count of remaining node is almost equal desired count

        int th = 0; // tree high count from 0
        int nl = 1; // number of maximum leaf node
        int tc = 0; // total count of all nodes in tree
        // max total count = total count + max possible gains from remaining nodes
        // Add remaining node to left most node of tree one by one, add 1 node, tree high increase 1
        long max_tc; 
        // remaining nodes = len - curren in-tree total node
        // current in-tree total node + 1 node = max possible leaf node when tree high + 1
        long rn; 
        while (true) { // each round make a full binary tree so remainng node can be lees than 0
            tc += nl * th;
            nl *= 2;
            rn = len - (nl -1);
            if (rn < 0) {
                max_tc = tc + rn * th;
            } else {
                max_tc = tc + (rn + th + th + 1) * rn / 2;
            }
            // max_tc < c mean that we can achieve desired count by increase count of some leaf node
            if (max_tc <= c) { //
                break;
            }
            th++;
        }

        List<TNode> lastNodes  = new ArrayList<>();
        TNode root = createBinaryTree(th, lastNodes);
        TNode firstLeftNode = lastNodes.get(0);
        if (rn < 0) { // remaining node < 0 => remove some leaf nodes
            while (rn < 0) {
                TNode lastNode = lastNodes.get(lastNodes.size() - 1);
                removeNode(lastNode);
                lastNodes.remove(lastNodes.size() - 1);
                rn++;
            }
        } else { // add all remaining node to left most node, one by one
            for (int i = 0; i < rn; i++) {
                TNode node = new TNode();
                node.parent = firstLeftNode;
                firstLeftNode.left = node;
                firstLeftNode = node;
            }
        }
        // Now tree count = max_tc

        if (max_tc < c) {
            long bonus = rn + 1;
            // Increase tree count by move leaf node to left most sub-left tree until it could be bigger desired count
            while (max_tc + bonus < c) {
                TNode lastNode = lastNodes.get(lastNodes.size() - 1);
                removeNode(lastNode);
                lastNodes.remove(lastNodes.size() - 1);
                lastNode.parent = firstLeftNode;
                firstLeftNode.left = lastNode;
                firstLeftNode = lastNode;
                max_tc += bonus;
                bonus++;
            }
            // Change position to attach node up node by node until we can get the desired count
            while (max_tc + bonus > c) {
                firstLeftNode = firstLeftNode.parent;
                bonus--;
            }
            // Attach node
            TNode lastNode = lastNodes.get(lastNodes.size() -1);
            removeNode(lastNode);
            lastNodes.remove(lastNodes.size() - 1);
            firstLeftNode.right = lastNode;
            lastNode.parent = firstLeftNode;
        }
        StringBuilder sb = new StringBuilder();

        // Recursive-way will cause stack over flow at some test cases
//        List<Integer> ls = new ArrayList<>();
//        generateNumber(1, root);
//        getListInt(root, ls);
//        for (int i : ls) {
//            sb.append(i).append(" ");
//        }
        List<TNode> nodes = generateValAndOrderNodes(0, root);
        for (TNode node : nodes) {
            sb.append(node.val).append(" ");
        }
        return sb.toString().trim();
    }

    static void getListInt(TNode node, List<Integer> ls) {
        ls.add(node.val);
        if (node.left != null) {
            getListInt(node.left, ls);
        }
        if (node.right != null) {
            getListInt(node.right, ls);
        }
    }

    static int generateNumber(int min, TNode node) {
        int currentMin = min;
        if (node.left != null) {
            currentMin = generateNumber(currentMin, node.left);
        }
        node.val = currentMin++;
        if (node.right != null) {
            currentMin = generateNumber(currentMin, node.right);
        }
        return currentMin;
    }

    static List<TNode> generateValAndOrderNodes(int min, TNode node) {
        Stack<TNode> stack = new Stack<>();
        List<TNode> nodes = new ArrayList<>();
        TNode cur = node;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                nodes.add(cur);
                cur = cur.left;
            }
            if (!stack.isEmpty()) {
                cur = stack.pop();
                cur.val = ++min;
                cur = cur.right;
            }
        }
        return nodes;
    }

    static void removeNode(TNode node) {
        if (node == node.parent.left) {
            node.parent.left = null;
        } else {
            node.parent.right = null;
        }
    }

    static TNode createBinaryTree(int high, List<TNode> lastNodes) {
        TNode node = new TNode();
        if (high > 0) {
            TNode leftNode = createBinaryTree(high - 1, lastNodes);
            TNode rightNode = createBinaryTree(high - 1, lastNodes);
            node.left = leftNode;
            leftNode.parent = node;
            node.right = rightNode;
            rightNode.parent = node;
        } else {
            lastNodes.add(node);
        }
        return node;
    }

    static class TNode {
        TNode parent;
        TNode left;
        TNode right;
        int val;
    }
}
