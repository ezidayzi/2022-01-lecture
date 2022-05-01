import cv2, numpy as np

TITLE = "dst"
IMAGE1 = "image1"
IMAGE2 = "image2"


def onAddWeighted(value):
    th[0] = cv2.getTrackbarPos(IMAGE1, TITLE)
    th[1] = cv2.getTrackbarPos(IMAGE2, TITLE)
    alpha = th[0] / 100
    beta = th[1] / 100
    result = cv2.addWeighted(add1, alpha, add2, beta, 0)
    image[:H, w1: w1 + w2] = result
    cv2.imshow(TITLE, image)


add1 = cv2.imread("images/add1.jpg", cv2.IMREAD_GRAYSCALE)
add2 = cv2.imread("images/add2.jpg", cv2.IMREAD_GRAYSCALE)

if add1 is None or add2 is None:
    raise Exception("영상 파일 읽기 오류")

(h1, w1), (h2, w2) = add1.shape[:2], add2.shape[:2]
W = w1 + w2 + 300
H = h1

image = np.full((H, W), 255, np.uint8)
image[:H, :w1] = add1
image[:H, w1: w1 + w2] = 0
image[:H, w1 + 300:W] = add2

th = [50, 50]
cv2.namedWindow(TITLE)
cv2.createTrackbar(IMAGE1, TITLE, th[0], 100, onAddWeighted)
cv2.createTrackbar(IMAGE2, TITLE, th[1], 100, onAddWeighted)
cv2.imshow(TITLE, image)
onAddWeighted(th[0])
cv2.waitKey(0)
