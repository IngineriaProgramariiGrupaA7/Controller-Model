package ActivityDiagram;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vlupoaie on 5/17/2016.
 */
@XmlRootElement(name = "diagram")
@XmlAccessorType(XmlAccessType.FIELD)
public class ModelActivity {

    @XmlElement(name = "activity")
    private List<Activity> activities;

    public ModelActivity() {
        Activity act = new Activity();
        this.activities = new ArrayList<>();
        this.activities.add(act);
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }
}
