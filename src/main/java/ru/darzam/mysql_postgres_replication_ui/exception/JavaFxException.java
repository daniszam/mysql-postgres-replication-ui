package ru.darzam.mysql_postgres_replication_ui.exception;

/**
 * @author zamaliev
 */
public class JavaFxException extends RuntimeException {

  public JavaFxException(String message) {
    super(message);
  }

  public JavaFxException(String message, Throwable cause) {
    super(message, cause);
  }

  public JavaFxException(Throwable cause) {
    super(cause);
  }

  public JavaFxException(String message, Throwable cause, boolean enableSuppression,
                          boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}