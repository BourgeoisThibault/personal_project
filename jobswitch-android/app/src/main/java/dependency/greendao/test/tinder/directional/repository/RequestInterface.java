package dependency.greendao.test.tinder.directional.repository;

import java.util.List;
import java.util.Map;

import dependency.greendao.test.tinder.directional.models.Client;
import dependency.greendao.test.tinder.directional.models.WorkEntity;
import dependency.greendao.test.tinder.directional.models.WorkPlace;
import dependency.greendao.test.tinder.directional.models.profile.ProfileAccount;
import dependency.greendao.test.tinder.directional.models.profile.ProfileInfo;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by RubenEdery on 23/02/2018.
 */

public interface RequestInterface {

    @GET("user/")
    Call<List<Client>> listClient();

    @GET("workplace/")
    Call<List<WorkPlace>> listworkplace();

    @GET("workentity/")
    Call<List<WorkEntity>> listentity();

    @POST("account/login/signin")
    Call<ProfileInfo> createUser(@Body ProfileInfo profileInfo);

    @GET("account/login/authentification")
    Call<ProfileInfo> getProfilInfo(@Header("login") String login,
                                          @Header("pass") String pass);


}
