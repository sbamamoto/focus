package focus

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*


class ResultController {

    def generator = { String alphabet, int n ->
        new Random().with {
            (1..n).collect { alphabet[ nextInt( alphabet.length() ) ] }.join()
        }
    }


    def index () {
        def test = CompletedTest.findById(params.testId)
        int fails = 0
        test.answers.each() {
            if (it.answer!=it.expected) {
                fails+=1
            }
        }
        [name:test.owner, fails:fails, uuid:test.uuid, date:test.testDate]
    }

}