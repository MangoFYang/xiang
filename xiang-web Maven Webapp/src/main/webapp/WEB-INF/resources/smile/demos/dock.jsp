<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/smile-taglib.jsp" %>
<script type="text/javascript">
<!--
	window.location.href = "${pageContext.request.contextPath}/smile/demos/";
//-->
</script>
<!DOCTYPE HTML>
<h:html overflowX="hidden" overflowY="hidden">
<h:head title="Smile Reference" />
<h:body style="background: url(\"scripts/dock/styles/images/cloud.jpg\") repeat scroll center center transparent; height: 1000px; display: block;">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/smile/demos/scripts/dock/styles/dock.css"></link>
<%-- 引用的JS文件, 必须以"/"开头, 例如： --%>
<s:script src="/smile/demos/scripts/dock/dock.js"></s:script>
<%--<s:script src="/smile/demos/scripts/index.js"></s:script>--%>
<s:script><%-- 此处放置JS标签 --%>
	<s:odialog title="core" renderTo="core" modal="false"
		width="1000" height="700" autoOpen="false" minWidth="500" minHeight="350"
		embedType="page" url="/smile/demos/core.jsp"/>
	<s:odialog title="bigpicture" renderTo="bigpicture" modal="false"
		width="1000" height="700" autoOpen="false" minWidth="500" minHeight="350"
		embedType="page" url="/smile/demos/bigpicture.jsp"/>
	<s:odialog title="messagebox" renderTo="messagebox" modal="false"
		width="1000" height="700" autoOpen="false" minWidth="500" minHeight="350"
		embedType="page" url="/smile/demos/messagebox.jsp"/>
	<s:odialog title="obutton" renderTo="obutton" modal="false"
		width="1000" height="700" autoOpen="false" minWidth="500" minHeight="350"
		embedType="page" url="/smile/demos/obutton.jsp"/>
	<s:odialog title="ocheckboxradio" renderTo="ocheckboxradio" modal="false"
		width="1000" height="700" autoOpen="false" minWidth="500" minHeight="350"
		embedType="page" url="/smile/demos/ocheckboxradio.jsp"/>
	<s:odialog title="olocation" renderTo="olocation" modal="false"
		width="1000" height="700" autoOpen="false" minWidth="500" minHeight="350"
		embedType="page" url="/smile/demos/olocation.jsp"/>
	<s:odialog title="odatepicker" renderTo="odatepicker" modal="false"
		width="1000" height="700" autoOpen="false" minWidth="500" minHeight="350"
		embedType="page" url="/smile/demos/odatepicker.jsp"/>
	<s:odialog title="otable" renderTo="otable" modal="false"
		width="1000" height="700" autoOpen="false" minWidth="500" minHeight="350"
		embedType="page" url="/smile/demos/otable.jsp"/>
	<s:odialog title="otextfield" renderTo="otextfield" modal="false"
		width="1000" height="700" autoOpen="false" minWidth="500" minHeight="350"
		embedType="page" url="/smile/demos/otextfield.jsp"/>
	<s:odialog title="oajaxinput" renderTo="oajaxinput" modal="false"
		width="1000" height="700" autoOpen="false" minWidth="500" minHeight="350"
		embedType="page" url="/smile/demos/oajaxinput.jsp"/>
	<s:odialog title="otriggerinput" renderTo="otriggerinput" modal="false"
		width="1000" height="700" autoOpen="false" minWidth="500" minHeight="350"
		embedType="page" url="/smile/demos/otriggerinput.jsp"/>
	<s:odialog title="olist4input" renderTo="olist4input" modal="false"
		width="1000" height="700" autoOpen="false" minWidth="500" minHeight="350"
		embedType="page" url="/smile/demos/olist4input.jsp"/>
	<s:odialog title="osinglebox" renderTo="osinglebox" modal="false"
		width="1000" height="700" autoOpen="false" minWidth="500" minHeight="350"
		embedType="page" url="/smile/demos/osinglebox.jsp"/>
	<s:odialog title="otwobox" renderTo="otwobox" modal="false"
		width="1000" height="700" autoOpen="false" minWidth="500" minHeight="350"
		embedType="page" url="/smile/demos/otwobox.jsp"/>
	<s:odialog title="oselect" renderTo="oselect" modal="false"
		width="1000" height="700" autoOpen="false" minWidth="500" minHeight="350"
		embedType="page" url="/smile/demos/oselect.jsp"/>
	<s:odialog title="olistselectsingle" renderTo="olistselectsingle" modal="false"
		width="1000" height="700" autoOpen="false" minWidth="500" minHeight="350"
		embedType="page" url="/smile/demos/olistselectsingle.jsp"/>
	<s:odialog title="otreeselectsingle" renderTo="otreeselectsingle" modal="false"
		width="1000" height="700" autoOpen="false" minWidth="500" minHeight="350"
		embedType="page" url="/smile/demos/otreeselectsingle.jsp"/>
	<s:odialog title="otreeselect" renderTo="otreeselect" modal="false"
		width="1000" height="700" autoOpen="false" minWidth="500" minHeight="350"
		embedType="page" url="/smile/demos/otreeselect.jsp"/>
	<s:odialog title="olistselect" renderTo="olistselect" modal="false"
		width="1000" height="700" autoOpen="false" minWidth="500" minHeight="350"
		embedType="page" url="/smile/demos/olistselect.jsp"/>
	<s:odialog title="olist4excludeinput" renderTo="olist4excludeinput" modal="false"
		width="1000" height="700" autoOpen="false" minWidth="500" minHeight="350"
		embedType="page" url="/smile/demos/olist4excludeinput.jsp"/>
	<s:odialog title="otree" renderTo="otree" modal="false"
		width="1000" height="700" autoOpen="false" minWidth="500" minHeight="350"
		embedType="page" url="/smile/demos/otree.jsp"/>
	<s:odialog title="olist" renderTo="olist" modal="false"
		width="1000" height="700" autoOpen="false" minWidth="500" minHeight="350"
		embedType="page" url="/smile/demos/olist.jsp"/>
	<s:odialog title="opageablelist" renderTo="opageablelist" modal="false"
		width="1000" height="700" autoOpen="false" minWidth="500" minHeight="350"
		embedType="page" url="/smile/demos/opageablelist.jsp"/>
	<s:odialog title="ogrid" renderTo="ogrid" modal="false"
		width="1000" height="700" autoOpen="false" minWidth="500" minHeight="350"
		embedType="page" url="/smile/demos/ogrid.jsp"/>
	<s:odialog title="odialog" renderTo="odialog" modal="false"
		width="1000" height="700" autoOpen="false" minWidth="500" minHeight="350"
		embedType="page" url="/smile/demos/odialog.jsp"/>
	<s:odialog title="otabs" renderTo="otabs" modal="false"
		width="1000" height="700" autoOpen="false" minWidth="500" minHeight="350"
		embedType="page" url="/smile/demos/otabs.jsp"/>
	<s:odialog title="obaselist" renderTo="obaselist" modal="false"
		width="1000" height="700" autoOpen="false" minWidth="500" minHeight="350"
		embedType="page" url="/smile/demos/obaselist.jsp"/>
	<s:odialog title="ofileupload" renderTo="ofileupload" modal="false"
		width="1000" height="700" autoOpen="false" minWidth="500" minHeight="350"
		embedType="page" url="/smile/demos/ofileupload.jsp"/>
