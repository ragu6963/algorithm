N, M = list(map(int, input().split()))

memories = [0] + list(map(int, input().split()))

costs = [0] + list(map(int, input().split()))

graph = [{"memory": "", "cost": ""} for _ in range(N + 1)]

for i in range(N + 1):
    graph[i]["memory"] = memories[i]
    graph[i]["cost"] = costs[i]

graph.sort(key=lambda x: x["memory"])

dp = [[0 for _ in range(sum(costs) + 1)] for _ in range(N + 1)]

ans = sum(costs)

for i in range(1, N + 1):
    for j in range(sum(costs) + 1):
        memory = graph[i]["memory"]
        cost = graph[i]["cost"]
        if cost > j:
            dp[i][j] = dp[i - 1][j]

        else:
            dp[i][j] = max(dp[i - 1][j], memory + dp[i - 1][j - cost])

        if dp[i][j] >= M:
            ans = min(ans, j)

print(ans)
