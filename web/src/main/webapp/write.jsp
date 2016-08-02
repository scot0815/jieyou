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
        <p>下面提供一些简单的格式，您可以直接在下面编辑，</p>
        <p>也可以在任何地方编辑直接复制到这里.</p>
        <p><a href="https://github.com/kenshin54/popline">Popline</a> is a non-intrusive <font color="#00ae52">WYSIWYG</font> editor.</p>
        <p>It shows up only after selecting a piece of text on the page.</p>
        <p>Inspired by <a href="http://pilotmoon.com/popclip/" target="_blank">popclip</a>.</p>
        <p>It provides commonly used editing features <b>out-of-the-box</b>.</p>
        <blockquote>Easy to extend, Easy to customize.</blockquote>
        <p>Two modes supported, <i>Edit mode</i> and <i>View mode</i>.</p>
        <p>Two popup ways supported, <u>Fixed</u> and <u>Relative</u>.</p>
        <p>
          The default theme popline used is designed by <a target="_blank" href="https://twitter.com/PepsinY">@Pepsin</a>, Thanks.
        </p>
        <p style="text-align: right;">happy to you <i class="fa fa-smile-o"></i></p>
        <p style="text-align: right;"><a>@XXX</a></p>
      </div>
    </article>
  </section>
  
</body>
</html>
