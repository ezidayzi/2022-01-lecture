import numpy as np, cv2


def bilinear_interpolation(image, size):
    height = image.shape[0]
    width = image.shape[1]

    scale_x = width / size[1]
    scale_y = height / size[0]
    dst = np.zeros(size, image.dtype)

    for i in range(size[0]): #y
        for j in range(size[1]): #x
            pt = (j*scale_x, i*scale_y)

            x, y = np.int32(pt)

            if x >= image.shape[1] - 1: x = x - 1
            if y >= image.shape[0] - 1: y = y - 1

            A, C, B, D = np.float32(image[y:y + 2, x: x + 2].flatten())

            a, b = pt[1] - y, pt[0] - x

            E = A + a * (B - A)
            F = C + a * (D - C)
            X = E + b * (F - E)

            dst[i, j] = np.clip(X, 0, 255)
    return dst

image = cv2.imread("images/interpolation.jpg", cv2.IMREAD_GRAYSCALE)
if image is None: raise Exception("영상 파일 읽기 오류")

size = (350, 329)
dst1 = bilinear_interpolation(image, size)

cv2.imshow("image", image)
cv2.imshow("User_bilinear2", dst1)
cv2.waitKey(0)