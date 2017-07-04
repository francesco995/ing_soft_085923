package it.polimi.ingsw.ps09.controller;

import it.polimi.ingsw.ps09.model.Player;

import java.util.logging.Logger;

import static java.util.logging.Level.INFO;

/**
 * Created by francesco995 on 18/06/2017.
 */
public class Timer extends Thread {

    private boolean mIsExpired = false;
    private int mTimer;
    private boolean mIsRunning = false;

    private static final Logger mLogger = Logger.getAnonymousLogger();


    public Timer(int timer){
        mTimer = timer;
    }


    public boolean isExpired() {
        return mIsExpired;
    }

    public boolean isRunning(){
        return mIsRunning;
    }

    public void startTimer(){

        mLogger.log(INFO, "Server: Starting timer... + (" + mTimer + ") seconds.");

        mIsRunning = true;
        mIsExpired = false;

        this.start();
    }


    public void run(){

        mIsExpired = false;

        for(int i = mTimer; i > 0; i--){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                mLogger.log(INFO, "Server: Timer interrupted");
                i=0;
                mIsExpired = false;
                mIsRunning = false;

            }

            if(i==0){
                mLogger.log(INFO, "Server: Timer expired!!!");
            }
            else{
                mLogger.log(INFO, "Server: Timer running, -" + i);
            }

        }

        mIsRunning = false;
        mIsExpired = true;

    }




}
