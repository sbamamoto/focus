<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <STYLE TYPE="text/css">
            TD{font-family: monospace; font-size: 14pt;}
        </STYLE>
    </head>
    <body>
        <div class="container">
            <h3> ${name} übertrage den Wert aus Spalte ${y+1} und Zeile ${x+1} in das Eingabefeld.</h3>
            
            <table>
                <g:each var="i" in="${ (0..<m.size()) }">
                    <tr>
                        <g:each var="j" in="${ (0..<m[i].size()) }">
                            <td style="fo">${m[i][j]}</td>   
                        </g:each>
                    </tr>
                </g:each>
            </table>
            <p style="valign:center;align:center;">
            <g:form name="myForm" action="processing" id="1">
                <g:field type="text" name="answer" id="answer" value="" autofocus="true"/>
                <g:field type="hidden" name="x" value="${x}"/>
                <g:field type="hidden" name="y" value="${y}"/>
                <g:field type="hidden" name="counter" value="${counter}"/>
                <g:field type="hidden" name="expected" value="${m[x][y]}"/>
                <g:field type="hidden" name="name" value="${name}"/>
                <g:field type="hidden" name="timestamp" value="${timestamp}"/>
                <g:field type="hidden" name="completed" value="${completed}"/>
                <g:field type="hidden" name="testId" value="${testId}"/>
                
                <g:submitButton name="save" value="Speichern" />
            </g:form>
            </p>

        </div>
    </body>

</html>