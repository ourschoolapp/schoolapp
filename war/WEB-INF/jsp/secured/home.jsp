<%@ include file="/WEB-INF/jsp/includes/include.jsp" %>

<html>
  <head>
        <title>Spring Security Example</title>
    </head>
    <body>
        <h1>Welcome <sec:authentication property="principal.username" />! </h1>

        <p>Click <a th:href="@{/hello}">here</a> to see a greeting.</p>
    </body>
</html>