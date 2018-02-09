package com.mobtexting.androiddb.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by azijul on 9/2/18.
 */

public class NetWorkResponse {
    public List<Object> rows = new ArrayList<>();
    public List<String> columns = new ArrayList<>();
    public boolean isSuccessful;
    public String error;
    public int dbVersion;

    public NetWorkResponse() {

    }
}
