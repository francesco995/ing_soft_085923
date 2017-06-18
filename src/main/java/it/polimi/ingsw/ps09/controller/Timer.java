package it.polimi.ingsw.ps09.controller;

/**
 * Created by francesco995 on 18/06/2017.
 */
public class Timer extends Thread {

    private boolean mIsExpired = false;
    private int mTimer;

    public Timer(int timer){
        mTimer = timer;
    }


    public boolean isExpired() {
        return mIsExpired;
    }


    public void run(){

        mIsExpired = false;

        try {
            Thread.sleep(mTimer * 1000);
        } catch (InterruptedException e) {

        }

        mIsExpired = true;

    }




}
