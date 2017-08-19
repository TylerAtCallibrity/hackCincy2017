package com.callibrity.litbit.drink;

import org.junit.Before
import org.junit.Test

class DrinkServiceTest {
    def drinkService
    private
    final String OLD_FASHIONED_JSON_STRING = '{"data":{"drinks":[{"name":"Old Fashioned","ingredients":["Bourbon","Orange Peel","Bitters","Cherry","Sugar cube"],"instructions":"Twist the orange peel to release orange oils; add ice, cherry, orange peel, bitters, and sugar cube into glass muddle them together; pour bourbon into glass mix with bar spoon; strain over ice"}]},"status":"OK"}'

    @Before
    void all() {
        drinkService = new com.callibrity.litbit.drink.DrinkService()
    }

    @Test
    void should_have_static_drinks_method() {
        assert drinkService.getDrinks() == OLD_FASHIONED_JSON_STRING
    }
}
