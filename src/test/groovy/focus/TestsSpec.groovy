package focus

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class TestsSpec extends Specification implements DomainUnitTest<Tests> {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        expect:"fix me"
            true == false
    }
}
