import numpy as np
import cv2


def onMouse(event, x, y, flags, param):
    global title, pt, pt_prev

    orange, blue, red, white = (0, 165, 255), (255, 0, 0), (0, 0, 255), (255, 255, 255)  # 색상지정

    if event == cv2.EVENT_MOUSEMOVE:
        if pt_prev[0] > 0:
            cv2.line(image, (x, y), pt_prev, red, 2)
            cv2.imshow(title, image)
            cv2.line(image, (x, y), pt_prev, white, 5)

    if event == cv2.EVENT_LBUTTONDOWN:
        if pt[0] < 0:
            pt = (x, y)
        if pt_prev[0] < 0:
            pt_prev = (x, y)

    if event == cv2.EVENT_LBUTTONUP:
        if pt[0] > 0:
            cv2.rectangle(image, pt, (x, y), (255, 0, 0), 2)
            center = ((x + pt[0]) // 2, (y + pt[1]) // 2)
            radius = int(np.linalg.norm(np.array(pt) - np.array(center)).round())
            cv2.ellipse(image, center, (radius, radius), 0, 45, 225, orange, 2)
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
