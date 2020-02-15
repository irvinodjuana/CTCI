

class Question4_7:
    """
    Assume all projects are unique
    projects = ['a', 'b', 'c', 'd']
    # dependencies = [('a', 'b'), ('d', 'a')]
    """
    def build_order(self, projects, dependencies):
        incoming = {}       # Map vertices to num of incoming edges
        vert_map = {}       # Map values to vertices - only for adding edges
        src_list = set()    # List of source vertices - no incoming edges

        # Create vertex / adjacency list for each project
        for proj in projects:
            vertex = self.Vertex(proj)
            incoming[vertex] = 0
            vert_map[proj] = vertex

        # Add edges for each dependency
        for dep in dependencies:
            parent = vert_map[dep[0]]
            child = vert_map[dep[1]]
            parent.add_child(child)
            incoming[child] += 1

        # Initialize source list
        for v in incoming:
            if incoming[v] == 0:
                src_list.add(v)
        
        top_order = []  # topological ordering - build order output

        # Generate topological ordering
        # 1. Remove source from source list
        # 2. Update children of source if they are now sources
        # 3. If source list empty before finish - no valid order / exists directed cycle
        while len(top_order) < len(projects):
            if not src_list:
                raise Exception("NO VALID BUILD ORDER")

            src = src_list.pop()
            top_order.append(src.val)
            for child in src.children:
                incoming[child] -= 1
                if incoming[child] == 0:
                    src_list.add(child)

        return top_order

    # helper vertex class
    class Vertex:
        def __init__(self, val):
            self.val = val
            self.children = []
        
        def add_child(self, v):
            self.children.append(v)


Q = Question4_7()
projects = ['a', 'b', 'c', 'd', 'e', 'f']
dependencies = [('a', 'd'), ('f', 'b'), ('b', 'd'), ('f', 'a'), ('d', 'c')]

result = Q.build_order(projects, dependencies)
print(result)
        