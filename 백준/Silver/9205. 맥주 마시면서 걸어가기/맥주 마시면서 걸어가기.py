from collections import defaultdict, deque


def calDist(y1, x1, y2, x2):
    return abs(x1 - x2) + abs(y1 - y2)


def bfs():
    que = deque()
    que.append(0)
    visit = set()
    visit.add(0)
    while que:
        node = que.popleft()

        y, x = stores[node]

        if (y, x) == end:
            print("happy")
            return

        for next_node in graph[node]:
            if next_node in visit:
                continue

            visit.add(next_node)
            que.append(next_node)

    print("sad")


T = int(input())
for _ in range(T):
    n = int(input())

    stores = []
    for _ in range(n + 2):
        x, y = list(map(int, input().split()))
        stores.append((y, x))

    start = stores[0]
    end = stores[-1]

    graph = defaultdict(list)

    for i in range(len(stores)):
        y1, x1 = stores[i]
        for j in range(i + 1, len(stores)):
            y2, x2 = stores[j]
            dist = calDist(y1, x1, y2, x2)
            if dist <= 1000:
                graph[i].append(j)
                graph[j].append(i)

    bfs()
