package FisaCerintelor;

/**
 * Created by m on 4/26/16.
 */
public class StakeholderAndInterest {
    private String numeActionar;
    private String textInteres;

    public void setName(String numeActionar){
        this.numeActionar=numeActionar;
    }

    public String getName(){
        return this.numeActionar;
    }

    public void setInterest(String textInteres){
        this.textInteres=textInteres;
    }

    public String getInterest(){
        return this.textInteres;
    }
}
