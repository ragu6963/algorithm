from collections import deque

dy = [-1, -1, -1, 0, 0, 0, 1, 1, 1]
dx = [-1, 0, 1, -1, 0, 1, -1, 0, 1]

N = 8
WALL = "#"
VOID = "."

graph = []


def MoveWall():
    for y in reversed(range(N)):
        ny = y + 1
        for x in range(N):
            if graph[y][x] == WALL and ny != N:
                graph[y][x], graph[ny][x] = VOID, WALL

            elif graph[y][x] == WALL and ny == N:
                graph[y][x] = VOID


def FindWall():
    for y in range(N):
        for x in range(N):
            if graph[y][x] == WALL:
                return True
    return False


def bfs():
    target = (0, N - 1)

    que = deque()
    que.append((N - 1, 0, 0))

    prev_t = 0
    visited = [[False for _ in range(N)] for _ in range(N)]
    while que:
        y, x, t = que.popleft()

        if target == (y, x):
            return True

        if prev_t != t:
            prev_t = t
            MoveWall()

        if graph[y][x] == WALL:
            continue

        for d in range(9):
            ny = y + dy[d]
            nx = x + dx[d]

            if not (-1 < ny < N and -1 < nx < N):
                continue

            if graph[ny][nx] == WALL:
                continue

            if visited[ny][nx]:
                continue

            visited[ny][nx] = True
            que.append((ny, nx, t + 1))

        if FindWall():
            visited = [[False for _ in range(N)] for _ in range(N)]

    return False


for y in range(N):
    row = list(input())
    graph.append(row)

if bfs():
    print(1)
else:
    print(0)
