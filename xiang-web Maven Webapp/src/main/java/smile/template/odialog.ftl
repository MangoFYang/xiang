$("#${renderTo}").odialog({<#t/>
<#if url??>
url:"${contextPath}${url}",<#t/>
</#if>
<#if embedType??>
embedType:"${embedType}",<#t/>
</#if>
<#if autoOpen??>
autoOpen:${autoOpen},<#t/>
</#if>
<#if closeOnEscape??>
closeOnEscape:${closeOnEscape},<#t/>
</#if>
<#if draggable??>
draggable:${draggable},<#t/>
</#if>
<#if height??>
height:"${height}",<#t/>
</#if>
<#if maxHeight??>
maxHeight:${maxHeight},<#t/>
</#if>
<#if maxWidth??>
maxWidth:${maxWidth},<#t/>
</#if>
<#if minHeight??>
minHeight:${minHeight},<#t/>
</#if>
<#if minWidth??>
minWidth:${minWidth},<#t/>
</#if>
<#if modal??>
modal:${modal},<#t/>
</#if>
<#if resizable??>
resizable:${resizable},<#t/>
</#if>
<#if stack??>
stack:${stack},<#t/>
</#if>
<#if title??>
title:"${title}",<#t/>
</#if>
<#if width??>
width:${width},<#t/>
</#if>
<#if zIndex??>
zIndex:${zIndex},<#t/>
</#if>
<#if data??>
data:${data},<#t/>
</#if>
"a":"a"});<#t/>