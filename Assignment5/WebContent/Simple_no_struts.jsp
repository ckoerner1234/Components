<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--  Carolyn Koerner  SWE642    -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Simple Notification Page</title>

<link rel="stylesheet" title="default styles" href="general.css"
	media="screen" type="text/css">

</head>
<body class="surveybgcolor" bgcolor="#40FF00">
	<h1 class="surveypageheader">Simple Acknowledgement</h1>

Thank you for filling out the form.
<p>Mean is ${data_bean.mean}.</p>
<p>Standard Deviation is ${data_bean.sd}.</p>


<ul>
<% 
   Object obj = request.getSession().getAttribute("numberOfStudents");
   int numstud = (Integer) obj;
   String[] studentidarray = (String[]) request.getSession().getAttribute("studentids");
    for (int i = 0; i < numstud ; i++) {  %>
        <li> <a href = "ProcessSurveyFormData?studentid2=<%=studentidarray[i]%>"><%= studentidarray[i] %> </a> </li>
<% 
    } 
%>
</ul>


</body>
</html>
