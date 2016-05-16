
import com.sun.xml.txw2.annotation.XmlElement;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

public class Shareholder {
    public String name;
    public String description;

    public void setName(String name){
        this.name=name;
    }

    public void setDescription(String description){
        this.description=description;
    }

}
