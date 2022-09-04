#!/usr/bin/env python
# coding: utf-8

# In[1]:


import matplotlib.pyplot as plt
import cv2
# %matplotlib inline


# In[6]:


img = plt.imread('dear.jpeg')
# plt.figure(figsize=(50,100))
plt.imshow(img)


# In[7]:


def bit_slice(img,bit):
    img = img & (1<<bit)
    img = img > 0
    return img


# In[10]:


def plot_img(img,ind,title,cmap='binary'):
    plt.subplot(4,2,ind)
    plt.title(title,fontsize=10)
#     multiply them by 255 to make it high and low
    plt.imshow(img*255,cmap=cmap)
    plt.savefig('problem_2.jpeg')
    


# In[11]:


grayscale = cv2.cvtColor(img,cv2.COLOR_RGB2GRAY)
# plot_img(grayscale,1,'GrayScale','gray')


for i in range(8):
    plot_img(bit_slice(grayscale,i),i+1,'sliced_'+str(i))
plt.show()


# In[ ]:




