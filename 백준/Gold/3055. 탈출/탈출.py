 
from collections import deque

dr = [0, 0, 1, -1]
dc = [1, -1, 0, 0]
VOID = "."
WATER = "*"
ROCK = "X"
START = "S"
END = "D"

R, C = list(map(int, input().split()))

end = None
que = deque()

graph = []

for r in range(R):
    graph.append(list(input()))

    for c in range(C):
        if graph[r][c] == START:
            que.append((r, c, 0))

        if graph[r][c] == END:
            end = (r, c)


def bfs():
    # 현재 시간
    t = -1

    while que:
        # 현재 비버 위치, 현재 시간
        r, c, pre_t = que.popleft()

        if (r, c) == end:
            return pre_t

        # 시간이 지났을 때
        if pre_t != t:
            t = pre_t
            temp_waters = []
            for water_r in range(R):
                for water_c in range(C):
                    if graph[water_r][water_c] == WATER:
                        for d in range(4):
                            nr = water_r + dr[d]
                            nc = water_c + dc[d]
                            if not (-1 < nr < R and -1 < nc < C):
                                continue

                            if graph[nr][nc] == ROCK:
                                continue

                            if graph[nr][nc] == END:
                                continue

                            temp_waters.append((nr, nc))

            for water_r, water_c in temp_waters:
                graph[water_r][water_c] = WATER

        for d in range(4):
            nr = r + dr[d]
            nc = c + dc[d]

            if not (-1 < nr < R and -1 < nc < C):
                continue

            if graph[nr][nc] == ROCK:
                continue

            if graph[nr][nc] == WATER:
                continue

            if graph[nr][nc] == START:
                continue

            que.append((nr, nc, pre_t + 1))
            graph[nr][nc] = START

    return "KAKTUS"


print(bfs())
