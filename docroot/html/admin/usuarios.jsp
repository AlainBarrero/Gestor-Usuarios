<%@include file = "/html/init.jsp" %> 

<%
	@SuppressWarnings("unchecked")
	List<User> susers = (List<User>)portletSession.getAttribute("susers");
	if(susers == null){
		susers = new ArrayList<User>();
	}

	@SuppressWarnings("unchecked")
	List<Subscription> cusers = (List<Subscription>)portletSession.getAttribute("cusers");
	if(cusers == null){
		cusers = new ArrayList<Subscription>();
	}
	
	@SuppressWarnings("unchecked")
	List<Role> croles = (List<Role>) portletSession.getAttribute("rolesUser");
	if(croles == null){
		croles = new ArrayList<Role>();
	}
%>

<portlet:actionURL name="deleteSubcriptionUser" var="delete"></portlet:actionURL>

<aui:form action="<%=delete%>"  name="<portlet:namespace />mt">
	<div id="myDataTable"></div>
	<aui:input type="hidden" name="userId" value=""  id="userId"/>
	<aui:button-row>
		<aui:button type="submit" value="Borrar" id="button"/>
	</aui:button-row>
</aui:form>

<script>
YUI().use(
		  'aui-datatable',
		  function(Y) {
		    var data = [];
		    <%
		    	for(int i = 0; i<cusers.size(); i++){
		    		if(cusers.get(i).isIsActive()){
			    		String rolesUserString = "";
			    		for(int j=0; j<croles.size(); j++){
			    			if(j == croles.size()-1){
			    				rolesUserString += " " + croles.get(j).getName();
			    			}else{
			    				rolesUserString += " " + croles.get(j).getName() + ",";	
			    			}
			    		}
			%>
			    		var groupRole = 
			    			{
			    				name: '<%=susers.get(i).getFullName()%>',
			    				user: '<%=susers.get(i).getScreenName()%>',
			    				role: '<%=rolesUserString%>',
			    				select: '<input type="checkbox" id="checkbox" value="<%=cusers.get(i).getSubscriptionId()%>">'
			    			}
			    		;
			    		data.push(groupRole);
		    <%		}
		    	}
		    %>
		    var table = new Y.DataTable({
		        columns : [
		            {   key: 'name',   label: 'Nombre' },
		            {   key: 'user',  label: 'Nombre de Usuario' },
		            {   key: 'role', label: 'Roles' },
		            {   key:        'select',
		                allowHTML:  true,
		                label: 'Seleccionar'
		            }
		        ],
		        width	  : '970px',
		        data      : data,
		        recordType: ['name', 'user', 'role', 'select']
		    }).render("#myDataTable");
		  });

</script>


<aui:script use="liferay-util-window">
AUI().use('#myDataTable', function(A){
	A.one("#button").on("click", function(){
	    var values = [];
	    A.all("#checkbox").each(function(){
	        if(this.get("checked")){
	            values.push(this.get("value"));
	            document.getElementById("<portlet:namespace />userId").value = values.toString()
	        }
	    });
	}); 
}); 
</aui:script>