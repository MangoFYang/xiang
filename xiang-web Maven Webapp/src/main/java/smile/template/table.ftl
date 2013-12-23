<table<#rt/>
<#if id??>
 id="${id?html}"<#rt/>
</#if>
 style="<#rt/>
<#if width??>
width:${width};<#rt/>
</#if>
<#if layout??>
table-layout:fixed;<#rt/>
</#if>
"<#rt/>
<#include "dynamic-attributes.ftl" />
>