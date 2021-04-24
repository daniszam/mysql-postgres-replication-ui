package ru.darzam.mysql_postgres_replication_ui.exception;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Window;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author zamaliev
 */
public class Alert {

  private final ResourceBundle bundle = ResourceBundle.getBundle("bundle", Locale.getDefault());

  public void showErrorDialog(String title, String message, Throwable throwable, Window owner) {
    Platform.runLater(() -> {
      javafx.scene.control.Alert alert = getAlert(javafx.scene.control.Alert.AlertType.ERROR, title, null, message, owner);
      if (throwable != null) {
        GridPane expandedContent = getGridPaneStackTrace(throwable);
        alert.getDialogPane().setExpanded(false);
        alert.getDialogPane().setExpandableContent(expandedContent);
      }
      Button okButton = (Button) alert.getDialogPane().lookupButton(ButtonType.OK);
      okButton.setId("okInAlertError");
      alert.showAndWait();
    });
  }

  private javafx.scene.control.Alert getAlert(final javafx.scene.control.Alert.AlertType type, final String title, final String header,
                                              final String message, final Window owner) {
    javafx.scene.control.Alert alert = new javafx.scene.control.Alert(type);
    alert.setTitle(title);
    alert.setHeaderText(header);
    alert.setContentText(message);
//    alert.initOwner(owner);
    return alert;
  }

  private GridPane getGridPaneStackTrace(final Throwable throwable) {
    GridPane expContent = new GridPane();
    expContent.setMaxWidth(Double.MAX_VALUE);

    // Add label
    final String info = bundle.getString("dialog.error.stack.trace.label");
    Label label = new Label(info);
    expContent.add(label, 0, 0);

    // Add stack trace text
    final String exceptionText = getStackTraceText(throwable);
    TextArea textArea = new TextArea(exceptionText);
    textArea.setEditable(false);
    textArea.setWrapText(true);
    textArea.setMaxWidth(Double.MAX_VALUE);
    textArea.setMaxHeight(Double.MAX_VALUE);
    GridPane.setVgrow(textArea, Priority.ALWAYS);
    GridPane.setHgrow(textArea, Priority.ALWAYS);
    expContent.add(textArea, 0, 1);
    return expContent;
  }

  private String getStackTraceText(final Throwable throwable) {
    StringWriter sw = new StringWriter();
    PrintWriter pw = new PrintWriter(sw);
    throwable.printStackTrace(pw);
    return sw.toString();
  }
}

