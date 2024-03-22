from typing import List

class TreeNode(object):
    def __init__(self, data=None, left=None, right=None):
        self.data = data
        self.left = left
        self.right = right

class HW10:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        result = []
        self.levelOrderHelper(root, result, 0)
        return result
    
    def levelOrderHelper(self, node: TreeNode, result: List[List[int]], level: int):
        if node is None:
            return
        if level == len(result):
            result.append([])
        result[level].append(node.data)
        self.levelOrderHelper(node.left, result, level + 1)
        self.levelOrderHelper(node.right, result, level + 1)

root = TreeNode(4)
root.left = TreeNode(3)
root.left.left = TreeNode(1)
root.right = TreeNode(8)
root.right.left = TreeNode(5)
root.right.right = TreeNode(9)

run = HW10()
levelOrderTraversal = run.levelOrder(root)
print("Level order traversal: ")
for level in levelOrderTraversal:
    print(level)

