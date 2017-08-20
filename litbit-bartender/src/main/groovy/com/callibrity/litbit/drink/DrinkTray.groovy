package com.callibrity.litbit.drink

import groovy.json.JsonOutput

class DrinkTray {

    String serve() {
        return JsonOutput.toJson([hello: "world"])
    }
}
