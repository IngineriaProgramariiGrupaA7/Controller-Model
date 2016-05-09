/**
 * Created by m on 5/9/16.
 */
public class ScenariuDeUtilizare {

    private ScenariiPasi scenariiPasi;
    private Extensii extensii;
    private ObiectivContext obiectivContext;

    public void setScenariiPasi(ScenariiPasi scenariiPasi){
        this.scenariiPasi=scenariiPasi;
    }

    public ScenariiPasi getScenariiPasi(){
        return this.scenariiPasi;
    }

    public void setExtensii(Extensii extensii){
        this.extensii=extensii;
    }

    public Extensii getExtensii(){
        return this.extensii;
    }

    public void setObiectivContext(ObiectivContext obiectivContext){
        this.obiectivContext=obiectivContext;
    }

    public ObiectivContext getObiectivContext(){
        return this.obiectivContext;
    }
}
