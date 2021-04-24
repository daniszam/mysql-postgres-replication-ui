package ru.darzam.mysql_postgres_replication_ui.exception;

import javafx.application.Platform;
import ru.darzam.mysql_postgres_replication_ui.stage.Primary;

import java.lang.invoke.MethodHandles;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * @author: zamaliev
 */
public class UncaughtExceptionHandlerImpl implements Thread.UncaughtExceptionHandler {

  private static final Logger LOGGER = Logger.getLogger(MethodHandles.lookup().lookupClass().getName());

  private final Alert alert;

  public UncaughtExceptionHandlerImpl() {
    this.alert = new Alert();
  }

  @Override
  public void uncaughtException(Thread t, Throwable throwable) {
    throwable.printStackTrace();
    LOGGER.log(Level.SEVERE, throwable.getMessage());

    //TODO: remove if after http://jira.cg.ru/browse/WEBBPMNEXT-6989
    String errorMessage = throwable.getMessage() == null ? "ERROR" : throwable.getMessage();
    Platform.runLater(() -> alert.showErrorDialog(null, errorMessage, throwable, Primary.getPrimaryStage()));
  }
}