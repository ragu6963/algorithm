from collections import deque

F, S, G, U, D = list(map(int, input().split()))

visited = [0 for _ in range(F + 1)]


def bfs():
    que = deque()
    que.append((S, 0))
    while que:
        s, count = que.popleft()

        if s == G:
            return count

        for next in [U, -1 * D]:
            ns = s + next

            if not 0 < ns < F + 1:
                continue

            if visited[ns] > 0:
                continue

            que.append((ns, count + 1))
            visited[ns] = visited[s] + 1

    return "use the stairs"


print(bfs())
