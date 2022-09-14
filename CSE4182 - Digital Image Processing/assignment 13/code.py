from PIL import Image
img = Image.open('world.jpeg')
img.save("changed_world.png",format='png')

img2 = Image.open('changed_world.png')
img2.save('changed_world_again.jpeg',format='jpeg')
img3 = Image.open('changed_world_again.jpeg')
print(img.format,img2.format,img3.format)
