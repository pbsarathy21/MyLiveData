package com.example.mylivedata;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableField;

public class UserModel extends ViewModel {

    public MutableLiveData<String> data;
    public MutableLiveData<Model> modelMutableLiveData;
    public ObservableField<String> textValue = new ObservableField<>("");
    public ObservableField<String> username = new ObservableField<>("");
    public ObservableField<String> password = new ObservableField<>("");


    public UserModel() {
        UserRepository userRepository = new UserRepository();
        textValue.set("Hello partha");
        modelMutableLiveData = userRepository.getResponseBodyMutableLiveData();
        //data = modelMutableLiveData.getValue().getTitle();
        //textValue.set(modelMutableLiveData.getValue().getTitle());
    }


    public MutableLiveData<String> getData() {
        return data;
    }
}
