<html>
<head><title>FreeMarker Hello World</title>
 
<body>

<center>
  <form name="user" action="MyServlet" method="post">
    Firstname: <input type="text" name="firstname" /> <br/>
    Lastname: <input type="text" name="lastname" />       <br/>
    <input type="submit" value="Save" />
  </form>
 
  <table class="datatable">
    <tr>
        <th>Firstname</th>  <th>Lastname</th>
    </tr>
    <#list users as user>
    <tr>
        <td>${user.firstName}</td> <td>${user.lastName}</td>
    </tr>
    </#list>
  </table>
  
  
  <#include "copyright.ftl">
  </center>
  
  
</body>
</html>