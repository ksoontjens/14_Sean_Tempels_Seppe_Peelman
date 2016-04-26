/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

import java.awt.Color;
import java.awt.Graphics;
import org.havi.ui.HComponent;

/**
 *
 * @author student
 */
public class CenterLine extends HComponent
{
    public int x;
    public int y = 0;
    public int width = 10;
    public int height;
    
    public CenterLine()
    {
        this.x = (HelloTVXlet.scene.getWidth()/2) - width/2;
        this.height = HelloTVXlet.scene.getHeight();
        
        this.setBounds(x, y, width, height);
    }
    
    public void paint(Graphics g)
    {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, width, height);
    }
}
