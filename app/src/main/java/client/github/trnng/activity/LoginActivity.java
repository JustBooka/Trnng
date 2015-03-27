package client.github.trnng.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import client.github.trnng.R;

/**
 * Created by alexey.bukin on 27.03.2015.
 */
public class LoginActivity extends Activity {

    RelativeLayout main;
    EditText userNameValue, passwordValue;
    TextView message, userName, password;
    RelativeLayout.LayoutParams messageDimensions, userNameDimensions, userNameValueDimensions,
            passwordDimensions, passwordValueDimensions, loginDimensions;
    Button login;
    int messageId = 1, userNameId = 2, userNameValueId = 3, passwordId = 4,
            passwordValueId = 5, loginId = 6;
    int paddingValue = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        init();
        createMessageTextView();
        createUserNameTextView();
        createUserNameEditText();
        createPasswordTextView();
        createPaswordEditText();
        createButton();
        main.addView(message, messageDimensions);
        main.addView(userName, userNameDimensions);
        main.addView(userNameValue, userNameValueDimensions);
        main.addView(password, passwordDimensions);
        main.addView(passwordValue, passwordValueDimensions);
        main.addView(login, loginDimensions);
    }

    public void init() {
        main = new RelativeLayout(this);
        RelativeLayout.LayoutParams mainDimensions = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        main.setLayoutParams(mainDimensions);

        userNameValue = new EditText(this);
        passwordValue = new EditText(this);
        userName = new TextView(this);
        password = new TextView(this);
        login = new Button(this);
        message = new TextView(this);
    }

    public void createMessageTextView() {
        RelativeLayout.LayoutParams messageDimensions = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        messageDimensions.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        message.setText("Please Login First");
        message.setId(messageId);
        message.setLayoutParams(this.messageDimensions);
        message.setPadding(paddingValue, 100, paddingValue, paddingValue);
    }


    private void createUserNameTextView() {
        userNameDimensions = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        userNameDimensions.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        userNameDimensions.addRule(RelativeLayout.BELOW, messageId);
        userName.setText("User Name:");
        userName.setId(userNameId);
        userName.setPadding(paddingValue, paddingValue, paddingValue, paddingValue);
    }

    private void createUserNameEditText() {
        userNameValueDimensions = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        userNameValueDimensions.addRule(RelativeLayout.RIGHT_OF, userNameId);
        userNameValueDimensions.addRule(RelativeLayout.BELOW, messageId);
        userNameValueDimensions.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        userNameValueDimensions.addRule(RelativeLayout.ALIGN_BASELINE, userNameId);
        userNameValue.setId(userNameValueId);
    }

    private void createPasswordTextView() {
        passwordDimensions = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        passwordDimensions.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        passwordDimensions.addRule(RelativeLayout.BELOW, userNameValueId);
        passwordDimensions.addRule(RelativeLayout.ALIGN_RIGHT, userNameId);
        password.setGravity(Gravity.RIGHT);
        password.setText("Password:");
        password.setId(passwordId);
        password.setPadding(paddingValue, paddingValue, paddingValue, paddingValue);


    }

    private void createPaswordEditText() {
        passwordValueDimensions = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        passwordValueDimensions.addRule(RelativeLayout.RIGHT_OF, passwordId);
        passwordValueDimensions.addRule(RelativeLayout.BELOW, userNameValueId);
        passwordValueDimensions.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        passwordValueDimensions.addRule(RelativeLayout.ALIGN_BASELINE, passwordId);
        passwordValue.setId(passwordValueId);

    }

    private void createButton() {
        loginDimensions = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        loginDimensions.addRule(RelativeLayout.BELOW, passwordValueId);
        loginDimensions.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        login.setId(loginId);
        login.setText("Login");

    }
}
