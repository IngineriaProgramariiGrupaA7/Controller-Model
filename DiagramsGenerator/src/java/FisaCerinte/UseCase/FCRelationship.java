package FisaCerinte.UseCase;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Daniel
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class FCRelationship {

    private String relation;
    private String entity_1;
    private String entity_2;

    public FCRelationship() {
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getEntity_1() {
        return entity_1;
    }

    public void setEntity_1(String entity_1) {
        this.entity_1 = entity_1;
    }

    public String getEntity_2() {
        return entity_2;
    }

    public void setEntity_2(String entity_2) {
        this.entity_2 = entity_2;
    }
}
