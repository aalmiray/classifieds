<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <title></title>
</head>

<body>

<g:render template="/shared/errors" bean="${bean}"/>

<g:form controller="seller" action="subscribe">
  <fieldset>

    <div>
      <label for="name">
        Name
      </label>

      <g:textField name="name"
                   required=""
                   tabindex="1"
                   value="${bean?.name}"/>
    </div>

    <div>
      <label for="email">
        E-mail
      </label>

      <g:textField name="email"
                   email="true"
                   required=""
                   tabindex="2"
                   value="${bean?.email}"/>
    </div>

    <div>
      <label for="address.street">
        Street
      </label>

      <g:textField name="address.street"
                   required=""
                   tabindex="3"
                   value="${bean?.address?.street}"/>
    </div>

    <div>
      <label for="address.city">
        City
      </label>

      <g:textField name="address.city"
                   required=""
                   tabindex="4"
                   value="${bean?.address?.city}"/>
    </div>

    <div>
      <label for="address.country">
        Country
      </label>

      <g:textField name="address.country"
                   required=""
                   tabindex="5"
                   value="${bean?.address?.country}"/>
    </div>

  </fieldset>

  <g:submitButton name="submit" value="Submit"/>
</g:form>
</body>
</html>