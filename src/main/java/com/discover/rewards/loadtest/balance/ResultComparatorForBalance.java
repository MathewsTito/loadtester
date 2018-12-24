package com.discover.rewards.loadtest.balance;

import com.discover.rewards.loadtest.LoadTesterException;
import com.discover.rewards.loadtest.Result;
import com.discover.rewards.loadtest.ResultComparator;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;

public class ResultComparatorForBalance extends ResultComparator{

    DocumentBuilder builder = null;

    public ResultComparatorForBalance(){
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            builder = factory.newDocumentBuilder();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }


    public int compare(Result r1, Result r2) throws LoadTesterException {

        Document doc1 = parse(r1.getResponse());
        Document doc2 = parse(r2.getResponse());

        String bal1 = extractBalance(doc1);
        String bal2 = extractBalance(doc2);

        return bal1.compareTo(bal2);

    }

    private Document parse (String s) throws LoadTesterException{
        try {
            synchronized (builder) {
                ByteArrayInputStream input = new ByteArrayInputStream(s.getBytes("UTF-8"));
                Document doc = builder.parse(input);
                return doc;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new LoadTesterException();
        }
    }

    private String extractBalance (Document doc){
        //TODO Fix this...

        return "";
    }
}
