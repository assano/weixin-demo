package com.wangyang.controller;

import com.wangyang.service.CoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import com.wangyang.utils.SignUtil;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by wy on 2016/8/3.
 */
@Controller
public class CoreController {

    @Autowired
    private CoreService coreService;

    @RequestMapping(value = "/core", method = RequestMethod.GET)
    public void check(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 微信加密签名
        String signature = request.getParameter("signature");
        // 时间戳
        String timestamp = request.getParameter("timestamp");
        // 随机数
        String nonce = request.getParameter("nonce");
        // 随机字符串
        String echostr = request.getParameter("echostr");

        System.out.println("========from weixin server===== echostr:" + echostr + " signature:" + signature + " timestamp" + timestamp
                + " nonce" + nonce);

        PrintWriter out = response.getWriter();

        // 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
        if (SignUtil.checkSignature(signature, timestamp, nonce)) {

            out.print(echostr);

        }

        out.close();

        out = null;
    }

    @RequestMapping(value = "/core", method = RequestMethod.POST)
    public void process(HttpServletRequest request, HttpServletResponse response) throws IOException {

        // 将请求、响应的编码均设置为UTF-8（防止中文乱码）
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        // 调用核心业务类接收消息、处理消息
        String respMessage = coreService.processRequest(request);

        // 响应消息
        PrintWriter out = response.getWriter();
        out.print(respMessage);
        out.close();
    }


}
