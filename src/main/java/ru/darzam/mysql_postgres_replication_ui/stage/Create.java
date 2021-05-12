package ru.darzam.mysql_postgres_replication_ui.stage;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import ru.darzam.mysql_postgres_replication_ui.css.Css;
import ru.darzam.mysql_postgres_replication_ui.css.Icons;
import ru.darzam.mysql_postgres_replication_ui.datasource.DatasourceConfiguration;
import ru.darzam.mysql_postgres_replication_ui.datasource.DbManager;
import ru.darzam.mysql_postgres_replication_ui.datasource.JavaFxDatasourceConfiguration;
import ru.darzam.mysql_postgres_replication_ui.exception.JavaFxException;

import javax.swing.*;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;

/**
 * @author zamaliev
 */
public class Create extends Stage {

  private final ResourceBundle bundle = ResourceBundle.getBundle("bundle", Locale.getDefault());
  private final JavaFxDatasourceConfiguration mysqlJavaFxDatasourceConfiguration;
  private final JavaFxDatasourceConfiguration postgresJavaFxDatasourceConfiguration;
  private final DbManager dbManager;

  @FXML
  private TextField mysqlDbHostTextView;
  @FXML
  private TextField mysqlDbPortTextView;
  @FXML
  private TextField mysqlDbNameTextView;
  @FXML
  private TextField mysqlDbUserNameTextView;
  @FXML
  private TextField mysqlDbUserPasswordTextView;
  @FXML
  private VBox mysqlVbox;

  @FXML
  private TextField postgresDbHostTextView;
  @FXML
  private TextField postgresDbPortTextView;
  @FXML
  private TextField postgresDbNameTextView;
  @FXML
  private TextField postgresDbUserNameTextView;
  @FXML
  private TextField postgresDbUserPasswordTextView;
  @FXML
  private VBox postgresqlVbox;

  public Create() {
    initOwner(Primary.getPrimaryStage());
    this.dbManager = new DbManager();
    this.mysqlJavaFxDatasourceConfiguration = new JavaFxDatasourceConfiguration();
    this.postgresJavaFxDatasourceConfiguration = new JavaFxDatasourceConfiguration();
    try {
      FXMLLoader fxmlLoader = new FXMLLoader(Create.class.getResource("/ui/create.fxml"));
      fxmlLoader.setResources(bundle);
      fxmlLoader.setController(this);
      BorderPane root = fxmlLoader.load();
      bind();
      Scene scene = new Scene(root, 800, 400);
      scene.getStylesheets().add(Css.DEFAULT_CSS);
      setScene(scene);
      setResizable(false);
      setTitle(bundle.getString("welcome.screen.title"));
    }
    catch (IOException e) {
      throw new RuntimeException(e.getMessage(), e);
    }
  }

  public void bind () {
    this.mysqlDbHostTextView.textProperty().bindBidirectional(this.mysqlJavaFxDatasourceConfiguration.hostProperty());
    this.mysqlDbPortTextView.textProperty().bindBidirectional(this.mysqlJavaFxDatasourceConfiguration.portProperty(), new StringConverter<Number>() {
      @Override
      public String toString(Number object) {
        return object.toString();
      }

      @Override
      public Number fromString(String string) {
        return !mysqlDbPortTextView.getText().isEmpty() ? Integer.parseInt(mysqlDbPortTextView.getText()) : null;
      }
    });
    this.mysqlDbNameTextView.textProperty().bindBidirectional(this.mysqlJavaFxDatasourceConfiguration.dbNameProperty());
    this.mysqlDbUserNameTextView.textProperty().bindBidirectional(this.mysqlJavaFxDatasourceConfiguration.userProperty());
    this.mysqlDbUserPasswordTextView.textProperty().bindBidirectional(this.mysqlJavaFxDatasourceConfiguration.passwordProperty());

    this.postgresDbHostTextView.textProperty().bindBidirectional(this.postgresJavaFxDatasourceConfiguration.hostProperty());
    this.postgresDbPortTextView.textProperty().bindBidirectional(this.postgresJavaFxDatasourceConfiguration.portProperty(), new StringConverter<Number>() {
      @Override
      public String toString(Number object) {
        return object.toString();
      }

      @Override
      public Number fromString(String string) {
        return !postgresDbPortTextView.getText().isEmpty() ? Integer.parseInt(postgresDbPortTextView.getText()) : null;
      }
    });
    this.postgresDbNameTextView.textProperty().bindBidirectional(this.postgresJavaFxDatasourceConfiguration.dbNameProperty());
    this.postgresDbUserNameTextView.textProperty().bindBidirectional(this.postgresJavaFxDatasourceConfiguration.userProperty());
    this.postgresDbUserPasswordTextView.textProperty().bindBidirectional(this.postgresJavaFxDatasourceConfiguration.passwordProperty());
  }


