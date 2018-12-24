package com.discover.rewards.loadtest.balance;

import com.discover.rewards.loadtest.Command;
import com.discover.rewards.loadtest.Result;
import com.discover.rewards.loadtest.ResultAggregator;

/**
 * Created by tito on 12/24/18.
 */
public class CommandBalance implements Command {
    private Result result;
    private ResultAggregator ra;

    public CommandBalance(ResultAggregator r){
        result = new Result();
        result.setCreationTime(System.currentTimeMillis());
        ra = r;
    }

    @Override
    public void prepare() {
        //TODO prepare request xml
        result.setRequest(""); //TODO set request value
    }

    private void execute() {
        result.setReqStartTime(System.currentTimeMillis());

        //TODO Make the HTTP Call here..

        result.setReqEndTime(System.currentTimeMillis());
        ra.notify(result);
    }

    @Override
    public void validate() {

    }

    @Override
    public void run() {
        execute();
    }
}
