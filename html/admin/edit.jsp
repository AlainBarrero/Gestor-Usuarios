<%@include file = "/html/init.jsp" %>

<% 
	SubsConfiguration sconfig = (SubsConfiguration) renderRequest.getAttribute("sconfig");
	PayPal	pconfig = (PayPal) renderRequest.getAttribute("pconfig");
	
	@SuppressWarnings("unchecked")
	List<Role> roles = (List<Role>) renderRequest.getAttribute("roles");
	
	@SuppressWarnings("unchecked")
	List<Role> croles = (List<Role>) renderRequest.getAttribute("croles");
	if(croles == null){
		croles = new ArrayList<Role>();
	}
%> 

<portlet:renderURL var="cancel">
    <portlet:param name="cancel" value="/html/admin/edit.jsp"></portlet:param>
</portlet:renderURL>

<portlet:renderURL var="popupUrl" windowState="<%=LiferayWindowState.POP_UP.toString() %>">
 	<portlet:param name="mvcPath" value="/html/admin/usuarios.jsp"/>
</portlet:renderURL>

<portlet:actionURL name="updateConfiguration" var="updateConfiguration"></portlet:actionURL>

<aui:form action="<%=updateConfiguration%>" name="<portlet:namespace />mt">
	<aui:fieldset>
		<aui:input name="configurationId" type="hidden" value="<%=sconfig.getConfigurationId()%>"></aui:input>	
		<aui:row>
			<aui:col span="10">
				<!-- PayPal payment gateway -->
				<liferay-ui:panel title="PayPal" extended="true" collapsible="false">
					<aui:input name="paypalUser" helpMessage="liferay_api@gmail.com" value="<%=pconfig.getPaypalUser()%>" label="Usuario API"/>
					<aui:input name="paypalPassword" helpMessage="GM27AYV68YWXDTF8" value="<%=pconfig.getPaypalPassword()%>" label="Contraseña API"/>
					<aui:input name="paypalFirm" helpMessage="AFcWxV21C7fd0v3bY" value="<%=pconfig.getPaypalFirm()%>" label="Firma API"/>
					<aui:input name="paypalEmail" helpMessage="liferay@gmail.com" value="<%=pconfig.getPaypalEmail()%>" type="email" label="Email PayPal"/>
				</liferay-ui:panel>	
			</aui:col>
			<aui:col span="2">
				<liferay-ui:panel title="Administración" extended="true" collapsible="false">
					<div id="popup_id">Usuarios</div>
				</liferay-ui:panel>
			</aui:col>
		</aui:row>
		<aui:row>
			<aui:col span="10">
				<liferay-ui:panel title="Configuración" extended="true" defaultState="close">
					<aui:input name="description" helpMessage="Descripción del pago" value="<%=sconfig.getDescription()%>" type="text"/>
					<aui:input name="amount" helpMessage="Cantidad del pago" value="<%=sconfig.getAmount()%>" type="number" step="any"/>
					<aui:row>
						<aui:col span="5">
							<aui:select name="time" helpMessage="Periodicidad del pago">
           						<%
           							for(int i=1; i<=30; i++){ 
           						        boolean selected = false;
           						        if(sconfig.getTime() == i){
           						            selected = true;
           						        } 
           						%>
           								<aui:option value="<%=i%>" selected="<%=selected%>"><%=i%></aui:option>
           						<%
           							}
           						%>
           					</aui:select>
						</aui:col>
						<aui:col span="4">
							<aui:select name="cycle" label="Ciclo">
		  						<aui:option value="Day" selected="<%=sconfig.getCycle().equals(\"Day\")%>">Días</aui:option>
		  						<aui:option value="Week" selected="<%=sconfig.getCycle().equals(\"Week\")%>">Semanas</aui:option>
		  						<aui:option value="Month" selected="<%=sconfig.getCycle().equals(\"Month\")%>">Meses</aui:option>
		  						<aui:option value="Year" selected="<%=sconfig.getCycle().equals(\"Year\")%>">Años</aui:option>
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
		    		 String checked = "";
				     if(croles.contains(roles.get(i))){
				        checked = "checked";
				      } 
		    %>
		    		var groupRole = 
		    			{
		    				select: '<input type="checkbox" <%=checked%> id="checkbox" value="<%=roles.get(i).getRoleId()%>">',
		    				title: '<%=roles.get(i).getTitle(themeDisplay.getLanguageId())%>',
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
		            {   key: 'description', label: 'Descripción' }
		        ],
		        data      : data,
		        recordType: ['select', 'title', 'description']
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

<aui:script use="liferay-util-window">
A.one('#popup_id').on('click', function(event) {
	 Liferay.Util.openWindow({ dialog: { 
	 	centered: true, 
	 	height: 700, 
	 	modal: true, 
	 	width: 1000 
	 	}, 
	 id: '<portlet:namespace />dialog',
	 title: 'Usuarios', 
	 uri: '<%=popupUrl%>'
	}); 
});
</aui:script>


