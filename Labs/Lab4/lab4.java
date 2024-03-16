class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;
    
    public TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class lab4 {
    TreeNode root;

    public void insert(int data) {
        root = insertRec(root, data);
    }

    private TreeNode insertRec(TreeNode root, int data) {
        if (root == null) {
            return new TreeNode(data);
        }

        if (data < root.data) {
            root.left = insertRec(root.left, data);
        } else if (data > root.data) {
            root.right = insertRec(root.right, data);
        }

        return root;
    }

    public void inorder(TreeNode node) {
        if (node != null) {
        	inorder(node.left);
            System.out.print(node.data + " ");
            inorder(node.right);
        }
    }

    public void invertTree(TreeNode node) {
        if (node == null) {
            return;
        }

        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;

        invertTree(node.left);
        invertTree(node.right);
    }

    public static void main(String[] args) {
        lab4 tree = new lab4();
        tree.insert(4);
        tree.insert(2);
        tree.insert(7);
        tree.insert(1);
        tree.insert(3);
        tree.insert(6);
        tree.insert(9);

        System.out.println("Inorder traversal of original tree:");
        tree.inorder(tree.root);

        tree.invertTree(tree.root);

        System.out.println("\nInorder traversal of inverted tree:");
        tree.inorder(tree.root);
    }
}
