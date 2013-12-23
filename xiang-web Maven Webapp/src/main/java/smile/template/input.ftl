<input<#rt/>
 type="${type!"text"}"<#rt/>
<#if id??>
 id="${id?html}"<#rt/>
</#if>
<#if name??>
 name="${name?html}"<#rt/>
</#if>
<#if type?? && type == "file">
 class="opacity0"<#rt/>
</#if>
<#include "dynamic-attributes.ftl" />
/><#rt/>