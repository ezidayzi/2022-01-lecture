import numpy as np
import cv2


def onChangePos(value):
    global image, title  # 전역 변수 참조

    add_value = np.uint8(value - int(image[0][0]))
    image = image + add_value
    cv2.imshow(title, image)


def onMousePos(event, x, y, flags, param):
    global image, bar_name

    if event == cv2.EVENT_RBUTTONDOWN:
        if image[0][0] < 246:
            image = image + 10
        cv2.setTrackbarPos(bar_name, title, image[0][0])  # 트랙바 위치 변경
        cv2.imshow(title, image)
        print("오른쪽 마우스 클릭: {}".format(image[0][0]))
    elif event == cv2.EVENT_LBUTTONDOWN:
        if image[0][0] >= 10:
            image = image - 10
        cv2.setTrackbarPos(bar_name, title, image[0][0])  # 트랙바 위치 변경
        cv2.imshow(title, image)
        print("왼쪽 마우스 클릭: {}".format(image[0][0]))


image = np.zeros((300, 500), np.uint8)

title = "Trackbar & MouseEvent"
bar_name = "Brightness"
cv2.imshow(title, image)

cv2.createTrackbar(bar_name, title, image[0][0], 255, onChangePos)
cv2.setMouseCallback(title, onMousePos)
cv2.waitKey(0)
cv2.destroyAllWindows()
