from itertools import combinations
from collections import deque


dirs = [[0, 1], [0, -1], [-1, 0], [1, 0]]


N, M = list(map(int, input().split()))
possible_virus_lo = []
void_lo = []
graph = []

# 0은 빈 칸, 1은 벽, 2는 바이러스를 놓을 수 있는 위치
for y in range(N):
    row = list(map(int, input().split()))
    graph.append(row)

    for x in range(len(row)):
        # 빈 공간
        if row[x] == 0:
            void_lo.append((y, x))
            graph[y][x] = -1

        # 벽
        elif row[x] == 1:
            graph[y][x] = "-"

        # 비활성 바이러스
        elif row[x] == 2:
            possible_virus_lo.append((y, x))
            graph[y][x] = "*"


combi_possible_virus_lo = list(combinations(possible_virus_lo, M))


def is_inside(y, x):
    return -1 < y and y < N and -1 < x and x < N


def activate_virus(virus_location):
    for y, x in virus_location:
        graph[y][x] = 0


def deactivate_virus():
    for y, x in possible_virus_lo:
        graph[y][x] = "*"


def delete_virus():
    for y, x in void_lo:
        graph[y][x] = -1


def check_max_val():
    max_count = 0
    for y in range(N):
        for x in range(N):
            val = graph[y][x]
            if val == -1:
                max_count = -1
                return False, 0

            if val != "-" and val != "*" and val >= 0:
                max_count = max(max_count, val)

    return True, max_count


def bfs(virus_location):
    que = deque([])

    for y, x in virus_location:
        que.append((y, x))

    while que:
        y, x = que.popleft()

        for d in range(4):
            ny = y + dirs[d][0]
            nx = x + dirs[d][1]

            if not is_inside(ny, nx):
                continue

            if graph[ny][nx] == -1 or graph[ny][nx] == "*":
                que.append((ny, nx))
                graph[ny][nx] = graph[y][x] + 1

    return check_max_val()


INF = 10e9
ans = INF
for virus_location in combi_possible_virus_lo:
    activate_virus(virus_location)
    max_count = bfs(virus_location)

    if max_count[0]:
        ans = min(max_count[1], ans)
    deactivate_virus()

    delete_virus()

if ans == INF:
    print(-1)
else:
    print(ans)