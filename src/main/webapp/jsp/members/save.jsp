<%-- JAVA 의 import 문 --%>
<%@ page import="hello.servletLec.domain.member.Member" %>
<%@ page import="hello.servletLec.domain.member.MemberRepository" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  // 이곳에 JAVA 코드를 입력할 수 있다.
  // request, response 는 그냥 사용 가능
  MemberRepository memberRepository = MemberRepository.getInstance();

  System.out.println("MemberSaveServlet.service");
  String username = request.getParameter("username");
  int age = Integer.parseInt(request.getParameter("age"));

  Member member = new Member(username, age);
  memberRepository.save(member);
%>
<html>
<head>
  <title>Title</title>
</head>
<body>
성공
<ul>
  <%-- 이 부분에 JAVA 코드를 출력할 수 있다. --%>
  <li>id=<%= member.getId() %></li>
  <li>username=<%= member.getUsername() %></li>
  <li>age=<%= member.getAge() %></li>
</ul>
<a href="/index.html">메인</a>
</body>
</html>