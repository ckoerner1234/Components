<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title><tiles:getAsString name="pageTitle"/></title>
<style type="text/css">@import url(css/main.css);</style>
</head>
<body>
<tiles: insertAttribute name="header"/>
<tiles: insertAttribute name="body"/>
<tiles: insertAttribute name="footer"/>
</body>
</html>