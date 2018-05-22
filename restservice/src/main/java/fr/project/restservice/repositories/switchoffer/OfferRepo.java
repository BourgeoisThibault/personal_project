package fr.project.restservice.repositories.switchoffer;

import fr.project.utils.entities.switchoffer.Offer;
import fr.project.utils.entities.users.ProfileInfo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OfferRepo extends CrudRepository<Offer, Long> {
    List<Offer> findAllByProfileInfoNot(ProfileInfo profileInfo);
}
