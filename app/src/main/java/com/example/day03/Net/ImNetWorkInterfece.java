package com.example.day03.Net;

public interface ImNetWorkInterfece {
    public <T> void get(String url,ImNetWorkCallback<T> callback);
}
