package com.example.praktikumsqlite.helper;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.praktikumsqlite.ui.NoteInsertUpdateViewModel;
import com.example.praktikumsqlite.ui.NoteMainViewModel;

public class ViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private static volatile ViewModelFactory INSTANCE;
    private final Application mApplication;
    private ViewModelFactory(Application application) {
        mApplication = application;
    }
    public static ViewModelFactory getInstance(Application
                                                       application) {
        if (INSTANCE == null) {
            synchronized (ViewModelFactory.class) {
                INSTANCE = new ViewModelFactory(application);
            }
        }
        return INSTANCE;
    }
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T>
                                                  modelClass) {
        if
        (modelClass.isAssignableFrom(NoteMainViewModel.class)) {
            return (T) new NoteMainViewModel(mApplication);
        } else if
        (modelClass.isAssignableFrom(NoteInsertUpdateViewModel.class))
        {
            return (T) new
                    NoteInsertUpdateViewModel(mApplication);
        }
        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
    }
}
