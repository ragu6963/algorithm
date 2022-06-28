N = int(input())
lst = list(map(int, input().split()))
answer = [-1] * N
stack = []


for i in range(N):
    val = lst[i]
    if len(stack) == 0:
        stack.append((val, i))

    else:
        while stack and stack[-1][0] < val:
            value, index = stack.pop()
            answer[index] = val

        stack.append((val, i))

print(*answer)
