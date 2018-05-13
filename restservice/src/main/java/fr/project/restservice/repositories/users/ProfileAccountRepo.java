package fr.project.restservice.repositories.users;

import fr.project.utils.entities.others.Sample;
import fr.project.utils.entities.users.ProfileAccount;
import org.springframework.data.repository.CrudRepository;

public interface ProfileAccountRepo extends CrudRepository<ProfileAccount, Long> {
    ProfileAccount findByPseudo(String pseudo);
}
