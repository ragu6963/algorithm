dy = [1, 0]
dx = [0, 1]
N = int(input())
graph = [list(map(int, input().split())) for _ in range(N)]
dp = [[0 for _ in range(N)] for _ in range(N)]

dp[0][0] = 1

for i in range(N):
    for j in range(N):
        if graph[i][j] == 0:
            continue

        if -1 < j + graph[i][j] < N:
            dp[i][j + graph[i][j]] += dp[i][j]
        if -1 < i + graph[i][j] < N:
            dp[i + graph[i][j]][j] += dp[i][j]

print(dp[-1][-1])