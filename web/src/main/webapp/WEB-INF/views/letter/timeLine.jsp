<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <%@include file="/WEB-INF/common/ctx.jsp"%>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="images\favicon.png">

    <title>时间轴</title>
    <link href='http\fonts.googleapis.com\MS_5.html' rel='stylesheet' type='text/css'>
    <link href='http\fonts.googleapis.com\MS_3.html' rel='stylesheet' type='text/css'>

    <!-- Bootstrap core CSS -->
    <link href="${ctx}/js/bootstrap/dist/css/bootstrap.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="${ctx}/js/jquery.gritter/css/jquery.gritter.css" />

    <link rel="stylesheet" href="${ctx}/fonts/font-awesome-4/css/font-awesome.min.css">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="http\foxythemes.net\assets\js\MS_6.js"></script>
    <script src="http\foxythemes.net\assets\js\MS_7.js"></script>
    <![endif]-->
    <link rel="stylesheet" type="text/css" href="${ctx}/js/jquery.nanoscroller/nanoscroller.css" />
    <link rel="stylesheet" type="text/css" href="${ctx}/js/jquery.easypiechart/jquery.easy-pie-chart.css" />
    <link rel="stylesheet" type="text/css" href="${ctx}/js/bootstrap.switch/bootstrap-switch.css" />
    <link rel="stylesheet" type="text/css" href="${ctx}/js/bootstrap.datetimepicker/css/bootstrap-datetimepicker.min.css" />
    <link rel="stylesheet" type="text/css" href="${ctx}/js/jquery.select2/select2.css" />
    <link rel="stylesheet" type="text/css" href="${ctx}/js/bootstrap.slider/css/slider.css" />
    <link rel="stylesheet" type="text/css" href="${ctx}/js/jquery.timeline/css/component.css" />
    <!-- Custom styles for this template -->
    <link href="${ctx}/css/style.css" rel="stylesheet" />

    </head>

<body>

<%@include file="/WEB-INF/common/head.jsp"%>

<div id="cl-wrapper" class="fixed-menu">

    <jsp:include page="/WEB-INF/common/left.jsp">
        <jsp:param name="active" value="${active}"/>
    </jsp:include>

<div class="container-fluid" id="pcont">
    <c:if test="${letters[0].letterStatus != 5}">
        <div>
            <c:set var="url" value="${ctx}/letter/writeView?id=${initialId}&isReply=${isReply}"/>
            <c:set var="endUrl" value="${ctx}/letter/letterEnd?initialId=${initialId}"/>
            <c:if test="${!isReply}">
                    <button data-toggle="modal" data-target="#mod-info" type="button" class="btn btn-primary"
                            onclick="javascript:window.location.href='${endUrl}'"
                            style="margin-top:5px;margin-right:10px;float: right">
                        <i class="fa fa-pencil nav-icon"></i> 完结
                    </button>
            </c:if>

            <c:if test="${isReply}">
            <button data-toggle="modal" data-target="#mod-info" type="button" class="btn btn-primary"
                    onclick="javascript:window.location.href='${url}'"
                    style="margin-top:5px;margin-right:10px;float: right">
                <i class="fa fa-pencil nav-icon"></i> 回复
            </button>
        </c:if>
        </div>
    </c:if>
    <div class="cl-mcont">
        <ul class="cbp_tmtimeline">
            <c:forEach var="letter" items="${letters}" varStatus="status">
                <li>
                    <time class="cbp_tmtime" datetime="<fmt:formatDate value="${letter.updateTime}" pattern="yyyy-MM-dd HH:mm"/>">
                        <span><fmt:formatDate value="${letter.updateTime}" pattern="HH:mm"/></span>
                        <span><fmt:formatDate value="${letter.updateTime}" pattern="dd/MM/yy"/></span>
                    </time>
                    <div class="cbp_tmicon cbp_tmicon-phone"></div>
                    <div class="cbp_tmlabel">
                        ${letter.content}
                    </div>
                </li>
            </c:forEach>


        </ul>
    </div>

</div>

</div>


<script src="${ctx}/js/jquery.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery.nanoscroller/jquery.nanoscroller.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery.sparkline/jquery.sparkline.min.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery.easypiechart/jquery.easy-pie-chart.js"></script>
<script src="${ctx}/js/jquery.timeline/js/modernizr.custom.js"></script>
<script type="text/javascript" src="${ctx}/js/behaviour/general.js"></script>
<script src="${ctx}/js/jquery.ui/jquery-ui.js" type="text/javascript"></script>
<script type="text/javascript" src="${ctx}/js/jquery.nestable/jquery.nestable.js"></script>
<script type="text/javascript" src="${ctx}/js/bootstrap.switch/bootstrap-switch.min.js"></script>
<script type="text/javascript" src="${ctx}/js/bootstrap.datetimepicker/js/bootstrap-datetimepicker.min.js"></script>
<script src="${ctx}/js/jquery.select2/select2.min.js" type="text/javascript"></script>
<script src="${ctx}/js/bootstrap.slider/js/bootstrap-slider.js" type="text/javascript"></script>
<script type="text/javascript" src="${ctx}/js/jquery.gritter/js/jquery.gritter.js"></script>

<script type="text/javascript">
    $(document).ready(function(){
        //initialize the javascript
        App.init({
            nanoScroller: false
        });

    });
</script>

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="${ctx}/js/behaviour/voice-commands.js"></script>
<script src="${ctx}/js/bootstrap/dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery.flot/jquery.flot.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery.flot/jquery.flot.pie.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery.flot/jquery.flot.resize.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery.flot/jquery.flot.labels.js"></script>
</body>
</html>
