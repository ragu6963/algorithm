from collections import deque


def is_inside(r, c):
    return -1 < r and r < R and -1 < c and c < C


def move_swan():
    next_queue = deque()
    while queue:
        r, c = queue.popleft()

        if r == swans[1][0] and c == swans[1][1]:
            return True, None

        for d in range(4):
            nr = r + dirs[d][0]
            nc = c + dirs[d][1]

            if not is_inside(nr, nc):
                continue

            if visit[nr][nc]:
                continue

            if graph[nr][nc] == ICE:
                next_queue.append((nr, nc))

            else:
                queue.append((nr, nc))

            visit[nr][nc] = True

    return False, next_queue


def move_water():
    next_waters = deque()
    while waters:
        r, c = waters.popleft()

        for d in range(4):
            nr = r + dirs[d][0]
            nc = c + dirs[d][1]

            if not is_inside(nr, nc):
                continue

            if graph[nr][nc] == ICE:
                next_waters.append((nr, nc))
                graph[nr][nc] = WATER

    return next_waters


dirs = [[0, 1], [0, -1], [-1, 0], [1, 0]]

R, C = list(map(int, input().split()))
visit = [[False for _ in range(C)] for _ in range(R)]

WATER = "."
ICE = "X"
SWAN = "L"

graph = []

swans = deque()

waters = deque()

for r in range(R):
    row = list(input())
    graph.append(row)
    for c in range(C):

        if graph[r][c] == SWAN:
            swans.append([r, c])
            waters.append((r, c))

        if graph[r][c] == WATER:
            waters.append((r, c))

queue = deque()
queue.append([swans[0][0], swans[0][1]])
visit[swans[0][0]][swans[0][1]] = True
ans = 0

while True:

    is_find, next_queue = move_swan()

    if is_find:
        break

    waters = move_water()
    queue = next_queue
    ans += 1


print(ans)
