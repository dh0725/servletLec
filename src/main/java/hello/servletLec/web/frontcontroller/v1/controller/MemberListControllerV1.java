package hello.servletLec.web.frontcontroller.v1.controller;

import hello.servletLec.domain.member.Member;
import hello.servletLec.domain.member.MemberRepository;
import hello.servletLec.web.frontcontroller.v1.ControllerV1;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class MemberListControllerV1 implements ControllerV1 {
    private final MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public void process(
            HttpServletRequest request
            , HttpServletResponse response) throws ServletException, IOException {
        List<Member> members = memberRepository.findAll();

        request.setAttribute("members", members);

        String viewPath = "/WEB-INF/views/members.jsp";
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(viewPath);
        requestDispatcher.forward(request, response);

    }
}
