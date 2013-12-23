$("#${renderTo}").ogrid({<#t/>
<#if url??>
url:"${contextPath}${url}",<#t/>
</#if>
<#if datatype??>
datatype:"${datatype}",<#t/>
</#if>
colModel:[<#t/>