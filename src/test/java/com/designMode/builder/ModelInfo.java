/**
 * Copyright (C), 2018-2019, zenki.ai
 * FileName: ModelInfo
 * Author:   feiyi
 * Date:     2019/1/2 下午2:44
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.designMode.builder;

/**
 * 〈一句话功能简述〉:
 * 〈Builder设计模式〉
 *
 * @author feiyi
 * @create 2019/1/2
 * @since 1.0.0
 */
public class ModelInfo {

    private String id;

    private String comment;

    private Integer index;

    private String schema;

    private String parentLabel;

    private String dbName;

    ModelInfo(String id, String comment, Integer index, String schema, String parentLabel, String dbName){
        this.id = id;
        this.comment = comment;
        this.index = index;
        this.schema = schema;
        this.parentLabel = parentLabel;
        this.dbName = dbName;
    }

    ModelInfo(){}

    public static class Builder{

        private String id;

        private String comment;

        private Integer index;

        private String schema;

        private String parentLabel;

        private String dbName;

        public Builder id(String id){
            this.id = id;
            return this;
        }

        public Builder comment(String comment){
            this.comment = comment;
            return this;
        }

        public Builder index(Integer index){
            this.index =index;
            return this;
        }

        public Builder schema(String schema){
            this.schema = schema;
            return this;
        }

        public Builder parentLabel(String parentLabel){
            this.parentLabel = parentLabel;
            return this;
        }

        public Builder dbName(String dbName){
            this.dbName = dbName;
            return this;
        }

        public ModelInfo build(){
            return new ModelInfo(id, comment, index, schema, parentLabel, dbName);
        }
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }

    public String getParentLabel() {
        return parentLabel;
    }

    public void setParentLabel(String parentLabel) {
        this.parentLabel = parentLabel;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDb_name(String dbName) {
        this.dbName = dbName;
    }
}

