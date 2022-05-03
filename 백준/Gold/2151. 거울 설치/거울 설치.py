from collections import deque

UP = 0
DOWN = 1
LEFT = 2
RIGHT = 3
MIRROR = "!"
VOID = "."
WALL = "*"
DOOR = "#"

dy = [-1, 1, 0, 0]
dx = [0, 0, -1, 1]

N = int(input())
graph = []


doors = deque()

for y in range(N):
    row = list(input())
    graph.append(row)

    for x in range(N):
        if graph[y][x] == DOOR:
            doors.append((y, x))

y = doors[0][0]
x = doors[0][1]

INF = 10e9
visited = [[[INF for _ in range(4)] for _ in range(N)] for _ in range(N)]

que = deque()

for d in range(4):
    que.append((y, x, d))
    visited[y][x][d] = 0


while que:
    y, x, to = que.popleft()

    ny = y + dy[to]
    nx = x + dx[to]

    if not (-1 < ny < N and -1 < nx < N):
        continue

    if graph[ny][nx] == WALL:
        continue

    if graph[ny][nx] == VOID or graph[ny][nx] == DOOR:
        if visited[y][x][to] < visited[ny][nx][to]:
            visited[ny][nx][to] = visited[y][x][to]
            que.append((ny, nx, to))

    if graph[ny][nx] == MIRROR:
        if visited[y][x][to] < visited[ny][nx][to]:
            visited[ny][nx][to] = visited[y][x][to]
            que.append((ny, nx, to))
        if to in [UP, DOWN]:
            for nto in [LEFT, RIGHT]:
                if visited[y][x][to] < visited[ny][nx][nto]:
                    visited[ny][nx][nto] = visited[y][x][to] + 1
                    que.append((ny, nx, nto))

        if to in [LEFT, RIGHT]:
            for nto in [UP, DOWN]:
                if visited[y][x][to] < visited[ny][nx][nto]:
                    visited[ny][nx][nto] = visited[y][x][to] + 1
                    que.append((ny, nx, nto))


y, x = doors[1][0], doors[1][1]
print(min(visited[y][x]))
