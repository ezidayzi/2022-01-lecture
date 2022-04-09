import numpy as np, cv2

m = np.random.rand(3, 5) * 1000/10

reduce_sum = cv2.reduce(m, dim=0, rtype=cv2.REDUCE_SUM)
reduce_avg = cv2.reduce(m, dim=1, rtype=cv2.REDUCE_AVG)
reduce_max = cv2.reduce(m, dim=0, rtype=cv2.REDUCE_MAX)
reduce_min = cv2.reduce(m, dim=1, rtype=cv2.REDUCE_MIN)

print(m)
print()

print(reduce_sum.flatten())
print()

print(reduce_max.flatten())
print()
print(reduce_min.flatten())
