package focus

import grails.test.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class MeasuresServiceSpec extends Specification {

    MeasuresService measuresService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Measures(...).save(flush: true, failOnError: true)
        //new Measures(...).save(flush: true, failOnError: true)
        //Measures measures = new Measures(...).save(flush: true, failOnError: true)
        //new Measures(...).save(flush: true, failOnError: true)
        //new Measures(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //measures.id
    }

    void "test get"() {
        setupData()

        expect:
        measuresService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Measures> measuresList = measuresService.list(max: 2, offset: 2)

        then:
        measuresList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        measuresService.count() == 5
    }

    void "test delete"() {
        Long measuresId = setupData()

        expect:
        measuresService.count() == 5

        when:
        measuresService.delete(measuresId)
        sessionFactory.currentSession.flush()

        then:
        measuresService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Measures measures = new Measures()
        measuresService.save(measures)

        then:
        measures.id != null
    }
}