</s:script>
<%-- 此处放置HTML标签 --%>

<h:div id="core"></h:div>
<h:div id="bigpicture"></h:div>
<h:div id="messagebox"></h:div>
<h:div id="obutton"></h:div>
<h:div id="ocheckboxradio"></h:div>
<h:div id="olocation"></h:div>
<h:div id="odatepicker"></h:div>
<h:div id="otable"></h:div>
<h:div id="otextfield"></h:div>
<h:div id="oajaxinput"></h:div>
<h:div id="otriggerinput"></h:div>
<h:div id="olist4input"></h:div>
<h:div id="osinglebox"></h:div>
<h:div id="otwobox"></h:div>
<h:div id="oselect"></h:div>
<h:div id="olistselectsingle"></h:div>
<h:div id="otreeselectsingle"></h:div>
<h:div id="otreeselect"></h:div>
<h:div id="olistselect"></h:div>
<h:div id="olist4excludeinput"></h:div>
<h:div id="otree"></h:div>
<h:div id="olist"></h:div>
<h:div id="opageablelist"></h:div>
<h:div id="ogrid"></h:div>
<h:div id="odialog"></h:div>
<h:div id="otabs"></h:div>
<h:div id="obaselist"></h:div>
<h:div id="ofileupload"></h:div>

<%--
<h:button id="coreBtn">core</h:button>
<h:button id="bigpictureBtn">bigpicture</h:button>
<h:button id="messageboxBtn">messagebox</h:button>
<h:button id="obuttonBtn">obutton</h:button>
<h:button id="odatepickerBtn">odatepicker</h:button>
<h:button id="otableBtn">otable</h:button>
<h:button id="otextfieldBtn">otextfield</h:button>
<h:button id="oajaxinputBtn">oajaxinput</h:button>
<h:button id="otriggerinputBtn">otriggerinput</h:button>
<h:button id="olist4inputBtn">olist4input</h:button>
<h:button id="ocomboboxBtn">ocombobox</h:button>
<h:button id="osingleboxBtn">osinglebox</h:button>
<h:button id="otwoboxBtn">otwobox</h:button>
<h:button id="olistselectsingleBtn">olistselectsingle</h:button>
<h:button id="otreeselectsingleBtn">otreeselectsingle</h:button>
<h:button id="otreeselectBtn">otreeselect</h:button>
<h:button id="olistselectBtn">olistselect</h:button>
<h:button id="olist4excludeinputBtn">olist4excludeinput</h:button>
<h:button id="otreeBtn">otree</h:button>
<h:button id="olistBtn">olist</h:button>
<h:button id="ogridBtn">ogrid</h:button>
<h:button id="odialogBtn">odialog</h:button>
<h:button id="otabsBtn">otabs</h:button>
 --%>

