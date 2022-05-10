from collections import deque

dy = [-1, 1, 0, 0]
dx = [0, 0, -1, 1]

UP = 0
DOWN = 1
LEFT = 2
RIGHT = 3

# NxN 목초지
# K 마리 소
N, K, R = list(map(int, input().split()))

graph = [[[True, True, True, True] for _ in range(N + 1)] for _ in range(N + 1)]

for _ in range(R):
    r1, c1, r2, c2 = list(map(int, input().split()))

    if r2 - r1 == 1:
        graph[r1][c1][DOWN] = False
        graph[r2][c2][UP] = False

    elif r2 - r1 == -1:
        graph[r1][c1][UP] = False
        graph[r2][c2][DOWN] = False

    if c2 - c1 == 1:
        graph[r1][c1][RIGHT] = False
        graph[r2][c2][LEFT] = False

    elif c2 - c1 == -1:
        graph[r1][c1][LEFT] = False
        graph[r2][c2][RIGHT] = False


cows = []
for _ in range(K):
    y, x = list(map(int, input().split()))
    cows.append((y, x))

ans = 0


def is_inside(y, x):
    return 1 <= y <= N and 1 <= x <= N


def bfs(start_y, start_x, index):
    global ans
    count = 0
    que = deque()
    que.append((start_y, start_x))
    visited = set()
    visited.add((start_y, start_x))

    while que:
        y, x = que.popleft()

        if (y, x) in cows[index + 1 :]:
            # print(start_y, start_x, y, x)
            count += 1

        for d in [UP, DOWN, LEFT, RIGHT]:
            ny = y + dy[d]
            nx = x + dx[d]

            if not is_inside(ny, nx):
                continue

            if (ny, nx) in visited:
                continue

            if graph[y][x][d] == False:
                continue

            visited.add((ny, nx))
            que.append((ny, nx))

    ans += len(cows[index + 1 :]) - count


for index in range(len(cows)):
    y, x = cows[index]
    bfs(y, x, index)

print(ans)
