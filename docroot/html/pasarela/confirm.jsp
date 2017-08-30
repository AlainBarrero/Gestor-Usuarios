<%@include file = "/html/init.jsp" %> 

<portlet:actionURL name="confirmOrderPayPal" var="confirmOrderPayPal"></portlet:actionURL>
<portlet:actionURL name="deleteSessionParameter" var="deleteSessionParameter"></portlet:actionURL>

<aui:form action="<%=confirmOrderPayPal%>" name="<portlet:namespace />mt">
	<aui:button type="submit" value="Confirmar"/>
	<aui:button type="cancel" onClick="<%= deleteSessionParameter%>"/>
</aui:form>