package FisaCerintelor.UseCase;

/**
 *
 * @author Daniel
 */
public class Extension {

    String stepTitle;
    String extensionTitle;
    String description;

    public Extension() {
    }

    public void setStepTitle(String stepTitle) {
        this.stepTitle = stepTitle;
    }

    public void setExtensionTitle(String extensionTitle) {
        this.extensionTitle = extensionTitle;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStepTitle() {
        return stepTitle;
    }

    public String getExtensionTitle() {
        return extensionTitle;
    }

    public String getDescription() {
        return description;
    }

}
