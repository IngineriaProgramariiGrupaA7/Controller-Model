import java.util.ArrayList;
import java.util.List;

/**
 * Created by m on 5/9/16.
 */
public class ScenariiDeUtilizare {

    private List<ScenariuDeUtilizare> scenariiDeUtilizare=new ArrayList<>();

    public void setScenariiDeUtilizare(ScenariuDeUtilizare scenariiDeUtilizare){
        this.scenariiDeUtilizare.add(scenariiDeUtilizare);
    }

    public List<ScenariuDeUtilizare> getScenariiDeUtilizare(){
        return this.scenariiDeUtilizare;
    }
}
