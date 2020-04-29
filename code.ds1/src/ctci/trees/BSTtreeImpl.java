package trees;

public class BSTtreeImpl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearchTree tree = new BinarySearchTree();
		tree.add(5);
		tree.add(2);
		tree.add(7);
		tree.add(1);
		tree.add(3);
		tree.add(6);
		tree.add(8);
		tree.printInorder(tree.root);
		tree.generateDepthLists(tree.root);
		System.out.println("Check Balanced: "+tree.checkBalancedTree(tree.root));
		System.out.println("Validate BST: "+tree.validateBST(tree.root, null, null));
		tree.findLCA(tree.root, 1,8);
	
	}

}
