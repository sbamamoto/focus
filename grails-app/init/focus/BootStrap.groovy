package focus

class BootStrap {

    def init = { servletContext ->
        new Tests (colCount:10, rowCount:8, lenSymbols:8, answerCount:5).save()
        new Tester (name:"Dev", neededPerTest:0, errorCount:0, testCount:0).save()
    }
    def destroy = {
    }
}
