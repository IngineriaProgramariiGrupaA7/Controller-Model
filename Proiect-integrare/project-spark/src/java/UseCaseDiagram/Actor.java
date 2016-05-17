package UseCaseDiagram;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Daniel
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Actor {

    String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
