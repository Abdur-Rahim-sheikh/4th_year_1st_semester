#!/usr/bin/env python
# coding: utf-8

# In[6]:


import cv2
import matplotlib.pyplot as plt
from numpy import random
import numpy as np


# In[ ]:





# In[7]:


hen = plt.imread('hen.webp')
print("house dimentions: ",hen.shape)
plt.imshow(hen)


# In[74]:


kernel = random.randint(-3,4,(5,5))
kernel


# In[79]:



gray_hen = cv2.cvtColor(hen,cv2.COLOR_RGB2GRAY)
filtered = []
x,y = kernel.shape
const = np.sum(kernel) # did not used cause cv2.filter2D does not use

for i in range(gray_hen.shape[0]-x+1):
    row = []
    for j in range(gray_hen.shape[1]-y+1):
        calc = np.sum(np.multiply(kernel,gray_hen[i:i+x,j:j+y]))
        if calc<0:
            calc = 0
        elif calc>255:
            calc = 255
        row.append(calc)

    filtered.append(row)

filtered_hen = np.array(filtered)
plt.imshow(filtered_hen,cmap='gray')


# In[80]:


fil_hen2 = cv2.filter2D(gray_hen,0,kernel)
plt.imshow(fil_hen2,cmap='gray')


# In[ ]:





# In[ ]:




