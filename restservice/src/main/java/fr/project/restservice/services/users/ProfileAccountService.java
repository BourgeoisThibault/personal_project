package fr.project.restservice.services.users;

import fr.project.restservice.repositories.users.ProfileAccountRepo;
import fr.project.utils.entities.users.ProfileAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author BOURGEOIS Thibault
 * Date     12/05/2018
 * Time     18:14
 */
@Service
public class ProfileAccountService {
    @Autowired
    private ProfileAccountRepo profileAccountRepo;

    public ProfileAccount getOneAccountByPseudo(String pseudo) {
        return profileAccountRepo.findByPseudo(pseudo);
    }

    public ProfileAccount getOneAccountByMail(String mail){
        return profileAccountRepo.findByMail(mail);
    }

    public ProfileAccount createNewAccount(ProfileAccount profileAccount){
        return profileAccountRepo.save(profileAccount);
    }
}
