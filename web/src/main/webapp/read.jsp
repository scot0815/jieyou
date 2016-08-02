<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <%@include file="/WEB-INF/common/ctx.jsp"%>
  <title>读信</title>
  <link rel="stylesheet" type="text/css" href="${ctx}/css/normalize.css" />
  <link rel="stylesheet" type="text/css" href="${ctx}/css/toggle-switch.css" />
  <link rel="stylesheet" type="text/css" href="${ctx}/themes/default.css" />
  <link rel="stylesheet" type="text/css" href="${ctx}/css/page.css" />
</head>
<body>
  <section class="container">
    <article class="content">
      <div id="read_div" class="editor" contenteditable="true">
          ${content}
      </div>
    </article>
  </section>
  
</body>
</html>
