<%@ taglib prefix="s" uri="/struts-tags"%>


<div id="global" style="background-color:#E3CEF6">

	<h1 class="surveypageheader">Simple Acknowledgement</h1>

Thank you for filling out the form.
<p>Mean is 
<s:property value="winres.mean"/>.</p>
<p>Standard Deviation is 
<s:property value="winres.sd"/>.</p>

<s:property value="student.firstname"/>
<s:property value="student.lastname"/>
<p><s:property value="greeting"/></p>

</div>
