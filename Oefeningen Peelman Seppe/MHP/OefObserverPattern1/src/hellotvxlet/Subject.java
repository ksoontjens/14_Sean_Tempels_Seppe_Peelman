

package hellotvxlet;

import java.util.ArrayList;
import java.util.TimerTask;

public class Subject extends TimerTask implements SubjectInterface {
    
    ArrayList oblijst = new ArrayList();
    int tijd = 0;
    
    public void run()
    {
        tijd++;
        for(int i=0;i<oblijst.size();i++)
        {
            ((ObserverInterface)oblijst.get(0)).update(tijd);
        }

    }

    public void register(ObserverInterface ob) {
        oblijst.add(ob);
    }

    public void unregister(ObserverInterface ob) {
        oblijst.remove(ob);
    }
}
