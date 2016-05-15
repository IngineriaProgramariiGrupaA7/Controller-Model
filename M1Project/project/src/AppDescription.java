/**
 * Created by m on 4/26/16.
 */
package src;

import com.sun.xml.txw2.annotation.XmlElement;


public class AppDescription {

    private String description;

    public void setDescription(String description){
        this.description=description;
    }

    public String getDescription(){
        return this.description;
    }
}
