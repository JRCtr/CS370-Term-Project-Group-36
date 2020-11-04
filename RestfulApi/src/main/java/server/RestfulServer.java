package server;

import spark.Spark;
import spark.Request;
import spark.Response;

public class RestfulServer{
    public RestfulServer(){
        this.configApi();
        this.processApiRequests();
    }

    private void configApi() {
        Spark.port(8080);
        System.out.println("Server set to listen on port 8080");
    }

    private void processApiRequests(){
        Spark.get("/",this::echoRequest);
    }

    private String echoRequest(Request request, Response response){
        response.type("application/json");
        response.header("Access-Control-Allow-Orgin", "*");
        response.status(200);

        return printBody(request);
    }

    private String printBody(Request request){
       return "Request received with body: " + request.body() + "\n";
    }

    public static void main(String[] args){
        RestfulServer restfulServer = new RestfulServer();


    }
}
