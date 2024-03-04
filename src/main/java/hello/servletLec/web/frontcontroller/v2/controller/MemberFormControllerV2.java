package hello.servletLec.web.frontcontroller.v2.controller;

import hello.servletLec.web.frontcontroller.MyView;
import hello.servletLec.web.frontcontroller.v2.ControllerV2;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MemberFormControllerV2 implements ControllerV2 {
    @Override
    public MyView process(
            HttpServletRequest request
            , HttpServletResponse response) {

        return new MyView("/WEB-INF/views/new-form.jsp");
    }
}
