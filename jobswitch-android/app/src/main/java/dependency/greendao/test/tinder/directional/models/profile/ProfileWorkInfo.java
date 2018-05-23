package dependency.greendao.test.tinder.directional.models.profile;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;

import dependency.greendao.test.tinder.directional.models.working.WorkType;
import dependency.greendao.test.tinder.directional.models.working.WorkingDepartment;
import dependency.greendao.test.tinder.directional.models.working.WorkingLocation;

/**
 * Created by RubenEdery on 23/05/2018.
 */

public class ProfileWorkInfo {

    @SerializedName("id")
    @Expose
    private Long id;

    @SerializedName("profileInfo")
    @Expose
    private ProfileInfo profileInfo;

    @SerializedName("workLibelle")
    @Expose
    private String workLibelle;

    @SerializedName("workType")
    @Expose
    private WorkType workType;

    @SerializedName("workEntity")
    @Expose
    private WorkingDepartment workEntity;

    @SerializedName("workingLocation")
    @Expose
    private WorkingLocation workingLocation;

    @SerializedName("hiringDate")
    @Expose
    private Date hiringDate;

    @SerializedName("interestJob")
    @Expose
    private List<WorkType> interestJob;


    public ProfileWorkInfo(ProfileInfo profileInfo, String workLibelle, WorkType workType, WorkingDepartment workEntity, WorkingLocation workingLocation, Date hiringDate, List<WorkType> interestJob) {
        this.profileInfo = profileInfo;
        this.workLibelle = workLibelle;
        this.workType = workType;
        this.workEntity = workEntity;
        this.workingLocation = workingLocation;
        this.hiringDate = hiringDate;
        this.interestJob = interestJob;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProfileInfo getProfileInfo() {
        return profileInfo;
    }

    public void setProfileInfo(ProfileInfo profileInfo) {
        this.profileInfo = profileInfo;
    }

    public String getWorkLibelle() {
        return workLibelle;
    }

    public void setWorkLibelle(String workLibelle) {
        this.workLibelle = workLibelle;
    }

    public WorkType getWorkType() {
        return workType;
    }

    public void setWorkType(WorkType workType) {
        this.workType = workType;
    }

    public WorkingDepartment getWorkEntity() {
        return workEntity;
    }

    public void setWorkEntity(WorkingDepartment workEntity) {
        this.workEntity = workEntity;
    }

    public WorkingLocation getWorkingLocation() {
        return workingLocation;
    }

    public void setWorkingLocation(WorkingLocation workingLocation) {
        this.workingLocation = workingLocation;
    }

    public Date getHiringDate() {
        return hiringDate;
    }

    public void setHiringDate(Date hiringDate) {
        this.hiringDate = hiringDate;
    }

    public List<WorkType> getInterestJob() {
        return interestJob;
    }

    public void setInterestJob(List<WorkType> interestJob) {
        this.interestJob = interestJob;
    }
}
