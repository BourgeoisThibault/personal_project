package dependency.greendao.test.tinder.directional.models.profile;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.sql.Timestamp;
import java.util.Date;

import dependency.greendao.test.tinder.directional.models.working.ProfileType;

/**
 * Created by RubenEdery on 23/05/2018.
 */

public class ProfileInfo {

    @SerializedName("id")
    @Expose
    private Long id;

    @SerializedName("profileAccount")
    @Expose
    private ProfileAccount profileAccount;

    @SerializedName("firstName")
    @Expose
    private String firstName;

    @SerializedName("lastName")
    @Expose
    private String lastName;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("birthday")
    @Expose
    private String birthday;

    @SerializedName("registration")
    @Expose
    private String registration;

    @SerializedName("dreamJobs")
    @Expose
    private String dreamJobs;


    public ProfileInfo(ProfileAccount profileAccount, String firstName, String lastName, String description, String birthday, String registration, String dreamJobs) {
        this.profileAccount = profileAccount;
        this.firstName = firstName;
        this.lastName = lastName;
        this.description = description;
        this.birthday = birthday;
        this.registration = registration;
        this.dreamJobs = dreamJobs;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProfileAccount getProfileAccount() {
        return profileAccount;
    }

    public void setProfileAccount(ProfileAccount profileAccount) {
        this.profileAccount = profileAccount;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getDreamJobs() {
        return dreamJobs;
    }

    public void setDreamJobs(String dreamJobs) {
        this.dreamJobs = dreamJobs;
    }
}
