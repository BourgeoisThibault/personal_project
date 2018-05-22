package fr.project.restservice.services.switchoffer;

import fr.project.restservice.repositories.switchoffer.OfferRepo;
import fr.project.utils.entities.switchoffer.Offer;
import fr.project.utils.entities.users.ProfileInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author BOURGEOIS Thibault
 * Date     23/05/2018
 * Time     00:32
 */

@Service
public class OfferService {
    @Autowired
    private OfferRepo offerRepo;

    public List<Offer> getOfferForUser(ProfileInfo profileInfo) {
        return offerRepo.findAllByProfileInfoNot(profileInfo);
    }
}
