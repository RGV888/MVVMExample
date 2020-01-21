package com.example.mvvmexample.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.mvvmexample.Models.Hit;
import com.example.mvvmexample.repository.StoryRepository;

import java.util.List;

public class StoryViewModel extends AndroidViewModel {

    private StoryRepository storyRepository;
    public StoryViewModel(@NonNull Application application) {
        super(application);
        storyRepository=new StoryRepository();
    }

    public LiveData<List<Hit>> getStoryList(){
       return storyRepository.getLiveList();
    }


    public void callApiForStorys(int pageNo){
        storyRepository.callForStoryList(pageNo);
    }

}
