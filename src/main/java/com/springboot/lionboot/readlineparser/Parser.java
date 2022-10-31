package com.springboot.lionboot.readlineparser;

public interface Parser<T> {
    T parse(String str);
}
