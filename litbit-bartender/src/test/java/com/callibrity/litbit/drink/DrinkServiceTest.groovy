package com.callibrity.litbit.drink

import groovy.json.JsonOutput;
import org.junit.Before
import org.junit.Test

class DrinkServiceTest {
    def drinkService
    private
    final String OLD_FASHIONED_JSON_STRING_RESP = '{"data":{"drinks":[{"name":"Old Fashioned","ingredients":["Bourbon","Orange","Bitters","Cherry","Sugar cube"],"instructions":"Twist the orange peel to release orange oils; add ice, cherry, orange peel, bitters, and sugar cube into glass muddle them together; pour bourbon into glass mix with bar spoon; strain over ice"}]},"status":"OK"}'
    final String DUMMY_REQUEST = JsonOutput.toJson([data :
                                                        [ingredients : [
                                                                "Bourbon",
                                                                "Orange",
                                                                "Bitters",
                                                                "Cherry",
                                                                "Sugar cube"
                                                        ]]
                                                    ])

    @Before
    void all() {
        drinkService = new com.callibrity.litbit.drink.DrinkService()
    }

    @Test
    void should_take_data_map_of_values() {
        println(DUMMY_REQUEST)
        assert drinkService.getDrinks(DUMMY_REQUEST) == OLD_FASHIONED_JSON_STRING_RESP
    }
}
