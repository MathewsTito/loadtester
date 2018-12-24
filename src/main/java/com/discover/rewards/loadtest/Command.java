package com.discover.rewards.loadtest;

/**
 * Created by tito on 12/24/18.
 */
public interface Command  extends Runnable{
    public void prepare();
    public void validate();
}
