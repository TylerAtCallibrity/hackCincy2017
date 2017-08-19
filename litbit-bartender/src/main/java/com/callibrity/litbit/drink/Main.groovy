package com.callibrity.litbit.drink

import static spark.Spark.*

class Main {

    static void main(def args){
        def service = new DrinkService()

        get '/hello', {req, resp -> "hello world"}
        post '/drink', { req, resp -> service.getDrinks() }
    }
}
