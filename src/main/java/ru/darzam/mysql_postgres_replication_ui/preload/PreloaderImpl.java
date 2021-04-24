package ru.darzam.mysql_postgres_replication_ui.preload;

import javafx.application.Platform;
import javafx.application.Preloader;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import ru.darzam.mysql_postgres_replication_ui.stage.Welcome;

/**
 * @author zamaliev
 */
public class PreloaderImpl extends Preloader {

  private Stage stage;

  public void start(Stage primaryStage) throws Exception {
    this.stage = primaryStage;
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/ui/preloader.fxml"));
    this.stage.initStyle(StageStyle.UNDECORATED);
    loader.setController(this);
    Parent parent = loader.load();
    Scene scene = new Scene(parent, 450, 300);
    this.stage.setScene(scene);
    stage.show();
  }

  @Override
  public void handleStateChangeNotification(StateChangeNotification info) {
    if(info.getType() == StateChangeNotification.Type.BEFORE_START) {
      stage.hide();
      Platform.runLater(() -> {
        Welcome window = new Welcome();
//        window.refreshData();
        window.show();
      });
    }
  }
}
