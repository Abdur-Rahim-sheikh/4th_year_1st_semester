import numpy as np
import pygame
import time
bomber = []
for line in open('./bomber_position.txt'):
    point = [int(x) for x in line.split(' ')]
    bomber.append(point)
# print(bomber)
fighter = [0,0]
vf = 20

pygame.init()
screen_size = (1000,500)
screen = pygame.display.set_mode(screen_size)
f = pygame.font.get_fonts()[0]
font = pygame.font.SysFont(f,32)

screen.fill((0,255,0))
pygame.display.set_caption("Pure Pursuit")
pygame.time.delay(1000)
def render_text(text,pos):
    text = font.render(text,False,(255,0,0),(25,25,25))
    text_rect = text.get_rect()
    text_rect.center = pos
    return text,text_rect
    
# for event in pygame.event.get():
for point in bomber:
    time.sleep(0.4)
    dist = np.sqrt((point[0]-fighter[0])**2 + (point[1]-fighter[1])**2)
    print(dist)
    if dist<10:
        print("caught")
        text,pos = render_text("CAUGHT",(100,100))
        break
    f = (fighter[0]+200,fighter[1]+200)
    b = (point[0]+200,point[1]+200)
    pygame.draw.circle(screen,(255,255,255),f,5)
    pygame.draw.circle(screen,(0,255,255),b,5)
    pygame.display.flip()
    fighter[0] = fighter[0] + vf * (point[0]-fighter[0])/dist
    fighter[1] = fighter[1] + vf * (point[1]-fighter[1])/dist

if dist<10:
    print("caught")
    text,pos = render_text("CAUGHT",(100,100))

else:
    print("Escaped")
    text,pos = render_text("ESCAPED",(100,100))

screen.blit(text,pos)
pygame.display.flip()

from sys import exit
while True:
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            pygame.quit()
            exit()