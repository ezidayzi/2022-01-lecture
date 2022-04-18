import numpy as np
import cv2

image = np.zeros((200, 400), np.uint8)
image[:] = 200 # 복색 바탕
title1, title2 = 'Position1', 'Position2' #윈도우 이름
cv2.namedWindow(title1, cv2.WINDOW_AUTOSIZE)
cv2.namedWindow(title2)
# cv2.moveWindow(title1, 150, 150) # 윈도우 이동
# cv2.moveWindow(title2, 400, 50)

cv2.imshow(title1, image) #행렬 원소를 영상으로 표시 꼭 namedWindow를 만들지 않아도 된다.
cv2.imshow(title2, image)
a = cv2.waitKey(0) # 키 이벤트 대기
print(a)
cv2.destroyAllWindows()