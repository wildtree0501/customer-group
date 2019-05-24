package com.wildtree.crm.customergroup;
/**
 * @Description:    分群模式
 * @Creater:        wildtree
 * @CreateDate:     2019/5/23 15:18
 * @Author:         
 */
public enum GroupMode {
    SIMPLEMODE("com.wildtree.crm.customergroup.SimpleMode"),
//    NESTINGMODE("")
    ;

    private String mode;
    public String getMode() {
        return mode;
    }
    public void setMode(String mode) {
        this.mode = mode;
    }
    private GroupMode(String mode) {
        this.mode = mode;
    }
}
