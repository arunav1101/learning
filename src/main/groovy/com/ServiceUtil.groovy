package com

import org.apache.commons.logging.LogFactory

class ServiceUtil {
    def log = LogFactory.getLog(getClass())

    static Properties getAllProperties() {
        Properties properties = new Properties()
        File propertiesFile = new File("build/resources/test/swapitest.properties")
        propertiesFile.withInputStream {
            properties.load(it)
        }
        return properties
   }

    def serviceHelper(boolean assertions, Closure serviceCallBlock, int expectedStatus) {
        def response

        try {
            response = serviceCallBlock()
        } catch (Exception e) {
            log.error(e.message)
            response = e.response
        }
        if (expectedStatus != 200) {
            sleep(1000) // changing things takes time
        }
        assert response != null
        log.info(response.properties.collect { it }.join(';'))
        if (assertions) {
            assert response.status == expectedStatus
        }
        return response
    }

}
