import numpy as np

np.random.seed(10) # 랜덤 값의 시드 설정
a = np.random.rand(2, 3) # 균일 분포 난수, 2X3 행렬
b = np.random.randn(3, 2) # 평균 0, 표준편차 1의 정규분포 난수
c = np.random.rand(6) # 균일 분포 난수 - 1차원 행렬
d = np.random.randint(1, 100, 6) # 1~100 사이의 정수 난수 1차원 행렬
c = np.reshape(c, (2, 3)) # 형태(shape) 변경 방법 1
d = d.reshape(2, -1) # 형태(shape) 변경 방법 2

print('a 형태: ', a.shape, '\n', a)
print('b 형태: ', b.shape, '\n', b)
print('c 형태: ', a.shape, '\n', c)
print('d 형태: ', a.shape, '\n', d)

print('다차원 객체 1차원 변환 방법')
print('a =', a.flatten()) # 다차원 ndarray 객체 1차원 벡터로 변환
print('b =', np.ravel(b)) # 다차원 모든 객체를 1차원 벡터로 변환
print('c =', np.reshape(c, (-1))) # 넘파이의 reshape() 함수 사용
print('d =', d.reshape(-1, ))