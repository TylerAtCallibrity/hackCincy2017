package com.callibrity.litbit.drink

import org.eclipse.jetty.util.log.Slf4jLog
import spark.Filter
import spark.Request
import spark.Response

import static spark.Spark.*

class Main {


    static void main(def args) {
        def service = new DrinkService()
        def logger = new Slf4jLog()

        before new Filter() {
            void handle(Request request, Response response) throws Exception {
                response.header("Access-Control-Allow-Origin", "*")
            }
        }

        //{ request, response -> response.header "Access-Control-Allow-Origin", "*" }

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
