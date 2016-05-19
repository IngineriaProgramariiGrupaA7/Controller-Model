package FisaCerintelor.UseCase;

/**
 *
 * @author Daniel
 */
public class FCRelationship {

    String type;
    String from;
    String to;

    public FCRelationship() {
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getType() {
        return type;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

}