<h:div id="dockC" style="position: absolute; bottom: 0; width: 100%;" class="o-border-box o-unselect">
	<h:a class="prev disabled">-</h:a>
	<h:a class="next disabled">+</h:a>
	<h:div id="dockS" style="width: 70%; margin: auto; position: relative;">
		<h:div id="dock">
			<h:ul id="dockUl">
				<h:li><h:a><span>core</span><img src="scripts/dock/styles/images/sunflower.png" alt="[core]" /></h:a></h:li>
				<h:li><h:a><span>bigpicture</span><img src="scripts/dock/styles/images/sunflower.png" alt="[bigpicture]" /></h:a></h:li>
				<h:li><h:a><span>messagebox</span><img src="scripts/dock/styles/images/sunflower.png" alt="[messagebox]" /></h:a></h:li>
				<h:li><h:a><span>obutton</span><img src="scripts/dock/styles/images/sunflower.png" alt="[obutton]" /></h:a></h:li>
				<h:li><h:a><span>olocation</span><img src="scripts/dock/styles/images/sunflower.png" alt="[olocation]" /></h:a></h:li>
				<h:li><h:a><span>ocheckboxradio</span><img src="scripts/dock/styles/images/sunflower.png" alt="[ocheckboxradio]" /></h:a></h:li>
				<h:li><h:a><span>otabs</span><img src="scripts/dock/styles/images/sunflower.png" alt="[otabs]" /></h:a></h:li>
				<h:li><h:a><span>odialog</span><img src="scripts/dock/styles/images/sunflower.png" alt="[odialog]" /></h:a></h:li>
				<h:li><h:a><span>otextfield</span><img src="scripts/dock/styles/images/sunflower.png" alt="[otextfield]" /></h:a></h:li>
				<h:li><h:a><span>otable</span><img src="scripts/dock/styles/images/sunflower.png" alt="[otable]" /></h:a></h:li>
				<h:li><h:a><span>ogrid</span><img src="scripts/dock/styles/images/sunflower.png" alt="[ogrid]" /></h:a></h:li>
				<h:li><h:a><span>olist4excludeinput</span><img src="scripts/dock/styles/images/sunflower.png" alt="[olist4excludeinput]" /></h:a></h:li>
				<h:li><h:a><span>oajaxinput</span><img src="scripts/dock/styles/images/sunflower.png" alt="[oajaxinput]" /></h:a></h:li>
				<h:li><h:a><span>otriggerinput</span><img src="scripts/dock/styles/images/sunflower.png" alt="[otriggerinput]" /></h:a></h:li>
				<h:li><h:a><span>olist4input</span><img src="scripts/dock/styles/images/sunflower.png" alt="[olist4input]" /></h:a></h:li>
				<h:li><h:a><span>odatepicker</span><img src="scripts/dock/styles/images/sunflower.png" alt="[odatepicker]" /></h:a></h:li>
				<h:li><h:a><span>osinglebox</span><img src="scripts/dock/styles/images/sunflower.png" alt="[osinglebox]" /></h:a></h:li>
				<h:li><h:a><span>otwobox</span><img src="scripts/dock/styles/images/sunflower.png" alt="[otwobox]" /></h:a></h:li>
				<h:li><h:a><span>oselect</span><img src="scripts/dock/styles/images/sunflower.png" alt="[oselect]" /></h:a></h:li>
				<h:li><h:a><span>olistselectsingle</span><img src="scripts/dock/styles/images/sunflower.png" alt="[olistselectsingle]" /></h:a></h:li>
				<h:li><h:a><span>otreeselectsingle</span><img src="scripts/dock/styles/images/sunflower.png" alt="[otreeselectsingle]" /></h:a></h:li>
				<h:li><h:a><span>otreeselect</span><img src="scripts/dock/styles/images/sunflower.png" alt="[otreeselect]" /></h:a></h:li>
				<h:li><h:a><span>olistselect</span><img src="scripts/dock/styles/images/sunflower.png" alt="[olistselect]" /></h:a></h:li>
				<h:li><h:a><span>otree</span><img src="scripts/dock/styles/images/sunflower.png" alt="[otree]" /></h:a></h:li>
				<h:li><h:a><span>obaselist</span><img src="scripts/dock/styles/images/sunflower.png" alt="[obaselist]" /></h:a></h:li>
				<h:li><h:a><span>olist</span><img src="scripts/dock/styles/images/sunflower.png" alt="[olist]" /></h:a></h:li>
				<h:li><h:a><span>opageablelist</span><img src="scripts/dock/styles/images/sunflower.png" alt="[opageablelist]" /></h:a></h:li>
				<h:li><h:a><span>ofileupload</span><img src="scripts/dock/styles/images/sunflower.png" alt="[ofileupload]" /></h:a></h:li>
			</h:ul>
		</h:div>
	</h:div>
</h:div>

<h:div id="cloud1" style="background: url(scripts/dock/styles/images/cloud1.png) no-repeat scroll 0 0 transparent; height: 409px; width: 839px; position: absolute; overflow: hidden;"></h:div>

</h:body>
</h:html>