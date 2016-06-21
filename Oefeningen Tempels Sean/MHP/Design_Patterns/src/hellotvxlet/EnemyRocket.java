package hellotvxlet;

import java.awt.Image;
import java.awt.MediaTracker;
import org.havi.ui.HVisible;

public class EnemyRocket extends Sprite
{
    Image mijnimg;
    
    public EnemyRocket(int x, int y)
    {
        super(x, y);
        
        mijnimg = this.getToolkit().getImage("spaceship.png");
        MediaTracker mt = new MediaTracker(this);
        mt.addImage(mijnimg, 1);
        try
        {
            mt.waitForAll();
        }
        catch (InterruptedException ex)
        {
            ex.printStackTrace();
        }
        
        this.setGraphicContent(mijnimg, HVisible.NORMAL_STATE);
        this.setSize(mijnimg.getWidth(this), mijnimg.getHeight(this));
    }
    
    public void update(int tijd)
    {
        int x = this.getX();
        int y = this.getY();
        y++;
        
        if(y > 576) // uit het scherm
        {
           HelloTVXlet.scene.remove(this);
           HelloTVXlet.publisher.unregister(this);
        }
        
        this.setLocation(x, y);
    }
}

