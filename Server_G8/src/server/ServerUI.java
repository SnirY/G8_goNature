package server;

import javafx.application.Application;
import javafx.stage.Stage;
import mySQL.mysqlConnection;
import gui.ServerController;

public class ServerUI extends Application {
    private static EchoServer server;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        ServerController controller = new ServerController();
        controller.start(primaryStage);
    }

    public static void runServer(EchoServer echoServer) {
        if (server != null && server.isListening()) {
            System.out.println("Server is already running.");
            return;
        }
        server = echoServer;
        Thread serverThread = new Thread(server);
        serverThread.start();
    }

    public static void stopServer() {
        if (server != null && server.isListening()) {
            server.stopListening();
        }
    }

    public static boolean isServerUP() {
        return server != null && server.isListening();
    }
}