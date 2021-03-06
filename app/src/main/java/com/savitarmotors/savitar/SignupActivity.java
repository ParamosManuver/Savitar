package com.savitarmotors.savitar;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
;

public class SignupActivity extends AppCompatActivity {
    private static final String TAG = "SignupActivity";

    EditText _nameText;
    EditText _addressText;
    EditText _emailText;
    EditText _mobileText;
    EditText _passwordText;
    EditText _reEnterPasswordText;
    Button _signupButton;
    TextView _loginLink;
    DatabaseHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


    helper=new DatabaseHelper(this);

    _nameText=(EditText)findViewById(R.id.input_name);
    _addressText=(EditText)findViewById(R.id.input_address);
    _emailText=(EditText)findViewById(R.id.input_email);
    _mobileText=(EditText)findViewById(R.id.input_mobile);
    _passwordText=(EditText)findViewById(R.id.input_password);
    _reEnterPasswordText=(EditText)findViewById(R.id.input_reEnterPassword);
    _signupButton=(Button)findViewById(R.id.btn_signup);
    _loginLink=(TextView)findViewById(R.id.link_login);

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
            //Change To Home Activity
            Intent intent2 = new Intent(SignupActivity.this,LoginActivity.class);
            startActivity(intent2);
            finish();
            overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
        }
    });


}

    private void signup() {
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

        String name = _nameText.getText().toString();
        String address = _addressText.getText().toString();
        String email = _emailText.getText().toString();
        String mobile = _mobileText.getText().toString();
        String password = _passwordText.getText().toString();
        String reEnterPassword = _reEnterPasswordText.getText().toString();

        // TODO: Implement your own signup logic here.

        final boolean isInserted=helper.insertData
                (name,address,email,mobile,password);

        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        // On complete call either onSignupSuccess or onSignupFailed
                        // depending on succes
                        if (isInserted==true){
                            onSignupSuccess();
                        }
                        else {
                            onSignupFailed();
                        }
                        progressDialog.dismiss();
                    }
                }, 3000);
    }

    private void onSignupSuccess() {
        _signupButton.setEnabled(true);
        setResult(RESULT_OK, null);
        Intent intent=new Intent(SignupActivity.this,HomeActivity.class);
        startActivity(intent);

    }

    private void onSignupFailed() {
        Toast.makeText(getBaseContext(), "Houston we have a problem!!!! Account Creation failed", Toast.LENGTH_LONG).show();
        _signupButton.setEnabled(true);
    }


    private boolean validate() {
        boolean valid = true;

        String name = _nameText.getText().toString();
        String address = _addressText.getText().toString();
        String email = _emailText.getText().toString();
        String mobile = _mobileText.getText().toString();
        String password = _passwordText.getText().toString();
        String reEnterPassword = _reEnterPasswordText.getText().toString();

        if (name.isEmpty() || name.length() < 3) {
            _nameText.setError("at least 3 characters");
            valid = false;
        } else {
            _nameText.setError(null);
        }

        if (address.isEmpty()) {
            _addressText.setError("Enter Valid Address");
            valid = false;
        } else {
            _addressText.setError(null);
        }


        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            _emailText.setError("Enter a Valid Email Address");
            valid = false;
        } else {
            _emailText.setError(null);
        }

        if (mobile.isEmpty() || mobile.length()!=10) {
            _mobileText.setError("Enter Valid Mobile Number 10 characters");
            valid = false;
        } else {
            _mobileText.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            _passwordText.setError("between 4 and 10 alphanumeric characters");
            valid = false;
        } else {
            _passwordText.setError(null);
        }

        if (reEnterPassword.isEmpty() || reEnterPassword.length() < 4 || reEnterPassword.length() > 10 || !(reEnterPassword.equals(password))) {
            _reEnterPasswordText.setError("Password Do not match");
            valid = false;
        } else {
            _reEnterPasswordText.setError(null);
        }

        return valid;
    }

}
