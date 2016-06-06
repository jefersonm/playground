package helloWorld;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Vertx;

public class HelloWorld extends AbstractVerticle {

    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        vertx.deployVerticle(HelloWorld.class.getName());
    }

    public void start(Future<Void> fut) {
        vertx
                .createHttpServer()
                .requestHandler(req -> req.response().end("My first Vert.x application"))
                .listen(8080, handler -> {
                    if (handler.succeeded()) {
                        System.out.println("http://localhost:8080");
                    } else {
                        System.err.println("Failed to listen on port 8080");
                    }
                });
    }

}
