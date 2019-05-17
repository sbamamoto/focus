package focus

class CompletedTest {
    Date testDate
    String uuid
    Tests test
    String owner

    static constraints = {
    }

    static hasMany = [
        answers:Answer
    ]
}
