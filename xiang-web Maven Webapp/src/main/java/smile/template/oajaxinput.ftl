$("#${renderTo}").oajaxinput({<#t/>
<#if url??>
url:"${url}",<#t/>
</#if>
<#if termName??>
termName:"${termName}",<#t/>
</#if>
<#if onComplete??>
onComplete:${onComplete},<#t/>
</#if>
<#include "otextfield-attributes.ftl" />
"a":"a"});<#t/>