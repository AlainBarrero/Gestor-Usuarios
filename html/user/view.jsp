<%@include file = "/html/init.jsp" %> 

<%
	@SuppressWarnings("unchecked")
	List<SubsConfiguration> confList = (List<SubsConfiguration>) renderRequest.getAttribute("confList");
%>

<portlet:actionURL name="selectSuscription" var="selectSuscription"></portlet:actionURL>
	
	
<aui:form action="<%=selectSuscription%>"  name="<portlet:namespace />mt">
	<aui:select name="userOption" label="Suscripciones" showEmptyOption="true" onchange="this.form.submit()">
		<%for(int i = 0; i<confList.size(); i++){%>
			<aui:option value="<%=confList.get(i).getConfigurationId()%>"><%=confList.get(i).getDescription()%></aui:option>
		<%}%>
	</aui:select>
</aui:form>
	
	
