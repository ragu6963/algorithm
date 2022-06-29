def init(start, end, node):
    if start == end:
        tree[node] = [graph[start], graph[start]]
        return tree[node]

    mid = (start + end) // 2

    l = init(start, mid, node * 2)
    r = init(mid + 1, end, node * 2 + 1)

    tree[node] = [
        min(l[0], r[0]),
        max(l[1], r[1]),
    ]
    return tree[node]


def find_min_max(start, end, node, left, right):
    if left > end or right < start:
        return [MAX, 0]

    if start >= left and end <= right:
        return tree[node]

    mid = (start + end) // 2
    l = find_min_max(start, mid, node * 2, left, right)
    r = find_min_max(mid + 1, end, node * 2 + 1, left, right)
    return [
        min(l[0], r[0]),
        max(l[1], r[1]),
    ]


MAX = 1000000001
N, M = list(map(int, input().split()))

graph = [int(input()) for _ in range(N)]

# 최솟값, 최댓값
tree = [[-1, 0] for _ in range(N * 4)]
init(0, N - 1, 1)

for _ in range(M):
    a, b = list(map(int, input().split()))
    c, d = find_min_max(0, N - 1, 1, a - 1, b - 1)
    print(c, d)
