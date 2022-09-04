'''	
	To extract different kinds of information from an RGB image by 
	converting it into different kinds of single channels.

	Sangeeta Biswas
	Associate Professor
	Dept. of Computer Science & Engineering
	University of Rajshahi, Bangladesh
	6.6.2022
'''

import matplotlib.pyplot as plt
import cv2

def main():
	'''	Load an RGB image.	'''
	img_path = '/home/cse/DigitalImageProcessing/rose.jpeg'
	print(img_path)
	rgb = plt.imread(img_path)
	print(rgb.shape, rgb.max(), rgb.min())
	#print(rgb_img)
	
	'''	Split loaded RGB image into red, green and blue channels. '''
	red = rgb[:, :, 0]
	green = rgb[:, :, 1]
	blue = rgb[:, :, 2]
	print(red.shape, red.max(), red.min())
	
	'''	Convert loaded RGB image into grayscale image. 
		OpenCV does this:
		Grayscale = 0.299 * Red + 0.587 * Green + 0.114 * Blue
	'''
	grayscale = cv2.cvtColor(rgb, cv2.COLOR_RGB2GRAY)
	print(grayscale.shape, grayscale.max(), grayscale.min())
	
	'''	Turn the grayscale image into a binary image. '''
	_, binary = cv2.threshold(grayscale, 50, 255, cv2.THRESH_BINARY)
	
	'''	Plot images. '''
	img_set = [rgb, red, green, blue, grayscale, binary]
	title_set = ['RGB', 'Red', 'Green', 'Blue', 'Grayscale', 'Binary']
	plt.figure(figsize = (20, 20))
	for i in range(6):
		plt.subplot(2, 3,  i + 1)
		plt.title(title_set[i])
		ch = len(img_set[i].shape)
		if (ch == 3):
			plt.imshow(img_set[i])
		else:
			plt.imshow(img_set[i], cmap = 'gray')			
	plt.show()
	
if __name__ == '__main__':
	main()
