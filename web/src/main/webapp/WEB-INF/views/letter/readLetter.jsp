<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<!DOCTYPE html>
<html lang="en">
<head>
    <%@include file="/WEB-INF/common/ctx.jsp"%>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="${ctx}/images/favicon.png">

    <title>解忧箱</title>

    <!-- Bootstrap core CSS -->
    <link href="${ctx}/js/bootstrap/dist/css/bootstrap.css" rel="stylesheet" />
    <link rel="stylesheet" href="${ctx}/fonts/font-awesome-4/css/font-awesome.min.css">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.js"></script>
    <![endif]-->
    <link rel="stylesheet" type="text/css" href="${ctx}/js/jquery.gritter/css/jquery.gritter.css" />

    <link rel="stylesheet" type="text/css" href="${ctx}/js/jquery.nanoscroller/nanoscroller.css" />
    <link rel="stylesheet" type="text/css" href="${ctx}/js/jquery.easypiechart/jquery.easy-pie-chart.css" />
    <link rel="stylesheet" type="text/css" href="${ctx}/js/bootstrap.switch/bootstrap-switch.css" />
    <link rel="stylesheet" type="text/css" href="${ctx}/js/bootstrap.datetimepicker/css/bootstrap-datetimepicker.min.css" />
    <link rel="stylesheet" type="text/css" href="${ctx}/js/jquery.select2/select2.css" />
    <link rel="stylesheet" type="text/css" href="${ctx}/js/bootstrap.slider/css/slider.css" />
    <!-- Custom styles for this template -->
    <link href="${ctx}/css/style.css" rel="stylesheet" />
    </head>
<body>

<%@include file="/WEB-INF/common/head.jsp"%>

<div id="cl-wrapper" class="fixed-menu">

    <jsp:include page="/WEB-INF/common/left.jsp">
        <jsp:param name="active" value="${active}"/>
    </jsp:include>

    <form id="replyLetter" action="${ctx}/letter/" method="post">
        <input type="hidden" name="letterType" id="letterType" value="${param.letterType}"/>
        <input type="hidden" name="isInitial" id="isInitial" value="${param.isInitial}"/>
        <input type="hidden" name="isInitial" id="consultId" value="${param.consultId}"/>
        <input type="hidden" name="content" id="content" value=""/>
    </form>

<div class="container-fluid" id="pcont">
    <c:set var="url" value="${ctx}/letter/writeView?id=${letter.id}&isReply=${isReply}"/>
    <div style="float: right">
            <div style="float: left">
                <button  type="button" class="btn btn-primary"
                         onclick="javascript:window.location.href='${url}'" style="margin-top: 5px;">
                    <i class="fa fa-pencil nav-icon"></i> 回复
                </button>
            </div>
            <c:if test="${!isReply}">
                <div style="float: right">
                    <button  type="button" class="btn btn-primary"
                            onclick=""
                            style="margin-top: 5px;position:absolute;">
                        <i class="fa fa-pencil nav-icon"></i> 完结
                    </button>
                </div>
            </c:if>
    </div>

    <jsp:include page="/WEB-INF/views/letter/read.jsp">
        <jsp:param name="content" value="${letter.content}"/>
    </jsp:include>
</div>

    <div style="width: 100px;height: 100px;float:right;" >


    </div>

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
<script src="${ctx}/js/behaviour/voice-commands.js"></script>
<script src="${ctx}/js/bootstrap/dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery.flot/jquery.flot.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery.flot/jquery.flot.pie.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery.flot/jquery.flot.resize.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery.flot/jquery.flot.labels.js"></script>

<script type="text/javascript">
    function send() {
        $("#content").val($("#editor_div").html());
        $("#sendLetter").submit();
    }

</script>

</body>
</html>
