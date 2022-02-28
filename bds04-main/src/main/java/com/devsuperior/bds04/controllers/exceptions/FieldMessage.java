package com.devsuperior.bds04.controllers.exceptions;

public class FieldMessage {

    private String fieldName;
    private String message;

    public FieldMessage(){}

    public FieldMessage(String field, String message) {
        this.fieldName = field;
        this.message = message;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String field) {
        this.fieldName = field;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
