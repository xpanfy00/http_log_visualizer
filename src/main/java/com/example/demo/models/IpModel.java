package com.example.demo.models;

public class IpModel {

        private String ip;
        private String serverName;

        public IpModel() {

        }

        public IpModel(String ip, String serverName) {
            this.serverName= serverName;
            this.ip = ip;
        }

        public String getIp() {
            return ip;
        }

        public void setIp(String ip) {
            this.ip = ip;
        }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }
}
