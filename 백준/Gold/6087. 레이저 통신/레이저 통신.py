from collections import deque


dy = [-1, 1, 0, 0]
dx = [0, 0, -1, 1]

UP = 0
DOWN = 1
LEFT = 2
RIGHT = 3

W, H = list(map(int, input().split()))
graph = []

LASER = "C"
VOID = "."
WALL = "*"


laser = []
for y in range(H):

    row = list(input())
    graph.append(row)

    for x in range(W):
        if graph[y][x] == LASER:
            laser.append((y, x))


def is_inside(y, x):
    return -1 < y < H and -1 < x < W


def bfs(y, x):
    visited = [[10e9 for _ in range(W)] for _ in range(H)]
    visited[y][x] = 0
    que = deque()
    que.append((y, x))

    while que:
        y, x = que.popleft()
        if (y, x) == (laser[1][0], laser[1][1]):
            return visited[y][x] - 1

        for d in range(4):
            ny = y + dy[d]
            nx = x + dx[d]
            while True:
                if not is_inside(ny, nx):
                    break

                if graph[ny][nx] == WALL:
                    break

                if visited[ny][nx] < visited[y][x] + 1:
                    break

                que.append((ny, nx))
                visited[ny][nx] = visited[y][x] + 1

                ny = ny + dy[d]
                nx = nx + dx[d]


print(bfs(laser[0][0], laser[0][1]))
