import cv2
import matplotlib.pyplot as plt

image = cv2.imread("images/matplot.jpg", cv2.IMREAD_COLOR)
if image is None:
    raise Exception("영상 파일 읽기 에러")

rows, cols = image.shape[:2]
rgb_img = cv2.cvtColor(image, cv2.COLOR_BGR2RGB)
gray_img = cv2.cvtColor(image, cv2.COLOR_BGR2GRAY)

fig = plt.figure(num=1, figsize=(3,4))
plt.imshow(image), plt.title("figure1 - original(bgr)")
plt.axis('off'), plt.imshow(gray_img, cmap='gray')
plt.subplot(1,2,2), plt.imshow(gray_img, cmap='gray')
plt.title('gray_img2')
plt.show()