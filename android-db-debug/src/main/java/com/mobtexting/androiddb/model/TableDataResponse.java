package com.mobtexting.androiddb.model;

import java.util.List;

/**
 * Created by azijul on 9/2/18.
 */

public class TableDataResponse {
    public List<TableInfo> tableInfos;
    public boolean isSuccessful;
    public List<Object> rows;
    public String errorMessage;
    public boolean isEditable;
    public boolean isSelectQuery;

    public static class TableInfo {
        public String title;
        public boolean isPrimary;
    }

    public static class ColumnData {
        public String dataType;
        public Object value;
    }
}
