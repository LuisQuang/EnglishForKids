package com.example.sample_project.viewmode;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class M001MainVM extends ViewModel {
    private Thread th;
    private final MutableLiveData<Integer> timeData = new MutableLiveData<>(0);

    public LiveData<Integer> getTimeData() {
        return timeData;
    }

    public void startCountdown() {
        if (th == null || !th.isAlive()) {
            th = new Thread(() -> {
                for (int i = 10; i >= 0; i--) {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        return;
                    }
//                    Chú ý câu lệnh setValue và postValue
                    timeData.postValue(i);
                }
            });
            th.start();
        }
    }


}
