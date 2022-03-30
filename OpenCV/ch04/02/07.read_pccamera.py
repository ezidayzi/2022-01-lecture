import cv2
from Common.utils import put_String

capture = cv2.VideoCapture(1)
if not capture.isOpened():
    raise Exception("카메라 연결 안됨")

print("너비 %d" % capture.get(cv2.CAP_PROP_FRAME_WIDTH))
print("높이 %d" % capture.get(cv2.CAP_PROP_FRAME_HEIGHT))
print("노출 %d" % capture.get(cv2.CAP_PROP_EXPOSURE))
print("밝기 %d" % capture.get(cv2.CAP_PROP_BRIGHTNESS))

while True:
    ret, frame = capture.read()
    if not ret:
        break
    if cv2.waitKey(30) >= 0:
        break

    exposure = capture.get(cv2.CAP_PROP_EXPOSURE)
    put_String(frame, 'EXPOS: ', (10, 40), exposure)
    title = "View Frame form Camera"
    cv2.imshow(title, frame)

capture.release()