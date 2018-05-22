package fr.project.restservice.services.switchoffer;

import fr.project.restservice.repositories.switchoffer.OfferValidationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author BOURGEOIS Thibault
 * Date     23/05/2018
 * Time     00:32
 */

@Service
public class OfferValidationService {
    @Autowired
    private OfferValidationRepo offerValidationRepo;
}
