package com.example.soundoff.view.login;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import com.example.soundoff.data.model.Professor;
import com.example.soundoff.data.model.Student;
import com.example.soundoff.presenter.StudentLoginPresenter;

import java.io.ByteArrayOutputStream;

public class LoginActivity extends AppCompatActivity {
    boolean logged_in;
    private static LoginActivity main;

    public static LoginActivity getMain() {
        return main;
    }

    private Student student;
    private Professor teacher;


    private static final String LOG_TAG = "LoginActivity";

    private Toast loginInToast;

    private StudentLoginPresenter presenter;

    private EditText emailEdit;
    private EditText passwordEdit;
    private EditText nameEdit;
    private EditText majorEdit;
    private EditText phoneEdit;
    private EditText degreeEdit;
    private RadioButton teacherRadioButton;
    private RadioButton studentRadioButton;
    private Button loginButton;
    private Button signUpButton;


    private String email;
    private String password;
    private String name;
    private String major;
    private String phone;
    private String degree;
    private Boolean isTeacher;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.soundoff_login);

        presenter = new StudentLoginPresenter(this);




        emailEdit = findViewById(R.id.editTextEmail_so);
        passwordEdit = findViewById(R.id.editTextPassword_so);
        nameEdit = findViewById(R.id.editTextFullName_so);
        majorEdit = findViewById(R.id.editTextMajor_so);
        phoneEdit = findViewById(R.id.editTextPhone_so);
        degreeEdit = findViewById(R.id.editTextDegree_so);
        teacherRadioButton = findViewById(R.id.radioButtonTeacher_so);
        studentRadioButton = findViewById(R.id.radioButtonStudent_so);
        loginButton = findViewById(R.id.buttonLogin_so);
        signUpButton = findViewById(R.id.buttonSignUp_so);

        teacherRadioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setUser(True);
            }
        });

        studentRadioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setUser(False);
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                Login(view);
            }
        });

        signUpButton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                Register(view);
            }
        });


    }

    /**
     * Makes a login request. The user is hard-coded, so it doesn't matter what data we put
     * in the LoginRequest object.
     *
     * @param view the view object that was clicked.
     */
    public void Login(View view) {
        loginInToast = Toast.makeText(LoginActivity.this, "Logging In", Toast.LENGTH_LONG);
        loginInToast.show();

        private String email;
        private String password;
        private String name;
        private String major;
        private String phone;
        private String degree;
        private Boolean isTeacher;

        email = emailEdit.getText().toString();

        password = passwordEdit.getText().toString();

        //check to make sure nothing is left blank
        if (email != "" && password != "") {
            // It doesn't matter what values we put here. We will be logged in with a hard-coded dummy user.
            LoginRequest loginRequest = new LoginRequest(email, password);
            LoginTask loginTask = new LoginTask(presenter, Soundoff_Login.this);
            loginTask.execute(loginRequest);
        }


    }

    /**
     * Makes a login request. The user is hard-coded, so it doesn't matter what data we put
     * in the LoginRequest object.
     *
     * @param view the view object that was clicked.
     */
    private void Register(View view) {
        loginInToast = Toast.makeText(LoginActivity.this, "Registering User", Toast.LENGTH_LONG);
        loginInToast.show();

        firstName = firstNameEdit.getText().toString();

        lastName = lastNameEdit.getText().toString();

        username = "@" + userNameEdit.getText().toString();

        password = passwordEdit.getText().toString();


        if (firstName != "" && lastName != "" && username != "" && password != "" && currentPhoto != null) {
            // It doesn't matter what values we put here. We will be logged in with a hard-coded dummy user.
            RegisterRequest registerRequest = new RegisterRequest(firstName, lastName, username, password, currentPhoto);
            RegisterTask registerTask = new RegisterTask(presenter, LoginActivity.this);
            registerTask.execute(registerRequest);
        }


    }

    private void setUser(boolean isTeacher) {
        this.isTeacher = isTeacher;
    }

    private void TakePhoto() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        try {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        } catch (ActivityNotFoundException e) {
            loginInToast = Toast.makeText(LoginActivity.this, "Unable to Open Camera", Toast.LENGTH_LONG);
            loginInToast.show();
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            imageBitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
            currentPhoto = stream.toByteArray();
            imageBitmap.recycle();
        }
    }


    /**
     * The callback method that gets invoked for a successful login. Displays the MainActivity.
     *
     * @param loginResponse the response from the login request.
     */
    @Override
    public void loginSuccessful(LoginResponse loginResponse) {
        Intent intent = new Intent(this, MainActivity.class);

        // todo fix add intent stuff

        loginInToast.cancel();
        startActivity(intent);
    }

    /**
     * The callback method that gets invoked for an unsuccessful login. Displays a toast with a
     * message indicating why the login failed.
     *
     * @param loginResponse the response from the login request.
     */
    @Override
    public void loginUnsuccessful(LoginResponse loginResponse) {
        Toast.makeText(this, "Failed to login. " + loginResponse.getMessage(), Toast.LENGTH_LONG).show();
    }

    /**
     * A callback indicating that an exception was thrown in an asynchronous method called on the
     * presenter.
     *
     * @param exception the exception.
     */
    @Override
    public void handleException(Exception exception) {
        Log.e(LOG_TAG, exception.getMessage(), exception);
        Toast.makeText(this, "Failed to login because of exception: " + exception.getMessage(), Toast.LENGTH_LONG).show();
    }
}






