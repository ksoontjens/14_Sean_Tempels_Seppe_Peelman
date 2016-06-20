/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import org.dvb.ui.DVBColor;
import org.havi.ui.HComponent;

/**
 *
 * @author student
 */
public class MijnComponent extends HComponent {
    
    int br,ho;
    private Image schipimg;
    private Image sterrenimg;
    int x = 300;
    int sy = 0;
    
    public MijnComponent()
    {
        this.setBounds(0,0,100,100); //x,y,breedte,hoogte
    }
    
    public MijnComponent(int x, int y, int w, int h)
    {
        this.setBounds(x,y,w,h); //x,y,breedte,hoogte
        br = w;
        ho = h;
        sterrenimg = this.getToolkit().getImage("sterren.png");
        schipimg = this.getToolkit().getImage("spaceship.png");
        MediaTracker mt = new MediaTracker(this);
        mt.addImage(schipimg, 0);
        mt.addImage(sterrenimg, 1);
        try{
            mt.waitForAll();
        }
        catch(InterruptedException ex){
            ex.printStackTrace();
        }
    }
    
    public void moveleft()
    {
        if(x < 0) x = 0;
        x -= 5;
        this.repaint();
    }
    
    public void moveright()
    {
        if(x > 672) x = 672;
        x += 5;
        this.repaint();
    }
    
    public void scroll()
    {
        sy+=5; 
        if(sy >= 570)
        {
            sy = 0;
        }
        this.repaint();
    }
    
    public void paint(Graphics g)
    {
        g.drawImage(sterrenimg, 0, sy, null);
        g.drawImage(sterrenimg, 0, sy-570, null);
        g.drawImage(schipimg, x, 500, null);
    }

}
