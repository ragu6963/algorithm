from collections import deque

N = int(input())

graph = [[] for _ in range(N + 1)]

for _ in range(N - 1):
    n1, n2 = list(map(int, input().split()))
    graph[n1].append(n2)
    graph[n2].append(n1)

parent = [0] * (N + 1)
parent[1] = 1

que = deque(list())
que.append(1)

while que:
    node = que.popleft()

    for next_node in graph[node]:
        if parent[next_node] == 0:
            parent[next_node] = node
            que.append(next_node)


for i in range(2, N + 1):
    print(parent[i])
