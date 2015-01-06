<%@ taglib prefix="s" uri="/struts-tags"%>

<div id="global">
	<h1 class="surveypageheader">Search Surveys</h1>
	<br>
	<s:form action="SearchSurveys" method="post" id="surveyform"
		autocomplete="on" class="basicinfo">

		<s:textfield name="firstname" id="firstname" label="First Name"
			size="30" labelposition="left" />

		<s:textfield name="lastname" id="lastname" label="Last Name" size="30"
			labelposition="left" />

		<s:textfield name="city" label="City" id="city" size="30"
			labelposition="left" />

		<s:textfield name="state" id="state" label="State" size="30"
			labelposition="left" />


		<table>
			<tbody>

				<tr>
					<td><s:submit type="button" /></td>
					<td><a href="<s:url action='ass4_homepage' />">
							<button type="button">Cancel</button>
					</a></td>

				</tr>
			</tbody>
		</table>



	</s:form>



</div>

