package com.callibrity.litbit.drink

import org.eclipse.jetty.util.log.Slf4jLog

import static spark.Spark.get
import static spark.Spark.post

class Main {


    static void main(def args) {
        def service = new DrinkService()
        def logger = new Slf4jLog()

        get '/hello', { req, resp -> "hello world" }
        post '/drink', { req, resp ->
            try {
                logger.info("Processing request. requestBody=${req.body()}")
                service.getDrinks(req.body())
            }
            catch (Exception e) {
                logger.warn("Caught a fatal error while trying to process request; request=${req.raw()} stack=${e.printStackTrace()}")
            }

        }
    }
}
