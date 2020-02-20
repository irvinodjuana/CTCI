
class Question4_8:
    # Find first common ancestor of 2 nodes: O(n)
    def first_common_ancestor(self, root, n1, n2):
        code, node = self.DFS(root, n1, n2)
        return node
    
    # Recursive helper
    def DFS(self, root, n1, n2):
        if not root:
            return 0, None

        c1, res1 = self.DFS(root.left, n1, n2)
        c2, res2 = self.DFS(root.right, n1, n2)
        code = c1 + c2

        # Codes: 
        # (1 = n1 found in branch)
        # (2 = n2 found in branch)
        # (4 = FCA found in branch)
        if root == n1:
            if code == 2:       # n1 anc. of n2
                return 4, n1
            return 1, None
        
        elif root == n2:
            if code == 1:       # n2 anc. of n1
                return 4, n2
            return 2, None
        
        else:
            if code == 4:       # parent in branch
                if res1 is not None:
                    return 4, res1
                return 4, res2
            elif code == 3:     # current node is FCA
                return 4, root
            else:
                return code, None

class Node:
    def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None


def main():
    nodes = [None] * 9
    for i in range(9):
        nodes[i] = Node(i)
    
    # Test finding n5, n6 ancestor = other node
    nodes[0].left = nodes[1]
    nodes[0].right = nodes[2]
    nodes[1].left = nodes[3]
    nodes[1].right = nodes[4]
    nodes[3].right = nodes[5]
    nodes[4].right = nodes[6]
    nodes[2].left = nodes[7]
    nodes[2].right = nodes[8]

    Q = Question4_8()
    result = Q.first_common_ancestor(nodes[0], nodes[5], nodes[6])
    print("Should be 1:", result.val)

    # Test finding ancestor when n5 ancestor of n6
    nodes[2].left = None
    nodes[4].right = None
    nodes[5].right = nodes[7]
    nodes[7].left = nodes[6]

    result = Q.first_common_ancestor(nodes[0], nodes[5], nodes[6])
    print("Should be 5:", result.val)

if __name__ == "__main__":
    main()