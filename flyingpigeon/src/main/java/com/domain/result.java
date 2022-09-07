package com.domain;
import lombok.Data;

@Data
public class result {
    private boolean b;
    private Object data;

    public result(boolean b) {
        this.b = b;
    }

    public result(Object data) {
        this.data = data;
    }

    public result(boolean b,Object data) {
        this.b = b;
        this.data = data;
    }
}
