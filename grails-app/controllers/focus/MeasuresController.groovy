package focus

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class MeasuresController {

    MeasuresService measuresService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond measuresService.list(params), model:[measuresCount: measuresService.count()]
    }

    def show(Long id) {
        respond measuresService.get(id)
    }

    def create() {
        respond new Measures(params)
    }

    def save(Measures measures) {
        if (measures == null) {
            notFound()
            return
        }

        try {
            measuresService.save(measures)
        } catch (ValidationException e) {
            respond measures.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'measures.label', default: 'Measures'), measures.id])
                redirect measures
            }
            '*' { respond measures, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond measuresService.get(id)
    }

    def update(Measures measures) {
        if (measures == null) {
            notFound()
            return
        }

        try {
            measuresService.save(measures)
        } catch (ValidationException e) {
            respond measures.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'measures.label', default: 'Measures'), measures.id])
                redirect measures
            }
            '*'{ respond measures, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        measuresService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'measures.label', default: 'Measures'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'measures.label', default: 'Measures'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
