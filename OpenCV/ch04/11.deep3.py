import numpy as np
import cv2


def onMouse(event, x, y, flags, param):
    global title, pt, pt_prev

    orange, blue, red = (0, 165, 255), (255, 0, 0), (0, 0, 255)  # 색상지정

    if event == cv2.EVENT_MOUSEMOVE:
        if pt_prev[0] > 0:
            image[:, :] = [255, 255, 255]
            cv2.line(image, (x, y), pt_prev, red, 4)
            cv2.imshow(title, image)

    if event == cv2.EVENT_LBUTTONDOWN:
        if pt[0] < 0:
            pt = (x, y)
        if pt_prev[0] < 0:
            pt_prev = (x, y)

    if event == cv2.EVENT_LBUTTONUP:
        if pt[0] > 0:
            image[:, :] = [255, 255, 255]
            cv2.rectangle(image, pt, (x, y), blue, 2)
            center = ((x + pt[0]) // 2, (y + pt[1]) // 2)
            axes = np.abs(((pt[0] - x) // 2, (pt[1] - y) // 2))
            cv2.ellipse(image, center, axes, 0, 45, 225, orange, 2)
            cv2.imshow(title, image)
            pt = (-1, -1)
            pt_prev = (-1, -1)


image = np.full((300, 500, 3), (255, 255, 255), np.uint8)
pt = (-1, -1)
pt_prev = (-1, -1)
title = "Draw Event"
cv2.imshow(title, image)
cv2.setMouseCallback(title, onMouse)
cv2.waitKey(0)
