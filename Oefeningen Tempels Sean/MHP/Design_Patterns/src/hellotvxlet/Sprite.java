package hellotvxlet;

import org.havi.ui.HStaticIcon;

public abstract class Sprite extends HStaticIcon implements ObserverInterface
{
    public Sprite(int x, int y)
    {
        super();
        this.setLocation(x, y);
        this.setSize(50, 50);
    }

    public void update(int tijd) 
    {
        int x = this.getX();
        int y = this.getY();
        x++;
        this.setLocation(x, y);
    }
}
