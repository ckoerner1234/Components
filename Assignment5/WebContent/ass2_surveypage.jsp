<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Student Survey Page</title>

<script src="jquery.js"></script>
<script src="jquery-ui.js"></script>


<link rel="stylesheet" title="default styles" href="jquery-ui.css"
	media="screen" type="text/css">
<link rel="stylesheet" title="default styles" href="jquery-ui.min.css"
	media="screen" type="text/css">
<link rel="stylesheet" title="default styles" href="jquery.ui.theme.css"
	media="screen" type="text/css">
<link rel="stylesheet" title="default styles" href="general.css"
	media="screen" type="text/css">
	
<script src="surveypagejavascript.js"> </script>
<script src="check_survey_page.js"> </script>

</head>

<body class="surveybgcolor" bgcolor="#00CCCC">
	<h1 class="surveypageheader">Student Data</h1>
	<s:form action="ProcessSurveyFormData" method="post" id="surveyform" autocomplete="on" class="basicinfo" >
		<table class="one">
			<thead>
				<th colspan="2"><strong> Name</strong></th>
			</thead>
			<tbody>
				<tr>
					<s:textfield name="firstname" id="firstname" label="First Name" size="50"
						labelposition="top" />
				</tr>
				<tr>
					<s:textfield name="lastname" id="lastname" label="Last Name" size="50"
						 labelposition="top" />
				</tr>
				<tr>
					<s:textfield name="studentid" id="studentid"  label="Student ID" size="50"
						labelposition="top" />
				</tr>
		</table>


		<table class="two">
			<thead>
				<th colspan="2"><strong> Address</strong></th>
			</thead>
			<tbody>
				<tr>
					<s:textfield name="streetaddress1" id="streetaddress1" label="Street Address 1" size="50"
						labelposition="top" />
				</tr>
				<tr>
					<s:textfield name="streetaddress2" id="streetaddress2" label="Street Address 2" size="50"
						 labelposition="top" />
				</tr>
				<s:textfield name="city" label="City" id="city"  size="50" 
					labelposition="top" />
				</tr>
				<tr>
					<s:textfield name="state" id="state" label="State" size="50" 
						labelposition="top" />
				</tr>
				<tr>
					<s:textfield name="zipcode" id="zipcode" label="Zip Code" size="50"
						 labelposition="top" />
				</tr>
		</table>


		<table class="three">
			<thead>
				<th colspan="2"><strong> Contact Info</strong></th>
			</thead>
			<tbody>
				<tr>
					<s:textfield name="phone" id="phone" label="Phone" size="50" 
						labelposition="top" />
				</tr>
				<tr>
					<s:textfield name="email" id="email" label="Email" size="50" 
						labelposition="top" />
				</tr>
				<tr>
					<s:textfield name="url" id="url" label="URL" size="50"
						 labelposition="top" />
				</tr>
		</table>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<span id="validatezip" class="validator"> </span>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<p class="additionaldata">
		<s:textfield name="date" label="Date" id="date" size="50"
						 labelposition="top" />
		</p>

		<section class="additionaldata">
		<p>

		<s:textfield name="rafflebox" id="rafflebox" label="Raffle" size="50"
						 labelposition="top"/>

		</p>

		</section>
		<section class="additionaldata">
		<p>
			<strong>What did you like most about the campus?</strong> <br>
			Students <input id="checkbox1" type="checkbox" value="students"
				checked> Location<input id="checkbox2" type="checkbox"
				value="location"> Campus<input id="checkbox3"
				type="checkbox" value="campus"> Atmosphere<input
				id="checkbox4" type="checkbox" value="atmosphere"> Dorm
			Roooms<input id="checkbox5" type="checkbox" value="drooms">
			Sports<input id="checkbox6" type="checkbox" value="sports">
		</p>

		<p>
			<strong>How did you become interested in the university?</strong> <br>
			Friends<input name="interested" type="radio" value="friends" checked>
			Television<input name="interested" type="radio" value="tv">
			Internet<input name="interested" type="radio" value="internet">
			Other<input name="interested" type="radio" value="other">
		</p>
		</section>
		<p>
			<label> Comments: <br> <textarea id="commentarea"
					name="comments" rows="4" cols="50">
                  Enter comments here. </textarea>
			</label>
		</p>
		
		<p>
			How likely are you to recommend this school to other prospective
			students? <select>
				<option value="Very Likely">Very Likley</option>
				<option value="Likely">Likley</option>
				<option value="Unlikely">Unlikley</option>
			</select>
		</p>

		<br>
		<br>

		<table>
			<tbody>


				<a href="ass2_homepage.html">
					<button type="button">Cancel</button>
				</a>
				<!-- <input type="submit" value="Submit" onclick="validateForm()"> -->
				<s:submit  type="button" onclick="validateForm()"/> 
			</tbody>
		</table>



		<div id="oneandhundred" title="Warning Box" style="display: none;">
			You may only enter numbers between 1 and 100.</div>
		<div id="atleastten" title="Warning Box" style="display: none;">
			You must enter at least ten numbers.</div>
		<div id="notavalidemail" title="Warning Box" style="display: none;">
			Not a valid email address.</div>
		<div id="checkboxeswarning" title="Warning Box" style="display: none;">
			You must check at least two checkboxes.</div>
		<div id="addressisinvalid" title="Warning Box" style="display: none;">
			The address is invalid. Try again.</div>


	</s:form>

</body>
</html>