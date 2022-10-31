package com.springboot.lionboot.pratice.readlineparser;

public interface Parser<T> {
    T parse(String str);
}
