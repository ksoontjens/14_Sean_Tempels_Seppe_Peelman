/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

import java.awt.Color;
import java.awt.Graphics;
import org.dvb.event.UserEvent;
import org.dvb.event.UserEventListener;
import org.havi.ui.HComponent;

/**
 *
 * @author student
 */
public class Paddle extends HComponent implements ObserverInterface, UserEventListener {
    public int paddleNum;
    public int x;
    public int y;
    public int width = 25;
    public int height = 125;
    HelloTVXlet xlet;
    Color kleur;
    public int score;
    public boolean p2DirIsUp = true;
    int speed = 10;
    
    public Paddle(int paddleNum)
    {
        this.paddleNum = paddleNum;
        if(paddleNum == 1)
        {
            this.x = 0;
            kleur=Color.WHITE;
        }
        if(paddleNum == 2)
        {
            this.x = HelloTVXlet.scene.getWidth() - this.width;
            kleur=Color.WHITE;
            speed = 3;
        }

        this.y = HelloTVXlet.scene.getHeight()/2 - this.height/2;
       // this.y+=paddleNum*10;
      //  this.x=30;
        System.out.println(x+" "+y+" "+width+" "+height);
        this.setBounds(x, y, width, height); 
    }
    
    public void paint(Graphics g)
    {
        g.setColor(kleur);
        g.fillRect(0, 0, width, height);
    }
    
    public void Move(boolean directionUp)
    {   
        if(directionUp)
        {
            if(y - speed > 0)
            {
                y -= speed;
                this.setBounds(x, y, width, height);
            }
            else
            {
                y = 0;
                this.setBounds(x, y, width, height);
            }
        }
        else
        {
            if(y + height + speed < HelloTVXlet.scene.getHeight())
            {
                y += speed;
                this.setBounds(x, y, width, height);
            }
            else
            {
                y = HelloTVXlet.scene.getHeight() - height;
                this.setBounds(x, y, width, height);
            }
        }
    }

    public void userEventReceived(UserEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void update(int tijd) 
    {
        if (paddleNum == 2 && HelloTVXlet.b.ballOnRightSide)
        {
            float mistake = getRandRange(2f , 200f);
            if((this.y + this.height/2) > (HelloTVXlet.b.y + mistake))
            {
                p2DirIsUp = true;
            }
            else if((this.y + this.height/2) < (HelloTVXlet.b.y - mistake))
            {
                p2DirIsUp = false;
            }
            this.Move(p2DirIsUp);    
        }
    }
    
    public float getRandRange(float min, float max)
    {
        return min + (float)(Math.random() * max);
    }
    
}
