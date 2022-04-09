import numpy as np, cv2

def draw_histo(hist, shape=(200, 256)):
    hist_img = np.full(shape, 255, np.uint8)
    cv2.normalize(hist, hist, 0, shape[0], cv2.NORM_MINMAX) # 정규화
    gap = hist_img.shape[1]/hist.shape[0]

    for i, h in enumerate(hist):
        x = int(round(i*gap))
        w = int(round(gap))
        cv2.rectangle(hist_img, (x, 0, w, int(h)), 0, cv2.FILLED)

    return cv2.flip(hist_img, 0)

image = cv2.imread("images/pixel.jpg", cv2.IMREAD_GRAYSCALE) # 영상 읽기
if image is None: raise Exception("영상 파일 읽기 오류")

hist = cv2.calcHist([image], [0], None, [32], [0, 256])
hist_img = draw_histo(hist)