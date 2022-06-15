import cv2
import numpy as np
import sys
import tkinter.messagebox
from matplotlib import pyplot as plt


def color_reset():
    global RGB, RGB_index
    RGB = [255, 0, 0]
    RGB_index = 0


def onMouse(event, x, y, flags, params):
    global ix, iy, drawing, is_First, dstP, dstQ, srcP, srcQ, RGB, RGB_index
    if event == cv2.EVENT_LBUTTONDOWN:
        drawing = True
        ix, iy = x, y

    elif event == cv2.EVENT_LBUTTONUP:
        drawing = False
        cv2.line(params, (ix, iy), (x, y), (RGB[2], RGB[1], RGB[0]), 2)

        if is_First:
            RGB[RGB_index] -= 30
            if RGB[RGB_index] < 0:
                RGB[RGB_index] = 0
                RGB_index += 1
                if RGB_index > 2:
                    RGB_index = 0
                RGB[RGB_index] = 255
            srcP.append([ix, iy])
            srcQ.append([x, y])

        else:
            dstP.append([ix, iy])
            dstQ.append([x, y])


def mouseBrush(img):
    drawing = img.copy()
    cv2.namedWindow('paint')
    cv2.setMouseCallback('paint', onMouse, param=drawing)

    while True:
        cv2.imshow('paint', drawing)
        k = cv2.waitKey(1) & 0xFF

        if k == 27:
            break

    cv2.destroyAllWindows()
    return drawing


def MsgBox1():
    tkinter.messagebox.showinfo('워핑 수행 도우미',
                                '이미지 워핑을 성공적으로 수행하기 위해,'
                                '\n보이는 이미지와 같이 클릭 후 드래그하여 선을 그려주세요.'
                                '\n\n선을 다 그렸으면 Esc키를 눌러주세요.')


def MsgBox2():
    tkinter.messagebox.showinfo('워핑 수행 도우미',
                                '두 번째 이미지에서 선을 그릴 때,'
                                '\n첫 번째 이미지와 같은 순서로 그려주세요.'
                                '\n\n선을 다 그렸으면 Esc키를 눌러주세요.')


def MsgBox3():
    tkinter.messagebox.showinfo('워핑 수행 도우미',
                                '제어선 그리기 완료!'
                                '\n순서가 안맞거나 잘못 그리셨다면 프로그램을 재시작해주세요.'
                                '\n\n확인 버튼을 누르면 워핑을 시작합니다..')


def MsgBox_Fail():
    tkinter.messagebox.showinfo('워핑 수행 도우미',
                                '워핑 실패'
                                '\n제어선의 수가 일치하지 않습니다.\n다시 시도해주세요.')


def MsgBox_Fail2():
    tkinter.messagebox.showinfo('워핑 수행 도우미',
                                '워핑 실패'
                                '\n제어선이 잘못 그려진 것 같습니다.\n다시 시도해주세요.')


def MsgBox_Success():
    tkinter.messagebox.showinfo('워핑 수행 도우미',
                                '워핑 완료'
                                '\n결과를 확인해주세요.')


def perpendicular(a):
    b = np.empty_like(a)
    b[0] = -a[1]
    b[1] = a[0]
    return b


def doWarphing(img1, img2):
    global outputs
    height, width, channels = img1.shape

    dP = (np.array(dstP) - np.array(srcP))
    dQ = (np.array(dstQ) - np.array(srcQ))

    P1 = np.array(srcP)
    P2 = np.array(dstP)
    Q1 = np.array(srcQ)
    Q2 = np.array(dstQ)

    morphedIm = np.zeros(img1.shape, np.float32)

    P = np.array(srcP) + dP
    Q = np.array(srcQ) + dQ

    for h_index in range(0, height):
        for w_index in range(0, width):
            pixel = np.array([w_index, h_index])
            DSUM1 = np.array([0.0, 0.0])
            totalWeight = 0

            for i in range(int(np.array(srcP).size / 2)):
                norm_QP = np.linalg.norm(Q[i] - P[i])

                U = ((pixel - P[i]).dot(Q[i] - P[i])) / (norm_QP * norm_QP)
                H = ((pixel - P[i]).dot(perpendicular(Q[i] - P[i]))) / norm_QP

                xPrime1 = P1[i] + U * (Q1[i] - P1[i]) + (H * perpendicular(Q1[i] - P1[i])) \
                              / np.linalg.norm(Q1[i] - P2[i])

                if (U > 1):
                    shortestDist = np.linalg.norm(Q[i] - pixel)
                elif (U < 0):
                    shortestDist = np.linalg.norm(P[i] - pixel)
                else:
                    if H > 0:
                        shortestDist = H
                    else:
                        shortestDist = H * -1

                lineWeight = ((norm_QP ** p) / (a + shortestDist)) ** b

                DSUM1 = DSUM1 + (xPrime1 - pixel) * lineWeight
                totalWeight += lineWeight

            xPrime1 = pixel + DSUM1 / totalWeight

            srcX = int(xPrime1[0])
            srcY = int(xPrime1[1])

            if (srcX in range(0, width) and srcY in range(0, height)):
                srcRGB = img1[srcY][srcX]
            else:
                srcRGB = img1[h_index][w_index]

            R = (srcRGB[0])
            G = (srcRGB[1])
            B = (srcRGB[2])

            morphedIm[h_index][w_index] = [int(R), int(G), int(B)]

    morphedIm = np.uint8(morphedIm)
    cv2.imwrite('WarphingIMG.jpg', morphedIm)
    outputs = cv2.cvtColor(morphedIm, cv2.COLOR_BGR2RGB)
    print('saved frame')


def mouse_Input(img1, img2):
    global is_First

    is_First = True
    MsgBox1()
    cv2.imshow('example', example)
    drawing1 = mouseBrush(img1)

    is_First = False
    MsgBox2()
    cv2.imshow('First drawing', drawing1)
    color_reset()
    drawing2 = mouseBrush(img2)

    cv2.imshow('First drawing', drawing1)
    cv2.imshow('Second drawing', drawing2)
    MsgBox3()
    cv2.destroyAllWindows()


drawing = False
is_First = True
ix, iy = -1, -1
RGB = [255, 0, 0]
RGB_index = 0

srcP = list()
srcQ = list()
dstP = list()
dstQ = list()

a = 0.01
b = 2
p = 0.75

example = cv2.imread('images/example.png')
original1 = cv2.imread('images/P1.jpg')
original2 = np.zeros(original1.shape, np.uint8)

outputs = np.zeros(original1.shape, np.float32)

mouse_Input(original1, original2)

if not (len(srcP) == len(srcQ) == len(dstP) == len(dstQ)):
    MsgBox_Fail()
    sys.exit(-2)

doWarphing(original1, original2)
MsgBox_Success()

plt.xticks([]), plt.yticks([])
plt.imshow(np.uint8(outputs))
plt.title('warphing')
plt.show()
