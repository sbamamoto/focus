package focus

import grails.gorm.services.Service

@Service(Tests)
interface TestsService {

    Tests get(Serializable id)

    List<Tests> list(Map args)

    Long count()

    void delete(Serializable id)

    Tests save(Tests tests)

}