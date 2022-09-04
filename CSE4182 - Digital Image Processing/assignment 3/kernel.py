#!/usr/bin/env python
# coding: utf-8

# In[7]:


import cv2
import matplotlib.pyplot as plt
from numpy import random


# In[9]:


house = cv2.imread('house.jpeg')
print("house dimentions: ",house.shape)
plt.imshow(house)


# In[20]:


kernels = []
titles = []
for i in range(1,7):
    kernels.append(random.randint(-i,i,(i+1,i+1)))
    titles.append(f'kernel {i+1},{i+1} shape')


# In[21]:


def plot(img,title,ind):
    plt.subplot(3,2,ind)
    plt.title(title)
    plt.imshow(img,cmap='gray')


# In[22]:


grayscale = cv2.cvtColor(house,cv2.COLOR_RGB2GRAY)
plt.figure(figsize=(30,30))
for i in range(6):
    plot(cv2.filter2D(grayscale,-1,kernels[i]),titles[i],i+1)


# In[ ]:




