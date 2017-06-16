/**
 * Created by Hanjun Chen on 6/15/17.
 */
package com.dylanhelps.fxpress;

import yahoofinance.YahooFinance;
import yahoofinance.quotes.fx.FxQuote;
import java.io.IOException;

public class ExchangeRate {

    private final String TAG = this.getClass().getName();
    private String quote=" ";
    private String from,to;

    public  ExchangeRate(String from, String to){
        this.from = from;
        this.to = to;
    }


    public void findExchangeRate(){
        String URL = "http://download.finance.yahoo.com/d/quotes.csv?f=l1&s"+from+to+"=x";

        try {
            FxQuote quote = YahooFinance.getFx(from+to+"=X");
            this.quote= quote.toString();

        } catch (IOException e) {
            System.err.println(TAG+e.getMessage());
            quote= "Can't open "+URL;
        }

    }

    public String extractRate (){
        String res= quote;

        if (res.startsWith("Can't open") || res.trim().equals(""))
            return res;

        String[] lines = res.split("\\r?\\n");


        for (String s: lines){
            if (s.startsWith(from+to+"=X:"))
                quote = s;
        }

        return quote.substring(quote.indexOf("=X:")+4,quote.length());
    }
}

