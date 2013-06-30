<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="../js/jquery-1.6.2.min.js"></script>
</head>
<body>
	<s:hidden id="size" name="size" value="0" />
	<s:hidden id="pagesize" value="0"/>
	<s:set name="start" id="start" value="size"></s:set>
	<script type="text/javascript">
		//var cnum = "<s:property value='cnum'/>"; //此为当前加载的数据条数
        var cnum = 20;
		var endid = "<s:property value='eid'/>"; //因为微博随时都有可能有新的，所以在此不用一般分页模式请求数据，而且存了当前读取的数据最后一条的ID
        var size = 100;
		$(window).scroll(getmorest); //页面绑定滚动事件

		//add by lj 2011-8-30 加载更早以前的

		function getmorest() {

			var h = $(document.body).height() - $(window).height();
				$("#loadingmore").show();
                var top = $(document).scrollTop();
				if (top > h) {
					var pagesize = $("#pagesize").val();
					$(window).unbind("scroll", getmorest);
					var tbody = "<div>";
                    for(var i=0;i<size;i++){
                    	tbody += "asdfasdfasdfadfasdf==========="+size+"<br>";
                    }
                    tbody += "</div>";
                    $("[name=scroll]:last").after(tbody);
                    $("#pagesize").val(1*pagesize+1);
                    $
                    $(window).scroll(getmorest);
                    $.post('getJsonData',{pagesize:pagesize},function(json){
                    	
                    });
                    
					/* $.post('getData', {
						eid : endid
					}, function(temp) {

						var msg = jQuery.parseJSON(temp);

						if (msg.morest != '') {

							firstli = $("#info");

							var temp;

							for ( var i = 0; i < msg.cnum; i++) {

								firstli.append(msg.morest[i]);

							}

							cnum = msg.cnum;

							endid = msg.eid;

						} else {

							$("#loadingmore").hide();

						}

						if (cnum == 20) {
							$(window).scroll(getmorest)
						}

						else {
							$("#loadingmore").hide();
						}

					}); */

				}
		}
	</script>
	<s:property value="#start" />
	<div id="scroll" name="scroll">
		<%
			for (int i = 0; i < 400; i++) {
		%>
		asdfasf<br>
		<%
			}
		%>
	</div>
	<div id="loadingmore" style="display: none;">loadingmore....</div>
</body>
</html>