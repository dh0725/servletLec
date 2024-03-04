package hello.servletLec.web.frontcontroller.v2.controller;

import hello.servletLec.domain.member.Member;
import hello.servletLec.domain.member.MemberRepository;
import hello.servletLec.web.frontcontroller.MyView;
import hello.servletLec.web.frontcontroller.v2.ControllerV2;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;

public class MemberListControllerV2 implements ControllerV2 {
    private final MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public MyView process(
            HttpServletRequest request
            , HttpServletResponse response) {
        List<Member> members = memberRepository.findAll();

        request.setAttribute("members", members);

        return new MyView("/WEB-INF/views/members.jsp");
    }
}
