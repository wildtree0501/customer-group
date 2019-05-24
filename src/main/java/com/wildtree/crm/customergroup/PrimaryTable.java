package com.wildtree.crm.customergroup;

/**
 * 分群主表
 */
public enum PrimaryTable {
    CUSTOMER("customer_base", "id"),
    ;

    private String primaryTableName;
    private String primaryKey;
    public String getPrimaryTableName() {
        return primaryTableName;
    }
    public String getPrimaryKey() {
        return primaryKey;
    }
    public void setPrimaryKey(String primaryKey) {
        this.primaryKey = primaryKey;
    }
    public void setPrimaryTableName(String primaryTableName) {
        this.primaryTableName = primaryTableName;
    }
    private PrimaryTable(String primaryTableName, String primaryKey) {
        this.primaryTableName = primaryTableName;
        this.primaryKey = primaryKey;
    }
}
