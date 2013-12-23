<a<#rt/>
<#if id??>
 id="${id?html}"<#rt/>
</#if>
<#if href??>
 href="${href?html}"<#rt/>
<#else>
 href="javascript:void(0)"<#rt/>
</#if>
<#include "dynamic-attributes.ftl" />
>