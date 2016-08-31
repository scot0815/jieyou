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

    <title>过往回忆</title>

    <!-- Bootstrap core CSS -->
    <link href="${ctx}/js/bootstrap/dist/css/bootstrap.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="${ctx}/js/jquery.gritter/css/jquery.gritter.css" />
    <link rel="stylesheet" href="${ctx}/fonts/font-awesome-4/css/font-awesome.min.css">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https\oss.maxcdn.com\libs\html5shiv\3.7.0\MS_4.js"></script>
    <![endif]-->
    <link rel="stylesheet" type="text/css" href="${ctx}/js/jquery.nanoscroller/nanoscroller.css" />
    <link rel="stylesheet" type="text/css" href="${ctx}/js/jquery.easypiechart/jquery.easy-pie-chart.css" />
    <link rel="stylesheet" type="text/css" href="${ctx}/js/bootstrap.switch/bootstrap-switch.css" />
    <link rel="stylesheet" type="text/css" href="${ctx}/js/bootstrap.datetimepicker/css/bootstrap-datetimepicker.min.css" />
    <link rel="stylesheet" type="text/css" href="${ctx}/js/jquery.select2/select2.css" />
    <link rel="stylesheet" type="text/css" href="${ctx}/js/bootstrap.slider/css/slider.css" />
    <link rel="stylesheet" type="text/css" href="${ctx}/js/jquery.datatables/bootstrap-adapter/css/datatables.css" />
    <link rel="stylesheet" type="text/css" href="${ctx}/js/jquery.niftymodals/css/component.css" />
    <link href="${ctx}/css/style.css" rel="stylesheet" />

  <body style="overflow-x:hidden">

  <%@include file="/WEB-INF/common/head.jsp"%>

	<div id="cl-wrapper">
        <jsp:include page="/WEB-INF/common/left.jsp">
            <jsp:param name="active" value="consultlist"/>
        </jsp:include>
		<div class="container-fluid" id="pcont">
			<div class="row">
				<div class="col-md-12">
					<div class="block-flat">
						<div class="header">
							<h3>过往回忆</h3>
						</div>
						<div class="content">
							<div class="table-responsive">
								<table class="table table-bordered" id="datatable" >
									<thead>
										<tr>
                                            <th>时间轴</th>
											<th>最初咨询</th>
                                            <th>最后回复</th>
                                            <th>标题</th>
											<th>信件状态</th>
                                            <th>最初咨询时间</th>
                                            <th>最后更新时间</th>
										</tr>
									</thead>
                                    <tbody>
                                        <c:forEach var="letter" items="${letters}" varStatus="status">
                                            <tr class="even gradeA">
                                                <td>
                                                    <a href="${ctx}/letter/timeLine?initialId=${letter.initialId}&isReply=false&active=consultlist">
                                                        ${status.index+1}&nbsp;&nbsp;&nbsp;&nbsp;
                                                    </a>
                                                </td>
                                                <td class="center">
                                                        <pre id="content_${letter.id}" style="display: none" >
                                                            ${letter.content}
                                                        </pre>
                                                        <a class="md-trigger" href="#" data-modal="md-scale" onclick="addContent(${letter.id})"> ${letter.contentIntro}...</a>                                                </td>
                                                <td class="center">
                                                    <pre id="content_max${letter.id}" style="display: none" >
                                                            ${letter.maxContent}
                                                    </pre>
                                                    <a class="md-trigger" href="#" data-modal="md-scale" onclick="addContent('max${letter.id}')">${letter.maxContentIntro}...</a>
                                                </td>
                                                <td>${letter.title}</td>
                                                <td class="center">${letter.letterStatusName}</td>
                                                <td>
                                                    <time>
                                                        <fmt:formatDate value="${letter.createTime}" pattern="yyyy-MM-dd HH:mm"/>
                                                    </time>
                                                </td>
                                                <td>
                                                    <time>
                                                        <fmt:formatDate value="${letter.maxUpdateTime}" pattern="yyyy-MM-dd HH:mm"/>
                                                    </time>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

  <!-- Nifty Modal -->
  <div class="md-modal md-effect-1" id="md-scale">
      <div class="md-content">
          <div class="modal-header">
              <button type="button" class="close md-close" data-dismiss="modal" aria-hidden="true">&times;</button>
          </div>
          <div class="modal-body">
              <div id="letterContent">
                  <div class="i-circle primary"><i class="fa fa-check"></i></div>
                  <h4>Awesome!</h4>
                  <p>Changes has been saved successfully!</p>
              </div>
          </div>
      </div>
  </div>

  <div class="md-overlay"></div>



  <script src="${ctx}/js/jquery.js"></script>
	<script type="text/javascript" src="${ctx}/js/jquery.nanoscroller/jquery.nanoscroller.js"></script>
	<script type="text/javascript" src="${ctx}/js/jquery.sparkline/jquery.sparkline.min.js"></script>
	<script type="text/javascript" src="${ctx}/js/jquery.easypiechart/jquery.easy-pie-chart.js"></script>
	<script src="https/maps.googleapis.com/maps/api/MS_2.html"></script>
	<script type="text/javascript" src="${ctx}/js/behaviour/general.js"></script>
    <script src="${ctx}/js/jquery.ui/jquery-ui.js" type="text/javascript"></script>
	<script type="text/javascript" src="${ctx}/js/jquery.nestable/jquery.nestable.js"></script>
	<script type="text/javascript" src="${ctx}/js/bootstrap.switch/bootstrap-switch.min.js"></script>
	<script type="text/javascript" src="${ctx}/js/bootstrap.datetimepicker/js/bootstrap-datetimepicker.min.js"></script>
    <script src="${ctx}/js/jquery.select2/select2.min.js" type="text/javascript"></script>
    <script src="${ctx}/js/bootstrap.slider/js/bootstrap-slider.js" type="text/javascript"></script>
	<script type="text/javascript" src="${ctx}/js/jquery.gritter/js/jquery.gritter.js"></script>
	<script type="text/javascript" src="${ctx}/js/jquery.datatables/jquery.datatables.min.js"></script>
	<script type="text/javascript" src="${ctx}/js/jquery.datatables/bootstrap-adapter/js/datatables.js"></script>
    <script type="text/javascript" src="${ctx}/js/jquery.niftymodals/js/jquery.modalEffects.js"></script>


    <script type="text/javascript">
        $(document).ready(function(){
            //initialize the javascript
            App.init({
                nanoScroller: false
            });

            App.dashBoard();
            $('.md-trigger').modalEffects();
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

  <script>
      function addContent(id) {
          var sign = "#content_"+id;
          var content = $(sign).html();
          $("#letterContent").html(content);

      }
  </script>
  </body>
</html>
