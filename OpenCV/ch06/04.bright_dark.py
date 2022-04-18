import cv2

image = cv2.imread("images/ssu.jpg", cv2.IMREAD_GRAYSCALE)
if image is None: raise Exception("영상 파일 읽기 오류")

## OpenCV 함수 이용(saturation)
dst1 = cv2.add(image, 100) # 영상 밝게
dst2 = cv2.subtract(image, 126) # 영상 어둡게

## numpy.ndarray 이용 (modulo)
dst3 = image + 100 # 영상 밝게
dst4 = image - 5 # 영상 어둡게

print(image)
print(dst3)
print(dst4)

# cv2.imshow("original image", image)
# cv2.imshow("dst1- bright: OpenCV", dst1)
# cv2.imshow("dst2- dark: OpenCV", dst2)
# cv2.imshow("dst3- bright: numpy", dst3)
# cv2.imshow("dst4- dark: numpy", dst4)
# cv2.waitKey(0)
