package hellotvxlet;

import java.util.Timer;
import javax.tv.xlet.Xlet;
import javax.tv.xlet.XletContext;
import javax.tv.xlet.XletStateChangeException;
import org.havi.ui.HScene;
import org.havi.ui.HSceneFactory;


public class HelloTVXlet implements Xlet
{
    static HScene scene = null; // dit hoort bij de klasse niet het object
    static Subject publisher = null;
    
    public static HScene getScene()
    {
        return scene;
    }

    public static Subject getPublisher() 
    {
        return publisher;
    }

    public void destroyXlet(boolean unconditional) throws XletStateChangeException 
    {
        
    }

    public void initXlet(XletContext ctx) throws XletStateChangeException 
    {
        scene = HSceneFactory.getInstance().getDefaultHScene();
        
        EnemyRocket s2 = new EnemyRocket(200,200);
        
        scene.add(s2);
        
        Subject publisher = new Subject();
        
        Timer tim1 = new Timer();
        tim1.scheduleAtFixedRate(publisher, 0, 10); // elke 10ms
        
        for(int x = 0; x < 10; x++)
            for(int y = 0; y < 5; y++)
            {
                Enemy e = new Enemy(x * 50, y * 50);
                scene.add(e);
                publisher.register(e);
            }

        publisher.register(s2);
        
        scene.validate();
        scene.setVisible(true);
    }

    public void pauseXlet() 
    {
        
    }

    public void startXlet() throws XletStateChangeException 
    {
        
    }
   
}
