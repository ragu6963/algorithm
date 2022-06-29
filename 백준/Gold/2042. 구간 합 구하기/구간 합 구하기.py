
def init(start, end, node):

    if start == end:
        tree[node] = graph[start]
        return tree[node]

    mid = (start + end) // 2

    tree[node] = init(start, mid, node * 2) + init(mid + 1, end, node * 2 + 1)
    return tree[node]


# 트리의 구간 start, end
# 합을 구할려는 구간 left, right
def sub_sum(start, end, node, left, right):
    if left > end or right < start:
        return 0

    if start >= left and end <= right:
        return tree[node]

    mid = (start + end) // 2

    return sub_sum(start, mid, node * 2, left, right) + sub_sum(mid + 1, end, node * 2 + 1, left, right)


def update(start, end, node, index, dif):
    if index < start or index > end:
        return

    tree[node] += dif

    if start == end:
        return

    mid = (start + end) // 2

    update(start, mid, node * 2, index, dif)
    update(mid + 1, end, node * 2 + 1, index, dif)


N, M, K = list(map(int, input().split()))
graph = [int(input()) for _ in range(N)]

tree = [0 for _ in range(N * 4)]

init(0, N - 1, 1)

for _ in range(M + K):
    a, b, c = list(map(int, input().split()))

    # 값 수정
    if a == 1:
        b -= 1
        dif = c - graph[b]
        graph[b] = c
        update(0, N - 1, 1, b, dif)

    # 구간합 출력
    if a == 2:
        print(sub_sum(0, N - 1, 1, b - 1, c - 1))
