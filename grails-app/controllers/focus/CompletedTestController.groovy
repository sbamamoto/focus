package focus

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class CompletedTestController {

    CompletedTestService completedTestService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond completedTestService.list(params), model:[completedTestCount: completedTestService.count()]
    }

    def show(Long id) {
        respond completedTestService.get(id)
    }

    def create() {
        respond new CompletedTest(params)
    }

    def save(CompletedTest completedTest) {
        if (completedTest == null) {
            notFound()
            return
        }

        try {
            completedTestService.save(completedTest)
        } catch (ValidationException e) {
            respond completedTest.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'completedTest.label', default: 'CompletedTest'), completedTest.id])
                redirect completedTest
            }
            '*' { respond completedTest, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond completedTestService.get(id)
    }

    def update(CompletedTest completedTest) {
        if (completedTest == null) {
            notFound()
            return
        }

        try {
            completedTestService.save(completedTest)
        } catch (ValidationException e) {
            respond completedTest.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'completedTest.label', default: 'CompletedTest'), completedTest.id])
                redirect completedTest
            }
            '*'{ respond completedTest, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        completedTestService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'completedTest.label', default: 'CompletedTest'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'completedTest.label', default: 'CompletedTest'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
