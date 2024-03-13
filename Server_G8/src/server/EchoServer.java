package server;

import ocsf.server.AbstractServer;
import ocsf.server.ConnectionToClient;

import java.sql.Connection;

/**
 * The EchoServer class extends AbstractServer and implements a simple
 * echo server functionality. It receives messages from clients and broadcasts
 * them to all connected clients.
 */
public class EchoServer extends AbstractServer {
    private Connection conn;

    /**
     * Constructs a new EchoServer instance.
     *
     * @param port The port number to listen on.
     * @param conn The database connection.
     */
    public EchoServer(int port, Connection conn) {
        super(port);
        this.conn = conn;
    }

    /**
     * This method handles any messages received from the client.
     *
     * @param msg    The message received from the client.
     * @param client The connection from which the message originated.
     */
    @Override
    protected void handleMessageFromClient(Object msg, ConnectionToClient client) {
        System.out.println("Message received: " + msg + " from " + client);
        this.sendToAllClients(msg);
    }

    /**
     * This method is called when the server starts listening for connections.
     */
    @Override
    protected void serverStarted() {
        System.out.println("Server listening for connections on port " + getPort());
    }

    /**
     * This method is called when the server stops listening for connections.
     */
    @Override
    protected void serverStopped() {
        System.out.println("Server has stopped listening for connections.");
    }
}
