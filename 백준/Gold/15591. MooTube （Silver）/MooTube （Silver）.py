from collections import deque

N, Q = list(map(int, input().split()))


graph = [[] for _ in range(N + 1)]

for _ in range(N - 1):
    # p <-> q, 유사도 r
    p, q, r = list(map(int, input().split()))
    graph[p].append((q, r))
    graph[q].append((p, r))


def bfs(start, k, visit):
    que = deque([])
    que.append(start)
    visit[start] = True
    count = 0
    while que:
        node = que.popleft()

        for next_node, weight in graph[node]:
            if visit[next_node]:
                continue

            if weight >= k:
                visit[next_node] = True
                count += 1
                que.append(next_node)

    return count


for _ in range(Q):
    # 정점 v에서 유사도가 k 이상인 값의 개수
    k, v = list(map(int, input().split()))
    count = bfs(v, k, [False] * (N + 1))

    print(count)
