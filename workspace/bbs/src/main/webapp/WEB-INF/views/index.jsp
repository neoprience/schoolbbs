<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<meta name="Author" content="文鹏" />
		<meta name="Keywords" content="" />
		<meta name="Description" content="" />
		<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0" />
		<title>宜宾学院校园论坛首页</title>
		<link rel="stylesheet" href="${rPath}/css/tz-page.css">
		<%@include file="/WEB-INF/pages/common/common.jsp" %>
	</head>
	<body>
		<!--header start-->
		<c:import url="/pages/common/header" />
		<!--header end-->
		<!--content start-->
		<div id="content">
			<!--content left start-->
			<div class="left">
				<div class="content"></div>
				<div class="cpage" style="overflow: auto;text-shadow: none;"></div>
			</div>
			<!--content left end-->
			<!--content right start-->
			<%@include file="/WEB-INF/pages/common/right.jsp" %>
			<!--content right end-->
		</div>
		<c:import url="/pages/common/bottom" />
		
		
		<script>
			clock.init("canvas_timer");
			
			
			var content = {
				initPage:function(itemCount){
					$(".cpage").tzPage(itemCount, {
						num_edge_entries : 1, //边缘页数
						num_display_entries : 4, //主体页数
						num_edge_entries : 5,
						current_page : 0,
						showGo : true,
						showSelect : true,
						items_per_page : 10, //每页显示X项
						prev_text : "前一页",
						next_text : "后一页",
						callback : function(pageNo, psize) { //回调函数
							content.loadData(pageNo, psize);
						}
					});
				},
				loadData:function(pageNo, pageSize, callback){
					var keyword = $("#keywords").val();
					$.ajax({
						type:"post",
						url:basePath+"/template",
						data:{
							pageNo : pageNo * pageSize,
							pageSize : pageSize,
							keyword : keyword
						},
						success : function(data) {
							var $data = $(data);
							$(".content").html($data);
							var itemCount = $data.find("#itemCount").val();
							if (callback) callback(itemCount);
						}
					});
				},
				search:function(){
					content.loadData(0, 10, function(itemCount) {
						content.initPage(itemCount); //分页加载一次吗
					});
				}
			}
			content.loadData(0,10,function(itemCount){
				content.initPage(itemCount);
			});
			$(function(){
				$("#backTop").click(function(){
					$("html,body").animate({
						scrollTop:0
					},1000)
				});
				$(window).scroll(function(){
					if($(window).scrollTop() >= 200) {
						$("#backTop").fadeIn(700);
					}else{
						$("#backTop").stop(true,true).fadeOut(1000); // 如果小于等于 200 淡出
					}
				});
			});
		</script>
	</body>
</html>
