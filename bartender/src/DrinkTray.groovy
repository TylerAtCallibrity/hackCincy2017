import groovy.json.JsonOutput

class DrinkTray {

    String serve() {
        return JsonOutput.toJson([hello: "world"])
    }
}
