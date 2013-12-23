$("#${renderTo}").ocombobox({<#t/>
<#if autoFocus??>
autoFocus:${autoFocus},<#t/>
</#if>
<#if minLength??>
minLength:${minLength},<#t/>
</#if>
<#if delay??>
delay:${delay},<#t/>
</#if>
<#if menuMaxHeight??>
menuMaxHeight:${menuMaxHeight},<#t/>
</#if>
<#include "list4input-attributes.ftl" />
<#include "otriggerinput-attributes.ftl" />
<#include "otextfield-attributes.ftl" />
"a":"a"});<#t/>