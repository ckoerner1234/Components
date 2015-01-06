<%@ taglib prefix="s" uri="/struts-tags"%>

<div id="global" style="background-color:#E3CEF6">

	<h1 class="surveypageheader">Winner Acknowledgement</h1>

Congratulations!!  You are a raffle winner of two movie tickets!!!  
<br>

Thank you for filling out the form.
<br>
<p>Mean is 
<s:property value="winres.mean"/>.</p>
<p>Standard Deviation is 
<s:property value="winres.sd"/>.</p>

<p><s:property value="greeting"/></p>

<s:property value="student.firstname"/>
<s:property value="student.lastname"/>

</div>
