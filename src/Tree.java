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
}
