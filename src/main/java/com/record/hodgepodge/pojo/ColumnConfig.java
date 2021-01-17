package com.record.hodgepodge.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("T_COLUMN_CONFIG")
public class ColumnConfig {

    /**
     * 主键id
     */
    @TableId("ID")
    private String id;

    /**
     * 对应的excel列序号
     */
    @TableField("CELL_INDEX")
    private String cellIndex;

    /**
     * 对应的excel列标题
     */
    @TableField("COLUMN_NAME")
    private String columnName;

    /**
     * 对应的java字段名
     */
    @TableField("JAVA_NAME")
    private String javaName;

    /**
     * 对应java字段的数据类型
     */
    @TableField("JAVA_TYPE")
    private String javaType;

    /**
     * 模板id
     */
    @TableField("TEMPLATE_ID")
    private String templateId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCellIndex() {
        return cellIndex;
    }

    public void setCellIndex(String cellIndex) {
        this.cellIndex = cellIndex;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getJavaName() {
        return javaName;
    }

    public void setJavaName(String javaName) {
        this.javaName = javaName;
    }

    public String getJavaType() {
        return javaType;
    }

    public void setJavaType(String javaType) {
        this.javaType = javaType;
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    @Override
    public String toString() {
        return "ColumnConfig{" +
                "id='" + id + '\'' +
                ", cellIndex='" + cellIndex + '\'' +
                ", columnName='" + columnName + '\'' +
                ", javaName='" + javaName + '\'' +
                ", javaType='" + javaType + '\'' +
                ", templateId='" + templateId + '\'' +
                '}';
    }
}
