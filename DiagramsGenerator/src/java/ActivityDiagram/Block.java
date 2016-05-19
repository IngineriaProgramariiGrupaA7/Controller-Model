package ActivityDiagram;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Created by vlupoaie on 5/17/2016.
 */
@XmlRootElement(name = "block")
@XmlAccessorType(XmlAccessType.FIELD)
public class Block {

    @XmlAttribute
    private String type;

    @XmlAttribute
    private int chainsCount;

    @XmlElement(name = "chain")
    private List<Chain> chainsList;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getChainsCount() {
        return chainsCount;
    }

    public void setChainsCount(int chainsCount) {
        this.chainsCount = chainsCount;
    }

    public List<Chain> getChainsList() {
        return chainsList;
    }

    public void setChainsList(List<Chain> chainsList) {
        this.chainsList = chainsList;
    }
}
