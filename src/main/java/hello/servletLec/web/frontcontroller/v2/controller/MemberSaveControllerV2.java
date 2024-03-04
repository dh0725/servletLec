package hello.servletLec.web.frontcontroller.v2.controller;

import hello.servletLec.domain.member.Member;
import hello.servletLec.domain.member.MemberRepository;
import hello.servletLec.web.frontcontroller.MyView;
import hello.servletLec.web.frontcontroller.v2.ControllerV2;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MemberSaveControllerV2 implements ControllerV2 {
    private final MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public MyView process(
            HttpServletRequest request
            , HttpServletResponse response) {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        Member member = new Member(username, age);
        memberRepository.save(member);

        // Model 에 데이터를 보관한다.
        request.setAttribute("member", member);

        return new MyView("/WEB-INF/views/save-result.jsp");
    }
}
