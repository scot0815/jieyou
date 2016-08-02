<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <%@include file="/WEB-INF/common/ctx.jsp"%>
  <title>读信</title>
  <link rel="stylesheet" type="text/css" href="${ctx}/css/toggle-switch.css" />
  <link rel="stylesheet" type="text/css" href="${ctx}/themes/default.css" />
  <link rel="stylesheet" type="text/css" href="${ctx}/css/page.css" />
</head>
<body>
  <section class="container">
    <article class="content">
          ${param.content}
    </article>
  </section>
  
</body>
</html>
