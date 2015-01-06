<%@ taglib prefix="s" uri="/struts-tags"%>

<div id="global" style="background-color:#81DAF5">
<s:if test="hasActionErrors()">
    <div class="errorDiv">
        <s:actionerror/>
    </div>
</s:if>

	<s:form action="ProcessSurveyFormData" method="post" id="surveyform"
		autocomplete="on" class="basicinfo">
		<h1 class="surveypageheader">Student Data</h1>


		<s:textfield name="firstname" id="firstname" label="First Name"
			size="30" labelposition="left" />

		<s:textfield name="lastname" id="lastname" label="Last Name" size="30"
			labelposition="left" />

		<s:textfield name="studentid" id="studentid" label="Student ID"
			size="30" labelposition="left" />

		<s:textfield name="streetaddress1" id="streetaddress1"
			label="Street Address 1" size="30" labelposition="left" />

		<s:textfield name="streetaddress2" id="streetaddress2"
			label="Street Address 2" size="30" labelposition="left" />

		<s:textfield name="city" label="City" id="city" size="30"
			labelposition="left" />

		<s:textfield name="state" id="state" label="State" size="30"
			labelposition="left" />

		<s:textfield name="zipcode" id="zipcode" label="Zip Code" size="30"
			labelposition="left" />


		<s:textfield name="phone" id="phone" label="Phone" size="30"
			labelposition="left" />

		<s:textfield name="email" id="email" label="Email" size="30"
			labelposition="left" />

		<s:textfield name="url" id="url" label="URL" size="30"
			labelposition="left" />
		<br>
		<br>
		<s:textfield name="date" label="Date" id="date" size="30"
			labelposition="left" />
		<s:textfield name="rafflebox" id="rafflebox" label="Raffle" size="30"
			labelposition="left" />
			
		<table>
		<tr>
		<h2> Emergency Contact Information</h2>
		</tr>
		<tr>
		<s:textfield name="ecifirstname" id="ecifirstname" label="First Name"
			size="30" labelposition="left" />
		</tr>
		<tr>
		<s:textfield name="ecilastname" id="ecilastname" label="Last Name" size="30"
			labelposition="left" />
		</tr>
		<tr>
		<s:textfield name="eciphone" id="eciphone" label="Phone" size="30"
			labelposition="left" />
		</tr>
		<tr>
		<s:textfield name="eciemail" id="eciemail" label="Email" size="30"
			labelposition="left" />
		</tr>
		</table>
		


<br>
		<table>
			<tr>What did you like most about the campus?:
			</tr>
			<tr>
				<s:checkbox name="students" fieldValue="true" label="Students" />
				<s:checkbox name="location" label="Location" />
				<s:checkbox name="atmosphere" label="Atmosphere" />
				<s:checkbox name="campus" label="Campus" />
				<s:checkbox name="dormrooms" label="Dorm Rooms" />
				<s:checkbox name="sports" label="Sports" />
			</tr>
		</table>
		<br>

		<table>
			<s:radio label="How did you become interested in the university?"
				name="interested"
				list="#{'1':'Friends','2':'TV','3':'Internet','4':'Other'}"
				value="1" />
		</table>
		<br>
		<br>
		<label> Comments: <br> <textarea id="commentarea"
				name="comments" rows="4" cols="50">
                  Enter comments here. </textarea>
		</label>

		<br>
		
			How likely are you to recommend this school to other prospective
			students? 
			<select>
			<option value="Very Likely">Very Likley</option>
			<option value="Likely">Likley</option>
			<option value="Unlikely">Unlikley</option>
		</select>



		<table>
			<tbody>

				<tr>
					<td>
						<!-- <input type="submit" value="Submit" onclick="validateForm()"> -->
						<s:submit type="button" onclick="validateForm()" />
					</td>
					<td><a href="<s:url action='assignment4_homepage' />">
							<button type="button">Cancel</button>
					</a></td>
				</tr>
			</tbody>
		</table>

	</s:form>




</div>

