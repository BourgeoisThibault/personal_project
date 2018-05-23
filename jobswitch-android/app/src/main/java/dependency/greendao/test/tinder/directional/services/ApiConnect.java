package dependency.greendao.test.tinder.directional.services;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import dependency.greendao.test.tinder.directional.models.Client;
import dependency.greendao.test.tinder.directional.repository.RequestInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by RubenEdery on 23/02/2018.
 */

public class ApiConnect {

    String BASE_URL = "http://rest.jobswitch.inside.esiag.info/user";
    private ArrayList<Client> data;

    public ArrayList<Client> displayData(final Context mContext, String URL){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                //.baseUrl("http://localhost:25000/data-access-service/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RequestInterface request = retrofit.create(RequestInterface.class);
        Call<List<Client>> call = request.listClient();
        call.enqueue(new Callback<List<Client>>() {
            @Override
            public void onResponse(Call<List<Client>> call, Response<List<Client>> response) {
                if(response.isSuccess()){
                    List<Client> userResponse = response.body();
                    data = new ArrayList<Client>(userResponse);
                    Log.d("Taille", String.valueOf(data.size()));
                    int i =0;
                    while(i<data.size()){
                        Log.d("GET_MY_ID", String.valueOf(data.get(i).getId()));
                        Log.d("GET_MY_STRING",data.get(i).getFirstName().toString());
                        i++;
                    }
                }
                else {
                    Toast.makeText(mContext,"Erreur ! Il n'y aucun compte rattaché à cet ID ",Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<List<Client>> call, Throwable t) {
                Log.d("Error",t.getMessage());
                Toast.makeText(mContext,"Erreur ! Il n'y aucun compte rattaché à cet ID. Veuillez changer d'ID. "+t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });



        return data;
    }

}
