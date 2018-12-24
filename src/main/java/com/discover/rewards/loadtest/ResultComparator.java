package com.discover.rewards.loadtest;

/**
 * Created by tito on 12/24/18.
 */
public abstract class ResultComparator {
    public abstract int compare(Result r1, Result r2) throws LoadTesterException ;
}
