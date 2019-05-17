<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="main" />
    <asset:javascript src="Chart.min.js"/>
</head>

    <body>
        <div class="container">
            <div class="row">
                <table>
                    <tr>
                        <td>Test Durchläufe:</td><td> ${newTest.test.answerCount}</td>
                    </tr><tr>
                       <td>Test Time:</td><td> ${newTest.testDate}</td>
                    </tr><tr>
                        <td>Test Run:</td><td> ${newTest.uuid}</td>
                    </tr>
                </table>
            </div>
            <div class="row">
                <g:form action="run" id="1">
                    Bitte Testernamen eingeben:
                    <g:field type="text" name="name" id="name" value="" autofocus="true" placeholder="Rico"/>
                    <g:field type="hidden" name="testId" value="${newTest.id}"/>
                    <g:field type="hidden" name="counter" value="${newTest.test.answerCount}"/>
                    <g:field type="hidden" name="completed" value="0"/>
                    <g:submitButton name="start" value="Test starten" />
                </g:form>
            </div>
        </div>
    </body>
</html> 