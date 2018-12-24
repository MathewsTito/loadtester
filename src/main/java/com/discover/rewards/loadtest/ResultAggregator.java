package com.discover.rewards.loadtest;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by tito on 12/24/18.
 */
public class ResultAggregator {

    private Queue<Result> myQ = new LinkedList<>();
    private Object lock = new Object();

    public void notify(Result r){
        synchronized (lock){
            myQ.add(r);
        }
    }

    public Result getResult(){
        return myQ.poll();
    }
}
