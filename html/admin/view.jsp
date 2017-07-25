<%@include file = "/html/init.jsp" %> 

<% 
	Long sconfig = (Long) renderRequest.getAttribute("sconfig");

	@SuppressWarnings("unchecked")
	List<Role> roles = (List<Role>) renderRequest.getAttribute("roles");	
%>

<portlet:renderURL var="cancel">
    <portlet:param name="cancel" value="/html/admin/edit.jsp"></portlet:param>
</portlet:renderURL>

<portlet:actionURL name="updateConfiguration" var="updateConfigurationURL"></portlet:actionURL>

<aui:form action="<%=updateConfigurationURL%>" name="<portlet:namespace />mt">
	<aui:fieldset>	
		<aui:input name="configurationId" type="hidden" value="<%=sconfig%>"></aui:input>
		<aui:row>
			<aui:col span="10">
				<!-- PayPal payment gateway -->
				<liferay-ui:panel title="PayPal" extended="true" collapsible="false" >
					<aui:input name="paypalUser" helpMessage="liferay_api@gmail.com" label="Usuario API"/>
					<aui:input name="paypalPassword" helpMessage="GM27AYV68YWXDTF8" label="Contraseña API"/>
					<aui:input name="paypalFirm" helpMessage="AFcWxV21C7fd0v3bY"  label="Firma API"/>
					<aui:input name="paypalEmail" helpMessage="liferay@gmail.com"  type="email" label="Email PayPal"/>
				</liferay-ui:panel>	
			</aui:col>
		</aui:row>
		<aui:row>
			<aui:col span="10">
				<liferay-ui:panel title="Configuración" extended="true">
					<aui:input name="description" helpMessage="Descripción del pago"  type="text"/>
					<aui:input name="amount" helpMessage="Cantidad del pago" type="number" step="any"/>
					<aui:row>
						<aui:col span="5">
							<aui:select name="time" helpMessage="Periodicidad del pago">
           						<%for(int i=1; i<=30; i++){ %>
           						<aui:option value="<%=i%>"><%=i%></aui:option>
           						<%}%>
           					</aui:select>
						</aui:col>
						<aui:col span="4">
							<aui:select name="cycle" label="Ciclo">
		  						<aui:option value="Day">Días</aui:option>
		  						<aui:option value="Week">Semanas</aui:option>
		  						<aui:option value="Month">Meses</aui:option>
		  						<aui:option value="Year">Años</aui:option>
		           			</aui:select>
						</aui:col>
					</aui:row>
					<div id="myDataTable"></div>
				</liferay-ui:panel>
			</aui:col>
		</aui:row>
		<aui:input type="hidden" name="roles" value=""  id="roles"/>
		<aui:button-row>
			<aui:button type="submit" id="button"/>
			<aui:button type="cancel" onClick="<%= cancel%>"/>
		</aui:button-row>
	</aui:fieldset>
</aui:form>

<script>
YUI().use(
		  'aui-datatable',
		  function(Y) {
		    var data = [];
		    <%
		    	for(int i = 0; i<roles.size(); i++){
		    %>
		    		var groupRole = 
		    			{
		    				select: '<input type="checkbox" id="checkbox" value="<%=roles.get(i).getRoleId()%>">',
		    				title: '<%=roles.get(i).getTitle(themeDisplay.getLanguageId())%>',
		    				type: '<%=roles.get(i).getTypeLabel()%>',
		    				description: '<%=roles.get(i).getDescriptionCurrentValue()%>'
		    			}
		    		;
		    		data.push(groupRole);
		    	<%}%>
		    var table = new Y.DataTable({
		        columns : [
		            {   key:        'select',
		                allowHTML:  true,scrollable: "",
		                label: 'Seleccionar'
		            },
		            {   key: 'title',   label: 'Título' },
		            {   key: 'type',  label: 'Tipo' },
		            {   key: 'description', label: 'Descripción' }
		        ],
		        data      : data,
		        recordType: ['select', 'title', 'type', 'description']
		    }).render("#myDataTable");
		  });


AUI().use("#myDataTable", function(A){
	A.one("#button").on("click", function(){
	    var values = [];
	    A.all("#checkbox").each(function(){
	        if(this.get("checked")){
	            values.push(this.get("value"));
	            document.getElementById("<portlet:namespace />roles").value = values.toString()
	        }
	    });
	}); 
});
</script>




