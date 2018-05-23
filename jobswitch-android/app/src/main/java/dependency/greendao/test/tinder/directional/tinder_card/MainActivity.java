package dependency.greendao.test.tinder.directional.tinder_card;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.mindorks.placeholderview.SwipeDecor;
import com.mindorks.placeholderview.SwipeDirectionalView;
import com.mindorks.placeholderview.listeners.ItemRemovedListener;

import java.util.ArrayList;
import java.util.List;

import dependency.greendao.test.tinder.directional.R;
import dependency.greendao.test.tinder.directional.models.Client;
import dependency.greendao.test.tinder.directional.repository.RequestInterface;
import dependency.greendao.test.tinder.directional.services.ApiConnect;
import dependency.greendao.test.tinder.directional.tinder_card.Profile;
import dependency.greendao.test.tinder.directional.tinder_card.TinderCard;
import dependency.greendao.test.tinder.directional.tinder_card.Utils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements TinderCard.Callback {

    private SwipeDirectionalView mSwipeView;
    private Context mContext;
    private int mAnimationDuration = 300;
    private boolean isToUndo = false;
    String BASE_URL = "http://rest.jobswitch.inside.esiag.info/";
    private ArrayList<Client> data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSwipeView = (SwipeDirectionalView) findViewById(R.id.swipeView);
        mContext = getApplicationContext();

        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
        Log.i("Preference email : ",pref.getString("email", null)); // getting String
        Log.i("Preference mdp : ",pref.getString("mdp", null)); // getting String



        int bottomMargin = Utils.dpToPx(160);
        Point windowSize = Utils.getDisplaySize(getWindowManager());
        mSwipeView.getBuilder()
                .setDisplayViewCount(3)
                .setIsUndoEnabled(true)
                .setSwipeVerticalThreshold(Utils.dpToPx(50))
                .setSwipeHorizontalThreshold(Utils.dpToPx(50))
                .setHeightSwipeDistFactor(10)
                .setWidthSwipeDistFactor(5)
                .setSwipeDecor(new SwipeDecor()
                        .setViewWidth(windowSize.x)
                        .setViewHeight(windowSize.y - bottomMargin)
                        .setViewGravity(Gravity.TOP)
                        .setPaddingTop(20)
                        .setSwipeAnimTime(mAnimationDuration)
                        .setRelativeScale(0.01f)
                        .setSwipeInMsgLayoutId(R.layout.tinder_swipe_in_msg_view)
                        .setSwipeOutMsgLayoutId(R.layout.tinder_swipe_out_msg_view));


        Point cardViewHolderSize = new Point(windowSize.x, windowSize.y - bottomMargin);

        for (Profile profile : Utils.loadProfiles(this.getApplicationContext())) {
            mSwipeView.addView(new TinderCard(mContext, profile, cardViewHolderSize, this));
        }

        findViewById(R.id.rejectBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSwipeView.doSwipe(false);
            }
        });

        findViewById(R.id.acceptBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSwipeView.doSwipe(true);
            }
        });

        findViewById(R.id.undoBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSwipeView.undoLastSwipe();
            }
        });

        mSwipeView.addItemRemoveListener(new ItemRemovedListener() {
            @Override
            public void onItemRemoved(int count) {
                if (isToUndo) {
                    isToUndo = false;
                    mSwipeView.undoLastSwipe();
                }
            }
        });


        //ApiConnect apiConnect = new ApiConnect();
        //apiConnect.displayData(mContext,BASE_URL);
        displayData();
    }



    @Override
    public void onSwipeUp() {
        Toast.makeText(this, "SUPER LIKE! Show any dialog here.", Toast.LENGTH_SHORT).show();
        isToUndo = true;
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void displayData(){

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
                    int i =0;
                    while(i<data.size()){
                        Log.d("GET_MY_ID", String.valueOf(data.get(i).getId()));
                        Log.d("GET_MY_STRING",data.get(i).getFirstName().toString());
                        i++;
                    }
                }
                else {
                    Toast.makeText(getApplicationContext(),"Erreur ! Aucune réponse n'est renvoyé ",Toast.LENGTH_SHORT).show();
                }
    }
            @Override
            public void onFailure(Call<List<Client>> call, Throwable t) {
                Log.d("Error",t.getMessage());
                Toast.makeText(getApplicationContext(),"Erreur ! Aucune connexion n'est faite avec l'API. "+t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