//package com.example.soundoff.view.login;
//
//import android.app.Activity;
//
//import androidx.lifecycle.Observer;
//import androidx.lifecycle.ViewModelProviders;
//
//import android.os.Bundle;
//
//import androidx.annotation.Nullable;
//import androidx.annotation.StringRes;
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.text.Editable;
//import android.text.TextWatcher;
//import android.view.KeyEvent;
//import android.view.View;
//import android.view.inputmethod.EditorInfo;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.ProgressBar;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.example.soundoff.R;
//
//public class LoginActivity extends AppCompatActivity {
//
//    private LoginViewModel loginViewModel;
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_login);
//        loginViewModel = ViewModelProviders.of(this, new LoginViewModelFactory())
//                .get(LoginViewModel.class);
//
//        final EditText usernameEditText = findViewById(R.id.username);
//        final EditText passwordEditText = findViewById(R.id.password);
//        final Button loginButton = findViewById(R.id.login);
//        final ProgressBar loadingProgressBar = findViewById(R.id.loading);
//
//        loginViewModel.getLoginFormState().observe(this, new Observer<LoginFormState>() {
//            @Override
//            public void onChanged(@Nullable LoginFormState loginFormState) {
//                if (loginFormState == null) {
//                    return;
//                }
//                loginButton.setEnabled(loginFormState.isDataValid());
//                if (loginFormState.getUsernameError() != null) {
//                    usernameEditText.setError(getString(loginFormState.getUsernameError()));
//                }
//                if (loginFormState.getPasswordError() != null) {
//                    passwordEditText.setError(getString(loginFormState.getPasswordError()));
//                }
//            }
//        });
//
//        loginViewModel.getLoginResult().observe(this, new Observer<LoginResult>() {
//            @Override
//            public void onChanged(@Nullable LoginResult loginResult) {
//                if (loginResult == null) {
//                    return;
//                }
//                loadingProgressBar.setVisibility(View.GONE);
//                if (loginResult.getError() != null) {
//                    showLoginFailed(loginResult.getError());
//                }
//                if (loginResult.getSuccess() != null) {
//                    updateUiWithUser(loginResult.getSuccess());
//                }
//                setResult(Activity.RESULT_OK);
//
//                //Complete and destroy login activity once successful
//                finish();
//            }
//        });
//
//        TextWatcher afterTextChangedListener = new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//                // ignore
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                // ignore
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//                loginViewModel.loginDataChanged(usernameEditText.getText().toString(),
//                        passwordEditText.getText().toString());
//            }
//        };
//        usernameEditText.addTextChangedListener(afterTextChangedListener);
//        passwordEditText.addTextChangedListener(afterTextChangedListener);
//        passwordEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
//
//            @Override
//            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
//                if (actionId == EditorInfo.IME_ACTION_DONE) {
//                    loginViewModel.login(usernameEditText.getText().toString(),
//                            passwordEditText.getText().toString());
//                }
//                return false;
//            }
//        });
//
//        loginButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                loadingProgressBar.setVisibility(View.VISIBLE);
//                loginViewModel.login(usernameEditText.getText().toString(),
//                        passwordEditText.getText().toString());
//            }
//        });
//    }
//
//    private void updateUiWithUser(LoggedInUserView model) {
//        String welcome = getString(R.string.welcome) + model.getDisplayName();
//        // TODO : initiate successful logged in experience
//        Toast.makeText(getApplicationContext(), welcome, Toast.LENGTH_LONG).show();
//    }
//
//    private void showLoginFailed(@StringRes Integer errorString) {
//        Toast.makeText(getApplicationContext(), errorString, Toast.LENGTH_SHORT).show();
//    }
//}