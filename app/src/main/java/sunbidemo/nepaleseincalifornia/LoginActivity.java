package sunbidemo.nepaleseincalifornia;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    TextInputEditText emailTextField, passwordTextField;
    Button loginButton;
    TextView forgetPasswordTextView;
    ProgressDialog progressDialog;
    String email,password;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if ((keyCode == KeyEvent.KEYCODE_BACK))
        {
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);

        progressDialog= new ProgressDialog(this);
        progressDialog.setCancelable(true);

        emailTextField = (TextInputEditText) findViewById(R.id.emailEditText);
        passwordTextField = (TextInputEditText) findViewById(R.id.passwordEditText);

        forgetPasswordTextView = (TextView) findViewById(R.id.forgetPasswordTextView);

        loginButton = (Button) findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email=emailTextField.getText().toString().trim();
                password=passwordTextField.getText().toString().trim();
                if(email.equals("")||password.equals("")){
                    Toast.makeText(LoginActivity.this, "Email or Password Field is Empty.", Toast.LENGTH_SHORT).show();
                }
                else{
                    progressDialog.setMessage("Logging In...");
                    showDialog();
                    Intent i=new Intent(LoginActivity.this,Welcome_Screen_Activity.class);
                    i.putExtra("Username",email);

                    startActivity(i);
                    finish();
                }


            }
        });

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out);

    }


    private void showDialog() {
        if (!progressDialog.isShowing())
            progressDialog.show();
    }

    private void hideDialog() {
        if (progressDialog.isShowing())
            progressDialog.dismiss();
    }
}
