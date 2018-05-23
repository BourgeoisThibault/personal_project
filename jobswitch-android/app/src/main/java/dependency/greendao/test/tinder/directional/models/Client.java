package dependency.greendao.test.tinder.directional.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by RubenEdery on 23/02/2018.
 */

public class Client {

    public Client(String firstName, String lastName, String mail, String pseudo, String password, String dateOfBirth, WorkEntity workEntity, WorkPlace workplace) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mail = mail;
        this.pseudo = pseudo;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.workEntity = workEntity;
        this.workplace = workplace;
    }

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("firstName")
    @Expose
    private String firstName;
    @SerializedName("lastName")
    @Expose
    private String lastName;
    @SerializedName("mail")
    @Expose
    private String mail;
    @SerializedName("pseudo")
    @Expose
    private String pseudo;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("dateOfBirth")
    @Expose
    private String dateOfBirth;
    @SerializedName("workEntity")
    @Expose
    private WorkEntity workEntity;
    @SerializedName("workplace")
    @Expose
    private WorkPlace workplace;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public WorkEntity getWorkEntity() {
        return workEntity;
    }

    public void setWorkEntity(WorkEntity workEntity) {
        this.workEntity = workEntity;
    }

    public WorkPlace getWorkplace() {
        return workplace;
    }

    public void setWorkplace(WorkPlace workplace) {
        this.workplace = workplace;
    }





}
