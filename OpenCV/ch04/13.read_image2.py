import cv2

from Common.utils import print_matInfo

title1, title2 = 'color2gray', 'color2color' # 윈도우 이름
color2gray = cv2.imread("02/images/read_color.jpg", cv2.IMREAD_GRAYSCALE) # 명암도
color2color = cv2.imread("02/images/read_color.jpg", cv2.IMREAD_COLOR) # 컬러 영상

## 예외 처리 - 영상 파일 읽기 여부 조사
if color2gray is None or color2color is None:
    raise Exception("영상파일 읽기 에러")


print("행렬 좌표(100, 100) 화소값")
print("%s %s" % (title1, color2gray[100, 100]))
print("%s %s\n" % (title1, color2color[100, 100]))

print_matInfo(title1, color2gray)
print_matInfo(title2, color2color)

cv2.imshow(title1, color2gray)
cv2.imshow(title2, color2color)
cv2.waitKey(0)