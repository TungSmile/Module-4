package com.example.filter;

import com.example.entity.User;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebFilter({"/home.html","/admin/**"})
public class authentication extends HttpFilter {
    public void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws ServletException, IOException {
        HttpSession session=req.getSession();
        User user=(User) session.getAttribute("user");
        if(user.getRole().equals("admin")){
            chain.doFilter(req,res);
        }else res.sendRedirect("redirect:/user");
    }
}
