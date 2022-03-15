def solution(s):
    result = len(s)
    for step in range(1, len(s) // 2 + 1):
        count = 1
        comp_str = ""
        prev = s[0:step]
        for i in range(step, len(s), step):
            now = s[i:i + step]
            if prev == now:
                count += 1
            else:
                comp_str += str(count) + prev if count >= 2 else prev
                prev = s[i:i + step]
                count = 1

        comp_str += str(count) + prev if count >= 2 else prev
        result = min(result, len(comp_str))
    return result

print(solution("ababcdcdababcdcd"))