package com.iwmstudio.belight.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AboutActivityViewModel extends ViewModel {

    private MutableLiveData<Boolean> finish = new MutableLiveData<>();

    private MutableLiveData<Boolean> contact = new MutableLiveData<>();

    private MutableLiveData<String> about = new MutableLiveData<>();

    public void finish()
    {
        finish.setValue(true);
    }

    public void openContact()
    {
        contact.setValue(true);
    }

    public MutableLiveData<Boolean> getContact() {
        return contact;
    }

    public MutableLiveData<Boolean> getFinish() {
        return finish;
    }

    public MutableLiveData<String> getAbout() {
        return about;
    }

}
