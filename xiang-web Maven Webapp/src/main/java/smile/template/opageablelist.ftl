$("#${renderTo}").opageablelist({<#t/>
<#if size??>
size:${size},<#t/>
</#if>
<#if ptext??>
ptext:"${ptext}",<#t/>
</#if>
<#if btext??>
btext:"${btext}",<#t/>
</#if>
<#include "baselist-attributes.ftl" />
<#include "olist4excludeinput-attributes.ftl" />
"a":"a"});<#t/>