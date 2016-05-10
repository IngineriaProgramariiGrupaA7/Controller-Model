package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by m on 5/9/16.
 */
public class Extensii {
    private List<Extensie>extensiiList=new ArrayList<>();

    public void addExtensii(Extensie extensie){
        this.extensiiList.add(extensie);
    }

    public List<Extensie> getExtensieList(){
        return this.extensiiList;
    }
}
