package com.wangyang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import com.wangyang.utils.SignUtil;

/**
 * Created by wy on 2016/8/3.
 */
@Controller
public class CoreController {

    @RequestMapping(value = "/core")
    public void check(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 微信加密签名
        String signature = request.getParameter("signature");
        // 时间戳
        String timestamp = request.getParameter("timestamp ");
        // 随机数
        String nonce = request.getParameter("nonce ");
        // 随机字符串
        String echostr = request.getParameter("echostr");

        PrintWriter out = response.getWriter();

        // 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
        if (SignUtil.checkSignature(signature, timestamp, nonce)) {

            out.print(echostr);

        }

        out.close();

        out = null;
    }
}
