from collections import deque

def calc(n1, op, n2):
    if op == '+':
        return n1 + n2
    elif op == '*':
        return n1 * n2
    elif op == '-':
        return n1 - n2
    else:
        if n1*n2 < 0 and n1%n2 != 0:
            return (n1 // n2) + 1
        return n1 // n2

s = input()
exp = deque()
num = None
neg = False
for c in s:
    if c.isdigit():
        if num == None:
            num = 0
        num *= 10
        num += int(c)
    else:
        if num == None:
            neg = True
        else:
            if neg:
                exp.append(-num)
                neg = False
            else:
                exp.append(num)
            exp.append(c)
            num = None

if neg:
    exp.append(-num)
    neg = False
else:
    exp.append(num)

while len(exp) > 1:
    result = 'front'
    op1 = exp[1]
    op2 = exp[-2]

    if op1 in ('+', '-') and op2 in ('*', '/'):
        result = 'back'
    elif op1 in ('*', '/') and op2 in ('+', '-'):
        result = 'front'
    else: # 연산자 우선순위가 같은 경우
        calc1 = calc(exp[0], exp[1], exp[2])
        calc2 = calc(exp[-3], exp[-2], exp[-1])
        if calc1 > calc2:
            result = 'front'
        elif calc1 < calc2:
            result = 'back'
        else: # 연산자의 계산 값이 같은 경우
            result = 'front'

    if result == 'front':
        calc_result = calc(exp[0], exp[1], exp[2])
        for _ in range(3):
            exp.popleft()
        exp.appendleft(calc_result)
    else:
        calc_result = calc(exp[-3], exp[-2], exp[-1])
        for _ in range(3):
            exp.pop()
        exp.append(calc_result)

print(exp[0])