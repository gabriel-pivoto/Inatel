import matplotlib.pyplot as plt
import numpy as np
from PIL import Image

ninja = np.array(Image.open('Ninja.jpg'))[:,:,:3]
shrine = np.array(Image.open('Shrine.jpg'))[:,:,:3]
techno = np.array(Image.open('techno.jpg'))[:,:,:3]

# plt.figure(figsize=(16,16))
# plt.subplot(1, 1, 1)
# plt.imshow(ninja)
# plt.figure(figsize=(16,16))
# plt.subplot(2, 1, 1)
# plt.imshow(shrine)
# plt.figure(figsize=(16,16))
# plt.subplot(3, 1, 1)
# plt.imshow(techno)
# plt.show()
# print(ninja.shape)
# print(shrine.shape)
# print(techno.shape)


def ninja_to_tecnho(ninja):
    (l , c, p) = ninja.shape
    scale_x, scale_y = 2, 2
    ninja_novo_tamanho = np.zeros(shape=(l * scale_y, c * scale_x, p), dtype=np.uint8)
    for i in range(l):
        for j in range(c):
            new_x = np.round(j * scale_x)
            new_y = np.round(i * scale_y)
            ninja_novo_tamanho[new_y, new_x] = ninja[i, j]

    plt.imshow(ninja_novo_tamanho)
    Image.fromarray(ninja_novo_tamanho).save('ninja_novo_tamanho.png')

# ninja_to_tecnho(ninja)


def histogram_gray(img):
    (l, c) = img.shape
    histogram = np.zeros(256, dtype=np.int32)

    for i in range(l):
        for j in range(c):
            intensity = img[i, j]
            histogram[intensity] += 1
            
    return histogram

def show_histogram_gray(img):
    histogram = histogram_gray(img)
    plt.figure(figsize=(16, 16))
    plt.subplot(2, 1, 1)
    plt.imshow(img, cmap='gray', vmin=0, vmax=255)
    plt.subplot(2, 1, 2)
    plt.bar(range(256), histogram)

def show_histogram(img):
    histogram_r = histogram_gray(img[:, :, 0])
    histogram_g = histogram_gray(img[:, :, 1])
    histogram_b = histogram_gray(img[:, :, 2])
    
    plt.figure(figsize=(16, 16))
    plt.subplot(2, 1, 1)
    plt.imshow(img, cmap='gray', vmin=0, vmax=255)
    plt.subplot(2, 1, 2)
    plt.bar(range(256), histogram_r, color='red')
    plt.bar(range(256), histogram_g, color='green')
    plt.bar(range(256), histogram_b, color='blue')
    plt.show()


# show_histogram(shrine)

(l, c, p) = techno.shape
refl = np.zeros(shape=techno.shape, dtype=np.uint8)
for i in range(l):
    for j in range(c):
        new_x = -j
        new_y = i
        refl[new_y, new_x] = techno[i, j]

# plt.imshow(refl)
# plt.show()

ninja_blending = np.array(Image.open('ninja_novo_tamanho.png'))[:,:,:3]
imagem_blending = (0.5 * ninja_blending) + ((1 - 0.5) * refl)
imagem_blending = imagem_blending.astype(np.uint8)
# plt.imshow(imagem_blending)
# plt.show()

imagem_blending2 = np.array(imagem_blending)[:,:,:3]
imagem_blending2 = (0.2 * imagem_blending) + ((1 - 0.2) * shrine)
imagem_blending2 = imagem_blending2.astype(np.uint8)
# plt.imshow(imagem_blending2)
# plt.show()


def rgb_to_cmy(img_np):
    
    img_avg = np.zeros(shape=(l, c), dtype=np.uint8)
    for i in range(l):
        for j in range(c):
            r = float(img_np[i, j, 0])
            g = float(img_np[i, j, 1])
            b = float(img_np[i, j, 2])
            
            img_avg[i, j] = (1 - r)+  (1-g)+ (1-b)
    

    Image.fromarray(img_avg).save('resultado.jpg')
    plt.imshow(img_avg)
    plt.show()

rgb_to_cmy(imagem_blending2)
