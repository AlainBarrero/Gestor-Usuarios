<%@include file = "/html/init.jsp" %> 

<portlet:actionURL name="shortcutExpressCheckout" var="shortcutExpressCheckout"></portlet:actionURL>

<aui:form action="<%=shortcutExpressCheckout%>" name="<portlet:namespace />mt">
	<aui:button type="submit" value="Suscribirse"/>
</aui:form>
