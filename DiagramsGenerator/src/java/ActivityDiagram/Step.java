package ActivityDiagram;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by vlupoaie on 5/17/2016.
 */
@XmlRootElement(name = "step")
@XmlAccessorType(XmlAccessType.FIELD)
public class Step {

    @XmlAttribute
    private String type;

    @XmlAttribute
    private String belongingNamespace;

    private String name;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBelongingNamespace() {
        return belongingNamespace;
    }

    public void setBelongingNamespace(String belongingNamespace) {
        this.belongingNamespace = belongingNamespace;
    }
}
