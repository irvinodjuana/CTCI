class Question4_10:
    def compare(self, n1, n2):
        if not n1 and not n2:
            return True
        elif not n1 or not n2:
            return False
        elif n1.val != n2.val:
            return False
        return self.compare(n1.left, n2.left) and self.compare(n1.right, n2.right)

    def isSubtree(self, t1, t2):
        if not t2:
            return True
        elif not t1:
            return False
        elif t1.val == t2.val:
            if self.compare(t1, t2):
                return True
        return self.isSubtree(t1.left, t2) or self.isSubtree(t1.right, t2)

class Node:
    def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None

# helper
def insert(nodes, n, l, r):
    nodes[n].left = nodes[l]
    nodes[n].right = nodes[r]

def main():
    nodes = [None] * 19
    for i in range(18):
        nodes[i] = Node(i)
    
    none = 18
    insert(nodes, 0, 1, 4)
    insert(nodes, 1, 2, 3)
    insert(nodes, 3, 6, none)
    insert(nodes, 6, 7, 8)
    insert(nodes, 8, 9, 10)
    insert(nodes, 4, 5, 11)
    insert(nodes, 5, 13, none)
    insert(nodes, 13, none, 14)
    insert(nodes, 11, 12, none)
    insert(nodes, 12, 15, 16)
    insert(nodes, 16, none, 17)

    t1 = nodes[0]

    t2 = Node(8)
    t2.left = Node(9)
    t2.right = Node(10)

    q = Question4_10()
    print(q.isSubtree(t1, t2))   # True

    t2.right = None
    print(q.isSubtree(t1, t2))   # False


if __name__ == "__main__":
    main()

    
    