  public void mysqlUpdate() {
    DatasourceConfiguration datasource = new DatasourceConfiguration();
    datasource.setHost(mysqlDbHostTextView.getText());
    Integer port = mysqlDbPortTextView.getText() != null && !mysqlDbPortTextView.getText().isEmpty() ?
        Integer.parseInt(mysqlDbPortTextView.getText()) :
        null;
    datasource.setPort(port);
    datasource.setDbName(mysqlDbNameTextView.getText());
    datasource.setUser(mysqlDbUserNameTextView.getText());
    datasource.setPassword(mysqlDbUserPasswordTextView.getText());
    datasource.setDriverClassName("com.mysql.cj.jdbc.Driver");
    datasource.setUrl("jdbc:mysql:" + "//" + datasource.getHost() + ":" + datasource.getPort() + "/" + datasource.getDbName());
    try {
      datasource.setDbBeanPackage(Files.createTempDirectory("db-package").toString());
      dbManager.testConnection(datasource);
    }
    catch (Exception e) {
      throw new JavaFxException(bundle.getString("db.connection.error.msg"), e);
    }
    mysqlVbox.getChildren().clear();
    BorderPane borderPane = new BorderPane();
    ImageView imageView = new ImageView(Icons.SUCCESS_CONNECTION);
    BorderPane.setAlignment(imageView, Pos.CENTER);
    BorderPane.setMargin(imageView, new Insets(100,100,100,100)); // optional
    borderPane.setCenter(imageView);
    mysqlVbox.getChildren().addAll(borderPane);

//    SelectSchemaDlg selectSchemaDlg = new SelectSchemaDlg(getIdeWindow(), internalDatabaseManager, datasource);
//    Optional<List<String>> selectedSchemas = selectSchemaDlg.showAndWait();
//    if (!selectedSchemas.isPresent()) {
//      return;
//    }
//    datasource.setSchemas(selectedSchemas.get());
//    progressManager.executeWithDialog(() -> {
//      // generate
//      try {
//        internalDatabaseManager.generateDbClasses(datasource);
//      }
//      catch (Exception e) {
//        throw new ProcessException(DatabaseBundle.message("generate.db.beans.error.msg"), e);
//      }
//      // save datasourse
//      try {
//        internalDatabaseManager.saveDatasource(datasource);
//      }
//      catch (Exception e) {
//        throw new ProcessException(DatabaseBundle.message("save.datasource.error.msg"), e);
//      }
//    }, DatabaseBundle.message("saving.db.info"), false);
  }

  public void postgresSqlUpdate() {
    DatasourceConfiguration datasource = new DatasourceConfiguration();
    datasource.setHost(postgresDbHostTextView.getText());
    Integer port = postgresDbPortTextView.getText() != null && !postgresDbPortTextView.getText().isEmpty() ?
        Integer.parseInt(postgresDbPortTextView.getText()) :
        null;
    datasource.setPort(port);
    datasource.setDbName(postgresDbNameTextView.getText());
    datasource.setUser(postgresDbUserNameTextView.getText());
    datasource.setPassword(postgresDbUserPasswordTextView.getText());
    datasource.setDriverClassName("org.postgresql.Driver");
    datasource.setUrl("jdbc:postgresql:" + "//" + datasource.getHost() + ":" + datasource.getPort() + "/" + datasource.getDbName());
    try {
      datasource.setDbBeanPackage(Files.createTempDirectory("db-package").toString());
      dbManager.testConnection(datasource);
    }
    catch (Exception e) {
      throw new JavaFxException(bundle.getString("db.connection.error.msg"), e);
    }

    postgresqlVbox.getChildren().clear();
    BorderPane borderPane = new BorderPane();
    ImageView imageView = new ImageView(Icons.SUCCESS_CONNECTION);
    BorderPane.setAlignment(imageView, Pos.CENTER);
    BorderPane.setMargin(imageView, new Insets(100,100,100,100)); // optional
    borderPane.setCenter(imageView);
    postgresqlVbox.getChildren().addAll(borderPane);
  }
}
