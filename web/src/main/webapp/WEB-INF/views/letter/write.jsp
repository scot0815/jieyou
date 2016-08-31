<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <%@include file="/WEB-INF/common/ctx.jsp"%>
  <title>写信</title>
  <link rel="stylesheet" type="text/css" href="${ctx}/css/normalize.css" />
  <link rel="stylesheet" type="text/css" href="${ctx}/css/toggle-switch.css" />
  <link rel="stylesheet" type="text/css" href="${ctx}/themes/default.css" />
  <link rel="stylesheet" type="text/css" href="${ctx}/css/page.css" />
  <!--[if lt IE 9]>
    <script type="text/javascript" src="${ctx}/scripts/html5shiv.min.js"></script>
  <![endif]-->
  <script type="text/javascript" src="${ctx}/scripts/jquery.min.js"></script>
  <script type="text/javascript" src="${ctx}/scripts/jquery.popline.js"></script>
  <script type="text/javascript" src="${ctx}/scripts/plugins/jquery.popline.link.js"></script>
  <script type="text/javascript" src="${ctx}/scripts/plugins/jquery.popline.blockquote.js"></script>
  <script type="text/javascript" src="${ctx}/scripts/plugins/jquery.popline.decoration.js"></script>
  <script type="text/javascript" src="${ctx}/scripts/plugins/jquery.popline.list.js"></script>
  <script type="text/javascript" src="${ctx}/scripts/plugins/jquery.popline.justify.js"></script>
  <script type="text/javascript" src="${ctx}/scripts/plugins/jquery.popline.blockformat.js"></script>
  <script type="text/javascript" src="${ctx}/scripts/plugins/jquery.popline.social.js"></script>
  <script type="text/javascript" src="${ctx}/scripts/plugins/jquery.popline.backcolor.js"></script>
</head>
<body>
  <section class="container">
    <article class="content">
      <div id="editor_div" class="editor" contenteditable="true">
        <p>您可以直接在下面编辑，也可以在任何地方编辑直接复制到这里。</p>

      </div>
    </article>
  </section>
  
</body>
</html>
