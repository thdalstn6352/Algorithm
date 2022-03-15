data = input()

number_arr = []
alphabet_arr = []
for i in range(len(data)):
    # 숫자일경우
    if ord(data[i]) < 65:
        number_arr.append(int(data[i]))
    else:
        alphabet_arr.append(data[i])

sum = sum(number_arr)
alphabet_arr.sort()
alphabet_string = ''.join(alphabet_arr)

result = alphabet_string + str(sum)
print(result)