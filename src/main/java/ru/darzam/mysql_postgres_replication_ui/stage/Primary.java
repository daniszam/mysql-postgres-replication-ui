package ru.darzam.mysql_postgres_replication_ui.stage;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * @author zamaliev
 */
public class Primary {

  private static Stage primaryStage;

  public static void setPrimaryStage(Stage primaryStage) {
    Primary.primaryStage = primaryStage;
  }

  public static Stage getPrimaryStage() {
    return primaryStage;
  }
}
