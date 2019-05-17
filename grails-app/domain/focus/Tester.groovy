package focus

class Tester {
    String name
    int neededPerTest
    int errorCount
    int testCount
    static constraints = {
    }

    static hasMany = [
        tests:CompletedTest
        ]
}   