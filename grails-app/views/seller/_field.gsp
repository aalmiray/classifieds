<div>
  <label for="${field.name}">
    ${field.label}
  </label>

  <g:textField name="${field.name}"
               required=""
               tabindex="${tabIndex}"
               value="${command?.getAt(field.name)}"/>
</div>