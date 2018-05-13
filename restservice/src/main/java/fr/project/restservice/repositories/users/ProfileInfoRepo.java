package fr.project.restservice.repositories.users;

import fr.project.utils.entities.others.Sample;
import fr.project.utils.entities.users.ProfileAccount;
import fr.project.utils.entities.users.ProfileInfo;
import org.springframework.data.repository.CrudRepository;

/**
 * @author BOURGEOIS Thibault
 * Date     12/05/2018
 * Time     17:53
 */

public interface ProfileInfoRepo extends CrudRepository<ProfileInfo, Long> {
    ProfileInfo getByProfileAccount(ProfileAccount profileAccount);
}
