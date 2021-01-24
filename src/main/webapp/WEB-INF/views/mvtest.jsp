<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>


ModelandView와 jstl 테스트페이지입니다
<br>

${objecttest}
<br>
${listTest}
<br>
<c:forEach var="listTest" items="${listTest}">
    ${listTest} <br>
</c:forEach>
