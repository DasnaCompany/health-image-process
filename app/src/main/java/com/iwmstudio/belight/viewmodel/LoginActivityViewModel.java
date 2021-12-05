package com.iwmstudio.belight.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LoginActivityViewModel extends ViewModel {

    private final MutableLiveData<Boolean> finish = new MutableLiveData<>(false);

    private final MutableLiveData<String> phone = new MutableLiveData<>();
    private final MutableLiveData<String> password = new MutableLiveData<>();

    private final MutableLiveData<Boolean> btnClick = new MutableLiveData<>();
    private final MutableLiveData<Boolean> registerClicked = new MutableLiveData<>();

    public void finish()
    {
        finish.setValue(true);
    }

    public void btnClicked()
    {
        btnClick.setValue(true);
    }

    public void register()
    {
        registerClicked.setValue(true);
    }

    public MutableLiveData<String> getPhone() {
        return phone;
    }

    public MutableLiveData<String> getPassword() {
        return password;
    }

    public MutableLiveData<Boolean> getBtnClick() {
        return btnClick;
    }

    public MutableLiveData<Boolean> getFinish() {
        return finish;
    }

    public MutableLiveData<Boolean> getRegisterClicked() {
        return registerClicked;
    }

}
