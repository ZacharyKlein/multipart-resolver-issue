<html>

<body>
<h1>Upload</h1>


<g:if test="${flash.message}">
    <h2>${flash.message}</h2>
</g:if>

<g:if test="${uploadInstance.hasErrors()}">
    <h2>Errors!</h2>
</g:if>

<g:uploadForm name="uploadForm" action="save">
    <input type="file" name="file" />
    <fieldset class="buttons">
        <input class="save" type="submit" value="${message(code: 'restaurant.featuredImage.upload.label', default: 'Upload')}" />
    </fieldset>
</g:uploadForm>
</body>

</html>