<%@ taglib prefix="s" uri="/struts-tags"%>

<div id="global">
	<h1 class="surveypageheader">List of Students</h1>
	<br>
	<s:form action="deleteAction" method="post">
	<table>

		<tr>
			<th width="14%">First Name</th>
			<th width="15%">Last Name</th>
			<th width="19%">Student ID</th>
			<th width="13%">Address</th>
			<th width="8%">City</th>
			<th width="5%">State</th>
			<th width="8%">Zip Code</th>
			<th width="18%">Email</th>
			<th width="10%">Delete</th>
		</tr>



		<s:iterator value="collectionOfStudents" status="stat">
			<tr class="blue">
				<td width="14%"><s:property value="firstname" /></td>
				<td width="15%"><s:property value="lastname" /></td>
				<td width="9%"><s:property value="studentid" /></td>
				<td width="13%"><s:property value="streetaddress1" /></td>
				<td width="8%"><s:property value="city" /></td>
				<td width="5%"><s:property  value="state" /></td>
				<td width="8%"><s:property  value="zipcode" /></td>
				<td width="18%"><s:property  value="email" /></td>
			    <td width="10%"><s:checkbox name="list_of_deleted_students[%{#stat.index}]" theme="simple"/></td>
			<tr>
		</s:iterator>

	</table>
		<h2> Emergency Contact Information</h2>
<table>
		<tr>
			<th width="20%">Student ID</th>
			<th width="20%">First Name</th>
			<th width="20%">Last Name</th>
			<th width=20%">Phone</th>
			<th width="20%">Email</th>
		</tr>


		<s:iterator value="collectionOfStudents" >
		 <s:iterator value="ecis" >
			<tr class="blue">
				<td width="20%"><s:property value="studentid" /></td>
				<td width="20%"><s:property value="firstname" /></td>
				<td width="20%"><s:property value="lastname" /></td>
				<td width="20%"><s:property value="phone" /></td>
				<td width="20%"><s:property value="email" /></td>			
			<tr>
		 </s:iterator>
		</s:iterator>
</table>

	<br><br>
	<h2> Using the Web Service </h2>
<table>
<th>List of Students from the Web Service</th>
		<s:iterator value="studentlistfromwebservice" status="statusVar">
			<tr class="blue">
				<td ><s:property /></td>
			</tr>
		</s:iterator>

</table>

		<table>
				<tr>
					<td>
						<s:submit id="delete" value="delete"/>
					</td>
					<td><a href="<s:url action='ass5_homepage' />">
							<button type="button">Back to Homepage</button>
					</a></td>
				</tr>
		</table>


	</s:form>

</div>


