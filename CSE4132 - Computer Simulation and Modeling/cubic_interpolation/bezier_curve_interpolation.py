import pygame
import time

pygame.init()



pygame.display.set_caption("curve")

screenSize = (1000,600)
screen = pygame.display.set_mode(screenSize)

x, y = 400.0, 400.0
height, width = 90, 90
Speed = 0.0004
f = pygame.font.get_fonts()[0]
font = pygame.font.SysFont(f, 32)
position_text1 = font.render("P0", True, (255,255,255), (0,0,0))
position_text2 = font.render("P1", True, (255,255,255), (0,0,0))
position_text3 = font.render("P2", True, (255,255,255), (0,0,0))
position_text4 = font.render("P3", True, (255,255,255), (0,0,0))

textRect1 = position_text1.get_rect()
textRect2 = position_text2.get_rect()
textRect3 = position_text3.get_rect()
textRect4 = position_text4.get_rect()

path_position = [(100.0, 500.0),(200.0, 100.0),(600.0, 80.0),(650.0, 410.0)]

t = 0
running = True


                
while running:
    screen.fill((0,0,0))
    pygame.time.delay(50)
    
    P0 = path_position[0]
    P1 = path_position[1]
    P2 = path_position[2]
    P3 = path_position[3]
    
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            running = False
            
            
            while t<1:
                t +=Speed
                
                P0_x = pow((1-t),3) * P0[0]
                P0_y = pow((1-t),3) * P0[1]
                
                P1_x = 3 * pow((1-t),2) * t * P1[0]
                P1_y = 3 * pow((1-t),2) * t * P1[1]
                
                P2_x = 3 * (1-t) * pow(t,2) * P2[0]
                P2_y = 3 * (1-t) * pow(t,2) * P2[1]
                
                P3_x = pow(t,3) * P3[0]
                P3_y = pow(t,3) * P3[1]
                
                
                formular = ((P0_x + P1_x + P2_x + P3_x),(P0_y + P1_y + P2_y + P3_y))
                
                x, y = formular
                
                ### Display text
                
                textRect1.center = P0
                textRect2.center = P1
                textRect3.center = P2
                textRect4.center = P3
                
                screen.blit(position_text1,textRect1)
                screen.blit(position_text2,textRect2)
                screen.blit(position_text3,textRect3)
                screen.blit(position_text4,textRect4)
                ### Display the lines
                
                pygame.draw.line(screen, (0,255,0), P0, P1, 1)
                pygame.draw.line(screen, (0,0,255), P2, P3, 1)
                
                
                pygame.draw.circle(screen, (0,0,255), (round(x),round(y)), 10)
                
                
                pygame.display.flip()
               

pygame.time.delay(1000)
pygame.quit()

                
