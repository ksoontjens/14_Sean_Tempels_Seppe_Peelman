/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import org.havi.ui.HComponent;
import org.havi.ui.HVisible;

/**
 *
 * @author student
 */
public class Ball extends HComponent implements ObserverInterface {
    int x;
    int y;
    int width;
    int height;
    Color kleur;
    public boolean isPlaying = true;
    public boolean ballOnRightSide;
    
    public int motionX;
    public int motionY;
    
    public int amountOfHits;
    
    public Random rnd;
    
    public Ball(int w, int h)
    {
        this.rnd = new Random();
        this.width = w;
        this.height = h;
        spawn();
        
    }
    public void update(int tijd) 
    {
        if (isPlaying)
        {
            int speed = 1;
            this.x += motionX * speed;
            this.y += motionY * speed;

            if(this.y + height - motionY > HelloTVXlet.scene.getHeight() || this.y + motionY < 0)
            {
                if(this.motionY < 0)
                {
                    this.y = 0;
                    this.motionY = 1 * speed;
                }
                else
                {
                    this.y = HelloTVXlet.scene.getHeight()-this.height;
                    this.motionY = -1 * speed;
                }
            }
            if(checkCol(HelloTVXlet.p1) == 1)
            {
                this.motionX = 1 + (amountOfHits/5);
                amountOfHits++;
            }
            else if(checkCol(HelloTVXlet.p2) == 1)
            {
                this.motionX = -1 - (amountOfHits/5);
                amountOfHits++;
            }
            if(checkCol(HelloTVXlet.p1) == 2)
            {
                HelloTVXlet.p2.score++;
                HelloTVXlet.scoreP2.setTextContent(Integer.toString(HelloTVXlet.p2.score),HVisible.NORMAL_STATE);
                spawn();
            }
            else if(checkCol(HelloTVXlet.p2) == 2)
            {
                HelloTVXlet.p1.score++;
                HelloTVXlet.scoreP1.setTextContent(Integer.toString(HelloTVXlet.p1.score),HVisible.NORMAL_STATE);
                spawn();
            }

            this.setLocation(x, y);
            
            HelloTVXlet.scene.repaint();
            
            if(this.x > HelloTVXlet.scene.getWidth()/2 - 100)
            {
                ballOnRightSide = true;
            }
            else
            {
                ballOnRightSide = false;
            }
        } 
    }
    
    public void paint(Graphics g)
    {
        g.setColor(kleur);
        g.fillRect(0, 0, width, height);
    }
    
    public void spawn()
    {
        if(HelloTVXlet.p1.score == 7)
        {
            HelloTVXlet.gameOver.setTextContent("Player 1 wins!\nPress ENTER to restart", HVisible.NORMAL_STATE);
            GameOver();
        }
        if(HelloTVXlet.p2.score == 7)
        {
            HelloTVXlet.gameOver.setTextContent("Player 2 wins!\nPress ENTER to restart", HVisible.NORMAL_STATE);
            GameOver();
        }
        
        this.amountOfHits = 0;
        this.x = HelloTVXlet.scene.getWidth()/2 - this.width/2;
        this.y = HelloTVXlet.scene.getHeight()/2 - this.height/2;
        this.setBounds(x, y, width, height);
        this.motionY = -2 + rnd.nextInt(4);
        
        if(motionY == 0)
        {
            motionY = 1;
        }
        if(rnd.nextBoolean())
        {
            motionX = 1;
        }
        else
        {
            motionX = -1;
        }
        HelloTVXlet.scene.repaint();
    }
    
    public int checkCol(Paddle pad)
    {
        if(this.x < pad.x + pad.width && this.x + width > pad.x 
                && this.y < pad.y + pad.height 
                && this.y + height > pad.y)
        {
            return 1; //collision
        }
        else if((pad.x > x && pad.paddleNum == 1) 
                || pad.x < x - width && pad.paddleNum == 2)
        {
            return 2; //score
        }
        return 0;
    }
    
    public void GameOver()
    {
        isPlaying = false;
        HelloTVXlet.gameOver.setVisible(true);
    }
}
