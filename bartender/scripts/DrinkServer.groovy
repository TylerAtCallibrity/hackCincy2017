@Grab(group = 'com.sparkjava', module = 'spark-core', version = '2.1')
import static spark.Spark.*

println("Configuring server...")

get '/hello', {req, resp -> 'Hello World'}