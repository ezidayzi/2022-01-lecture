import numpy as np


def mat_access1(mat):
    for i in range(mat.shape[0]):
        for j in range(mat.shape[1]):
            k = mat[i, j]
            mat[i, j] = k * 2


def mat_access2(mat):
    for i in range(mat.shape[0]):
        for j in range(mat.shape[1]):
            k = mat.item(i, j)
            mat.itemset((i, j), k * 2)


mat1 = np.arange(10).reshape(2, 5)
mat2 = np.arange(10).reshape(2, 5)

print("원소 처리 전:")
print(mat1)
print()

mat_access1(mat1)

print("원소 처리 후:")
print(mat1)
print()

print("원소 처리 전:")
print(mat2)
print()

mat_access2(mat2)

print("원소 처리 후:")
print(mat2)
print()
