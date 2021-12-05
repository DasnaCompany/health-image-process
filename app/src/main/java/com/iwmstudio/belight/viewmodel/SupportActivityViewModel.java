package com.iwmstudio.belight.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SupportActivityViewModel extends ViewModel {

    private final MutableLiveData<Boolean> finish = new MutableLiveData<>(false);
    private final MutableLiveData<Integer> callAction = new MutableLiveData<>(0);

    private final MutableLiveData<String> phone = new MutableLiveData<>();
    private final MutableLiveData<String> whatsapp = new MutableLiveData<>();
    private final MutableLiveData<String> telegram = new MutableLiveData<>();

    public void finish()
    {
        finish.setValue(true);
    }

    public void whatsappCall()
    {
        callAction.setValue(1);
    }

    public void telegramCall()
    {
        callAction.setValue(2);
    }

    public MutableLiveData<Boolean> getFinish() {
        return finish;
    }

    public MutableLiveData<String> getPhone() {
        return phone;
    }

    public MutableLiveData<String> getWhatsapp() {
        return whatsapp;
    }

    public MutableLiveData<String> getTelegram() {
        return telegram;
    }

    public MutableLiveData<Integer> getCallAction() {
        return callAction;
    }

}
