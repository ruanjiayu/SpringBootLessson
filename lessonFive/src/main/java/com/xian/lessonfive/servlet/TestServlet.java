package com.xian.lessonfive.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Description:
 * @Author: Xian
 * @CreateDate: 2019/9/9  9:48
 * @Version: 0.0.1-SHAPSHOT
 */
public class TestServlet extends HttpServlet {

    /**
     * 重写get方法
     *
     * @param req 请求
     * @param resp 响应
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("我进入了doGet方法内!!!!");
        // 设置返回类型
        resp.setContentType("application/json");
        // 设置返回字符集
        resp.setCharacterEncoding("utf-8");
        // 输出对象
        PrintWriter writer = resp.getWriter();
        // 输出的信息
        writer.write("执行TestServlet内的doGet方法成功!!!");
        writer.close();
    }
}
