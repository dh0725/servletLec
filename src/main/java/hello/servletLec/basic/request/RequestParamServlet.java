package hello.servletLec.basic.request;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * 1. 파라미터 전송 기능
 * <a href="http://localhost:8080/request-param?username=hello&age=20">...</a>
 */
@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("RequestParamServlet.service");
        System.out.println();

        System.out.println("전체 파라미터 조회 - START");
        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> System.out.println(paramName + " = " + request.getParameter(paramName)));
        System.out.println("전체 파라미터 조회 - END");

        System.out.println("단일 파라미터 조회 - START");
        String username = request.getParameter("username");
        String age = request.getParameter("age");
        System.out.println("username = " + username);
        System.out.println("age = " + age);
        System.out.println("단일 파라미터 조회 - END");

        System.out.println("이름이 같은 복수개의 파라미터 조회 - START");
        String[] usernames = request.getParameterValues("username");
        for (String name : usernames) {
            System.out.println("name = " + name);
        }
        System.out.println("이름이 같은 복수개의 파라미터 조회 - END");

        response.getWriter().write("ok");
    }
}
