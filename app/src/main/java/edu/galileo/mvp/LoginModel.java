package edu.galileo.mvp;

/**
 * Created by Tony Howarth on 5/4/2017.
 */

public interface LoginModel {

    interface OnLoginFinishedListener {

        void onCanceled();

        void onPasswordError();

        void onSuccess();

    }

    void login(String username, String password, OnLoginFinishedListener listener);

}
