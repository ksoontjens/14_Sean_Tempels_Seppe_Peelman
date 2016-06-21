package hellotvxlet;

import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.tv.xlet.*;
import org.dvb.ui.DVBColor;
import org.havi.ui.HScene;
import org.havi.ui.HSceneFactory;
import org.havi.ui.HStaticText;
import org.havi.ui.HTextButton;
import org.havi.ui.HVisible;
import org.havi.ui.event.HActionListener;


public class HelloTVXlet implements Xlet, HActionListener
{
    HScene scene;
    HTextButton button1;
    HTextButton button2;
    HTextButton button3;
    HTextButton button4;
    HStaticText label1;
    
    public HelloTVXlet() 
    {
        
    }

    public void initXlet(XletContext context) 
    {
     System.out.println("initXlet");
     
     scene = HSceneFactory.getInstance().getDefaultHScene();
    }

    public void startXlet() 
    {
     System.out.println("startXlet");
     
                                                                      // x, y, breedte, hoogte
     label1 = new HStaticText("There's suppose to be a question here.", 50, 380, 600, 50);
     label1.setBackgroundMode(HVisible.BACKGROUND_FILL);
     label1.setBackground(Color.GRAY);
     
     button1 = new HTextButton("option 1", 50, 440, 295, 50);
     button2 = new HTextButton("option 2", 50, 500, 295, 50);
     button3 = new HTextButton("option 3", 355, 440, 295, 50);
     button4 = new HTextButton("option 4", 355, 500, 295, 50);
     
     button1.setBackgroundMode(HVisible.BACKGROUND_FILL);
     button2.setBackgroundMode(HVisible.BACKGROUND_FILL);
     button3.setBackgroundMode(HVisible.BACKGROUND_FILL);
     button4.setBackgroundMode(HVisible.BACKGROUND_FILL);
     button1.setBackground(new DVBColor(0, 255, 255, 179)); //R, G, B, Alpha
     button2.setBackground(new DVBColor(0, 255, 255, 179));
     button3.setBackground(new DVBColor(0, 255, 255, 179));
     button4.setBackground(new DVBColor(0, 255, 255, 179));
     
     scene.add(label1);
     scene.add(button1);
     scene.add(button2);
     scene.add(button3);
     scene.add(button4);
     
                               // up, down, left, right
     button1.setFocusTraversal(null, button2, null, button3);
     button2.setFocusTraversal(button1, null, null, button4);
     button3.setFocusTraversal(null, button4, button1, null);
     button4.setFocusTraversal(button3, null, button2, null);
     button1.setActionCommand("button1 click");
     button2.setActionCommand("button2 click");
     button3.setActionCommand("button3 click");
     button4.setActionCommand("button4 click");
     button1.addHActionListener(this); //HActionListener als implements toevoegen
     button2.addHActionListener(this);
     button3.addHActionListener(this);
     button4.addHActionListener(this);
     
     scene.validate();
     scene.setVisible(true);
     
     button1.requestFocus();
    }

    public void pauseXlet() 
    {
     
    }

    public void destroyXlet(boolean unconditional) 
    {
     
    }

    public void actionPerformed(ActionEvent event) {
        System.out.println(event.getActionCommand());
        
        if (event.getActionCommand().equals("button1 click"))
        {
            button1.setBackground(Color.BLUE);
            scene.repaint();
        }
        
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
