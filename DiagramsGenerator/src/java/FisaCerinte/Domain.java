
package FisaCerinte;

/**
 * Created by m on 4/26/16.
 *
 * Class used to model a domain in requirements diagram
 *
 */
public class Domain {

    public Domain(String domain){
        this.domain=domain;
    }

    private String domain;

    public void setDomain(String domain){
        this.domain=domain;
    }

    public String getDomain(){
        return this.domain;
    }


}
