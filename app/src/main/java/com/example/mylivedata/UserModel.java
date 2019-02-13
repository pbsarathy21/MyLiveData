package com.example.mylivedata;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableField;

public class UserModel extends ViewModel {

    private UserRepository userRepository;

    public MutableLiveData<String> data;
    //public MutableLiveData<Model> modelMutableLiveData;
    public ObservableField<String> textValue = new ObservableField<>("");
    public ObservableField<String> username = new ObservableField<>("");
    public ObservableField<String> password = new ObservableField<>("");


    public UserModel() {
        userRepository = new UserRepository();
        textValue.set("Hello partha");
        data = userRepository.getResponseBodyMutableLiveData();
        //data = modelMutableLiveData.getValue().getTitle();
        //textValue.set(modelMutableLiveData.getValue().getTitle());
    }


    public void showText()
    {
        data.setValue("Bobby");
        data = userRepository.getResponseBodyMutableLiveData();
    }


    public MutableLiveData<String> getData() {
        return data;
    }
}
