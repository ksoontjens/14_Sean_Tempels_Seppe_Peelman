package hellotvxlet;

import java.util.Timer;
import javax.microedition.xlet.Xlet;
import javax.microedition.xlet.XletContext;
import javax.microedition.xlet.XletStateChangeException;
import org.havi.ui.HScene;
import org.havi.ui.HSceneFactory;



public class HelloTVXlet implements Xlet
{

    public void initXlet(XletContext ctx) {
        
        HScene scene = HSceneFactory.getInstance().getDefaultHScene();
        
        Sprite s1 = new Sprite(100, 100);
        scene.add(s1);
        
        Sprite s2 = new Sprite(100, 150);
        scene.add(s2);
        
        Subject publisher = new Subject();
        Timer tim1 = new Timer();
        tim1.scheduleAtFixedRate(publisher, 0, 10);
        
        publisher.register(s1);
        
        
        scene.validate();
        scene.setVisible(true);
    }

    public void startXlet() throws XletStateChangeException {
        
    }

    public void pauseXlet() {
        
    }

    public void destroyXlet(boolean arg0) throws XletStateChangeException {
        
    }
}