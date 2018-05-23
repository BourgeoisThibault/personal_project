package fr.project.restservice.controllers.accounts;

import fr.project.restservice.services.params.ProfileService;
import fr.project.restservice.services.switchoffer.OfferService;
import fr.project.restservice.services.users.ProfileAccountService;
import fr.project.restservice.services.users.ProfileInfoService;
import fr.project.utils.entities.oldentities.User;
import fr.project.utils.entities.others.Error;
import fr.project.utils.entities.switchoffer.Offer;
import fr.project.utils.entities.users.ProfileAccount;
import fr.project.utils.entities.users.ProfileInfo;
import fr.project.utils.entities.users.ProfileWorkInfo;
import fr.project.utils.methods.Crypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * @author BOURGEOIS Thibault
 * Date     12/05/2018
 * Time     18:17
 */
@RestController
@RequestMapping("/account/login")
public class LoginController {

    @Autowired
    private ProfileAccountService profileAccountService;
    @Autowired
    private ProfileInfoService profileInfoService;
    @Autowired
    private OfferService offerService;

    @GetMapping(value = "/authentification")
    public ResponseEntity authentificateAccount(
            @RequestHeader(value = "login") String login,
            @RequestHeader(value = "pass") String pass) {
        try {

            ProfileAccount profileAccount = profileAccountService.getOneAccountByPseudo(login);

            if(profileAccount == null) {
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            }

            if (profileAccount.getEncryptedPass().equals(Crypt.getHash(pass))){
                ProfileInfo profileInfo = profileInfoService.getOneInfoByAccount(profileAccount);
                //List<Offer> offerList = offerService.getOfferForUser(profileInfo);
                return new ResponseEntity(profileInfo,HttpStatus.OK);
            }else{
                return new ResponseEntity(HttpStatus.UNAUTHORIZED);
            }

        } catch (HttpClientErrorException ex) {
            return new ResponseEntity(ex.getStatusCode());
        }

    }

    @RequestMapping(path = "/signin", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON)
    public ResponseEntity createNewUser(@RequestBody ProfileAccount profileAccount) {
        ProfileAccount profileAccount1 = profileAccountService.getOneAccountByPseudo(profileAccount.getPseudo());
        ProfileAccount profileAccount2 = profileAccountService.getOneAccountByMail(profileAccount.getMail());
        if ((profileAccount1 == null) && (profileAccount2 == null)) {
            profileAccount.setEncryptedPass(Crypt.getHash(profileAccount.getEncryptedPass()));
            profileAccount = profileAccountService.createNewAccount(profileAccount);
            return new ResponseEntity(profileAccount, HttpStatus.OK);
        } else {
            Error error = new Error("409","Account already exist");
            return new ResponseEntity(error, HttpStatus.CONFLICT);
        }
    }

}
