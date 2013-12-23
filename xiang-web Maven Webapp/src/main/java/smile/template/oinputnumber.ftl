$("#${renderTo}").oinputnumber({<#t/>
<#if decimal??>
decimal:${decimal},<#t/>
</#if>
<#if max??>
max:${max},<#t/>
</#if>
<#if min??>
min:${min},<#t/>
</#if>
<#if step??>
step:${step},<#t/>
</#if>
<#if page??>
page:${page},<#t/>
</#if>
<#if change??>
change:${change},<#t/>
</#if>
<#if start??>
start:${start},<#t/>
</#if>
<#if spin??>
spin:${spin},<#t/>
</#if>
<#if stop??>
stop:${stop},<#t/>
</#if>
<#include "otextfield-attributes.ftl" />
"a":"a"});<#t/>