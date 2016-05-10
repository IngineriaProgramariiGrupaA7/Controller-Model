package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by m on 4/26/16.
 */
public class ActionariInterese {
    private List<ActionarInteres> actionariInteresList=new ArrayList<>();

    public void addActionariInterese(ActionarInteres actionarInteres){
        this.actionariInteresList.add(actionarInteres);
    }

    public List<ActionarInteres> getActionarInteresList(){
        return this.actionariInteresList;
    }

}
