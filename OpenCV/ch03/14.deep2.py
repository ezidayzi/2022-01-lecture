import numpy as np

# 기본 데이터
list = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
sha1 = np.array(list).reshape(2, -1)
sha2 = np.array(list).reshape(2, -1)

print('sha1')
print(sha1)
print('sha2')
print(sha2)

# 넘파이 제공 연산자 사용
print('sha1 + sha2')
print(sha1 + sha2)

arr1 = [[1, 2, 3, 4, 5], [6, 7, 8, 9, 10]]
arr2 = [[1, 2, 3, 4, 5], [6, 7, 8, 9, 10]]
arr3 = [[], []]

print('arr1')
print(arr1)
print('arr2')
print(arr2)

print(len(arr1))
print(len(arr1[0]))

n = 0
for items1, items2 in zip(arr1, arr2):
    for i, j in zip(items1, items2):
        arr3[n].append(i + j)
    n = n + 1

print('arr3')
print(arr3)