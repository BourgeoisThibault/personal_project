package dependency.greendao.test.tinder.directional;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import dependency.greendao.test.tinder.directional.models.Client;
import dependency.greendao.test.tinder.directional.repository.RequestInterface;
import dependency.greendao.test.tinder.directional.services.ServiceGenerator;
import dependency.greendao.test.tinder.directional.services.Utils;
import dependency.greendao.test.tinder.directional.tinder_card.MainActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NewLoginActivity extends AppCompatActivity {
    Utils utils = new Utils();
    private static final String TAG = "LoginActivity";
    String BASE_URL = "http://rest.jobswitch.inside.esiag.info/";
    private ArrayList<Client> data;

    boolean validation;


    private static final int REQUEST_SIGNUP = 0;

    @Bind(R.id.input_email)
    EditText _emailText;
    @Bind(R.id.input_password)
    EditText _passwordText;
    @Bind(R.id.btn_login)
    Button _loginButton;
    @Bind(R.id.link_signup)
    TextView _signupLink;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        _loginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                login();
            }
        });

        _signupLink.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SignupActivity.class);
                startActivityForResult(intent, REQUEST_SIGNUP);
                finish();
                overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
            }
        });
    }

    public void login() {
        Log.d(TAG, "Login");

        if (!validate()) {
            onLoginFailed();
            return;
        }

        _loginButton.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(NewLoginActivity.this,
                R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Authenticating...");
        progressDialog.show();

        final String email = _emailText.getText().toString();
        final String password = _passwordText.getText().toString();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RequestInterface request = ServiceGenerator.createService(RequestInterface.class);
        Call<List<Client>> call = request.listClient();

        call.enqueue(new Callback<List<Client>>() {
            @Override
            public void onResponse(Call<List<Client>> call, Response<List<Client>> response) {

                if(response.isSuccess()){
                    List<Client> userResponse = response.body();
                    data = new ArrayList<Client>(userResponse);
                    int i =0;

                    while(i<data.size()){
                        System.out.println("Password entrer crypté de la base: " + data.get(i).getPassword().toString());
                        System.out.println("Password entrer : " + password.toString());
                        System.out.println("Password entrer crypté  : " + utils.get_SHA_512_SecurePassword(password.toString()));


                        if(email.equals(data.get(i).getMail()) && data.get(i).getPassword().toString().equals(utils.get_SHA_512_SecurePassword(password.toString()))){
                            validation=true;
                            onLoginSuccess();
                            //Test Shared Preference
                            SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
                            SharedPreferences.Editor editor = pref.edit();
                            editor.putString("email", data.get(i).getMail()); // Storing string email
                            editor.putString("mdp", data.get(i).getPassword().toString()); // Storing string mdp
                            editor.commit(); // commit changes

                            progressDialog.dismiss();
                            redirect();
                            break;
                        }
                        i++;
                    }

                    if(i==data.size()){
                        onLoginFailed();
                        progressDialog.dismiss();
                    }
                }
                else {
                    Toast.makeText(getApplicationContext(),"Erreur ! Il n'y aucun compte rattaché à cet ID ",Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<List<Client>> call, Throwable t) {
                Log.d("Error",t.getMessage());
                Toast.makeText(getApplicationContext(),"Erreur ! Il n'y aucun compte rattaché à cet ID. Veuillez changer d'ID. "+t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.d("RESULT", "RESULT");

        if (requestCode == REQUEST_SIGNUP) {
            Log.d("RESULT", "RESULT");

            if (resultCode == RESULT_OK) {

                // TODO: Implement successful signup logic here

                Log.d("RESULT", "RESULT");

                // By default we just finish the Activity and log them in automatically
                this.finish();
            }
        }
    }

    @Override
    public void onBackPressed() {
        // Disable going back to the MainActivity
        moveTaskToBack(true);
    }

    public void onLoginSuccess() {
        _loginButton.setEnabled(true);
        finish();
    }

    public void onLoginFailed() {
        Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();

        _loginButton.setEnabled(true);
    }

    public boolean validate() {
        boolean valid = true;

        String email = _emailText.getText().toString();
        String password = _passwordText.getText().toString();

        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            _emailText.setError("enter a valid email address");
            valid = false;
        } else {
            _emailText.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            _passwordText.setError("between 4 and 10 alphanumeric characters");
            valid = false;
        } else {
            _passwordText.setError(null);
        }

        return valid;
    }


    public boolean checkIfAuthentificationIsOk() {


        //Need to use data from api.

        boolean valid = true;
        String email = _emailText.getText().toString();
        String password = _passwordText.getText().toString();

        if (!email.equals("ederyruben@yahoo.fr")) {
            valid = false;
        } else if (email.equals("ederyruben@yahoo.fr")) {
            valid = true;
        }

        return valid;
    }

    public void redirect(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
