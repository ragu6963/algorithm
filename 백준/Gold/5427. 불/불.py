 
from collections import deque


dy = [0, 0, -1, 1]
dx = [-1, 1, 0, 0]
VOID = "."
WALL = "#"
START = "@"
FIRE = "*"


def bfs(que: deque):
    next_que = deque()

    while que:
        y, x = que.popleft()

        if y in (0, h - 1) or x in (0, w - 1):
            return True, None

        for d in range(4):
            ny = y + dy[d]
            nx = x + dx[d]

            if not (-1 < ny < h and -1 < nx < w):
                continue

            if graph[ny][nx] == WALL:
                continue

            if graph[ny][nx] == FIRE:
                continue

            if graph[ny][nx] == START:
                continue

            graph[ny][nx] = START

            next_que.append((ny, nx))

    return False, next_que


def move_fire(fire):
    next_fire = set()

    for y, x in fire:

        for d in range(4):
            ny = y + dy[d]
            nx = x + dx[d]

            if not (-1 < ny < h and -1 < nx < w):
                continue

            if graph[ny][nx] == WALL:
                continue

            if graph[ny][nx] == FIRE:
                continue

            next_fire.add((ny, nx))

    for y, x in next_fire:
        graph[y][x] = FIRE

    return next_fire


def solve(que, fire):
    cnt = 0
    while que:
        cnt += 1
        fire = move_fire(fire)
        is_escape, que = bfs(que)

        if is_escape:
            return cnt

    return "IMPOSSIBLE"


T = int(input())

for _ in range(T):
    w, h = list(map(int, input().split()))
    graph = []
    que = deque()
    fire = set()

    for y in range(h):
        graph.append(list(input()))

        for x in range(w):
            if graph[y][x] == START:
                que.append((y, x))

            if graph[y][x] == FIRE:
                fire.add((y, x))

    print(solve(que, fire))
