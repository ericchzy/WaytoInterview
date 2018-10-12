package com.company.MultiThreads;

public class Client {
    private Sevice _service;

    public Client(Sevice s) {
        _service = s;
    }

    public void requestService() {
        _service.sayHello();
    }
}
