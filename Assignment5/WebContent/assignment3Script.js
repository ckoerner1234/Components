//Carolyn Koerner   SWE642


$(function (){
   $("#main-tabbed-panel-div").tabs();
});



function onlyNumbersBetweenOneAndTen()
{
    $("#oneandten").dialog(
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


function getMaxAndAvg()
{

   var inputString = document.getElementById("databox").value;
   var stringNumbers = inputString.split(",");

   var average;
   var maximum;
   var totalNum = stringNumbers.length;
   var minNum  = 10;

   if(totalNum < minNum) 
   {
        atLeastTen();
       
        document.getElementById("databox").value=" ";
        document.getElementById("average").value=" ";
        document.getElementById("maximum").value=" ";
   }

   if(totalNum >= minNum)
   {
      maximum = calculateMax(stringNumbers);
      if(maximum != -1)
      {
        average = calculateAverage(stringNumbers);
        document.getElementById("average").value=average;
        document.getElementById("maximum").value=maximum;
      }
    }
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
     	   onlyNumbersBetweenOneAndTen();
            
            document.getElementById("databox").value=" ";
            document.getElementById("average").value=" ";
            document.getElementById("maximum").value=" ";
            return -1;
       }
       if(number > maximum) maximum=number;
   }
     return maximum;
}


function calculateAverage(stringNumbers)
{
   var total = 0;
   var average;
   var totalNum = stringNumbers.length;

   for(var i=0; i< totalNum; i++)
   {
       number = parseFloat(stringNumbers[i]);
       total = total + number;
   }
   average = total/totalNum;
   return average;
}


function validateForm()
{
   var fnameWarning = " ";
   var lnameWarning = " ";
   var address1Warning = " ";
   var address2Warning = " ";
   var zipWarning = " ";

   var letters = new RegExp(/^[a-zA-Z\s]+$/);
   var fname = document.getElementById("firstName").value;
   if(!fname.match(letters)) 
   {
      var fnameWarning = "Only letters are allowed in the First name box.  \n";
      document.getElementById("firstName").value = " ";
   }

   var lname = document.getElementById("lastName").value;
   if(!lname.match(letters)) 
   {
      var lnameWarning = "Only letters are allowed in the Last name box.  \n";
      document.getElementById("lastName").value = " ";
   }


   var checkAddress1 = new RegExp(/^[a-z A-Z0-9.,_-\s]+$/);
   var address1 = document.getElementById("address1").value;
   if(!address1.match(checkAddress1)) 
   {
      var address1Warning = "Not a valid input for Address 1.  \n";
      document.getElementById("address1").value = " ";
   }

   var checkAddress2 = new RegExp(/^[a-z A-Z0-9., \s]*$/);
   var address2 = document.getElementById("address2").value;
   if(!address2.match(checkAddress2)) 
   {
      var address2Warning = "Not a valid input for Address 2.  \n";
      document.getElementById("address2").value = " ";
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
	   addressIsInvalid();
   }

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

function resetForm()
{
   document.getElementById("surveyform").reset();
   document.getElementById("city").innerHTML = "        ";
   document.getElementById("state").innerHTML = "        ";
   document.getElementById("validatezip").innerHTML = "        ";
}


$(function() {
$("#zipcode").mouseout(getZipCodes);
});

function getZipCodes(){
$.ajax({ url: "http://localhost:8080/Assignment4/zipcodes.json",
         datatype: "json",
         success: showCityState});
}

function showCityState (data)
{

  document.getElementById('validatezip').innerHTML = "Checking zip codes      ";

  var length = data.zipcodes.length;
  var zipcode = document.getElementById ("zipcode").value;
  var valid = 0;


  for(var i = 0; i < length; i++){
     var jsonzipcode = data.zipcodes[i].zip;
     var n = zipcode.indexOf(jsonzipcode);
     if(n === 0) {
         valid = 1;
         document.getElementById('city').value = data.zipcodes[i].city;
         document.getElementById('state').value = data.zipcodes[i].state;
    }
  }

  if(valid === 0){
      document.getElementById('validatezip').innerHTML = "Invalid Zip Code";
      document.getElementById('city').value = "";
      document.getElementById('state').value = "";
  }


}  //end function showCityState


function registerHandler()
{
var data = document.getElementById("databox");
data.onmouseout=getMaxAndAvg;

}

