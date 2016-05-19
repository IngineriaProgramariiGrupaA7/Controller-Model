package FisaCerintelor;

/**
 * Created by m on 4/26/16.
 */
public class ActorAndObjective {
    private String numeActor;
    private String textObiectiv;

    public void setName(String numeActor){
        this.numeActor=numeActor;
    }

    public String getName(){
        return this.numeActor;
    }

    public void setObjective(String textObiectiv){
        this.textObiectiv=textObiectiv;
    }

    public String getObjective(){
        return this.textObiectiv;
    }
}
