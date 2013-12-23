<textarea<#rt/>
<#if id??>
 id="${id?html}"<#rt/>
</#if>
<#if cols??>
 cols="${cols?html}"<#rt/>
</#if>
<#if rows??>
 rows="${rows?html}"<#rt/>
</#if>
<#include "dynamic-attributes.ftl" />
>