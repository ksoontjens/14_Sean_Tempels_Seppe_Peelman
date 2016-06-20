package hellotvxlet;

import java.awt.Color;
import org.havi.ui.HStaticIcon;
import org.havi.ui.HVisible;

public class Sprite extends HStaticIcon implements ObserverInterface {
    
    public Sprite(int x, int y)
    {
        super();
        this.setLocation(x, y);
        this.setSize(50, 50);
        this.setBackground(Color.YELLOW);
        this.setBackgroundMode(HVisible.BACKGROUND_FILL);
    }

    public void update(int tijd) {
        int x = this.getX();
        int y = this.getY();
        x++;
        this.setLocation(x, y);
    }

}
