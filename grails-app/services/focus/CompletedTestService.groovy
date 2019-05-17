package focus

import grails.gorm.services.Service

@Service(CompletedTest)
interface CompletedTestService {

    CompletedTest get(Serializable id)

    List<CompletedTest> list(Map args)

    Long count()

    void delete(Serializable id)

    CompletedTest save(CompletedTest completedTest)

}