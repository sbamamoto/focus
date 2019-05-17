package focus

import grails.test.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class TestsServiceSpec extends Specification {

    TestsService testsService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Tests(...).save(flush: true, failOnError: true)
        //new Tests(...).save(flush: true, failOnError: true)
        //Tests tests = new Tests(...).save(flush: true, failOnError: true)
        //new Tests(...).save(flush: true, failOnError: true)
        //new Tests(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //tests.id
    }

    void "test get"() {
        setupData()

        expect:
        testsService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Tests> testsList = testsService.list(max: 2, offset: 2)

        then:
        testsList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        testsService.count() == 5
    }

    void "test delete"() {
        Long testsId = setupData()

        expect:
        testsService.count() == 5

        when:
        testsService.delete(testsId)
        sessionFactory.currentSession.flush()

        then:
        testsService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Tests tests = new Tests()
        testsService.save(tests)

        then:
        tests.id != null
    }
}
