w, g = map(int, input().split())

word = input()
sentence = input()

warr = [0] * 58
sarr = [0] * 58

for data in word:
    warr[ord(data) - 65] += 1

start = 0
length = 0
answer = 0

for word in sentence:
    sarr[ord(word) - 65] += 1
    length += 1

    if length == w:
        if warr == sarr:
            answer += 1
        sarr[ord(sentence[start]) - 65] -= 1
        start += 1
        length -= 1

print(answer)





