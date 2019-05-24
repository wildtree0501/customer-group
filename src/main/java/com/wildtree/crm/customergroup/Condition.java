package com.wildtree.crm.customergroup;

import lombok.Data;
/**
 * @Description:    条件
 * @Creater:        wildtree
 * @CreateDate:     2019/5/23 15:26
 * @Author:
 */
@Data
public class Condition {
    /**
     * 名称
     */
    private String name;
    /**
     * 描述
     */
    private String description;
    /**
     * 表名
     */
    private String tableName;
    /**
     * 字段名
     */
    private String columnName;
    /**
     * 字段类型
     */
    private String columnType;
    /**
     * 关联字段名
     */
    private String joinColumnName;
    /**
     * 类型
     */
    private String type;
    /**
     * 类型内容
     */
    private String typeContent;
    /**
     * 内容
     */
    private String content;
}
