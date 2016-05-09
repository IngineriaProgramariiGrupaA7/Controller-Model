import java.util.ArrayList;
import java.util.List;

/**
 * Created by m on 4/26/16.
 */
public class ActoriObiective {
    private List<ActorObiectiv> actoriObiectivList=new ArrayList<>();

    public void addActoriObiective(ActorObiectiv actorObiectiv ){
        this.actoriObiectivList.add(actorObiectiv);
    }

    public List<ActorObiectiv> getActorObiectivList(){
        return this.actoriObiectivList   ;
    }
}
