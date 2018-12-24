package com.discover.rewards.loadtest;

import com.discover.rewards.loadtest.balance.CommandBalance;
import com.discover.rewards.loadtest.balance.ResultComparatorForBalance;

public class Main {

    public static void main(String args[]){
        ResultComparatorForBalance rcb = new ResultComparatorForBalance();
        ResultAggregator ra = new ResultAggregator();
        ResultAnalyser rz = new ResultAnalyser(ra,rcb);

        Thread resultAnalyserThread = new Thread(rz);
        resultAnalyserThread.start();

        while (true) {
            Command command = new CommandBalance(ra);
            command.prepare();
            Thread t = new Thread(command);
            t.start();
        }

    }
}
