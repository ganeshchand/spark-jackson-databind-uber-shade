package com.databricks.support.java.jackson.databind.module;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;

public class CantChangeThis {
    static {
        System.out.println(PropertyNamingStrategy.UPPER_CAMEL_CASE);
    }

    public final String value = "Hello World";
}

