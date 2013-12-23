$("#${renderTo}").otreeselect({<#t/>
<#if selectableField??>
selectableField:"${selectableField}",<#t/>
</#if>
<#if model??>
model:"${model}",<#t/>
</#if>
adjacency:{<#t/>
<#if parentIdField??>
parentIdField:"${parentIdField}",<#t/>
</#if>
<#if parent4Root??>
parent4Root:"${parent4Root}",<#t/>
</#if>
"a":"a"},<#t/>
checkbox: {<#t/>
<#if twoState??>
two_state:${twoState},<#t/>
</#if>
"a":"a"},<#t/>
<#include "twobox-attributes.ftl" />
<#include "list4input-attributes.ftl" />
<#include "otriggerinput-attributes.ftl" />
<#include "otextfield-attributes.ftl" />
"a":"a"});<#t/>