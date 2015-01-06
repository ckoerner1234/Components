function checkRaffleBox(){
	var inputString = document.getElementById("rafflebox").value;
	var stringNumbers = inputString.split(",");
	var maximum;
	var totalNum = stringNumbers.length;
	var minNum  = 10;
	if(totalNum < minNum) 
	{
		atLeastTen();
		//alert("You must have at least 10 numbers entered here");
		document.getElementById("rafflebox").value=" ";
	}
	if(totalNum >= minNum)  maximum = calculateMax(stringNumbers);
	if(maximum > 100) alert("You are not allowed to enter any numbers greater than 100");
}

function calculateMax(stringNumbers)
{
	var number;
	var maximum = stringNumbers[0];
	var totalNum = stringNumbers.length;

	for(var i=0; i< totalNum; i++)
	{
		number = parseFloat(stringNumbers[i]);

		if(number < 1 || number > 100 || isNaN(number) ) 
		{             
			onlyNumbersBetweenOneAndHundred();

			document.getElementById("rafflebox").value=" ";

			return -1;
		}
		if(number > maximum) maximum=number;

	}
	return maximum;
}

function validateForm()
{

	var fnameWarning = " ";
	var lnameWarning = " ";
	var address1Warning = " ";
	var address2Warning = " ";
	var zipWarning = " ";

	var letters = new RegExp(/^[a-zA-Z\s]+$/);
	var fname = document.getElementById("firstname").value;
	if(!fname.match(letters)) 
	{
		var fnameWarning = "Only letters are allowed in the First name box.  \n";
		document.getElementById("firstname").value = " ";
	}

	var lname = document.getElementById("lastname").value;
	if(!lname.match(letters)) 
	{
		var lnameWarning = "Only letters are allowed in the Last name box.  \n";
		document.getElementById("lastname").value = " ";
	}


	var checkAddress1 = new RegExp(/^[a-z A-Z0-9.,_-\s]+$/);
	var address1 = document.getElementById("streetaddress1").value;
	if(!address1.match(checkAddress1)) 
	{
		var address1Warning = "Not a valid input for Address 1.  \n";
		document.getElementById("streetaddress1").value = " ";
	}

	var checkAddress2 = new RegExp(/^[a-z A-Z0-9., \s]*$/);
	var address2 = document.getElementById("streetaddress2").value;
	if(!address2.match(checkAddress2)) 
	{
		var address2Warning = "Not a valid input for Address 2.  \n";
		document.getElementById("streetaddress2").value = " ";
	}

	var checkZip = new RegExp(/^[0-9\s]+$/);
	var zip = document.getElementById("zipcode").value;
	if(!zip.match(checkZip)) 
	{
		var zipWarning = "Not a valid input for Zip Code.  \n";
		document.getElementById("zipcode").value = " ";
	}

	var warningString = fnameWarning.concat(lnameWarning,address1Warning,address2Warning,zipWarning);
	if(warningString.trim() != "") {
		//alert(warningString);
		addressIsInvalid();
	}

	checkRaffleBox();
	keepCount();
	checkEmail();
}

function checkEmail()
{
	var email = document.getElementById("email").value;
	var atpos = email.indexOf("@");
	var dotpos = email.lastIndexOf(".");
	if (atpos < 1 || dotpos < atpos+2 || dotpos+2 >= email.length)
	{      
		//alert("Not a valid email address");
		notAValidEmail();
	}
}


function keepCount()
{
	var count = 0;

	if(document.getElementById("checkbox1").checked)  count = count + 1;
	if(document.getElementById("checkbox2").checked)  count = count + 1;
	if(document.getElementById("checkbox3").checked)  count = count + 1;
	if(document.getElementById("checkbox4").checked)  count = count + 1;
	if(document.getElementById("checkbox5").checked)  count = count + 1;

	if(count < 2) {
		checkboxesWarning();
	}
}

function notAValidEmail()
{
	$("#notavalidemail").dialog(
			{
				width: 300,
				height: 200,
				modal: true
			});
	event.returnValue=false;
}

function checkboxesWarning()
{
	$("#checkboxeswarning").dialog(
			{
				width: 300,
				height: 200,
				modal: true
			});
	event.returnValue=false;
}    


function addressIsInvalid()
{
	$("#addressisinvalid").dialog(
			{
				width: 300,
				height: 200,
				modal: true
			});
	event.returnValue=false;
}    



function atLeastTen()
{
	$("#atleastten").dialog(
			{
				width: 300,
				height: 200,
				modal: true
			});
	event.returnValue=false;
}

function onlyNumbersBetweenOneAndHundred()
{
	$("#oneandhundred").dialog(
			{
				width: 300,
				height: 200,
				modal: true
			});
	event.returnValue=false;
}
