package com.callibrity.litbit.drink

import groovy.json.JsonOutput
import groovy.json.JsonSlurper
import org.eclipse.jetty.util.log.Slf4jLog

class DrinkService {

    static logger = new Slf4jLog()

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


    static String getDrinks(def requestData) {
        if (!requestData){
            return JsonOutput.toJson([data: [], status: "Fail", failureReason: "Request data cannot be null"])
        }
        try {
            def slurper = new JsonSlurper()
            def result = slurper.parseText(requestData)
            if (result.data.ingredients.contains("Bourbon")) {
                return OLD_FASHIONED
            }
            TEQUILA_OLD_FASHIONED
        }
        catch (Exception e){
            logger.warn("Encountered an error while attempting to fetch drinks")
            return JsonOutput.toJson([data: [], status: "Fail", failureReason: "Unable to find your drinks; please try again."])
        }
    }
}
