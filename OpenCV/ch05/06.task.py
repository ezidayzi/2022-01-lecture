import numpy as np, cv2

image = cv2.imread("images/ssu.jpg", cv2.IMREAD_COLOR)
logo1 = cv2.imread("images/ssu_logo1.jpg", cv2.IMREAD_COLOR)
logo2 = cv2.imread("images/ssu_logo2.jpg", cv2.IMREAD_COLOR)

logo = np.copy(logo1)

(H, W), (h, w) = logo1.shape[:2], logo2.shape[:2]
(x, y) = (W-w), (H-h)

logo[y: y + h, x: x + w] = np.copy(logo2)

masks = cv2.threshold(logo, 220, 255, cv2.THRESH_BINARY)[1]
masks = cv2.split(masks)

bg_pass_mask = cv2.bitwise_or(masks[0], masks[1])
bg_pass_mask = cv2.bitwise_or(masks[2], bg_pass_mask)
fg_pass_mask = cv2.bitwise_not(bg_pass_mask)

(H, W), (h, w) = image.shape[:2], logo.shape[:2]
(x, y) = (W-w), (H-h)

a = (W-w)//2
roi = image[h:h + h, a: w + a]

foreground = cv2.bitwise_and(logo, logo, mask=fg_pass_mask)
background = cv2.bitwise_and(roi, roi, mask=bg_pass_mask)

dst = cv2.add(background, foreground)
image[h:h + h, a: w + a] = dst

cv2.imshow("image", image)
cv2.imshow("logo1 origin", logo1)
cv2.imshow("logo2 origin", logo2)
cv2.imshow("logo1 merged", logo)
cv2.imshow("foreground", foreground)
cv2.imshow("background", background)
cv2.imshow("dst", dst)

cv2.waitKey(0)
