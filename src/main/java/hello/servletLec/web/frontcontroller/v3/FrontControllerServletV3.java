package hello.servletLec.web.frontcontroller.v3;

import hello.servletLec.web.frontcontroller.ModelView;
import hello.servletLec.web.frontcontroller.MyView;
import hello.servletLec.web.frontcontroller.v3.controller.MemberFormControllerV3;
import hello.servletLec.web.frontcontroller.v3.controller.MemberListControllerV3;
import hello.servletLec.web.frontcontroller.v3.controller.MemberSaveControllerV3;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServletV3", urlPatterns = "/front-controller/v3/*")
public class FrontControllerServletV3 extends HttpServlet {

    private Map<String, ControllerV3> controllerV3Map = new HashMap<>();

    public FrontControllerServletV3() {
        controllerV3Map.put("/front-controller/v3/members/new-form", new MemberFormControllerV3());
        controllerV3Map.put("/front-controller/v3/members/save", new MemberSaveControllerV3());
        controllerV3Map.put("/front-controller/v3/members", new MemberListControllerV3());
    }

    @Override
    public void service(
            HttpServletRequest request
            , HttpServletResponse response) throws ServletException, IOException {
        System.out.println("FrontControllerServletV3.service");

        // front-controller/v3/members
        String requestURI = request.getRequestURI();

        ControllerV3 controllerV3 = controllerV3Map.get(requestURI);
        if (controllerV3 == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);

            return ;
        }

        HashMap<String, String> paramMap = createParamMap(request);
        ModelView modelView = controllerV3.process(paramMap);

        String viewName = modelView.getViewName();
        MyView view = viewResolver(viewName);
        view.render(modelView.getModel(), request, response);
    }

    private static MyView viewResolver(String viewName) {
        return new MyView("/WEB-INF/views/" + viewName + ".jsp");
    }

    private static HashMap<String, String> createParamMap(HttpServletRequest request) {
        HashMap<String, String> paramMap = new HashMap<>();
        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName)));
        return paramMap;
    }
}
