
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/WEB-INF/common/ctx.jsp"%>
    <title>解忧箱</title>
    <!-- Bootstrap core CSS -->
    <link href="${ctx}/js/bootstrap/dist/css/bootstrap.css" rel="stylesheet" />
    <link rel="stylesheet" href="${ctx}/fonts/font-awesome-4/css/font-awesome.min.css">
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.js"></script>
    <![endif]-->

    <link rel="stylesheet" type="text/css" href="${ctx}/js/jquery.nanoscroller/nanoscroller.css" />
    <!-- Custom styles for this template -->
    <link href="${ctx}/css/style.css" rel="stylesheet" />

</head>
<body>

<%@include file="/WEB-INF/common/head.jsp"%>

<div id="cl-wrapper" class="fixed-menu">

    <jsp:include page="/WEB-INF/common/left.jsp">
        <jsp:param name="active" value="jieyouBox"/>
    </jsp:include>


    <button data-toggle="modal" data-target="#mod-info" type="button" class="btn btn-primary"
            onclick="javascript:window.location.href='${ctx}/letter/extractLetter'"
            style="margin-top: 5px;margin-right: 5px; float:right;">
        <i class="fa fa-envelope nav-icon"></i> 来帮助别人吧
    </button>



</div>

<script type="text/javascript" src="${ctx}/js/jquery.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery.gritter/js/jquery.gritter.js"></script>

<script type="text/javascript" src="${ctx}/js/jquery.nanoscroller/jquery.nanoscroller.js"></script>
<script type="text/javascript" src="${ctx}/js/behaviour/general.js"></script>
<script src="${ctx}/js/jquery.ui/jquery-ui.js" type="text/javascript"></script>
<script type="text/javascript" src="${ctx}/js/jquery.sparkline/jquery.sparkline.min.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery.easypiechart/jquery.easy-pie-chart.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery.nestable/jquery.nestable.js"></script>
<script type="text/javascript" src="${ctx}/js/bootstrap.switch/bootstrap-switch.min.js"></script>
<script type="text/javascript" src="${ctx}/js/bootstrap.datetimepicker/js/bootstrap-datetimepicker.min.js"></script>
<script src="${ctx}/js/jquery.select2/select2.min.js" type="text/javascript"></script>
<script src="${ctx}/js/skycons/skycons.js" type="text/javascript"></script>
<script src="${ctx}/js/bootstrap.slider/js/bootstrap-slider.js" type="text/javascript"></script>



<!-- Bootstrap core JavaScript
  ================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script type="text/javascript">
    $(document).ready(function(){
        //initialize the javascript
        App.init({
            nanoScroller: false
        });

        App.dashBoard();

    });
</script>
<script src="${ctx}/js/bootstrap/dist/js/bootstrap.min.js"></script>

</body>
</html>
