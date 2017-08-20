package com.callibrity.litbit.drink

import groovy.json.JsonOutput
import groovy.json.JsonSlurper;
import org.junit.Before
import org.junit.Test

class DrinkServiceTest {
    def drinkService
    def slurper
//    def expected = new ExpectException()
    final String OLD_FASHIONED_JSON_STRING_RESP = '{"data":{"drinks":[{"name":"Old Fashioned","ingredients":["Bourbon","Orange","Bitters","Cherry","Sugar cube"],"instructions":"Twist the orange peel to release orange oils; add ice, cherry, orange peel, bitters, and sugar cube into glass muddle them together; pour bourbon into glass mix with bar spoon; strain over ice"}]},"status":"OK"}'
    final String DUMMY_REQUEST = JsonOutput.toJson([data :
                                                        [ingredients : [
                                                                "cranberry juice",
                                                                "orange juice",
                                                                "vodka"
                                                        ]]
                                                    ])

    @Before
    void all() {
        drinkService = new com.callibrity.litbit.drink.DrinkService()
        slurper = new JsonSlurper()
    }

    @Test
    void should_take_data_map_of_values() {
        println(DUMMY_REQUEST)
        assert drinkService.getDrinks(DUMMY_REQUEST) == OLD_FASHIONED_JSON_STRING_RESP
    }

    @Test
    void should_handle_null(){
        def resp = slurper.parseText(drinkService.getDrinks(null))
        assert resp.status && resp.status == "Fail"
        assert resp.failureReason && resp.failureReason == "Request data cannot be null"
    }

    @Test
    void should_handle_bad_request(){
        def reqData = JsonOutput.toJson([authorization: "This iz tyrone"])
        def resp = slurper.parseText(drinkService.getDrinks(reqData))

        assert resp.status && resp.status == "Fail"
        assert resp.failureReason && resp.failureReason == "Unable to find your drinks; please try again."
    }

    @Test
    void should_call_db(){
        drinkService.callDB()
    }

    @Test
    void should_print(){
        println(DUMMY_REQUEST)
    }

}
