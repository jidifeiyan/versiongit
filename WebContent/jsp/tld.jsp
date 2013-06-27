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
<s:hidden id="size" name="size" value="12"/>
<s:set name="start" id="start" value="size"></s:set>
<script type="text/javascript">
var start = $("#size");
</script>
<s:property value="#start"/>
</body>
</html>