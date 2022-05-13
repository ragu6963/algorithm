from collections import deque

N = int(input())

graph = [[] for _ in range(N + 1)]
while True:
    a, b = list(map(int, input().split()))
    graph[a].append(b)
    graph[b].append(a)

    if (a, b) == (-1, -1):
        break


def bfs(start):
    que = deque()
    que.append(start)
    visited = [-1] * (N + 1)
    visited[start] = 0

    while que:
        node = que.popleft()

        for next_node in graph[node]:
            if visited[next_node] != -1:
                continue

            visited[next_node] = visited[node] + 1
            que.append(next_node)

    return max(visited)


max_value = 50
ans = []
for i in range(1, N + 1):
    temp = bfs(i)

    if temp < max_value:
        max_value = temp
        ans = [i]

    elif temp == max_value:
        ans.append(i)

print(max_value, len(ans))
print(*ans)
