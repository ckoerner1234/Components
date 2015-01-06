//Carolyn Koerner   SWE645


var now = new Date();
var hour = now.getHours();
var name;

if(hour < 12)
   document.write("<h1> Good Morning  ");

if(hour >= 12)
{
   hour=hour-12;
   if(hour < 6) document.write("<h1> Good Afternoon  ");
   if(hour >= 6) document.write("<h1> Good Evening  ");
}

 //document.cookie = "name=null;" + "expires=Tue, 11-Mar-2000 00:00:01 GMT";

   
if(document.cookie)
{

   var myCookie = unescape( document.cookie);

   var cookieTokens = myCookie.split( "=" );

   name = cookieTokens[1];
   
   var s = name.indexOf(";");
   if(s > -1){
	   name = prompt( "Please enter your name", "Sunitha");

	   document.cookie = "name=" + escape( name );
   }
   s = name.indexOf("undefined");
   if(s > -1){
	   name = prompt( "Please enter your name", "Sunitha");

	   document.cookie = "name=" + escape( name );
   }
   
   //name = myCookie;
}
else
{

   name = prompt( "Please enter your name", "Sunitha");

   document.cookie = "name=" + escape( name );
}

document.write(name  + ".  Welcome to Assignment #2! </h1>");
document.writeln( "<a href = 'javascript:wrongPerson()'> " + "Click here if you are not " + name + "</a>" );

function wrongPerson()
{
   document.cookie = "name=null;" + "expires=Tue, 11-Mar-2000 00:00:01 GMT";

   location.reload();
}   
