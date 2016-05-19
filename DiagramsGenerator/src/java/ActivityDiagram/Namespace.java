package ActivityDiagram;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by vlupoaie on 5/17/2016.
 */
@XmlRootElement(name = "namespace")
@XmlAccessorType(XmlAccessType.FIELD)
public class Namespace {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
