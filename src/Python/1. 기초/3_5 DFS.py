graph1 = {'A': ['B', 'D'],
          'B': ['A', 'C', 'E'],
          'C': ['B', 'F'],
          'D': ['A', 'E'],
          'E': ['B', 'D', 'F'],
          'F': ['C', 'E']}
visit = []


def recursiveDFS(graph, node):
    global visit
    if node not in visit:
        visit.append(node)
        for n in graph[node]:
            recursiveDFS(graph, n)


recursiveDFS(graph1, 'B')
