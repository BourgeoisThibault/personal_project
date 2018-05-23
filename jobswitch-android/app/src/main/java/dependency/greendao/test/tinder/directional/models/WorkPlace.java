package dependency.greendao.test.tinder.directional.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by RubenEdery on 13/03/2018.
 */

public class WorkPlace {

    public WorkPlace(Integer id) {
        this.id = id;
    }

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("wording")
    @Expose
    private String wording;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWording() {
        return wording;
    }

    public void setWording(String wording) {
        this.wording = wording;
    }



}
