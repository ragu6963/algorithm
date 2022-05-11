from collections import deque

N = int(input())

graph = [[] for _ in range(N + 1)]
for _ in range(N - 1):
    a, b = list(map(int, input().split()))
    graph[a].append(b)
    graph[b].append(a)

test_case = list(map(int, input().split()))
order = [0] * (N + 1)

for i in range(len(test_case)):
    order[test_case[i]] = i


for i in range(1, len(graph)):
    graph[i].sort(key=lambda x: order[x])


def bfs():
    s = 1
    visited = [False] * (N + 1)
    q = deque()
    q.append(s)
    temp = [1]
    visited[s] = True

    while q:
        start = q.popleft()
        for node in graph[start]:
            if not visited[node]:
                q.append(node)
                visited[node] = True
                temp.append(node)

    return temp


if test_case == bfs():
    print(1)
else:
    print(0)
