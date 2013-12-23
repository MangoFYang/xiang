$("#${renderTo}").obutton({<#t/>
<#if disabled??>
disabled:${disabled},<#t/>
</#if>
<#if text??>
text:${text},<#t/>
</#if>
<#if primaryIcon??>
primaryIcon:"${primaryIcon}",<#t/>
</#if>
<#if secondaryIcon??>
secondaryIcon:"${secondaryIcon}",<#t/>
</#if>
<#if click??>
click:${click},<#t/>
</#if>
"a":"a"})<#t/>