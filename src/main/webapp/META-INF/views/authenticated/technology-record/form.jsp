<%--
- form.jsp
-
- Copyright (c) 2019 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form readonly="true">
	<acme:form-textbox code="authenticated.technologyrecord.form.label.title" path="title"/>
	<acme:form-textbox code="authenticated.technologyrecord.form.label.sector" path="sector.name"/>
	<acme:form-textbox code="authenticated.technologyrecord.form.label.inventor" path="inventor"/>
	<acme:form-textarea code="authenticated.technologyrecord.form.label.description" path="description"/>
	<acme:form-url code="authenticated.technologyrecord.form.label.web" path="web"/>
	<acme:form-textbox code="authenticated.technologyrecord.form.label.email" path="email"/>
	<acme:form-checkbox code="authenticated.technologyrecord.form.label.openSource" path="openSource"/>
	<acme:form-integer code="authenticated.technologyrecord.form.label.stars" path="stars"/>
		
	<acme:form-return code="authenticated.technologyrecord.form.button.return"/>
</acme:form>