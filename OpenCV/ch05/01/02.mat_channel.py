import numpy as np
import cv2

ch0 = np.zeros((2, 4), np.uint8) + 10
ch1 = np.ones((2, 4), np.uint8) * 20
ch2 = np.full((2, 4), 30, np.uint8)

list_bgr = [ch0, ch1, ch2]