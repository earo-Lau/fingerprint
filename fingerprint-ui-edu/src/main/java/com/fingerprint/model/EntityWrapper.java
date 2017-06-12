package com.fingerprint.model;


import java.io.Serializable;

/**
 * Created by lauearo on 02/06/2017.
 */
public class EntityWrapper<T> implements Serializable {
    private ServerError error;
    private T entity;

    public EntityWrapper(T entity) {
        this.error = null;
        this.entity = entity;
    }

    public EntityWrapper(T entity, String code, String reason) {
        this.error = new ServerError(code, reason);
        this.entity = entity;
    }

    public class ServerError implements Serializable {
        private String code;
        private String reasone;

        public ServerError(String code, String reasone) {
            this.code = code;
            this.reasone = reasone;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getReasone() {
            return reasone;
        }

        public void setReasone(String reasone) {
            this.reasone = reasone;
        }
    }
}
