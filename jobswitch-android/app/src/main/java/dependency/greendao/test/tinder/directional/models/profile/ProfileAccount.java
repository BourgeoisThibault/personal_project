package dependency.greendao.test.tinder.directional.models.profile;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import dependency.greendao.test.tinder.directional.models.working.ProfileType;

/**
 * Created by RubenEdery on 23/05/2018.
 */

public class ProfileAccount {

    @SerializedName("id")
    @Expose
    private Long id;

    @SerializedName("pseudo")
    @Expose
    private String pseudo;

    @SerializedName("mail")
    @Expose
    private String mail;

    @SerializedName("encryptedPass")
    @Expose
    private String encryptedPass;

    @SerializedName("profileType")
    @Expose
    private ProfileType profileType;


    public ProfileAccount(String pseudo, String mail, String encryptedPass, ProfileType profileType) {
        this.pseudo = pseudo;
        this.mail = mail;
        this.encryptedPass = encryptedPass;
        this.profileType = profileType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getEncryptedPass() {
        return encryptedPass;
    }

    public void setEncryptedPass(String encryptedPass) {
        this.encryptedPass = encryptedPass;
    }

    public ProfileType getProfileType() {
        return profileType;
    }

    public void setProfileType(ProfileType profileType) {
        this.profileType = profileType;
    }
}
