package focus

import grails.test.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class CompletedTestServiceSpec extends Specification {

    CompletedTestService completedTestService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new CompletedTest(...).save(flush: true, failOnError: true)
        //new CompletedTest(...).save(flush: true, failOnError: true)
        //CompletedTest completedTest = new CompletedTest(...).save(flush: true, failOnError: true)
        //new CompletedTest(...).save(flush: true, failOnError: true)
        //new CompletedTest(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //completedTest.id
    }

    void "test get"() {
        setupData()

        expect:
        completedTestService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<CompletedTest> completedTestList = completedTestService.list(max: 2, offset: 2)

        then:
        completedTestList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        completedTestService.count() == 5
    }

    void "test delete"() {
        Long completedTestId = setupData()

        expect:
        completedTestService.count() == 5

        when:
        completedTestService.delete(completedTestId)
        sessionFactory.currentSession.flush()

        then:
        completedTestService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        CompletedTest completedTest = new CompletedTest()
        completedTestService.save(completedTest)

        then:
        completedTest.id != null
    }
}
