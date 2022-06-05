package com.example.demo.controllers;

import com.example.demo.dao.LogDAO;
import com.example.demo.models.IpModel;
import com.example.demo.models.LogModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static com.example.demo.dao.LogDAO.fileToList;
import static com.example.demo.download.downloadUsingStream;

@Controller
@RequestMapping("/")
public class LogController {
    private final LogDAO logDAO;
    private List<LogModel> log;
    private List<IpModel> ip;

    public LogController(LogDAO logDAO) {
        this.logDAO = logDAO;
    }

    @RequestMapping()
        public String index(Model model) throws IOException {
            String url = "https://gist.githubusercontent.com/hajda14/8da0b313b0503b0faee7a8d7fe63d9ca/raw/2eb3eb138e8307af00c0c64f20c97e3c802d54a2/testlog";
            String file = "E:/MVC/MVC/src/main/webapp/testLog.txt";
            downloadUsingStream(url, file);
            log = fileToList(file);
            ip =  logDAO.getIpFromLog(log);

            model.addAttribute("list", ip);

            return "log/index";
        }

    @GetMapping(value = "/{id}")
    public String redirectToIndex(Model model, @PathVariable("id") String id) {
        model.addAttribute("list", ip);
        model.addAttribute("output", logDAO.output(id, log));
        return "log/index";
    }
}
