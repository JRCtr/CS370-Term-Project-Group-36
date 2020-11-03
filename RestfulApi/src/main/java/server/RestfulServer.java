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

        return HttpRequestToJson(request);
    }

    private String HttpRequestToJson(Request request){
        return "{\n"
                + "\"attributes\":\"" + request.attributes() + "\",\n"
                + "\"body\":\"" + request.body() + "\",\n"
                + "\"contentLength\":\"" + request.contentLength() + "\",\n"
                + "\"contentType\":\"" + request.contentType() + "\",\n"
                + "\"contextPath\":\"" + request.contextPath() + "\",\n"
                + "\"cookies\":\"" + request.cookies() + "\",\n"
                + "\"headers\":\"" + request.headers() + "\",\n"
                + "\"host\":\"" + request.host() + "\",\n"
                + "\"ip\":\"" + request.ip() + "\",\n"
                + "\"params\":\"" + request.params() + "\",\n"
                + "\"pathInfo\":\"" + request.pathInfo() + "\",\n"
                + "\"serverPort\":\"" + request.port() + "\",\n"
                + "\"protocol\":\"" + request.protocol() + "\",\n"
                + "\"queryParams\":\"" + request.queryParams() + "\",\n"
                + "\"requestMethod\":\"" + request.requestMethod() + "\",\n"
                + "\"scheme\":\"" + request.scheme() + "\",\n"
                + "\"servletPath\":\"" + request.servletPath() + "\",\n"
                + "\"session\":\"" + request.session() + "\",\n"
                + "\"uri()\":\"" + request.uri() + "\",\n"
                + "\"url()\":\"" + request.url() + "\",\n"
                + "\"userAgent\":\"" + request.userAgent() + "\",\n"
                + "}";
    }

    public static void main(String[] args){
        RestfulServer restfulServer = new RestfulServer();


    }
}
