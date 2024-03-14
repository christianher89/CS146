
class TreeNode {
		int data;
		TreeNode right;
		TreeNode left;
		
		public TreeNode() {
			
		}
		
		public TreeNode(int data) {
			this.data = data;
		}
		
		public TreeNode(int data, TreeNode left, TreeNode right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}

public class BST {
	
	TreeNode root;
	
	public void insert(int data) {
		root = insertRec(root, data);
	}
	
	public TreeNode insertRec(TreeNode root, int data) {
		
		if(root == null) {
			root = new TreeNode(data);
		}
		else if(data < root.data) {
			root.left = insertRec(root.left, data);
		}
		else if(data > root.data) {
			root.right = insertRec(root.right, data);
		}
		
		return root;
	}
	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		
		if(root == null) {
			return null;
		}
		
		if (p.data < root.data && q.data < root.data) {
			return lowestCommonAncestor(root.left, p, q);
		}
		else if(p.data > root.data && q.data > root.data) {
			return lowestCommonAncestor(root.right, p, q);
		}
		else {
			return root;
		}
	}
	
	public static void main(String[] args) {
		BST bst = new BST();
		bst.insert(4);
		bst.insert(3);
		bst.insert(8);
		bst.insert(1);
		bst.insert(5);
		bst.insert(9);
		
		TreeNode p = new TreeNode(1);
		TreeNode q = new TreeNode(5);
		TreeNode lca = bst.lowestCommonAncestor(bst.root, p, q);
		System.out.println("The LCA of " + p.data + " and " + q.data + " is " + lca.data);
	}
}


