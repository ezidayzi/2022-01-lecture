import numpy as np, cv2

image = cv2.imread("../images/bit_test.jpg", cv2.IMREAD_COLOR)
logo = cv2.imread("../images/logo", cv2.IMREAD_COLOR)
if image is None or logo is None: raise Exception("영상파이 읽기 오류")

masks = cv2.threshold(logo, 220, 255, cv2.THRESH_BINARY)[1]
masks = cv2.split(masks)

fg_pass_mask = cv2.bitwise_or(masks[0], masks[1])
fg_pass_mask = cv2.bitwise_or(masks[1], masks[2])
bg_pass_mask = cv2.bitwise_not(fg_pass_mask)

(H, W), (h, w) = image.shape[:2], image.shape[:2]
x, y = (W-w)//2, (H-h)//2
roi = image[y: y+h, x: x+w]

foreground = cv2.bitwise_and(logo, logo, mask = fg_pass_mask)
background = cv2.bitwise_and(roi, roi, mask = bg_pass_mask)

dst = cv2.add(background, foreground)
image[y: y+h, x: x+w] = dst

cv2.imshow('background', background)
cv2.imshow('foreground', foreground)
cv2.imshow('dst', dst)
cv2.imshow('image', image)
cv2.waitKey()