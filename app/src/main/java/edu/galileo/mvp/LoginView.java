package edu.galileo.mvp;

/**
 * Created by Tony Howarth on 5/4/2017.
 */

public interface LoginView {
    void showProgress(boolean showProgress);

    void setUsernameError(int messageResId);

    void setPasswordError(int messageResId);

    void successAction();
}
