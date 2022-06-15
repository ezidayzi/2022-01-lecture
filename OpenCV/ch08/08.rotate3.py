import numpy as np, cv2
from Common.utils import contain
from Common.interpolation import bilinear_value

def rotate_pt(img, degree, pt):
    dst = np.zeros(img.shape[:2], img.dtype)
    radian = (degree/180) * np.pi
    sin, cos = np.sin(radian), np.cos(radian)

    for yd in range(img.shape[0]):
        for xd in range(img.shape[1]):
            xd2, yd2 = np.subtract((xd, yd), pt)
            x = xd2 * cos + yd2 * sin
            y = yd2 * cos - xd2 * sin
            x, y = np.add((x, y), pt)

            if contain((y, x), img.shape):
                dst[yd, xd] = bilinear_value(img, [x, y])

    return dst

image = cv2.imread('images/rotate.jpg', cv2.IMREAD_GRAYSCALE)
if image is None: raise Exception("영상 파일 읽기 에러")

center = np.divmod(image.shape[::-1], 2)[0]
dst1 = rotate_pt(image, 20, center)

cv2.imshow("image", image)
cv2.imshow("dst1-rotated on org", dst1)
cv2.waitKey(0)