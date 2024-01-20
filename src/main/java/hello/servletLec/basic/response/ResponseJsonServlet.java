package hello.servletLec.basic.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.servletLec.basic.HelloData;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "responseJsonServlet", urlPatterns = "/response-json")
public class ResponseJsonServlet extends HttpServlet {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Content-Type: application/json
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");

        HelloData helloData = new HelloData();
        helloData.setUsername("lim");
        helloData.setAge(20);

        // {"username":"lim", "age":20}
        String result = objectMapper.writeValueAsString(helloData);
        response.getWriter().write(result);

    }
}