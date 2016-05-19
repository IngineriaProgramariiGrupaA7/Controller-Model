package FisaCerinte.UseCase;

import javax.xml.bind.annotation.*;

/**
 *
 * @author Daniel
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Step {

    @XmlElement(name = "title")
    private String title;

    @XmlElement(name = "description")
    private String description;

    public Step() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
