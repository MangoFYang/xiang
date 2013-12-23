$("#${renderTo}").otree({<#t/>
<#if selectableField??>
selectableField:"${selectableField}",<#t/>
</#if>
<#if stateField??>
stateField:"${stateField}",<#t/>
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
<#if checkboxDisabled??>
checkboxDisabled:${checkboxDisabled},<#t/>
</#if>
checkbox: {<#t/>
<#if twoState??>
two_state:${twoState},<#t/>
</#if>
"a":"a"},<#t/>
<#if loaded??>
loaded:${loaded},<#t/>
</#if>
<#if afterOpen??>
afterOpen:${afterOpen},<#t/>
</#if>
<#if openNode??>
openNode:${openNode},<#t/>
</#if>
<#if afterClose??>
afterClose:${afterClose},<#t/>
</#if>
<#if closeNode??>
closeNode:${closeNode},<#t/>
</#if>
<#if checkNode??>
checkNode:${checkNode},<#t/>
</#if>
<#if selectNode??>
selectNode:${selectNode},<#t/>
</#if>
<#if deselectNode??>
deselectNode:${deselectNode},<#t/>
</#if>
<#if uncheckNode??>
uncheckNode:${uncheckNode},<#t/>
</#if>
<#include "olist4excludeinput-attributes.ftl" />
"a":"a"});<#t/>