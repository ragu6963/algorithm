
def find_parent(node):
    if node != parent[node]:
        parent[node] = find_parent(parent[node])

    return parent[node]


def union(a, b):
    a = find_parent(a)
    b = find_parent(b)
    if a < b:
        parent[b] = a
    else:
        parent[a] = b


N, M = list(map(int, input().split()))

lst = [0] * (N + 1)
parent = [i for i in range(N + 1)]

for i in range(1, N + 1):
    x, y = list(map(int, input().split()))
    lst[i] = [y, x]


for _ in range(M):
    a, b = list(map(int, input().split()))
    union(a, b)

edges = []

for i in range(1, N + 1):
    y1, x1 = lst[i]

    for j in range(1, N + 1):
        if i == j:
            continue

        y2, x2 = lst[j]
        dist = (y2 - y1) ** 2 + (x2 - x1) ** 2
        dist = dist ** (1 / 2)
        edges.append((i, j, dist))

edges = sorted(edges, key=lambda x: x[2])

ans = 0
for a, b, cost in edges:
    if find_parent(a) != find_parent(b):
        union(a, b)
        ans += cost
print(format(ans, ".2f"))
