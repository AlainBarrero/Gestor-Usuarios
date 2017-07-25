<%@include file = "/html/init.jsp" %> 

<portlet:actionURL name="getExpressCheckoutDetails" var="getExpressCheckoutDetails"></portlet:actionURL>
<portlet:actionURL name="deleteSessionParameter" var="deleteSessionParameter"></portlet:actionURL>

<aui:form action="<%=getExpressCheckoutDetails%>" name="<portlet:namespace />mt">
	<aui:button type="submit" value="Realizar Pago"/>
	<aui:button type="cancel" onClick="<%= deleteSessionParameter%>"/>
</aui:form>