package com.example.demo.models;

public class LogModel {


    private String id;
    private String date;
    private String time;
    private String INFO;
    private String name;
    private String RID;
    private String vRestLogger;
    private String type;
    private String param;
    private String request;
    private String server;

    public LogModel() {

    }

    public LogModel(String date, String time, String INFO, String name, String RID, String vRestLogger,String id, String type, String param, String request,String server) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.INFO = INFO;
        this.name = name;
        this.RID = RID;
        this.vRestLogger = vRestLogger;
        this.type = type;
        this.param = param;
        this.request = request;
        this.server = server;
    }

    public LogModel(String date, String time, String INFO, String name, String RID, String vRestLogger,String id, String type,String server) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.INFO = INFO;
        this.name = name;
        this.RID = RID;
        this.vRestLogger = vRestLogger;
        this.type = type;
        this.server = server;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getINFO() {
        return INFO;
    }

    public void setINFO(String INFO) {
        this.INFO = INFO;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRID() {
        return RID;
    }

    public void setRID(String RID) {
        this.RID = RID;
    }

    public String getvRestLogger() {
        return vRestLogger;
    }

    public void setvRestLogger(String vRestLogger) {
        this.vRestLogger = vRestLogger;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }
}
