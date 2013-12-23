<#if (dynamicAttributes?? && dynamicAttributes?size > 0)>
<#assign aKeys = dynamicAttributes?keys>
<#list aKeys as aKey>
 ${aKey}="${dynamicAttributes[aKey]?html}"<#rt/>
</#list>
</#if>