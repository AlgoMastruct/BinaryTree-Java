import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Tree {
    private TreeNode root;

    public Tree() {
        root = new TreeNode(9);
        root.left = new TreeNode(5);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(1);
        root.right.right = new TreeNode(6);
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void inorder() {
        inorder(root);
    }

    private void inorder(TreeNode p) {
        if (p != null) {
            inorder(p.left);
            System.out.println(p.data + " ");
            inorder(p.right);
        }
    }

    private static void visit(TreeNode p) {
        System.out.println(p.data + " ");
    }

    public void preorder() {
        preorder(root);
    }

    private void preorder(TreeNode p) {
        if (p != null) {
            System.out.println(p.data);
            preorder(p.left);
            preorder(p.right);
        }
    }

    public void postorder() {
        postorder(root);
    }

    private void postorder(TreeNode p) {
        if (p != null) {
            postorder(p.left);
            postorder(p.right);
            System.out.println(p.data);
        }
    }

    public void nonRecursiveInorder() {
        java.util.Stack<TreeNode> s = new Stack<>();
        TreeNode p = root;
        while (true) {
            while (p != null) {
                s.push(p);
                p = p.left;
            }
            if (s.isEmpty()) {
                return;
            }
            p = s.pop();
            System.out.println(p.data + " ");
            p = p.right;
        }
    }

    public void nonRecursivePreOrder() {
        java.util.Stack<TreeNode> s = new Stack<>();
        TreeNode p = root;
        while (true) {
            while (p != null) {
                System.out.println(p.data + " ");
                s.push(p);
                p = p.left;
            }
            if (s.isEmpty()) {
                return;
            }
            p = s.pop();
            p = p.right;
        }
    }

    public void levelOrder() {
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode p = root;
        while (p != null) {
            System.out.print(p.data + " ");
            if (p.left != null) {
                q.offer(p.left);
            }
            if (p.right != null) {
                q.offer(p.right);
            }
            p = q.poll();
        }
    }

    public void incrementAllNodes() {
        incrementAllNodes(root);
    }

    private void incrementAllNodes(TreeNode p) {
        if (p != null) {
            p.data++;
            incrementAllNodes(p.left);
            incrementAllNodes(p.right);
        }
    }

    public int numberOfNodes() {
        return numberOfNodes(root);
    }

    private int numberOfNodes(TreeNode p) {
        if (p == null) {
            return 0;
        }
        return 1 + numberOfNodes(p.left) + numberOfNodes(p.right);
    }

    public int height() {
        return height(root);
    }

    private int height(TreeNode p) {
        if (p == null) {
            return -1;
        }
        int m = height(p.left);
        int n = height(p.right);
        return m > n ? m + 1 : n + 1;
    }

    public Tree(TreeNode original) {
        root = copy(original);
    }

    private TreeNode copy(TreeNode p) {
        if (p == null) {
            return null;
        }
        TreeNode temp = new TreeNode();
        temp.data = p.data;
        temp.left = copy(p.left);
        temp.right = copy(p.right);
        return temp;
    }

    private static boolean equals(TreeNode first, TreeNode second) {
        if (first == null && second == null) {
            return true;
        }
        return first != null
                && second != null
                && first.data == second.data
                && equals(first.left, second.left)
                && equals(first.right, second.right);
    }

    public boolean isFull() {
        return isFull(root);
    }

    private boolean isFull(TreeNode p) {
        if (p == null) {
            return true;
        }
        if (height(p.left) != height(p.right)) {
            return false;
        }
        return isFull(p.left) && isFull(p.right);
    }

    public boolean isStrict() {
        return isStrict(root);
    }

    private boolean isStrict(TreeNode p) {
        if (p == null) {
            return true;
        }
        if (p.left == null && p.right != null) {
            return false;
        }
        if (p.left != null && p.right == null) {
            return false;
        }

        return isStrict(p.left) && isStrict(p.right);
    }

    public boolean isBalanced() {
        return isBalanced(root);
    }

    private boolean isBalanced(TreeNode p) {
        if (p == null) {
            return true;
        }
        return (Math.abs(height(p.left) - height(p.right)) <= 1)
                && isBalanced(p.left) && isBalanced(p.right);
    }

    public boolean isComplete() {
        return isComplete(root);
    }

    private boolean isComplete(TreeNode p) {
        int leftHeight, rightHeight;
        boolean leftIsFull, rightIsFull, leftIsComplete, rightIsComplete;
        if (p == null) {
            return true;
        }
        leftHeight = height(p.left);
        rightHeight = height(p.right);
        leftIsFull = isFull(p.left);
        rightIsFull = isFull(p.right);
        leftIsComplete = isComplete(p.left);
        rightIsComplete = isComplete(p.right);

        if (leftIsFull && rightIsComplete && (leftHeight == rightHeight)) {
            return true;
        }
        if (leftIsComplete && rightIsFull && (leftHeight == (rightHeight + 1))) {
            return true;
        }
        return false;
    }

    public void printTree() {
        printTree(root);
    }

    private void printTree(TreeNode p) {
        if (p != null) {
            if (p.left != null) {
                System.out.print("(");
            }
            printTree(p.left);
            if (p.left != null) {
                System.out.print(")");
            }
            System.out.print(" " + p.data + " ");
            if (p.right != null) {
                System.out.print("(");
            }
            printTree(p.right);
            if (p.right != null) {
                System.out.print(")");
            }
        }
    }

    public void printSideways() {
        printSideways(root, " ");
    }

    private void printSideways(TreeNode p, String indent) {
        if (p != null) {
            printSideways(p.right, indent + "    ");
            System.out.println(indent + p.data);
            printSideways(p.left, indent + "    ");
        }
    }

    public boolean isLeftSkewedTree() {
        return isLeftSkewedTree(root);
    }

    private boolean isLeftSkewedTree(TreeNode p) {
        if (p != null) {
            if (p.right != null) {
                return false;
            }
            return isLeftSkewedTree(p.left);
        }
        return true;
    }

    public int countOfEvenNodes() {
        return countOfEvenNodes(root);
    }

    private int countOfEvenNodes(TreeNode p) {
        if (p == null) {
            return 0;
        }
        int count = 0;
        if (p.left != null) {
            count++;
        }
        return count + countOfEvenNodes(p.left) + countOfEvenNodes(p.right);
    }

    public int countOfLeaves() {
        return countOfLeaves(root);
    }

    private int countOfLeaves(TreeNode p) {
        if (p == null) {
            return 0;
        }
        if (p.left == null && p.right == null) {
            return 1;
        }
        return countOfLeaves(p.left) + countOfLeaves(p.right);
    }

    public int countOfNonLeaveNodes() {
        return countOfNonLeaveNodes(root);
    }

    private int countOfNonLeaveNodes(TreeNode p) {
        if (p == null) {
            return 0;
        }
        int count = 0;
        if (p.left != null || p.right != null) {
            count++;
        }
        return count + countOfNonLeaveNodes(p.left) + countOfNonLeaveNodes(p.right);
    }
}
