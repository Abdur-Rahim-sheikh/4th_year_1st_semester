#!/usr/bin/env python
# coding: utf-8

# In[1]:


import numpy as np
import cv2
import matplotlib.pyplot as plt


# In[23]:


hen = plt.imread('hen.webp')
print(hen.shape)
plt.imshow(hen)


# In[24]:


gray_hen = cv2.cvtColor(hen,cv2.COLOR_RGB2GRAY)
plt.imshow(gray_hen,cmap='gray')


# In[25]:


array = []
total = 0
for i in range (256):
    total += (gray_hen==i).sum()
    array.append((gray_hen==i).sum())
print(gray_hen.shape[0]*gray_hen.shape[1],total)


# In[28]:


plt.bar(range(256),array,width=1)


# In[31]:


plt.hist(gray_hen.ravel(),255,[0,255])
print(gray_hen.shape)


# In[ ]:





# In[ ]:





# In[ ]:





# In[ ]:





# In[ ]:





# In[ ]:




