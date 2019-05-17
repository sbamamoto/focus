package focus

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import java.util.UUID


class RunnerController {

    def generator = { String alphabet, int n ->
        new Random().with {
            (1..n).collect { alphabet[ nextInt( alphabet.length() ) ] }.join()
        }
    }


    def index () {
        def tests = Tests.findAll()
        def test = tests.get(0)
        println ("#### "+test)
        CompletedTest newTest = new CompletedTest()
        newTest.uuid = UUID.randomUUID().toString()
        newTest.testDate = new Date()
        newTest.test = test
        newTest.owner = "UNKNWON"
        newTest.save(failOnError: true, flush:true)
        [newTest:newTest]
    }

    def create() {
        def test = CompletedTest.find(params.testId)
        test.owner = params.name
        test.save(failOnError: true, flush:true)
        redirect (action:"run", params: [counter: test.test.answerCount, name:test.owner, completed:params.completed, testId:test.id])
    }

    def run () {

        def m =[][]
        int counter = params.counter as Integer
        int completed = params.completed as Integer
        def timestamp = new Date().getTime()
        def name = params.name

        completed+=1
        println "*************++ "+completed+" of "+counter
        

        0.upto(10) { j ->
            m.add([])
            0.upto(10) { i -> 
                m[j].add (generator( (('A'..'Z')+('0'..'9')).join(), 9 ))
            }
        }
        int x = Math.abs(new Random().nextInt()) % 10
        int y = Math.abs(new Random().nextInt()) % 10
        println "+++ Ecpected:"+m[x][y]
        if (completed <=     counter) {
            [m:m, x:x, y:y, counter:counter, completed:completed, name:name, timestamp:timestamp, testId:params.testId]
        }
        else {
            redirect(controller:"result",params: [name:params.name, testId:params.testId])
        }
    }


    def processing() {
        println params
        println "########## "+ params.testId
        def testId = params.testId
        def test = CompletedTest.findById(testId)
        def now = new Date().getTime()
        println "Took to answer: "+(now - params.timestamp.toLong())/1000
        def answer = new Answer()
        answer.name = params.name
        answer.answer = params.answer
        answer.expected = params.expected
        answer.secondsNeeded = (now - params.timestamp.toLong())/1000
        answer.count = params.counter as Integer
        test.addToAnswers(answer)
        test.save(failOnError: true, flush:true)
        redirect(action:"run", params: [counter: params.counter, name:params.name, completed:params.completed, testId:test.id])
    }
}