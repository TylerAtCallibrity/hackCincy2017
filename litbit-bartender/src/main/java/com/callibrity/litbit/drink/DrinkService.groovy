package com.callibrity.litbit.drink

import groovy.json.JsonOutput

class DrinkService {

    static final String OLD_FASHIONED = JsonOutput.toJson([data  :
                                                                   [drinks:
                                                                            [[name        : "Old Fashioned",
                                                                              ingredients : [
                                                                                      "Bourbon",
                                                                                      "Orange Peel",
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
                                                                                              "Bourbon",
                                                                                              "Orange Peel",
                                                                                              "Bitters",
                                                                                              "Cherry",
                                                                                              "Agave Nectar"
                                                                                      ],
                                                                                      instructions: "Twist the orange peel to release orange oils; add ice, cherry, orange peel, bitters, and agave nectar into glass muddle them together; pour bourbon into glass mix with bar spoon; strain over ice"

                                                                                     ]]
                                                                           ],
                                                                   status: "OK"
    ])


    static String getDrinks() {
        return OLD_FASHIONED
    }
}
