package ActivityDiagram;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.*;


/**
 * Created by vlupoaie on 5/16/2016.
 *
 * Class used to model an activity element in xml
 * Contains namespace elements and block elements
 *
 */
@XmlRootElement(name = "activity")
@XmlAccessorType(XmlAccessType.FIELD)
public class Activity {

    @XmlElement(name = "namespace")
    private List<Namespace> namespaces;

    @XmlElement(name = "block")
    private List<Block> actionBlocks;

    public Activity() {
        this.namespaces = new ArrayList<>();
        this.actionBlocks = new ArrayList<>();

        // namespaces
        this.namespaces.add(new Namespace());
        this.namespaces.get(0).setName("Customer");

        this.namespaces.add(new Namespace());
        this.namespaces.get(1).setName("Sales");

        this.namespaces.add(new Namespace());
        this.namespaces.get(2).setName("Stockroom");

        // first block
        List<Step> stepsList = new ArrayList<>();
        stepsList.add(new Step());
        stepsList.get(0).setType("activity");
        stepsList.get(0).setName("Request service");
        stepsList.get(0).setBelongingNamespace("Customer");
        List<Chain> chainsList = new ArrayList<>();
        chainsList.add(new Chain());
        chainsList.get(0).setStepsList(stepsList);
        this.actionBlocks.add(new Block());
        this.actionBlocks.get(0).setType("single");
        this.actionBlocks.get(0).setChainsCount(1);
        this.actionBlocks.get(0).setChainsList(chainsList);

        // second block
        chainsList = new ArrayList<>();

        chainsList.add(new Chain());
        stepsList = new ArrayList<>();
        stepsList.add(new Step());
        stepsList.get(0).setType("activity");
        stepsList.get(0).setName("Pay");
        stepsList.get(0).setBelongingNamespace("Customer");
        chainsList.get(0).setStepsList(stepsList);

        chainsList.add(new Chain());
        stepsList = new ArrayList<>();
        stepsList.add(new Step());
        stepsList.get(0).setType("object");
        stepsList.get(0).setName("Order");
        stepsList.get(0).setBelongingNamespace("Sales");
        stepsList.add(new Step());
        stepsList.get(1).setType("activity");
        stepsList.get(1).setName("Take order");
        stepsList.get(1).setBelongingNamespace("Sales");
        stepsList.add(new Step());
        stepsList.get(2).setType("object");
        stepsList.get(2).setName("Order");
        stepsList.get(2).setBelongingNamespace("Stockroom");
        stepsList.add(new Step());
        stepsList.get(3).setType("activity");
        stepsList.get(3).setName("Fill order");
        stepsList.get(3).setBelongingNamespace("Stockroom");
        stepsList.add(new Step());
        stepsList.get(4).setType("object");
        stepsList.get(4).setName("Order");
        stepsList.get(4).setBelongingNamespace("Sales");
        chainsList.get(1).setStepsList(stepsList);
        this.actionBlocks.add(new Block());
        this.actionBlocks.get(1).setType("multiple");
        this.actionBlocks.get(1).setChainsCount(2);
        this.actionBlocks.get(1).setChainsList(chainsList);

        // third block
        stepsList = new ArrayList<>();
        stepsList.add(new Step());
        stepsList.get(0).setType("activity");
        stepsList.get(0).setName("Deliver order");
        stepsList.get(0).setBelongingNamespace("Sales");
        stepsList.add(new Step());
        stepsList.get(1).setType("object");
        stepsList.get(1).setName("Order");
        stepsList.get(1).setBelongingNamespace("Sales");
        stepsList.add(new Step());
        stepsList.get(2).setType("activity");
        stepsList.get(2).setName("Collect order");
        stepsList.get(2).setBelongingNamespace("Customer");
        chainsList = new ArrayList<>();
        chainsList.add(new Chain());
        chainsList.get(0).setStepsList(stepsList);
        this.actionBlocks.add(new Block());
        this.actionBlocks.get(2).setType("single");
        this.actionBlocks.get(2).setChainsCount(1);
        this.actionBlocks.get(2).setChainsList(chainsList);
    }

    public List<Block> getActionBlocks() {
        return actionBlocks;
    }

    public void setActionBlocks(List<Block> actionBlocks) {
        this.actionBlocks = actionBlocks;
    }

    public List<Namespace> getNamespaces() {
        return namespaces;
    }

    public void setNamespaces(List<Namespace> namespaces) {
        this.namespaces = namespaces;
    }
}

