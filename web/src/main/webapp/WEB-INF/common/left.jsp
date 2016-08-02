<%@ page contentType="text/html;charset=utf-8" %>
<html>
<head>
    <%@include file="/WEB-INF/common/ctx.jsp"%>
    <title></title>

    <script type="text/javascript" src="${ctx}/js/jquery.js"></script>
    <script type="text/javascript">
    $(document).ready(function(){
      var active = "#${param.active}";
      $(active).addClass("active");
    });
    </script>
</head>
<body>
<div class="cl-sidebar" data-position="right" data-step="1" data-intro="<strong>Fixed Sidebar</strong> <br/> It adjust to your needs." >
    <div class="cl-toggle"><i class="fa fa-bars"></i></div>
    <div class="cl-navblock">
        <div class="menu-space">
            <div class="content">
                <ul class="cl-vnavigation">
                    <li><a href="#"><i class="fa fa-home"></i><span>个人信息 </span></a>
                        <ul class="sub-menu">
                            <li id="index_li"><a href="index.html">Version 1</a></li>
                            <li><a href="dashboard2.html"><span class="label label-primary pull-right">New</span> Version 2</a></li>
                        </ul>
                    </li>
                    <li><a href="#"><i class="fa fa-envelope nav-icon"></i><span>我的咨询</span></a>
                        <ul class="sub-menu">
                            <li id="tusu"><a href="${ctx}/letter/tusu">吐诉吧</a></li>
                            <li id="zhdReceive"><a href="${ctx}/letter/zhdReceive">杂货店来信</a></li>
                            <li id="consultTimeLine"><a href="${ctx}/letter/consultTimeLine">咨询时间轴</a></li>
                        </ul>
                    </li>
                    <li><a href="#"><i class="fa fa-smile-o"></i><span>我的回复</span></a>
                        <ul class="sub-menu">
                            <li id="jieyouBox"><a href="${ctx}/letter/boxView">解忧箱</a></li>
                            <li id="replylist"><a href="${ctx}/letter/replyList">您的善意</a></li>
                        </ul>
                    </li>
                    </li>
                </ul>
            </div>
        </div>
        <div class="text-right collapse-button" style="padding:7px 9px;">
            <input type="text" class="form-control search" placeholder="Search..." />
            <button id="sidebar-collapse" class="btn btn-default" style=""><i style="color:#fff;" class="fa fa-angle-left"></i></button>
        </div>
    </div>
</div>


</body>
</html>
