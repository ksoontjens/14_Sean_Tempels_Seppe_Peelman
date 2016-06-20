package hellotvxlet;

import java.awt.event.KeyEvent;
import java.io.IOException;
import javax.tv.xlet.Xlet;
import javax.tv.xlet.XletContext;
import javax.tv.xlet.XletStateChangeException;
import org.davic.resources.ResourceClient;
import org.davic.resources.ResourceProxy;
import org.dvb.event.EventManager;
import org.dvb.event.UserEvent;
import org.dvb.event.UserEventListener;
import org.dvb.event.UserEventRepository;
import org.havi.ui.HBackgroundConfigTemplate;
import org.havi.ui.HBackgroundConfiguration;
import org.havi.ui.HBackgroundDevice;
import org.havi.ui.HBackgroundImage;
import org.havi.ui.HConfigurationException;
import org.havi.ui.HPermissionDeniedException;
import org.havi.ui.HScene;
import org.havi.ui.HSceneFactory;
import org.havi.ui.HScreen;
import org.havi.ui.HStaticText;
import org.havi.ui.HStillImageBackgroundConfiguration;
import org.havi.ui.event.HBackgroundImageEvent;
import org.havi.ui.event.HBackgroundImageListener;
import org.havi.ui.event.HRcEvent;


public class HelloTVXlet implements Xlet, ResourceClient, HBackgroundImageListener, UserEventListener
{
    private HScreen screen;
    private HBackgroundDevice bgDev;
    private HStillImageBackgroundConfiguration bgConfig;
    private HBackgroundImage pizza1, pizza2, pizza3, pizza4;
    private int imageteller = 0;
    private int cursor = 1;
    HStaticText orderhst;
    String orderstring = "";
    
    public void destroyXlet(boolean unconditional) throws XletStateChangeException {
    }

    public void initXlet(XletContext ctx) throws XletStateChangeException {
        screen=HScreen.getDefaultHScreen();
        bgDev=screen.getDefaultHBackgroundDevice();
        bgDev.reserveDevice(this);
        HBackgroundConfigTemplate bgConfigTemplate =new HBackgroundConfigTemplate();
        bgConfigTemplate.setPreference(HBackgroundConfigTemplate.STILL_IMAGE, 
                HBackgroundConfigTemplate.REQUIRED);
        try {
            bgConfig=(HStillImageBackgroundConfiguration)bgDev.getBestConfiguration(bgConfigTemplate);
            bgDev.setBackgroundConfiguration(bgConfig);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
             
    }

    public void startXlet() throws XletStateChangeException {
        pizza1=new HBackgroundImage("pizza1.m2v");
        pizza1.load(this);
        
        pizza2=new HBackgroundImage("pizza2.m2v");
        pizza2.load(this);
        
        pizza3=new HBackgroundImage("pizza3.m2v");
        pizza3.load(this);
        
        pizza4=new HBackgroundImage("pizza4.m2v");
        pizza4.load(this);
        
        UserEventRepository rep=new UserEventRepository("naam");
        rep.addAllArrowKeys();
        rep.addKey(HRcEvent.VK_ENTER);
        EventManager e=EventManager.getInstance();
        e.addUserEventListener(this, rep);//bij implements USerEventListener toevoegen
        
        HScene scene=HSceneFactory.getInstance().getDefaultHScene();
        orderhst=new HStaticText(orderstring,400,50,300,400);
        orderhst.setVerticalAlignment(HStaticText.VALIGN_TOP);
        orderhst.setHorizontalAlignment(HStaticText.HALIGN_LEFT);
        scene.add(orderhst);
        scene.validate();
        scene.setVisible(true);

    }
    
    public void userEventReceived(UserEvent e) {
        if(e.getType()==KeyEvent.KEY_PRESSED)
        {
            if(e.getCode()==HRcEvent.VK_LEFT)
            {
                cursor--;
                if(cursor<1)
                {
                    cursor=4;
                }
            }
            if(e.getCode()==HRcEvent.VK_RIGHT)
            {
                cursor++;
                if(cursor>4)
                {
                    cursor=1;
                }
            }
            if(e.getCode()==HRcEvent.VK_ENTER)
            {
                if(cursor==1)orderstring+="Meat Lover's\n";
                if(cursor==2)orderstring+="Pepperoni Lover's\n";
                if(cursor==3)orderstring+="Cheese Lover's\n";
                if(cursor==4)orderstring+="Vegi Lover's\n";
            }
            orderhst.setTextContent(orderstring, HStaticText.NORMAL_STATE);
        }
        
        try
        {
            if (cursor==1) bgConfig.displayImage(pizza1);
            if (cursor==2) bgConfig.displayImage(pizza2);
            if (cursor==3) bgConfig.displayImage(pizza3);
            if (cursor==4) bgConfig.displayImage(pizza4);
        }
        catch(Exception ex)
        {
            
        }
    }
    
    public void imageLoaded(HBackgroundImageEvent e) {
        imageteller++;//globaat int imageteller
        if(imageteller==4)
        {
            System.out.println("Alles is geladen");
        }
       try {
            bgConfig.displayImage(pizza1);
        } catch (Exception ex) {
            //ex.printStackTrace();
        }
    }

    public void imageLoadFailed(HBackgroundImageEvent e) {
        System.out.println("Image mislukt");
    }
    
    public void pauseXlet() {
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





    
}