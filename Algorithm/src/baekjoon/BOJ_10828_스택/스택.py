import sys

n = int(sys.stdin.readline().rstrip())
stack = []


def push(num):
    stack.append(num)


def pop():
    if size() == 0:
        return -1
    else:
        return stack.pop()


def size():
    return len(stack)


def empty():
    if size() == 0:
        return 1
    else:
        return 0


def top():
    if size() == 0:
        return -1
    else:
        return stack[size() - 1]


for i in range(n):
    # print(i+1)
    command = sys.stdin.readline().rstrip().split()
    if command[0] == "push":
        push(command[1])
    elif command[0] == "pop":
        print(pop())
    elif command[0] == "size":
        print(size())
    elif command[0] == "empty":
        print(empty())
    elif command[0] == "top":
        print(top())
