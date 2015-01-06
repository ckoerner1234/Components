<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">

<link rel="stylesheet" title="default styles" href="jquery-ui.css"
	media="screen" type="text/css">
<link rel="stylesheet" title="default styles" href="jquery-ui.min.css"
	media="screen" type="text/css">
<link rel="stylesheet" title="default styles" href="jquery.ui.theme.css"
	media="screen" type="text/css">
<link rel="stylesheet" title="default styles" href="general.css"
	media="screen" type="text/css">


<title>Student Information Page</title>
</head>

<body class="surveybgcolor" bgcolor="#00CCCC">
	<h1 class="surveypageheader">Student Data</h1>

	<table class="one">
		<thead>
			<th colspan="2"><strong> Name</strong></th>
		</thead>
		<tbody>
			<tr>
				<td>First Name:</td>
			</tr>
			<tr>
				<td><input id="firstName" type="text" size=50 name="firstname"  readonly
					value=${hyperlink_bean.firstName}></td>
			</tr>
			<tr>
				<td>Last Name:</td>
			</tr>
			<tr>
				<td><input id="lastName" type="text" size=50 name="lastname"  readonly
					value=${hyperlink_bean.lastName}></td>
			</tr>
			<tr>
				<td>Student ID:</td>
			</tr>
			<tr>
				<td><input id="studentid" type="text" size=50 name="studentid"  readonly
					value=${hyperlink_bean.studentid}></td>
			</tr>
	</table>


	<table class="two">
		<thead>
			<th colspan="2"><strong> Address</strong></th>
		</thead>
		<tbody>
			<tr>
				<td>Street Address 1:</td>
			</tr>
			<tr>
				<td><input id="address1" type="text" size=50
					name="streetaddress1" readonly value="${hyperlink_bean.address1}" >
				</td>
			</tr>
			<tr>
				<td>Street Address 2:</td>
			</tr>
			<tr>
				<td><input id="address2" type="text" name="streetaddress2"
					size=50 readonly value="${hyperlink_bean.address2}"></td>
			</tr>
			<tr>
				<td>City:</td>
			<tr>
				<td><input type="text" id="city" size=50 name="city"
					value=${hyperlink_bean.city}  readonly></td>
			</tr>
			<tr>
				<td>State:</td>
			</tr>
			<tr>
				<td><input type="text" id="state" size=50 name="state"
					value=${hyperlink_bean.state} readonly></td>
			</tr>
			<tr>
				<td>Zip Code:</td>
			</tr>
			<tr>
				<td><input id="zipcode" type="text" size=50 name="zipcode"  readonly
					value=${hyperlink_bean.zipcode}></td>
			</tr>
	</table>


	<table class="three">
		<thead>
			<th colspan="2"><strong> Contact Info</strong></th>
		</thead>
		<tbody>
			<tr>
				<td>Phone:</td>
			</tr>
			<tr>
				<td><input id="phone" type="text" size=50  readonly value=${hyperlink_bean.phone}></td> 
			</tr>
			<tr>
				<td>Email:</td>
			</tr>
			<tr>
				<td><input id="email" type="text" size=50 name="email" readonly value=${hyperlink_bean.email}></td>
			</tr>
			<tr>
				<td>URL:</td>
			</tr>
			<tr>
				<td><input type="text" size=50 name="url" readonly value=${hyperlink_bean.url}></td>
			</tr>
	</table>
	<br>
	<br>
	<br>
	<br>
</body>
</html>