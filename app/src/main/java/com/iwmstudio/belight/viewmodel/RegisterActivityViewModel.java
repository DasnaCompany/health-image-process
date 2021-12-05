package com.iwmstudio.belight.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RegisterActivityViewModel extends ViewModel {

    private final MutableLiveData<Boolean> finish = new MutableLiveData<>();

    private final MutableLiveData<String> name = new MutableLiveData<>();
    private final MutableLiveData<String> phone = new MutableLiveData<>();
    private final MutableLiveData<String> email = new MutableLiveData<>();
    private final MutableLiveData<String> password = new MutableLiveData<>();

    private final MutableLiveData<Boolean> registerBtn = new MutableLiveData<>(false);

    public void btnClicked()
    {
        registerBtn.setValue(true);
    }

    public void finish()
    {
        finish.setValue(true);
    }

    public MutableLiveData<String> getName() {
        return name;
    }

    public MutableLiveData<String> getPhone() {
        return phone;
    }

    public MutableLiveData<String> getEmail() {
        return email;
    }

    public MutableLiveData<String> getPassword() {
        return password;
    }

    public MutableLiveData<Boolean> getRegisterBtn() {
        return registerBtn;
    }

    public MutableLiveData<Boolean> getFinish() {
        return finish;
    }

}
