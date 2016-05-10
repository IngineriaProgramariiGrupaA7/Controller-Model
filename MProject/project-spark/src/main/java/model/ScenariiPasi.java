package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by m on 5/9/16.
 */
public class ScenariiPasi {

    private List<ScenariuPasi>scenariiPasiList=new ArrayList<>();

    public void addScenariuPasi(ScenariuPasi scenariuPasi){
        this.scenariiPasiList.add(scenariuPasi);
    }

    public List<ScenariuPasi> getScenariiPasiList(){
        return this.scenariiPasiList;
    }
}
