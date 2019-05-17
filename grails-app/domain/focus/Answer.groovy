package focus

class Answer {
    String name
    String answer
    String expected
    int secondsNeeded
    int count
    
    static constraints = {
    }

    static belongsTo = [completedTest:CompletedTest]
}
