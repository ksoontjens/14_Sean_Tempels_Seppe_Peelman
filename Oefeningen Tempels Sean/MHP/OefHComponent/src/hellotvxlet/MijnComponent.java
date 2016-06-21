/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import org.havi.ui.HComponent;

/**
 *
 * @author student
 */
public class MijnComponent extends HComponent
{
    int br, ho;
    int x = 300;
    int sy = 0;
    private Image schipimg, sterrenimg;
    
    public MijnComponent(int x, int y, int b, int h)
    {
       this.setBounds(x, y, b, h); // x, y, b, h 
       
       br = b;
       ho = h;
       
       sterrenimg = this.getToolkit().getImage("sterrenhemel.png");
       schipimg = this.getToolkit().getImage("spaceship.png");
       MediaTracker mt = new MediaTracker(this);
       mt.addImage(schipimg, 0);
       mt.addImage(sterrenimg, 1);
       
       try
       {
           mt.waitForAll();
       }
       catch (InterruptedException ex)
       {
           ex.printStackTrace();
       }
    }
    
    public void moveleft()
    {
        x -= 15;
        if (x < 0)
        {
            x = 0;
        }
        this.repaint();
    }
    
    public void moveright()
    {
        x += 15;
        if(x > 672)
        {
            x = 672;
        }
        this.repaint();
    }
    
    public void scroll()
    {
        sy += 5;
        if(sy >= 570)
        {
            sy = 0;
        }
        this.repaint();
    }
    
    public void paint(Graphics g)
    {
        g.drawImage(sterrenimg, 0, sy, null);
        g.drawImage(sterrenimg, 0, sy - 570, null);
        g.drawImage(schipimg, x, 500, null);
    }
}
