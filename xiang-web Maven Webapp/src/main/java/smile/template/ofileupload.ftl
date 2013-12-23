$("#${renderTo}").ofileupload({<#t/>
<#if label??>
label:"${label}",<#t/>
</#if>
<#if url??>
url:"${contextPath}${url}",<#t/>
</#if>
<#if detailAppendTo??>
detailAppendTo:${detailAppendTo},<#t/>
</#if>
<#if add??>
add:${add},<#t/>
</#if>
<#if done??>
done:${done},<#t/>
</#if>
<#if fail??>
fail:${fail},<#t/>
</#if>
"a":"a"});<#t/>