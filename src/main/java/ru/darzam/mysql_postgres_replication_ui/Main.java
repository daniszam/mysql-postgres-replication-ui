package ru.darzam.mysql_postgres_replication_ui;

import com.sun.deploy.uitoolkit.impl.fx.FXPreloader;
import com.sun.javafx.application.LauncherImpl;
import de.codecentric.centerdevice.javafxsvg.SvgImageLoaderFactory;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import ru.darzam.mysql_postgres_replication_ui.exception.UncaughtExceptionHandlerImpl;
import ru.darzam.mysql_postgres_replication_ui.preload.PreloaderImpl;
import ru.darzam.mysql_postgres_replication_ui.stage.Primary;

/**
 * @author zamaliev
 */
public class Main extends Application {


  public static void main(String[] args) {
    SvgImageLoaderFactory.install();
    LauncherImpl.launchApplication(Main.class, PreloaderImpl.class, args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    Thread.setDefaultUncaughtExceptionHandler(new UncaughtExceptionHandlerImpl());
    Platform.setImplicitExit(false);
    Primary.setPrimaryStage(primaryStage);
  }
}
