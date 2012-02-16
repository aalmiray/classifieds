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