$("#${renderTo}").olist({<#t/>
<#if value??>
value:"${value}",<#t/>
</#if>
<#if valueSeparator??>
valueSeparator:"${valueSeparator}",<#t/>
</#if>
<#if autoRefresh??>
autoRefresh:${autoRefresh},<#t/>
</#if>
<#include "baselist-attributes.ftl" />
<#include "olist4excludeinput-attributes.ftl" />
"a":"a"});<#t/>