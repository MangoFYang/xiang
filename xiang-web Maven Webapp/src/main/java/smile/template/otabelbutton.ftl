$("#${renderTo}").otable("addButton", {<#t/>
<#if id??>
id:"${id}",<#t/>
</#if>
<#if label??>
label:"${label}",<#t/>
</#if>
<#if click??>
click:${click},<#t/>
</#if>
"a":"a"});<#t/>