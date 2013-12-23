<div<#rt/>
<#if id??>
 id="${id?html}"<#rt/>
</#if>
 style="overflow: auto;<#rt/>
<#if height??>
 height: ${height};<#rt/>
</#if>
"<#rt/>
 class="ui-tabs-hide"<#rt/>
<#include "dynamic-attributes.ftl" />
>