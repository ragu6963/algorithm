import sys

sys.setrecursionlimit(10**6)

val = {"(": 0, ")": 0, "+": 1, "-": 1, "*": 2, "/": 2}


def stackCal(string):
    def infixToPostfix(string):
        stack = []
        ret = ""
        for s in string:
            if s in "0123456789":
                ret += s
            elif s == "(":
                stack.append(s)
            elif s == ")":
                while True:
                    x = stack.pop()
                    if x == "(":
                        break
                    ret += x
            else:
                while stack:
                    top = stack[-1]
                    if val[top] < val[s]:
                        break
                    ret += stack.pop()
                stack.append(s)
        while stack:
            ret += stack.pop()
        ret = ret.replace("(", "").replace(")", "")
        # print(ret)
        return ret

    def postfixCal(string):
        stack = []
        for s in string:
            if s == "+":
                op2 = stack.pop()
                op1 = stack.pop()
                stack.append(op1 + op2)
            elif s == "-":
                op2 = stack.pop()
                op1 = stack.pop()
                stack.append(op1 - op2)
            elif s == "*":
                op2 = stack.pop()
                op1 = stack.pop()
                stack.append(op1 * op2)
            elif s == "/":
                op2 = stack.pop()
                op1 = stack.pop()
                stack.append(op1 / op2)
            else:
                stack.append(int(s))
        return stack[0]

    return postfixCal(infixToPostfix(string))


def process_bracket(brackets: list):
    temp_expression = ""
    for index in range(len(opers)):
        n1 = numbers[index]
        n2 = numbers[index + 1]
        oper = opers[index]

        if brackets[index] == 1:
            temp_expression += f"({n1}{oper}{n2})"

        elif brackets[index] == 0:
            if brackets[index - 1] == 1 and index != 0:
                temp_expression += oper
            else:
                temp_expression += f"{n1}{oper}"
            if index == len(opers) - 1:
                temp_expression += n2

    return stackCal(temp_expression)


def dfs(brackets: list, index: int):
    global max_answer
    if index > len(opers) - 1:
        max_answer = max(max_answer, process_bracket(brackets))
        return

    if index > 0 and brackets[index - 1] == 1:
        brackets[index] = 0
        dfs(brackets, index + 1)

    else:
        brackets[index] = 0
        dfs(brackets, index + 1)

        brackets[index] = 1
        dfs(brackets, index + 1)


N = int(input())
max_answer = sys.maxsize * -1
expression = input()

if N == 1:
    print(expression)
else:
    numbers = []
    opers = []
    for i in range(len(expression)):
        e = expression[i]
        if e in ["+", "-", "*"]:
            opers.append(e)
        else:
            numbers.append(e)

    dfs([0 for _ in range(len(opers))], 0)

    print(max_answer)
