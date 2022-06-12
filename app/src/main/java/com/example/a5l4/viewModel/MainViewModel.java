package com.example.a5l4.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.a5l4.network.LoveModel;
import com.example.a5l4.repository.Repository;

public class MainViewModel extends ViewModel {
    Repository repository = new Repository();

    public LiveData<LoveModel>getLoveModelLiveData(String first, String second){
        return repository.getData(first,second);
    }
}
