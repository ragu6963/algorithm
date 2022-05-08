V, E = list(map(int, input().split()))

INF = 10e9
graph = [[INF for _ in range(V + 1)] for _ in range(V + 1)]

for i in range(V + 1):
    graph[i][i] = 0


for _ in range(E):
    a, b, c = list(map(int, input().split()))
    graph[a][b] = c

for k in range(1, V + 1):
    for a in range(1, V + 1):
        for b in range(1, V + 1):
            graph[a][b] = min(graph[a][b], graph[a][k] + graph[k][b])

ans = INF
for i in range(1, V):
    for j in range(1, V + 1):
        if i != j:
            ans = min(ans, graph[i][j] + graph[j][i])

if ans == INF:
    print(-1)
else:
    print(ans)
