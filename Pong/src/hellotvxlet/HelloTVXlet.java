package hellotvxlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.util.Random;

//import javax.swing.Renderer;
import java.util.Timer;
import javax.tv.xlet.Xlet;
import javax.tv.xlet.XletContext;
import javax.tv.xlet.XletStateChangeException;
import org.bluray.ui.event.HRcEvent;
import org.dvb.event.EventManager;
import org.dvb.event.UserEvent;
import org.dvb.event.UserEventListener;
import org.dvb.event.UserEventRepository;
import org.havi.ui.HScene;
import org.havi.ui.HSceneFactory;
import org.havi.ui.HStaticText;
import org.havi.ui.HVisible;



public class HelloTVXlet extends Thread implements Xlet, UserEventListener{
    
    public  HelloTVXlet xlet;
    public int width = 700;
    public int height = 576;
    
    public static Paddle p1;
    public static Paddle p2;
    public static Ball b;
    public static CenterLine c;
    
    //public Renderer renderer;
    public Random random;
    static HScene scene = null;
    static Subject publisher;
    
    static HStaticText scoreP1;
    static HStaticText scoreP2;
    static HStaticText gameOver;
     
    public static Subject getPublisher()
    {
        return publisher;
    }

    public void initXlet(XletContext ctx) throws XletStateChangeException {

        publisher = new Subject();
        Timer timer = new Timer();
        scene = HSceneFactory.getInstance().getDefaultHScene();
        scene.setBackground(Color.BLACK);
        scene.setBackgroundMode(HVisible.BACKGROUND_FILL);
        
        timer.scheduleAtFixedRate(publisher, 0, 30);
        

        
        p1 = new Paddle(1);
        p2 = new Paddle(2);
        
        publisher.register(p2);
                
        b = new Ball(25, 25);
        
        publisher.register(b);
        
        c = new CenterLine();
        
        scoreP1 = new HStaticText("0");
        scoreP2 = new HStaticText("0");
        int scoreLocation = scene.getWidth()/2 - 25;
        scoreP1.setLocation(scoreLocation - 50, 10);
        scoreP2.setLocation(scoreLocation + 50, 10);
        scoreP1.setSize(50, 50);
        scoreP2.setSize(50, 50);
        
        scoreP1.setFont(new Font("Serif", Font.BOLD, 50));
        scoreP2.setFont(new Font("Serif", Font.BOLD, 50));
        
        gameOver = new HStaticText("Player ? wins!\nPress enter to restart");
        gameOver.setLocation(scene.getWidth()/2 - 250, scene.getHeight()/2 - 150);
        gameOver.setSize(500, 300);
        gameOver.setBackground(Color.GRAY);
        gameOver.setBackgroundMode(HVisible.BACKGROUND_FILL);
        gameOver.setVisible(false);
        
        scene.add(gameOver);
        
        scene.add(scoreP1);
        scene.add(scoreP2);
        
        scene.add(p2);
        scene.add(p1);

        scene.add(c);
        
        scene.add(b);
        
        scene.validate();
        scene.setVisible(true);
    }

    public void startXlet() throws XletStateChangeException {
        EventManager manager = EventManager.getInstance();
        UserEventRepository repo = new UserEventRepository("eventRepository");
        
        repo.addKey(org.havi.ui.event.HRcEvent.VK_UP);
        repo.addKey(org.havi.ui.event.HRcEvent.VK_DOWN);
        repo.addKey(org.havi.ui.event.HRcEvent.VK_ENTER);
        
        manager.addUserEventListener(this, repo);
    }

    public void pauseXlet() {

    }

    public void destroyXlet(boolean arg0) throws XletStateChangeException {

    }

    public void userEventReceived(UserEvent e) {
        if(e.getType() == KeyEvent.KEY_PRESSED)
        {
            switch(e.getCode())
            {
                case HRcEvent.VK_UP:
                    p1.Move(true);
                    scene.repaint();
                    break;
                case HRcEvent.VK_DOWN:
                    p1.Move(false);
                    scene.repaint();
                    break;
            }
            
            if(e.getCode() == HRcEvent.VK_ENTER && b.isPlaying == false)
            {
                p1.y = scene.getHeight()/2 - p1.height/2;
                p2.y = scene.getHeight()/2 - p2.height/2;
                p1.setBounds(0, scene.getHeight()/2 - p1.height/2, p1.width, p1.height);
                p2.setBounds(scene.getWidth()-p2.width, scene.getHeight()/2 - p2.height/2, p2.width, p2.height);
                p1.score = 0;
                p2.score = 0;
                scoreP1.setTextContent(Integer.toString(p1.score), HVisible.NORMAL_STATE);
                scoreP2.setTextContent(Integer.toString(p2.score), HVisible.NORMAL_STATE);
                gameOver.setVisible(false);
                b.isPlaying = true;
            }
        }
    }
    
}
