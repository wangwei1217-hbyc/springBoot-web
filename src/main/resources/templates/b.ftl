<h1>This is a.ftl</h1>
<h2>name is ${name}</h2>
<#if (sex=='female')>
    ${name}
<#else>
    王威
</#if>
<hr/>
<#list list as str>
    ${str}&nbsp;
</#list>
