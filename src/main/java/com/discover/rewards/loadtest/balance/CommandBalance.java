package com.discover.rewards.loadtest.balance;

import com.discover.rewards.loadtest.Command;
import com.discover.rewards.loadtest.Result;
import com.discover.rewards.loadtest.ResultAggregator;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.FileRequestEntity;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;

import java.io.File;
import java.io.IOException;

/**
 * Created by tito on 12/24/18.
 */
public class CommandBalance implements Command {
    private Result result;
    private ResultAggregator ra;
    private String url = ""; //TODO Fix this..
    private RequestEntity requestEntity = null;


    public CommandBalance(ResultAggregator r){
        result = new Result();
        result.setCreationTime(System.currentTimeMillis());
        ra = r;
    }

    @Override
    public void prepare() {

        File iFile = new File("resources/commandbalance.xml");
        requestEntity = new FileRequestEntity(iFile, "text/xml; charset=ISO-8859-1");
        result.setRequest(requestEntity.toString());

    }

    private void execute() throws IOException{


        PostMethod post = new PostMethod(url);
        post.setRequestEntity(requestEntity);
        post.setRequestHeader("SOAPAction", "");  //TODO Fix this
        HttpClient client = new HttpClient();
        try {

            result.setReqStartTime(System.currentTimeMillis());

            client.executeMethod(post);


            String response = post.getResponseBodyAsString();

            result.setResponse(response);
        }finally {
            post.releaseConnection();
        }

        result.setReqEndTime(System.currentTimeMillis());

        ra.notify(result);
    }

    @Override
    public void validate() {

    }

    @Override
    public void run() {

        try {
            execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

