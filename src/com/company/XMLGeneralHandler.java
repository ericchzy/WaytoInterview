package com.company;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class XMLGeneralHandler extends DefaultHandler {


    private HashMap<String, String> map = null;
    private List<HashMap<String, String>> list = null;
    private String currentTag = null;
    private String currentValue = null;

    private String nodeName = null;

    public XMLGeneralHandler(String nodeName) {
        this.nodeName = nodeName;
    }


    public List<HashMap<String, String>> getList() {
        return list;
    }

    @Override
    public void startDocument() throws SAXException {
        list = new ArrayList<>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals(nodeName)) {
            map = new HashMap<String, String>();

            if (attributes != null && map != null) {
                for (int i = 0; i < attributes.getLength(); i++) {
                    map.put(attributes.getQName(i), attributes.getValue(i));
                }
            }
        }
        currentTag = qName;

    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {

        if (currentTag != null && map != null) {

            currentValue = new String(ch, start, length);
            if (currentValue != null && !currentValue.trim().equals("") && !currentValue.trim().equals("\n")) {
                map.put(currentTag, currentValue);
            }

        }

        currentTag = null;
        currentValue = null;

    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals(nodeName)) {
            list.add(map);
            map = null;
        }
    }

    @Override
    public void endDocument() throws SAXException {

    }
}
