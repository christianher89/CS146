class TreeNode:
    def __init__(self, data=0, left=None, right=None):
        self.data = data
        self.left = left
        self.right = right

class BST:
    def __init__(self):
        self.root = None

    def insert(self, data):
        self.root = self.insertRec(self.root, data)

    def insertRec(self, root, data):
        if root is None:
            root = TreeNode(data)
        elif data < root.data:
            root.left = self.insertRec(root.left, data)
        elif data > root.data:
            root.right = self.insertRec(root.right, data)
        return root

    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if root is None:
            return None
        if p.data < root.data and q.data < root.data:
            return self.lowestCommonAncestor(root.left, p, q)
        elif p.data > root.data and q.data > root.data:
            return self.lowestCommonAncestor(root.right, p, q)
        else:
            return root

bst = BST()
bst.insert(4)
bst.insert(3)
bst.insert(8)
bst.insert(1)
bst.insert(5)
bst.insert(9)
p = TreeNode(1)
q = TreeNode(5)
lca = bst.lowestCommonAncestor(bst.root, p, q)
print("The LCA of", p.data, "and", q.data, "is", lca.data)

