<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="theme" %>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>

<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portal.kernel.util.HtmlUtil" %>
<%@ page import="com.liferay.portal.kernel.util.StringPool" %>
<%@ page import="com.alain.monetizacion.model.SubsConfiguration" %>
<%@ page import="com.alain.monetizacion.model.PayPal" %>
<%@ page import="com.alain.monetizacion.model.Subscription" %>
<%@ page import="com.alain.monetizacion.model.Role_Config" %>
<%@ page import="com.liferay.portal.model.Role" %>
<%@ page import="com.liferay.portal.model.User" %>
<%@ page import="com.liferay.portal.service.RoleLocalServiceUtil" %>
<%@ page import="com.liferay.portal.service.UserLocalServiceUtil" %>
<%@ page import="com.alain.monetizacion.service.SubsConfigurationLocalServiceUtil" %>
<%@ page import="com.alain.monetizacion.service.SubscriptionLocalServiceUtil" %>
<%@ page import="com.alain.monetizacion.service.Role_ConfigLocalServiceUtil" %>
<%@ page import="com.alain.monetizacion.service.PayPalLocalServiceUtil" %>

<portlet:defineObjects />
<theme:defineObjects />