import sys


def str2time(value):
    v_hour, v_minute = map(int, value.split(":"))
    return v_hour * 60 + v_minute


checkIn = set()
checkOut = set()


S, E, Q = sys.stdin.readline().rstrip().split()
s_time = str2time(S)
e_time = str2time(E)
q_time = str2time(Q)

for line in sys.stdin:
    time, student = line.rstrip().split()
    real_time = str2time(time)
    if real_time <= s_time:
        checkIn.add(student)

    elif (real_time >= e_time) and (real_time <= q_time):
        checkOut.add(student)

    elif real_time > q_time:
        break

print(len(checkIn & checkOut))