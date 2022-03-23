import numpy as np

a = np.zeros((2, 5), np.int)
b = np.ones((3, 1), np.uint8)
c = np.empty((1, 5), np.float)
d = np.full(5, 15, np.float32)

print('a 자료형: ', type(a), type(a[0]), type(a[0][0]))
print('b 자료형: ', type(b), type(b[0]), type(b[0][0]))
print('c 자료형: ', type(c), type(c[0]), type(c[0][0]))
print('d 자료형: ', type(d), type(d[0]), type(d[0][0]))
print('c 형태: ', c.shape, '     d 형태: ', d.shape)
print(a), print(b), print(c), print(d)