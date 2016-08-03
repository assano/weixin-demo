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
        // ΢�ż���ǩ��
        String signature = request.getParameter("signature");
        // ʱ���
        String timestamp = request.getParameter("timestamp ");
        // �����
        String nonce = request.getParameter("nonce ");
        // ����ַ���
        String echostr = request.getParameter("echostr");

        PrintWriter out = response.getWriter();

        // ͨ������signature���������У�飬��У��ɹ���ԭ������echostr����ʾ����ɹ����������ʧ��
        if (SignUtil.checkSignature(signature, timestamp, nonce)) {

            out.print(echostr);

        }

        out.close();

        out = null;
    }
}
