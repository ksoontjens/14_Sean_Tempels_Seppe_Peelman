package hellotvxlet;

import java.util.Timer;
import javax.tv.xlet.Xlet;
import javax.tv.xlet.XletContext;
import javax.tv.xlet.XletStateChangeException;
import org.havi.ui.HScene;
import org.havi.ui.HSceneFactory;



public class HelloTVXlet implements Xlet
{
    static HScene scene;
    static Subject publisher;
    
    public static HScene getScene()
    {
        return scene;
    }
    public static Subject getPublisher()
    {
        return publisher;
    }
    public void initXlet(XletContext ctx) {
        
        scene = HSceneFactory.getInstance().getDefaultHScene();
        
        publisher = new Subject();
        Timer tim1 = new Timer();
        tim1.scheduleAtFixedRate(publisher, 0, 10);
        
        for(int x=0; x<10;x++)
        {
            for(int y=0; y<5;y++)
            {
                Enemy e = new Enemy(x*50, y*50);
                scene.add(e);
                publisher.register(e);
            }
        }
        
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