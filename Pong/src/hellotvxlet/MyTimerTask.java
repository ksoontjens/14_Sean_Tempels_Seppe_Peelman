/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

import java.util.TimerTask;
import org.dvb.event.UserEvent;
import org.dvb.event.UserEventListener;

/**
 *
 * @author student
 */
public class MyTimerTask extends TimerTask implements UserEventListener{

    public void run() 
    {
          
    }

    public void userEventReceived(UserEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
