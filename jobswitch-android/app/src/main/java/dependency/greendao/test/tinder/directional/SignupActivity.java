package dependency.greendao.test.tinder.directional;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.Bind;
import dependency.greendao.test.tinder.directional.models.Client;
import dependency.greendao.test.tinder.directional.models.WorkEntity;
import dependency.greendao.test.tinder.directional.models.WorkPlace;
import dependency.greendao.test.tinder.directional.models.profile.ProfileAccount;
import dependency.greendao.test.tinder.directional.models.profile.ProfileInfo;
import dependency.greendao.test.tinder.directional.models.working.ProfileType;
import dependency.greendao.test.tinder.directional.repository.RequestInterface;
import dependency.greendao.test.tinder.directional.services.Utils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SignupActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private static final String TAG = "SignupActivity";
    String BASE_URL = "http://rest.jobswitch.inside.esiag.info/";

    private Calendar calendar = null;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private ArrayList<WorkPlace> data;
    private ArrayList<WorkEntity> dataWorkEntity;

    List workerList = new ArrayList();
    List workerEntityList = new ArrayList();

    @Bind(R.id.input_name) EditText _nameText;
    @Bind(R.id.input_lastname) EditText _lastnameText;
    @Bind(R.id.input_pseudo) EditText _pseudoText;
    @Bind(R.id.input_email) EditText _emailText;
    @Bind(R.id.input_password) EditText _passwordText;
    @Bind(R.id.input_reEnterPassword) EditText _reEnterPasswordText;
    @Bind(R.id.btn_signup) Button _signupButton;
    @Bind(R.id.link_login) TextView _loginLink;
    //@Bind(R.id.spinner) Spinner spinner;
    //@Bind(R.id.spinnerEntity) Spinner spinnerEntity;
    @Bind(R.id.datebutton) Button datebutton;
    //@Bind(R.id.input_mobile) EditText _mobileText;





    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        ButterKnife.bind(this);
        calendar = Calendar.getInstance();

        _signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup();
            }
        });

        _loginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Finish the registration screen and return to the Login activity
                Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
            }
        });

        /*
        workerEntityList.add("Selectionnez une entity");

        spinnerEntity.setOnItemSelectedListener(this);
        displayDataWorkerEntityList();
        ArrayAdapter<String> dataAdapterEntity = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, workerEntityList);
        dataAdapterEntity.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerEntity.setAdapter(dataAdapterEntity);




        workerList.add("Séléctionnez un work");

        spinner.setOnItemSelectedListener(this);
        displayDataWorkerList();
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, workerList);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);
        */


    }

    public void signup() {
        Log.d(TAG, "Signup");

        if (!validate()) {
            onSignupFailed();
            return;
        }

        _signupButton.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(SignupActivity.this,
                R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Creating Account...");
        progressDialog.show();

        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        // On complete call either onSignupSuccess or onSignupFailed
                        // depending on success
                        onSignupSuccess();
                        // onSignupFailed();
                        progressDialog.dismiss();

                    }
                }, 3000);
    }


    public void onSignupSuccess() {
        _signupButton.setEnabled(true);
        setResult(RESULT_OK, null);

        Utils utils = new Utils();


        String name = _nameText.getText().toString();
        String lastname = _lastnameText.getText().toString();
        String pseudo = _pseudoText.getText().toString();
        String email = _emailText.getText().toString();
        //String mobile = _mobileText.getText().toString();
        String password = _passwordText.getText().toString();

        //String spinnertext = spinner.getSelectedItem().toString();
        //Integer idworkerlist = workerList.indexOf(spinnertext)+1;

        //String spinnertext2 = spinnerEntity.getSelectedItem().toString();
        //Integer idworkerentitylist2 = workerEntityList.indexOf(spinnertext2)+1;

        String date = datebutton.getText().toString();

        String password_crypt = utils.get_SHA_512_SecurePassword(password);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                //.baseUrl("http://localhost:25000/data-access-service/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RequestInterface request = retrofit.create(RequestInterface.class);

        //WorkEntity w = new WorkEntity(idworkerlist);
        //WorkPlace wp = new WorkPlace(idworkerentitylist2);

        ProfileType profileType = new ProfileType("Utilisateur");
        ProfileAccount profileAccount = new ProfileAccount(pseudo,email,password,profileType);
        ProfileInfo profileInfo = new ProfileInfo(profileAccount,name,lastname,"descriptiontest",null,null,"thibault");

        Call<ProfileInfo> call2 = request.createUser(profileInfo);

        call2.enqueue(new Callback<ProfileInfo>() {
            @Override
            public void onResponse(Call<ProfileInfo> call, Response<ProfileInfo> response) {
                Toast.makeText(getBaseContext(), "Inscription réussie ! ", Toast.LENGTH_LONG).show();
                redirectToSignIn();
            }

            @Override
            public void onFailure(Call<ProfileInfo> call, Throwable t) {
                Toast.makeText(getBaseContext(), "L'inscription n'a pas fonctionné ! ", Toast.LENGTH_LONG).show();
            }
        });


        //finish();
    }

    public void onSignupFailed() {
        Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();

        _signupButton.setEnabled(true);
    }

    public boolean validate() {
        boolean valid = true;

        //String mobile = _mobileText.getText().toString();
        String password = _passwordText.getText().toString();
        String reEnterPassword = _reEnterPasswordText.getText().toString();
        String name = _nameText.getText().toString();
        String pseudo = _pseudoText.getText().toString();
        String email = _emailText.getText().toString();

        if (name.isEmpty() || name.length() < 2) {
            _nameText.setError("at least 2 characters");
            valid = false;
        } else {
            _nameText.setError(null);
        }

        if (pseudo.isEmpty()) {
            _pseudoText.setError("Enter Valid Address");
            valid = false;
        } else {
            _pseudoText.setError(null);
        }


        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            _emailText.setError("enter a valid email address");
            valid = false;
        } else {
            _emailText.setError(null);
        }

        /*if (mobile.isEmpty() || mobile.length()!=10) {
            _mobileText.setError("Enter Valid Mobile Number");
            valid = false;
        } else {
            _mobileText.setError(null);
        }*/

        if (password.isEmpty() || password.length() < 4 || password.length() > 20) {
            _passwordText.setError("between 4 and 20 alphanumeric characters");
            valid = false;
        } else {
            _passwordText.setError(null);
        }

        if (reEnterPassword.isEmpty() || reEnterPassword.length() < 4 || reEnterPassword.length() > 20 || !(reEnterPassword.equals(password))) {
            _reEnterPasswordText.setError("Password Do not match");
            valid = false;
        } else {
            _reEnterPasswordText.setError(null);
        }

        return valid;
    }




    public void displayDataWorkerList(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                //.baseUrl("http://localhost:25000/data-access-service/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RequestInterface request = retrofit.create(RequestInterface.class);
        Call<List<WorkPlace>> call = request.listworkplace();
        call.enqueue(new Callback<List<WorkPlace>>() {
            @Override
            public void onResponse(Call<List<WorkPlace>> call, Response<List<WorkPlace>> response) {
                if(response.isSuccess()){
                    List<WorkPlace> userResponse = response.body();
                    data = new ArrayList<WorkPlace>(userResponse);
                    int i =0;
                    while(i<data.size()){
                        workerList.add(data.get(i).getWording().toString());
                        i++;
                    }
                    workerList.remove(0);

                }
                else {
                    //Toast.makeText(getApplicationContext(),"Erreur ! Il n'y aucun compte rattaché à cet ID ",Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<List<WorkPlace>> call, Throwable t) {
                Log.d("Error",t.getMessage());
                //Toast.makeText(getApplicationContext(),"Erreur ! Il n'y aucun compte rattaché à cet ID. Veuillez changer d'ID. "+t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();
        // Showing selected spinner item
        //Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
    }


    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void displayDataWorkerEntityList(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                //.baseUrl("http://localhost:25000/data-access-service/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RequestInterface request = retrofit.create(RequestInterface.class);
        Call<List<WorkEntity>> call = request.listentity();
        call.enqueue(new Callback<List<WorkEntity>>() {
            @Override
            public void onResponse(Call<List<WorkEntity>> call, Response<List<WorkEntity>> response) {
                if(response.isSuccess()){
                    List<WorkEntity> userResponse = response.body();
                    dataWorkEntity = new ArrayList<WorkEntity>(userResponse);
                    int i =0;
                    while(i<dataWorkEntity.size()){
                        workerEntityList.add(dataWorkEntity.get(i).getId(),dataWorkEntity.get(i).getWording().toString());
                        i++;
                    }
                    workerEntityList.remove(0);

                }
                else {
                    Toast.makeText(getApplicationContext(),"Erreur ! Il n'y aucun compte rattaché à cet ID ",Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<List<WorkEntity>> call, Throwable t) {
                Log.d("Error",t.getMessage());
                Toast.makeText(getApplicationContext(),"Erreur ! Il n'y aucun compte rattaché à cet ID. Veuillez changer d'ID. "+t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }


    public void onDateButtonClick(View view) {

        DatePickerDialog dialog;
        dialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                calendar = Calendar.getInstance();
                calendar.set(calendar.YEAR,year);
                calendar.set(calendar.MONTH,month);
                calendar.set(calendar.DAY_OF_MONTH,day);
                String date = dateFormat.format(calendar.getTime());
                datebutton.setText(date);
            }
        }, calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_WEEK));
        dialog.show();
    }


    public void redirectToSignIn(){
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
    }


}