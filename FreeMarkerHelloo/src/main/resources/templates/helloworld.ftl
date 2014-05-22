FreeMarker Template example: ${message}  

We are printing the list created at ${date1?time} on ${date1?date}


=======================
===  County List   ====
=======================

<#--This is the comment.-->
<#list countries as country>
    ${country_index + 1}. ${country}
</#list>
<#-- item_index: This is a numerical value that contains 
the index of the current item being stepped over in the loop.

item_has_next: Boolean value that tells if the current item 
the last in the sequence or not.-->



The line below prints the hash
${hash.first}



Calling the Java function
<#assign x = "something">
${indexOf("met",x)}
${indexOf("foo",x)}




		
Create and call freeMarker function
<#function avg x y>
  <#return (x + y) / 2>
</#function>
Avg of 10 & 20: ${avg(10, 20)}  





Macro's in freeMarker
<#macro test>
  Test text
</#macro>
Hi
<#-- call the macro: -->
<@test/>  

Macro complex example
<#macro repeat count>
  <#list 1..count as x>
    <#nested x, x/2, x==count>
  </#list>
</#macro>


<@repeat count=4 ; c, halfc, last>
  ${c}. ${halfc}<#if last> Last!</#if>
</@repeat>  




User defined Directive
foo
<@upper>
  bar
  <#-- All kind of FTL is allowed here -->
  <#list ["red", "green", "blue"] as color>
    ${color}
  </#list>
  baaz
</@upper>
wombat  






XML parsing
<#list doc["book/chapter[title='Ch1']/para"] as p>
  <p>${p}
</#list>  


	
<#list doc.book?children as c>
- ${c?node_type} <#if c?node_type = 'element'>${c?node_name}</#if>
</#list> 



		
		
The current locale is: ${.locale}
<#setting locale="en_US">
US people write:        ${12345678?string(",##0.00")}
<#setting locale="hu">
The current locale is: ${.locale}
Hungarian people write: ${12345678?string(",##0.00")} 





escaping for special characters.
<#escape x as x?html >
${message}
< dsfsdfjkl0 0>
message
</#escape>
