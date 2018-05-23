package dependency.greendao.test.tinder.directional.models.working;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by RubenEdery on 23/05/2018.
 */

public class WorkingLocation {

    @SerializedName("wording")
    @Expose
    private String wording;

    public WorkingLocation(String wording) {
        this.wording = wording;
    }

    public String getWording() {
        return wording;
    }

    public void setWording(String wording) {
        this.wording = wording;
    }
}