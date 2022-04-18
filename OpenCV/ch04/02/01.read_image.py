import cv2
from Common.utils import print_matInfo

###############################################################################################################
# gray 영상 파일 읽기
title1, title2 = 'gray2gray', 'gray2color' # 윈도우 이름
gray2gray = cv2.imread("images/read_gray.jpg", cv2.IMREAD_GRAYSCALE) # 명암도
gray2color = cv2.imread("images/read_gray.jpg", cv2.IMREAD_COLOR) # 컬러 영상

print(gray2color.dtype)

## 예외 처리 - 영상 파일 읽기 여부 조사
if gray2gray is None or gray2color is None:
    raise Exception("영상파일 읽기 에러")


print("행렬 좌표(100, 100) 화소값")
print("%s %s" %(title1, gray2gray[100, 100]))
print("%s %s\n" %(title1, gray2color[100, 100]))

print_matInfo(title1, gray2gray)
print_matInfo(title2, gray2color)

cv2.imshow(title1, gray2gray)
cv2.imshow(title2, gray2color)
cv2.waitKey(0)
cv2.destroyAllWindows()

###############################################################################################################

print("\n")

###############################################################################################################
# color 영상 파일 읽기
title1, title2 = 'color2gray', 'color2color' # 윈도우 이름
gray2gray = cv2.imread("images/read_color.jpg", cv2.IMREAD_GRAYSCALE) # 명암도
gray2color = cv2.imread("images/read_color.jpg", cv2.IMREAD_COLOR) # 컬러 영상

## 예외 처리 - 영상 파일 읽기 여부 조사
if gray2gray is None or gray2color is None:
    raise Exception("영상파일 읽기 에러")


print("행렬 좌표(100, 100) 화소값")
print("%s %s" %(title1, gray2gray[100, 100]))
print("%s %s\n" %(title1, gray2color[100, 100]))

print_matInfo(title1, gray2gray)
print_matInfo(title2, gray2color)

cv2.imshow(title1, gray2gray)
cv2.imshow(title2, gray2color)
cv2.waitKey(0)

###############################################################################################################

print("\n")

###############################################################################################################

# 16비트 & 32비트 영상 파일 읽기
title1, title2 = '16bit unchanged', '32bit unchanged' # 윈도우 이름
color2unchanged1 = cv2.imread("images/read_16.tif", cv2.IMREAD_UNCHANGED) # 명암도
color2unchanged2 = cv2.imread("images/read_16.tif", cv2.IMREAD_UNCHANGED) # 컬러 영상

## 예외 처리 - 영상 파일 읽기 여부 조사
if color2unchanged1 is None or color2unchanged2 is None:
    raise Exception("영상파일 읽기 에러")

print("16/32비트 영상 행렬 좌표(10,10) 화소값")
print(title1, '원소 자료형', type(color2unchanged1[10][10][0]))
print(title1, '화소값(3원소)', color2unchanged1[10, 10])
print(title2, '원소 자료형', type(color2unchanged2[10][10][0]))
print(title2, '화소값(3원소)', color2unchanged2[10, 10])
print()

print_matInfo(title1, color2unchanged1)
print_matInfo(title2, color2unchanged2)
cv2.imshow(title1, color2unchanged1)
cv2.imshow(title2, (color2unchanged2*255).astype("uint8"))

cv2.waitKey(0)
###############################################################################################################