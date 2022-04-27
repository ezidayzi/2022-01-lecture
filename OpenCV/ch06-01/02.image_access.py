import numpy as np, cv2, time


# 1. 배열 첨자 기능 이용
def pixel_access1(image):
    image1 = np.zeros(image.shape[:2], image.dtype)

    for i in range(image.shape[0]):
        for j in range(image.shape[1]):
            pixel = image[i, j]
            image1[i, j] = 255 - pixel

    return image1


# 2. item() 함수 접근 방법
def pixel_access2(image):
    image2 = np.zeros(image.shape[:2], image.dtype)

    for i in range(image.shape[0]):
        for j in range(image.shape[1]):
            pixel = image.item(i, j)
            image2.itemset((i, j), 255 - pixel)

    return image2


# 3. 룩업테이블 이용 방법
# 행렬 정보를 배열로 바꾸어 배열로 접근할 수 있도록 하는 방법
def pixel_access3(image):
    lut = [255 - i for i in range(256)]
    lut = np.array(lut, np.uint8)
    image3 = lut[image]
    return image3


# 4. OpenCV 함수 이용
def pixel_access4(image):
    image4 = cv2.subtract(255, image) # 빼준다
    return image4


# 5. ndarray 산술 연산 방법
def pixel_access5(image):
    image5 = 255 - image # 빼기 연산 오버라이딩 -> 화소에 모두 적용
    return image5


