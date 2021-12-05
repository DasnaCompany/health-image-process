package com.iwmstudio.belight.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class FormActivityViewModel extends ViewModel implements ViewModelProvider.Factory {

    private String pack;
    private final MutableLiveData<Boolean> finish = new MutableLiveData<>(false);

    private final MutableLiveData<String> weight = new MutableLiveData<>();
    private final MutableLiveData<String> height = new MutableLiveData<>();
    private final MutableLiveData<String> arm = new MutableLiveData<>();
    private final MutableLiveData<String> abdomen = new MutableLiveData<>();
    private final MutableLiveData<String> thigh = new MutableLiveData<>();
    private final MutableLiveData<String> neck = new MutableLiveData<>();

    private final MutableLiveData<Boolean> submit = new MutableLiveData<>();

    public FormActivityViewModel(String pack) {
        this.pack = pack;
    }

    public void finish()
    {
        finish.setValue(true);
    }

    public MutableLiveData<Boolean> getFinish() {
        return finish;
    }

    public String getPack() {
        return pack;
    }

    public void submit()
    {
        submit.setValue(true);
    }

    public MutableLiveData<String> getWeight() {
        return weight;
    }

    public MutableLiveData<String> getHeight() {
        return height;
    }

    public MutableLiveData<String> getArm() {
        return arm;
    }

    public MutableLiveData<String> getAbdomen() {
        return abdomen;
    }

    public MutableLiveData<String> getThigh() {
        return thigh;
    }

    public MutableLiveData<String> getNeck() {
        return neck;
    }

    public MutableLiveData<Boolean> getSubmit() {
        return submit;
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        return (T) new FormActivityViewModel(pack);
    }

}