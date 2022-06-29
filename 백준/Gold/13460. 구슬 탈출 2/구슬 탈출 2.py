# import sys

# sys.stdin = open("input.txt")

from collections import deque


def move_ball(y, x, dy, dx):
    cnt = 0
    while graph[y + dy][x + dx] != WALL and graph[y][x] != HALL:
        y += dy
        x += dx
        cnt += 1

    return y, x, cnt


dy = [0, 0, 1, -1]
dx = [1, -1, 0, 0]
VOID = "."
WALL = "#"
HALL = "O"
RED = "R"
BLUE = "B"

que = deque()

# 세로 가로
N, M = list(map(int, input().split()))

graph = []
ry, rx, by, bx = 0, 0, 0, 0
for y in range(N):
    graph.append(list(input()))
    for x in range(M):
        if graph[y][x] == RED:
            ry, rx = y, x
        if graph[y][x] == BLUE:
            by, bx = y, x

que.append((ry, rx, by, bx, 1))
visit = set()


def bfs():
    while que:
        ry, rx, by, bx, depth = que.popleft()

        if depth > 10:
            break

        for d in range(4):
            nry, nrx, rcnt = move_ball(ry, rx, dy[d], dx[d])
            nby, nbx, bcnt = move_ball(by, bx, dy[d], dx[d])

            if graph[nby][nbx] != HALL:
                if graph[nry][nrx] == HALL:
                    return depth

                if (nry, nrx) == (nby, nbx):
                    if rcnt > bcnt:
                        nry -= dy[d]
                        nrx -= dx[d]

                    else:
                        nby -= dy[d]
                        nbx -= dx[d]

                if (nry, nrx, nby, nbx) not in visit:
                    visit.add((nry, nrx, nby, nbx))
                    que.append((nry, nrx, nby, nbx, depth + 1))
    return -1


print(bfs())
