from collections import deque

N, Q = list(map(int, input().split()))


graph = [[] for _ in range(N + 1)]

for _ in range(N - 1):
    # p <-> q, 유사도 r
    p, q, r = list(map(int, input().split()))
    graph[p].append((q, r))
    graph[q].append((p, r))


INF = 10e9
distances = [[INF for _ in range(N + 1)] for _ in range(N + 1)]


def bfs(node):
    distance = distances[node]

    que = deque()
    que.append([node, INF])

    visit = set()
    visit.add(node)

    while que:
        node, min_weight = que.popleft()

        for next_node, next_weight in graph[node]:
            if next_node in visit:
                continue

            if next_weight < min_weight:
                distance[next_node] = next_weight
                que.append([next_node, next_weight])
            else:
                distance[next_node] = min_weight
                que.append([next_node, min_weight])

            visit.add(next_node)


for i in range(1, N + 1):
    bfs(i)

for _ in range(Q):
    # 정점 v에서 유사도가 k 이상인 값의 개수
    k, v = list(map(int, input().split()))

    distance = distances[v][1:]
    count = 0

    for d in distance:
        if d >= k:
            count += 1

    print(count - 1)
