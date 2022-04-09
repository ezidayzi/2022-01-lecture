import numpy as np
import cv2


def onChange(value):
    global image, title  # 전역 변수 참조

    add_value = np.uint8(value - int(image[0][0]))
    image = image + add_value
    cv2.imshow(title, image)


image = np.zeros((300, 500), np.uint8)

title = "Trackbar Event"
bar_name = "Brightness"
cv2.imshow(title, image)

cv2.createTrackbar(bar_name, title, image[0][0], 255, onChange)

cv2.waitKey(0)
cv2.destroyAllWindows()
