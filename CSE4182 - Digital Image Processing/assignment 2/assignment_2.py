#!/usr/bin/env python
# coding: utf-8

# In[1]:


import matplotlib.pyplot as plt
plt.rcParams['figure.figsize'] = [10, 5]
import numpy as np
import cv2


# In[2]:


home = cv2.imread('home.webp')
gray_home = cv2.cvtColor(home,cv2.COLOR_BGR2GRAY)
# print(ai_house)
plt.imshow(home)

# constants
T1 = 47
T2 = 213
c = 7
p = 20
epsilon = 1e-3


# In[3]:


plt.figure(figsize=(20,25))
def image_plot(img,title,ind,cmap='gray'):
    plt.subplot(2,2,ind)
    plt.title(title)
    plt.imshow(img,cmap = cmap)


# In[4]:


# problem 1
r = np.copy(gray_home)
np.testing.assert_equal(r,gray_home)
s1 = np.where((r>=T1) & (r<=T2),100,10)


# In[5]:


# problem 2
s2 = np.where((r>=T1) & (r<=T2),100,r)


# In[6]:


# problem 3
# s = c * np.log(1+r)
rp = np.where(((r+1<=0) & (r+1)>255),255,r)
s = c * np.log(rp)
s3 = np.array(s,dtype='uint8')


# In[7]:


s4 = c * np.power(( r + epsilon ), p)


# In[8]:


contents = [s1,s2,s3,s4]
titles = ['10 or 100','100 or r','logarithomic','power_case']
cnt = 1
for content,title in zip(contents,titles):
    image_plot(content,title,cnt)
    cnt+=1


# In[ ]:




