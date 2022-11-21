import pygame

pygame.init()
pygame.display.set_caption("Beizier curve")

screenSize = (1000,800)
screen = pygame.display.set_mode(screenSize)

Speed = 0.0004
f = pygame.font.get_fonts()[0]
font = pygame.font.SysFont(f, 32)

def render_text(text,pos,color):
    text = font.render(text,True,color,(2,3,5))
    position = text.get_rect()
    position.center = pos
    return text,position
position_texts = []

control_points = [(100.0, 500.0),(200.0, 100.0),(160.0, 600.0),(650.0, 410.0)]

for i,point in enumerate(control_points):
    a,b = render_text('P'+str(i),point,(255,255,255))
    position_texts.append([a,b])
t = 0

screen.fill((0,0,0))
pygame.time.delay(1000)
coef = [1,3,3,1]


for event in pygame.event.get():
    while t<1:
        t +=Speed
        n = 3
        x,y = 0,0
        for i in range(n+1):
            value = coef[i] * pow(1-t,n-i) * pow(t,i)
            x = x + value * control_points[i][0]
            y = y + value * control_points[i][1]
        
        
        # # Display text
        for text,position in position_texts:
            screen.blit(text,position)
        
        ### Display the lines
        for i in range(3):
            pygame.draw.line(screen,(0,255,0),control_points[i],control_points[i+1],1)
      
        pygame.draw.circle(screen, (0,0,255), (round(x),round(y)), 10)
          
        pygame.display.flip()

print("OUT")

from sys import exit
while True: 
    for event in pygame.event.get():
            if event.type == pygame.QUIT:
                pygame.quit()
                exit()
