package com.example.assignmenttdd;

public interface Queue {
    void add(Integer value) throws Exception;

    Integer pop();

    boolean full();

    boolean empty();

    int size();

    Integer front();

    Integer rear();

}
