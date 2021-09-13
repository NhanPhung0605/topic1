package com.fpt.test.topic1.constant;

/**
 * @author : Admin
 * @created : 13-Aug-21
 **/
public class EnumConstant {
    public enum fieldType {
        NUMBER(1, "Number"),
        BOOLEAN(2, "Boolean");

        fieldType(Integer code, String bool) {
            this.code = code;
            this.value = bool;
        }

        private Integer code;
        private String value;

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public static fieldType getEnumFieldTypeByType(Integer code) {
            for (fieldType fieldType : fieldType.values()) {
                if (fieldType.code.equals(code)) {
                    return fieldType;
                }
            }
            return null;
        }
    }
}



