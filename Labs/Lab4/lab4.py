class TreeNode(Object):
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None

class lab4:
    def __init__(self):
        self.root = None

    def insert(self, data):
        self.root = self.insertRec(self.root, data)

    def insertRec(self, root, data):
        if root is None:
            return TreeNode(data)
        if data < root.data:
            root.left = self.insertRec(root.left, data)
        elif data > root.data:
            root.right = self.insertRec(root.right, data)
        return root

    def inorder(self, root):
        if node is not None:
            self.inorder(node.left)
            print(node.data, end=" ")
            self.inorder(node.right)

    def invertTree(self, root):
        if node is None:
            return
        temp = node.left
        node.left = node.right
        node.right = temp
        self.invertTree(node.left)
        self.invertTree(node.right)

tree = lab4()
tree.insert(4)
tree.insert(2)
tree.insert(7)
tree.insert(1)
tree.insert(3)
tree.insert(6)
tree.insert(9)
print("Inorder traversal of original tree:")
tree.inorder(tree.root)
tree.invertTree(tree.root)
print("\nInorder traversal of inverted tree:")
tree.inorder(tree.root)

