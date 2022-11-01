package com.springboot.lionboot.hospital.readlineparser;

public interface Parser<T> {
    T parse(String str);
}
