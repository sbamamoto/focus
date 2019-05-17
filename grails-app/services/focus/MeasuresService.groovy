package focus

import grails.gorm.services.Service

@Service(Measures)
interface MeasuresService {

    Measures get(Serializable id)

    List<Measures> list(Map args)

    Long count()

    void delete(Serializable id)

    Measures save(Measures measures)

}