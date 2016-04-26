import java.util.ArrayList;
import java.util.List;

/**
 * Created by m on 4/26/16.
 */
public class ActionariInterese {
    private List<ActionarInteres> actionarInteresList=new ArrayList<>();

    public void addActionariInterese(ActionarInteres actionarInteres){
        this.actionarInteresList.add(actionarInteres);
    }

    public List<ActionarInteres> getActionarInteresList(){
        return this.actionarInteresList;
    }

}
