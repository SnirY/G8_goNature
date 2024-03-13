// ServerController.java

package gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import server.EchoServer;
import server.ServerUI;
import mySQL.mysqlConnection;
import gui.ServerController;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ServerController implements Initializable {

    @FXML
    private Button btnConnect;

    @FXML
    private TextField dbhost;

    @FXML
    private Button btnDisonnect;

    @FXML
    private TextField dbusername;

    @FXML
    private PasswordField dbpass;

    @FXML
    private TextField dbscheme;

    @FXML
    private TextField dbport;

    @FXML
    private Button btnStart;

    @FXML
    private Button stopServer;

    @FXML
    private TextField serverport;

    @FXML
    private TextArea logUpdate;

    @FXML
    void connect(ActionEvent event) {
        ArrayList<String> str = new ArrayList<String>();
        str.add(getHost());
        str.add(getDBport());
        str.add(getScheme());
        str.add(getUsername());
        str.add(getPassword());
        mysqlConnection.connectToDB(str);
        if (mysqlConnection.isDBup()) {
            btnDisonnect.setDisable(false);
            btnConnect.setDisable(true);
        }
    }

    @FXML
    void disonnect(ActionEvent event) {
        mysqlConnection.disconnectFromDB();
        if (!mysqlConnection.isDBup()) {
            btnDisonnect.setDisable(true);
            btnConnect.setDisable(false);
        }
    }

    @FXML
    void startServerBtn(ActionEvent event) {
        Connection con = mysqlConnection.getConnection();
        EchoServer sv = new EchoServer(Integer.parseInt(getServerPort()), con);
        ServerUI.runServer(sv);
        if (ServerUI.isServerUP()) {
            stopServer.setDisable(false);
            btnStart.setDisable(true);
        }
    }

    @FXML
    void stopServerBtn(ActionEvent event) {
        ServerUI.stopServer();
        if (!ServerUI.isServerUP()) {
            stopServer.setDisable(true);
            btnStart.setDisable(false);
        }
    }

    public void logIt(String str) {
        logUpdate.appendText(str + "\n");
    }

    public String getHost() {
        return dbhost.getText();
    }

    public String getUsername() {
        return dbusername.getText();
    }

    public String getPassword() {
        return dbpass.getText();
    }

    public String getDBport() {
        return dbport.getText();
    }

    public String getScheme() {
        return dbscheme.getText();
    }

    public String getServerPort() {
        return serverport.getText();
    }

    @SuppressWarnings("exports")
	public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/Server.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        primaryStage.setTitle("Server");
        primaryStage.setScene(scene);
        primaryStage.show();

        primaryStage.setOnCloseRequest((WindowEvent t) -> {
            System.out.println("emergency exit");
            if (ServerUI.isServerUP())
                ServerUI.stopServer();
            if (mysqlConnection.isDBup())
                mysqlConnection.disconnectFromDB();
            System.exit(0);
        });
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        dbhost.setText("localhost");
        dbusername.setText("root");
        dbpass.setText("Aa12345");
        dbscheme.setText("dbtest");
        dbport.setText("3306");
        serverport.setText("5555");
        btnDisonnect.setDisable(true);
        stopServer.setDisable(true);
    }
}
