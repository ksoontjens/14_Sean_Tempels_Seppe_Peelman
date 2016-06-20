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
    
    public MijnComponent()
    {
        this.setBounds(0,0,100,100); //x,y,breedte,hoogte
    }
    
    public MijnComponent(int x, int y, int w, int h)
    {
        this.setBounds(x,y,w,h); //x,y,breedte,hoogte
        br = w;
        ho = h;
    }
    
    public void paint(Graphics g)
    {
        g.setColor(new DVBColor(0,0,63,179));
        g.fillRoundRect(10, 10, br-10, ho-10, 15, 15);
        g.setColor(new DVBColor(0,0,179,179));
        g.fillRoundRect(0, 0, br-10, ho-10, 15, 15);
        g.setColor(new DVBColor(255,255,0,255));
        g.drawString("Tekst1",50,50);
    }

}
