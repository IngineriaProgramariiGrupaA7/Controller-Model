package FisaCerinte;

/**
 * Created by m on 4/26/16.
 *
 * Class used to model a description in requirements diagram
 *
 */
public class Description {

    public Description(String description){
        this.description=description;
    }

    private String description;

    public void setDescription(String description){
        this.description=description;
    }

    public String getDescription(){
        return this.description;
    }
}
