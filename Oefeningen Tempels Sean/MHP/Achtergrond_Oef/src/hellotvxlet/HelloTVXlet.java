package hellotvxlet;


import java.awt.event.KeyEvent;
import javax.tv.xlet.Xlet;
import javax.tv.xlet.XletContext;
import javax.tv.xlet.XletStateChangeException;
import org.bluray.ui.event.HRcEvent;
import org.davic.resources.ResourceClient;
import org.davic.resources.ResourceProxy;
import org.dvb.event.EventManager;
import org.dvb.event.UserEvent;
import org.dvb.event.UserEventListener;
import org.dvb.event.UserEventRepository;
import org.havi.ui.HBackgroundConfigTemplate;
import org.havi.ui.HBackgroundDevice;
import org.havi.ui.HBackgroundImage;
import org.havi.ui.HScene;
import org.havi.ui.HSceneFactory;
import org.havi.ui.HScreen;
import org.havi.ui.HStaticText;
import org.havi.ui.HStillImageBackgroundConfiguration;
import org.havi.ui.event.HBackgroundImageEvent;
import org.havi.ui.event.HBackgroundImageListener;


public class HelloTVXlet implements Xlet, ResourceClient, HBackgroundImageListener, UserEventListener
{
    int imageteller = 0;
    int cursor = 1;
    String orderstring = "orderlijst:\n";
    HBackgroundDevice hBackgrDev;
    HBackgroundImage pizza1, pizza2, pizza3, pizza4;
    HStillImageBackgroundConfiguration hsibc;
    HStaticText orderhst;

    public void destroyXlet(boolean unconditional) throws XletStateChangeException 
    {
        
    }

    public void initXlet(XletContext ctx) throws XletStateChangeException 
    {
        HScreen hscreen = HScreen.getDefaultHScreen();
        hBackgrDev = hscreen.getDefaultHBackgroundDevice();
        
        hBackgrDev.reserveDevice(this); //bovenaan implements RescourceClient
                                        //toevoegen+ import+ implement all
        HBackgroundConfigTemplate cfgTemplate = new HBackgroundConfigTemplate();
        cfgTemplate.setPreference(HBackgroundConfigTemplate.STILL_IMAGE, HBackgroundConfigTemplate.REQUIRED);
        
        hsibc = (HStillImageBackgroundConfiguration)hBackgrDev.getBestConfiguration(cfgTemplate);
        
        try
        {
           if (hBackgrDev.setBackgroundConfiguration(hsibc))
           {
               System.out.println("Reservatie & configuratie gelukt!");
           }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        
        pizza1 = new HBackgroundImage("pizza1.m2v");
        pizza1.load(this); //bovenaan implements HBackgroundImageListener
        pizza2 = new HBackgroundImage("pizza2.m2v");
        pizza2.load(this);
        pizza3 = new HBackgroundImage("pizza3.m2v");
        pizza3.load(this);
        pizza4 = new HBackgroundImage("pizza4.m2v");
        pizza4.load(this);
        
        UserEventRepository rep = new UserEventRepository("naam");
        rep.addAllArrowKeys();
        rep.addKey(HRcEvent.VK_ENTER);
        EventManager e = EventManager.getInstance();
        e.addUserEventListener(this, rep);
        HScene scene = HSceneFactory.getInstance().getDefaultHScene();
        //globaal HStaticText orderhst
        //        String orderstring = "orderlijst:"
        orderhst = new HStaticText(orderstring, 300, 50, 300, 400); //x, y, w, h
        orderhst.setVerticalAlignment(HStaticText.VALIGN_TOP);
        orderhst.setHorizontalAlignment(HStaticText.HALIGN_LEFT);
        scene.add(orderhst);
        scene.validate();
        scene.setVisible(true);
    }

    public void pauseXlet() 
    {
        
    }

    public void startXlet() throws XletStateChangeException 
    {
        
    }

    public boolean requestRelease(ResourceProxy proxy, Object requestData) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void release(ResourceProxy proxy) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void notifyRelease(ResourceProxy proxy) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void imageLoaded(HBackgroundImageEvent e) 
    {
        imageteller++; // globaal int imageteller
        
        if(imageteller == 4)
        {
            System.out.println("images loaded");
            try {hsibc.displayImage(pizza1);}
            catch (Exception ex) {}
        }
    }

    public void imageLoadFailed(HBackgroundImageEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void userEventReceived(UserEvent e) 
    {
        if(e.getType() == KeyEvent.KEY_PRESSED)
        {
            if(e.getCode() == HRcEvent.VK_LEFT)
            {
                cursor--;
                
                if(cursor < 1)
                {
                    cursor = 4;//int cursor = 1 bovenaan
                }
            }
            
            if(e.getCode() == HRcEvent.VK_RIGHT)
            {
                cursor++;
                
                if(cursor > 4)
                {
                    cursor = 1;
                }
            }
            
            if(e.getCode() == HRcEvent.VK_ENTER)
            {
                if(cursor == 1) orderstring = orderstring + "Meat Lovers\n";
                if(cursor == 2) orderstring = orderstring + "Pepperoni Lovers\n";
                if(cursor == 3) orderstring = orderstring + "Cheese Lovers\n";
                if(cursor == 4) orderstring = orderstring + "Vegi Lovers\n";
            }
            
            orderhst.setTextContent(orderstring, HStaticText.NORMAL_STATE);
            
            try
            {
                if(cursor == 1) hsibc.displayImage(pizza1);
                if(cursor == 2) hsibc.displayImage(pizza2);
                if(cursor == 3) hsibc.displayImage(pizza3);
                if(cursor == 4) hsibc.displayImage(pizza4);
            }
            catch(Exception ex)
            {
                
            }
        }
    }
}
