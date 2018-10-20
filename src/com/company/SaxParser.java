package com.company;

import com.company.util.HttpUtil;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

public class SaxParser {
    public static void main(String[] args) {
        String path = "http://api.ithome.com/xml/newslist/news.xml";
        System.out.println(path);
        InputStream inputStream = HttpUtil.getXML(path);
        try{

            List<HashMap<String,String>> list = null;

            SAXParserFactory spf = SAXParserFactory.newInstance();
            SAXParser sp =  spf.newSAXParser();
            XMLGeneralHandler mhandler = new XMLGeneralHandler("item");
            sp.parse(inputStream, mhandler);
            inputStream.close();

            list = mhandler.getList();

            for(HashMap<String,String> p:list){
                System.out.println(p.toString());
            }

        }catch(Exception e){

        }
    }
}
