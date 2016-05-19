package ActivityDiagram;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by vlupoaie on 5/17/2016.
 */
@XmlRootElement(name = "chain")
@XmlAccessorType(XmlAccessType.FIELD)
public class Chain {

    @XmlElement(name = "step")
    private List<Step> stepsList;

    public List<Step> getStepsList() {
        return stepsList;
    }

    public void setStepsList(List<Step> stepsList) {
        this.stepsList = stepsList;
    }
}
