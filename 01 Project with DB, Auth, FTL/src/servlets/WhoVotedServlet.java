package com.example.votingsystem2.servlets;

import com.example.votingsystem2.FreemarkerConfigSingleton;
import com.example.votingsystem2.dao.impl.UserDAOImpl;
import com.example.votingsystem2.models.User;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WhoVotedServlet extends HttpServlet {
    public void init() {
        FreemarkerConfigSingleton.setServletContext(this.getServletContext());
    }
    public void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            Template tmpl = FreemarkerConfigSingleton.getCfg().getTemplate("who_voted.ftl");
            List<User> users = (new UserDAOImpl()).getAll();
            HashMap<String, Object> root = new HashMap<>();
            root.put("users", users);
            resp.setContentType("text/html");
            tmpl.process(root, resp.getWriter());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (TemplateException e) {
            throw new RuntimeException(e);
        }
    }
}
