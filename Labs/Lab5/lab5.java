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

public class lab5 {
	
	TreeNode root;
	
	public void insert(int data) {
		root = insertRec(root, data);
	}
	
	public TreeNode insertRec(TreeNode root, int data) {
		
		if(root == null) {
			root = new TreeNode(data);
		}
		else if(Math.random() > 0.5) {
			root.left = insertRec(root.left, data);
		}
		else{
			root.right = insertRec(root.right, data);
		}
		
		return root;
	}
	
	public void inOrder(TreeNode root) {
		if (root != null) {
			inOrder(root.left);
			System.out.print(root.data + " ");
			inOrder(root.right);
		}
	}
	
	public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }

        if ((min != null && root.data <= min) || (max != null && root.data >= max)) {
            return false;
        }

        return isValidBST(root.left, min, root.data) && isValidBST(root.right, root.data, max);
    }
	
	public static void main(String[] args) {
		lab5 bst = new lab5();
		bst.insert(4);
		bst.insert(8);
		bst.insert(3);
		bst.insert(1);
		bst.insert(5);
		
		bst.inOrder(bst.root);
		
		Boolean isValid = bst.isValidBST(bst.root);
		System.out.println(isValid);
		
	}
}