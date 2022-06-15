import numpy as np,cv2
from Common.interpolation import bilinear_value
from Common.utils import contain

def rotate_pt(img, degree, pt):
    dst = np.zeros(img.shape[:2], img.dtype)
    radian = (degree/180)*np.pi
    sin, cos = np.sin(radian), np.cos(radian)

    for yd in range(img.shape[0]):
        for xd in range(img.shape[1]):
            xd2, yd2 = np.subtract((xd,yd),pt)
            x = xd2*cos + yd2*sin
            y = yd2*cos - xd2*sin
            x,y = np.add((x,y),pt)
            if contain((y,x), img.shape):
                dst[yd, xd] = bilinear_value(img, [x,y])
    return dst

def rotate_pt_by_math(img,degree,pt):
    dst = np.zeros(img.shape[:2], img.dtype)
    radian = (degree/180)*np.pi
    sin,cos = np.sin(radian), np.cos(radian)
    Hy = img.shape[0]-1

    for yd in range(img.shape[0]):
        for xd in range(img.shape[1]):
            x=((Hy-yd) - pt[0])* sin + (xd-pt[1]) * cos +pt[1]
            y = Hy - (((Hy-yd)-pt[0])*cos - (xd-pt[1])*sin+pt[1])
            if contain((y,x), img.shape):
                dst[yd,xd] = bilinear_value(img,[x,y])
    return dst

image = cv2.imread('images/rotate.jpg', cv2.IMREAD_GRAYSCALE)
if image is None: raise Exception("영상 파일을 읽기 에러")

center = np.divmod(image.shape[::-1],2)[0]
dst1 = rotate_pt(image,20,center)
dst2 = rotate_pt_by_math(image,20,center)

cv2.imshow("image",image)
cv2.imshow("dst1-rotated on center",dst1)
cv2.imshow("dst2-rotated on center by math", dst2)
cv2.waitKey(0)