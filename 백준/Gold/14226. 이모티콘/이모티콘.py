from collections import deque

S = int(input())


def bfs():
    que = deque()
    que.append((1, 0))
    visit = {}
    visit[1, 0] = 0

    while que:
        s, c = que.popleft()

        if s == S:
            return visit[s, c]

        if (s, s) not in visit.keys():
            que.append((s, s))
            visit[s, s] = visit[s, c] + 1

        if (s + c, c) not in visit.keys():
            que.append((s + c, c))
            visit[s + c, c] = visit[s, c] + 1

        if (s - 1, c) not in visit.keys():
            que.append((s - 1, c))
            visit[s - 1, c] = visit[s, c] + 1


print(bfs())