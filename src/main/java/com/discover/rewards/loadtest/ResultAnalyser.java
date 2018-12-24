package com.discover.rewards.loadtest;

/**
 * Created by tito on 12/24/18.
 */
public class ResultAnalyser implements Runnable{
    private ResultAggregator ra;
    private ResultComparator rc;

    public ResultAnalyser(ResultAggregator ra, ResultComparator rc){
        this.ra = ra;
        this.rc = rc;
    }


    @Override
    public void run() {
        System.out.println("Starting Result Analyser thread..");
        Result pResult = null;
        while (true){
            Result cResult = ra.getResult();
            if (cResult == null){
                try {
                    Thread.sleep(1000);
                } catch (Throwable t){
                    t.printStackTrace();
                }
            } else  if (rc.compare(cResult,pResult) != 0){
                //TODO Fix this.. what happens when there is a mismatch..
                System.out.println(cResult.getResponse());
            }

            pResult = cResult!=null?cResult:pResult;
        }
    }
}
