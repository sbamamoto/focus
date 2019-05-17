package focus

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class TestsController {

    TestsService testsService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        respond Tests.findAll()
        
    }

    def show(Long id) {
        respond testsService.get(id)
    }

    def create() {
        respond new Tests(params)
    }

    def save(Tests tests) {
        if (tests == null) {
            notFound()
            return
        }

        try {
            println tests.save()
            //testsService.save(tests)
        } catch (ValidationException e) {
            respond tests.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'tests.label', default: 'Tests'), tests.id])
                redirect tests
            }
            '*' { respond tests, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond testsService.get(id)
    }

    def update(Tests tests) {
        if (tests == null) {
            notFound()
            return
        }

        try {
            testsService.save(tests)
        } catch (ValidationException e) {
            respond tests.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'tests.label', default: 'Tests'), tests.id])
                redirect tests
            }
            '*'{ respond tests, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        testsService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'tests.label', default: 'Tests'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'tests.label', default: 'Tests'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
