import cv2

image = cv2.imread("images/low.jpg", cv2.IMREAD_COLOR)
if image is None:
    raise Exception("영상 파일 읽기 오류")

hsv = cv2.cvtColor(image, cv2.COLOR_BGR2HSV)
h, s, v = cv2.split(hsv)
equalized_image = cv2.equalizeHist(v)
bright_image = cv2.merge([h, s, equalized_image])
bright_image = cv2.cvtColor(bright_image, cv2.COLOR_HSV2BGR)

cv2.imshow("Origin Image", image)
cv2.imshow('Corrected Image', bright_image)

cv2.waitKey(0)
