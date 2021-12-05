package com.iwmstudio.belight.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ProfileActivityViewModel extends ViewModel {

    private final MutableLiveData<Boolean> finish = new MutableLiveData<>();

    private final MutableLiveData<String> name = new MutableLiveData<>();
    private final MutableLiveData<String> phone = new MutableLiveData<>();
    private final MutableLiveData<String> email = new MutableLiveData<>();

    private final MutableLiveData<Boolean> save = new MutableLiveData<>();

    public void finish()
    {
        finish.setValue(true);
    }

    public void btnClicked()
    {
        save.setValue(true);
    }

    public MutableLiveData<Boolean> getFinish() {
        return finish;
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

    public MutableLiveData<Boolean> getSave() {
        return save;
    }

}
