<td<#rt/>
<#if id??>
 id="${id?html}"<#rt/>
</#if>
<#if colspan??>
 colspan="${colspan?html}"<#rt/>
</#if>
<#if rowspan??>
 rowspan="${rowspan?html}"<#rt/>
</#if>
 style="<#rt/>
<#if valign??>
vertical-align:${valign};<#rt/>
</#if>
<#if width??>
width:${width};<#rt/>
</#if>
"<#rt/>
<#include "dynamic-attributes.ftl" />
>