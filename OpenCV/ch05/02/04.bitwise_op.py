import cv2
import numpy as np

image1 = np.full((300, 300),200, np.uint8)
image2 = image1.copy()

h, w = image1.shape[:2]
cx, cy = w // 2, h // 2
cv2.circle(image1, (cx, cy), 100, 150, -1)
cv2.rectangle(image2, (0, 0, cx, h), 100, -1)

image3 = cv2.bitwise_or(image1, image2)
image4 = cv2.bitwise_and(image1, image2)
image5 = cv2.bitwise_xor(image1, image2)
image6 = cv2.bitwise_not(image1)

cv2.imshow("image1", image1)
cv2.imshow("image2", image2)
cv2.imshow("bitwise_or", image3)
cv2.imshow("bitwise_and", image4)
cv2.imshow("bitwise_xor", image5)
cv2.imshow("bitwise_not", image6)

cv2.waitKey(0)
