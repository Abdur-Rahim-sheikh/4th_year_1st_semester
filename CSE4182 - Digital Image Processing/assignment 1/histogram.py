#!/usr/bin/env python
# coding: utf-8

# In[18]:


import matplotlib.pyplot as plt
import cv2
import numpy as np


# In[24]:


img = plt.imread('nature.webp')
plt.imshow(img)


# In[33]:


def plot(img,title,ind):
    plt.subplot(6,2,ind*2+1)
    if(len(img.shape)==3):
        cmap = None
    else:
        cmap = title
            
    plt.title(title)
    plt.imshow(img,cmap)
    
    plt.subplot(6,2,ind*2+2)
            
    plt.hist(img.ravel(),255,[0,255])
    


# In[35]:


plt.figure(figsize=(50,50))

gray = cv2.cvtColor(img,cv2.COLOR_RGB2GRAY)

_, binary = cv2.threshold(gray, 126, 255, cv2.THRESH_BINARY)

img_concated = [img,img[...,0],img[...,1],img[...,2],gray,binary]
titles = ['rgb','Reds','Greens','Blues','gray','binary']

ind = 0
for image,title in zip(img_concated,titles):
    plot(image,title,ind)
    ind +=1
plt.show()


# In[ ]:




