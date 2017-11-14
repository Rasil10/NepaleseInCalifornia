package sunbidemo.nepaleseincalifornia;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.ActionMode;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {
    TextInputEditText fullNameEditText, emailEditText, addressEditText, numberEditText, passwordOneEditText, passwordTwoEditText;
    Button signUpButton, loginButton;
    RadioGroup categoryRadioGroup;
    RadioButton categroyRadioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);


        fullNameEditText = (TextInputEditText) findViewById(R.id.fullNameEditText);
        emailEditText = (TextInputEditText) findViewById(R.id.emailAddressEditText);
        addressEditText = (TextInputEditText) findViewById(R.id.addressEditText);
        numberEditText = (TextInputEditText) findViewById(R.id.contactEditText);
        passwordOneEditText = (TextInputEditText) findViewById(R.id.passwordEditText);
        passwordTwoEditText = (TextInputEditText) findViewById(R.id.passwordConfirmEditText);
        categoryRadioGroup = (RadioGroup) findViewById(R.id.categoryRadioGroup);

        loginButton = (Button) findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SignUpActivity.this, LoginActivity.class);
//                ActivityOptions options =
//                        ActivityOptions.makeCustomAnimation(SignUpActivity.this, R.anim.anim_one, R.anim.anim_two);
//                SignUpActivity.this.startActivity(i, options.toBundle());
//                SignUpActivity.this.finish();
                startActivity(i);
                finish();
            }
        });
        signUpButton = (Button) findViewById(R.id.SignUpButton);
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fullname, emailAddress, addresss, number, password, confirmPassword, category;

                int selectedId = categoryRadioGroup.getCheckedRadioButtonId();
                categroyRadioButton = (RadioButton) findViewById(selectedId);

                fullname = fullNameEditText.getText().toString().trim();
                emailAddress = emailEditText.getText().toString().trim();
                addresss = addressEditText.getText().toString().trim();
                number = numberEditText.getText().toString().trim();
                password = passwordOneEditText.getText().toString().trim();
                confirmPassword = passwordTwoEditText.getText().toString().trim();

                category = categroyRadioButton.getText().toString().trim();
                Toast.makeText(SignUpActivity.this, fullname + "-- " + emailAddress + "-- " + addresss + "-- " + number
                        + "-- " + password + "-- " + confirmPassword + "-- " + category, Toast.LENGTH_LONG).show();

            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out);


    }

    @Override
    protected void onStart() {
        super.onStart();
        overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out);

    }

    @Override
    public void onSupportActionModeStarted(@NonNull ActionMode mode) {
        super.onSupportActionModeStarted(mode);
    }

    @Nullable
    @Override
    public ActionMode onWindowStartingSupportActionMode(@NonNull ActionMode.Callback callback) {
        return super.onWindowStartingSupportActionMode(callback);
    }

    @Override
    public void onLocalVoiceInteractionStarted() {
        super.onLocalVoiceInteractionStarted();
    }

    @Nullable
    @Override
    public android.view.ActionMode onWindowStartingActionMode(android.view.ActionMode.Callback callback) {
        return super.onWindowStartingActionMode(callback);
    }

    @Nullable
    @Override
    public android.view.ActionMode onWindowStartingActionMode(android.view.ActionMode.Callback callback, int type) {
        return super.onWindowStartingActionMode(callback, type);
    }

    @Override
    public void onActionModeStarted(android.view.ActionMode mode) {
        super.onActionModeStarted(mode);
    }
}
