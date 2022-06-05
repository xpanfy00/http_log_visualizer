package com.example.demo.dao;

import com.example.demo.models.IpModel;
import com.example.demo.models.LogModel;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class LogDAO {

    private List<LogModel> log;
    private List<IpModel> ip;




    public List<LogModel> index() {
        return log;
    }



    public List<IpModel> getIp() {
        return ip;
    }

    public static List<LogModel> fileToList(String path){
        try (BufferedReader bf = new BufferedReader(new FileReader(path))) {
            String line;
            List<LogModel> logModel = new ArrayList<>();
            while ((line = bf.readLine()) != null) {
                String[] split = line.split("\\s+");
                if (split.length == 9) {
                    logModel.add(new LogModel(split[0], split[1], split[2], split[3], split[4], split[5], split[6],
                            split[7], split[8]));
                }else{
                    logModel.add(new LogModel(split[0], split[1], split[2], split[3], split[4], split[5], split[6],
                            split[7], split[8], split[9], split[10]));
                }
            }
            return logModel;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<IpModel> getIpFromLog(List<LogModel> log) {
        List<IpModel> ip = new ArrayList<>();
        List<String> ipList = new ArrayList<>();
        for (LogModel item : log) {
            if (item.getServer().contains("switch") || item.getServer().contains("router")) {
                String[] arr = item.getServer().split("/");
                boolean haveIp = ipList.contains(arr[2]);
                if (!haveIp) {
                    ipList.add(arr[2]);
                    ip.add(new IpModel(arr[2], item.getName()));
                    }
                }
            }
        return ip;
    }

    public LogModel show(String id){
        return log.stream().filter(s -> s.getName().equals(id)).findAny().orElse(null);
    }

    public List<LogModel> sent(List<LogModel> log) {
        List<LogModel> sent = new ArrayList<>();
        for (LogModel item : log) {
            if (item.getType().equals("SENT:")) {
                sent.add(item);
            }
        }
        return sent;
    }

    public List<LogModel> received(List<LogModel> log) {
            List<LogModel> received = new ArrayList<>();
            for (LogModel item : log) {
                if (item.getType().equals("RECEIVED:")) {
                    received.add(item);
                }
            }
            return received;
        }
    public List<String> output(String id, List<LogModel> log) {
        List<LogModel> sent = sent(log);
        List<LogModel> received = received(log);
        List<String> output = new ArrayList<>();
        for (int i = 0; i < sent.size() && i < received.size(); i++) {
            String[] arr = sent.get(i).getServer().split("/");
            if (sent.get(i).getId().equals(received.get(i).getId()) && arr[2].equals(id)){
                output.add(sent.get(i).getType() + " id = " + sent.get(i).getId() + " " +
                        sent.get(i).getParam() + " " + sent.get(i).getRequest() + " " + "/" + arr[3] + "/" + arr[4] +
                        "      " + received.get(i).getType() + " id = " + received.get(i).getId() + "  "  + received.get(i).getServer());
            }
        }
        return output;
    }





}
