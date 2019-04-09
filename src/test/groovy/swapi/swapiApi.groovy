package swapi


import base.BaseTestSpec

//import com.ServiceUtil

//import org.apache.commons.logging.LogFactory




/**
 * Swapi API Test
 * * Created by agup18 on 04/08/19.
 */


class swapiApi extends BaseTestSpec {

    def mySwapi = new com.util();

    def "01. Get Swapi details"() {
        when: "I query the Swapi service"

        def swapiSearch = mySwapi.search(true)

        then: "I get back the details"
//        log.info(swapiSearch.status)

        swapiSearch.status == 200
        // Validate the length of response
        def swapiArray = swapiSearch.data.results
        def myLength = swapiArray.size
        assert (myLength > 0 && myLength <= 10)
        assert (swapiSearch.data.containsKey('count'))
        assert (swapiSearch.data.containsKey('next'))
        assert (swapiSearch.data.containsKey('previous'))

        // Validate all properties exists in the list

        for (item in swapiArray) {
            assert (item.containsKey('climate'))
            assert (item.containsKey('created'))
            assert (item.containsKey('diameter'))
            assert (item.containsKey('edited'))
            assert (item.containsKey('films'))
            assert (item.containsKey('gravity'))
            assert (item.containsKey('orbital_period'))
            assert (item.containsKey('population'))
            assert (item.containsKey('residents'))
            assert (item.containsKey('rotation_period'))
            assert (item.containsKey('surface_water'))
            assert (item.containsKey('terrain'))
            assert (item.containsKey('url'))
        }

        // Validate Type of properties

        for (item in swapiArray) {
            assert (item.climate) instanceof String
            assert (item.created) instanceof String
            assert (item.diameter) instanceof String
            assert (item.edited) instanceof String
            assert (item.films) instanceof Object
            assert (item.gravity) instanceof String
            assert (item.orbital_period) instanceof String
            assert (item.population) instanceof String
            assert (item.residents) instanceof Object
            assert (item.rotation_period) instanceof String
            assert (item.surface_water) instanceof String
            assert (item.terrain) instanceof String
            assert (item.url) instanceof String
        }
    }
    def "02. Get Swapi details by id"() {
        when: "I query the Swapi service by id"
        def myUri = '1';
        def swapiSearch = mySwapi.searchById(true,myUri)

        then: "I get back the details as per ID"
        swapiSearch.status == 200

        // Validate the length of response
        def swapiArray = swapiSearch.data

        // Validate all properties exists in the list

            assert (swapiArray.containsKey('climate'))
            assert (swapiArray.containsKey('created'))
            assert (swapiArray.containsKey('diameter'))
            assert (swapiArray.containsKey('edited'))
            assert (swapiArray.containsKey('films'))
            assert (swapiArray.containsKey('gravity'))
            assert (swapiArray.containsKey('orbital_period'))
            assert (swapiArray.containsKey('population'))
            assert (swapiArray.containsKey('residents'))
            assert (swapiArray.containsKey('rotation_period'))
            assert (swapiArray.containsKey('surface_water'))
            assert (swapiArray.containsKey('terrain'))
            assert (swapiArray.containsKey('url'))
            assert (swapiArray.url == "https://swapi.co/api/planets/${myUri}/")
    }
}