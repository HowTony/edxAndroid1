package edu.galileo.mvp;

import android.text.TextUtils;

import static android.R.string.cancel;
import static edu.galileo.mvp.R.id.email;

/**
 * Created by Tony Howarth on 5/4/2017.
 */

public class LoginPresenterImpl implements  LoginPresenter, LoginModel.OnLoginFinishedListener {

    private LoginView mLoginView;
    private LoginModel mLoginModel;


    public LoginPresenterImpl(LoginView loginView) {
        mLoginView = loginView;
        mLoginModel = new LoginModelImpl();
    }



    @Override
    public void validateCredentials(String username, String password) {
        // Check for a valid password, if the user entered one.
        if (!TextUtils.isEmpty(password) && !isPasswordValid(password)) {
            mLoginView.setPasswordError(R.string.error_invalid_password);
            return;
        }

        // Check for a valid email address.
        if (TextUtils.isEmpty(username)) {
            mLoginView.setUsernameError(R.string.error_field_required);
            return;
        } else if (!isEmailValid(username)) {
            mLoginView.setUsernameError(R.string.error_invalid_email);
            return;
        }
        mLoginView.showProgress(true);
        mLoginModel.login(username, password, this);
    }

    @Override
    public void onCanceled() {
        mLoginView.showProgress(false);
    }

    @Override
    public void onPasswordError() {
        mLoginView.showProgress(false);
        mLoginView.setPasswordError(R.string.error_incorrect_password);
    }

    @Override
    public void onSuccess() {
        mLoginView.showProgress(false);
        mLoginView.successAction();
    }

    private boolean isEmailValid(String email) {
        //TODO: Replace this with your own logic
        return email.contains("@");
    }

    private boolean isPasswordValid(String password) {
        //TODO: Replace this with your own logic
        return password.length() > 4;
    }

}
