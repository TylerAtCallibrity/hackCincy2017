@Grab(group = 'com.sparkjava', module = 'spark-core', version = '2.1')
import static spark.Spark.*

println("Configuring server...")
def service = new DrinkService()

get '/hello', { req, resp -> 'Hello World' }
post '/drink', { req, resp -> service.getDrink() }