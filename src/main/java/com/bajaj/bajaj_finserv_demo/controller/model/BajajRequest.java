package com.bajaj.bajaj_finserv_demo.controller.model;

import lombok.Data;

import java.util.List;

public class BajajRequest {

    private List<String> data;

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }
}
