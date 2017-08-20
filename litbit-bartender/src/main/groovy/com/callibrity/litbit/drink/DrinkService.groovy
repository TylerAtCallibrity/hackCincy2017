package com.callibrity.litbit.drink

import groovy.json.JsonOutput
import groovy.json.JsonSlurper
import groovy.sql.Sql
import org.eclipse.jetty.util.log.Slf4jLog

class DrinkService {

    static logger = new Slf4jLog()

    static final String DATABASE_URL = "jdbc:mysql://172.28.1.3:3306/drinks?useSSL=false"
    static final String DATABASE_USERNAME = "root"
    static final String DATABASE_PASSWORD = "root"

    static final String OLD_FASHIONED = JsonOutput.toJson([data  :
                                                                   [drinks:
                                                                            [[name        : "Old Fashioned",
                                                                              ingredients : [
                                                                                      "Bourbon",
                                                                                      "Orange",
                                                                                      "Bitters",
                                                                                      "Cherry",
                                                                                      "Sugar cube"
                                                                              ],
                                                                              instructions: "Twist the orange peel to release orange oils; add ice, cherry, orange peel, bitters, and sugar cube into glass muddle them together; pour bourbon into glass mix with bar spoon; strain over ice"

                                                                             ]]
                                                                   ],
                                                           status: "OK"
    ])

    static final String TEQUILA_OLD_FASHIONED = JsonOutput.toJson([data  :
                                                                           [drinks:
                                                                                    [[name        : "Old Fashioned",
                                                                                      ingredients : [
                                                                                              "Tequila",
                                                                                              "Orange",
                                                                                              "Bitters",
                                                                                              "Cherry",
                                                                                              "Agave Nectar"
                                                                                      ],
                                                                                      instructions: "Twist the orange peel to release orange oils; add ice, cherry, orange peel, bitters, and agave nectar into glass muddle them together; pour bourbon into glass mix with bar spoon; strain over ice"

                                                                                     ]]
                                                                           ],
                                                                   status: "OK"
    ])

    static final String DUMMY_REQUEST = JsonOutput.toJson([data:
                                                                   [ingredients: [
                                                                           "Orange juice",
                                                                           "cranberry juice",
                                                                           "vodka",
                                                                   ]]
    ])


    static String getDrinks(def requestData) {
        if (!requestData) {
            return JsonOutput.toJson([data: [], status: "Fail", failureReason: "Request data cannot be null"])
        }
        try {
            def sql = Sql.newInstance(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD)
            def slurper = new JsonSlurper()
            def result = slurper.parseText(requestData)
            def query = """SELECT *
                        FROM drinks AS d
                        WHERE
                        (SELECT COUNT(di.ingredient_id)
                        FROM drinks_ingredients di
                        WHERE di.drink_id = d.drink_id AND
                        NOT FIND_IN_SET(di.ingredient_id, (select GROUP_CONCAT(ingredient_id) from ingredients where ingredient_name like '""" + result.data.ingredients[0].toLowerCase() + "' "
            for (def i = 1; i < result.data.ingredients.size; i++) {
                query += "OR ingredient_name LIKE '${result.data.ingredients[i].toLowerCase()}' "
            }
            query += '))) < 1;'

            def jsonOutput = [data: [drinks: [:]], status: 'OK']
            println("TWRR >>>> query=${query}")
            def drinks = [[:]]
            sql.eachRow(query) { row ->
                println "Row: drink_id = ${row.drink_id} and drink_name = ${row.drink_name} and drink_instructions = ${row.description}"
                drinks.add(([name: row.drink_name, instructions: row.description]))
            }
            jsonOutput.data.drinks = drinks
            return JsonOutput.toJson(jsonOutput)
            sql.close()

        }
        catch (Exception e) {
            logger.warn("Encountered an error while attempting to fetch drinks ${e.printStackTrace()}")
            return JsonOutput.toJson([data: [], status: "Fail", failureReason: "Unable to find your drinks; please try again."])
        }
    }

//    static callDB(){
//
//
//        def slurper = new JsonSlurper()
//        def reqJson = slurper.parseText(DUMMY_REQUEST)
//        def query = """SELECT *
//                        FROM drinks AS d
//                        WHERE
//                        (SELECT COUNT(di.ingredient_id)
//                        FROM drinks_ingredients di
//                        WHERE di.drink_id = d.drink_id AND
//                        NOT FIND_IN_SET(di.ingredient_id, (select GROUP_CONCAT(ingredient_id) from ingredients where ingredient_name like '""" + reqJson.data.ingredients[0].toLowerCase() + "' "
//        for (def i = 1; i < reqJson.data.ingredients.size; i++){
//            query += "OR ingredient_name LIKE '${reqJson.data.ingredients[i].toLowerCase()}' "
//        }
//        query += '))) < 1;'
//
//        def jsonOutput = [data : [drinks : [:]], status: 'OK']
//        println("TWRR >>>> query=${query}")
//        def drinks = [[:]]
//        sql.eachRow(query){ row ->
//            println "Row: drink_id = ${row.drink_id} and drink_name = ${row.drink_name} and drink_instructions = ${row.description}"
//            drinks.add(([name: row.drink_name, instructions: row.description]))
//        }
//        jsonOutput.data.drinks = drinks
//        println(JsonOutput.toJson(jsonOutput))
//        sql.close()
//
//    }

}
