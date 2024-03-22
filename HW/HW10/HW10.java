import java.util.*;

class TreeNode {
	int data;
	TreeNode left;
	TreeNode right;
	
	TreeNode(){
		
	}
	
	TreeNode(int data){
		this.data = data;
	}
	
	TreeNode(int data, TreeNode left, TreeNode right){
		this.data = data;
		this.left = left;
		this.right = right;
	}
}


public class HW10 {
	public List<List<Integer>> levelOrder(TreeNode root){
		List<List<Integer>> result = new ArrayList<>();
		levelOrderHelper(root, result, 0);
		
		return result;
	}
	
	private void levelOrderHelper(TreeNode node, List<List<Integer>> result, int level) {
		if(node == null) {
			return;
		}
		
		if(level == result.size()) {
			result.add(new ArrayList<>());
		}
		
		result.get(level).add(node.data);
		
		levelOrderHelper(node.left, result, level + 1);
		levelOrderHelper(node.right, result, level + 1);
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(3);
		root.left.left = new TreeNode(1);
		root.right = new TreeNode(8);
		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(9);
		
		HW10 run = new HW10();
		
		List<List<Integer>> levelOrderTraversal = run.levelOrder(root);
		
		System.out.println("Level order traversal: ");
		for(List<Integer> level: levelOrderTraversal) {
			System.out.print(level);
		}
		
	}
}
