<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <title></title>
</head>

<body>
<g:if test="${flash.message}">
  <div class="alert-message">
    <p>${flash.message}</p>
  </div>
</g:if>

<g:hasErrors bean="${bean}">
  <g:eachError bean="${bean}" var="error">
    <div class="alert-message">
      <g:message error="${error}"/>
    </div>
  </g:eachError>
</g:hasErrors>
<g:form controller="ad" action="submit">
  <f:field bean="bean" property="heading"/>
  <f:field bean="bean" property="description"/>
  <f:field bean="bean" property="askingPrice"/>
  <f:field bean="bean" property="email"/>
  <g:submitButton name="submitButton" value="Submit"/>
</g:form>
</body>
</html>