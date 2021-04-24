package ru.darzam.mysql_postgres_replication_ui.stage;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import ru.darzam.mysql_postgres_replication_ui.css.Css;
import ru.darzam.mysql_postgres_replication_ui.css.Icons;

import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author zamaliev
 */
public class Welcome extends Stage implements Initializable {

  @FXML
  protected Button createNewConf;
  @FXML
  protected Button openConf;
  @FXML
  protected VBox recentConf;

  private final ResourceBundle bundle = ResourceBundle.getBundle("bundle", Locale.getDefault());

  public Welcome() {
    initOwner(Primary.getPrimaryStage());
    try {
      FXMLLoader fxmlLoader = new FXMLLoader(Welcome.class.getResource("/ui/welcome.fxml"));
      fxmlLoader.setController(this);
      AnchorPane root = fxmlLoader.load();
      Scene scene = new Scene(root, 600, 500);
      scene.getStylesheets().add(Css.DEFAULT_CSS);
      setScene(scene);
      setResizable(false);
      setTitle(bundle.getString("welcome.screen.title"));
    }
    catch (IOException e) {
      throw new RuntimeException(e.getMessage(), e);
    }
  }

  @FXML
  protected void openDirectory() {
//    welcomeScreen.loadAndOpenProject(null);
  }

  protected void openRecentProject() {
//    Path path = Paths.get(projectInfo.getProjectPath());
//    welcomeScreen.loadAndOpenProject(path);
//
//    if (!Files.exists(path)) {
//      projectInfoObservableList.remove(projectInfo);
//    }
  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {
//    this.recentProjects.getChildren().clear();
//    this.projectInfoObservableList.addListener((ListChangeListener<ProjectInfo>) c -> refreshView());

    createNewConf.setText(bundle.getString("new.config"));
    createNewConf.setGraphic(new ImageView(Icons.CREATE));
    createNewConf.setOnAction(e -> createStage());

    openConf.setText(bundle.getString("open.config"));
    openConf.setGraphic(new ImageView(Icons.OPEN));
    Platform.runLater(openConf::requestFocus);
  }

  private void refreshView() {
//    SortedList<ProjectInfo> projectInfos = new SortedList<>(projectInfoObservableList);
//    projectInfos.setComparator((o1, o2) -> o2.getOpenDate().compareTo(o1.getOpenDate()));
//    recentProjects.getChildren().clear();
//
//    for (ProjectInfo projectInfo : projectInfos) {
//      recentProjects.getChildren().add(createResentProjectView(projectInfo));
//    }
  }

//  private StackPane createResentProjectView(ProjectInfo projectInfo) {
//    StackPane newPane = new StackPane();
//    newPane.getStyleClass().add("project-item");
//    newPane.setId(projectInfo.getProjectPath());
//
//    Label projectName = new Label(projectInfo.getProjectName());
//    projectName.getStyleClass().add("project-name");
//
//    Label projectPath = new Label(projectInfo.getProjectPath());
//    projectPath.getStyleClass().add("project-path");
//
//    StackPane.setAlignment(projectName, Pos.TOP_LEFT);
//    StackPane.setAlignment(projectPath, Pos.BOTTOM_LEFT);
//    StackPane.setMargin(projectName, new Insets(5, 5, 5, 5));
//    StackPane.setMargin(projectPath, new Insets(5, 5, 5, 5));
//
//    newPane.getChildren().add(projectName);
//    newPane.getChildren().add(projectPath);
//
//    newPane.setOnMouseClicked(event -> openRecentProject(projectInfo));
//    return newPane;
//  }

//  public void refreshData() {
//    projectInfoObservableList.setAll(projectInfoHelper.getRecentProjectInfoList());
//  }

  private void createStage() {
    this.hide();
    Platform.runLater(() -> {
      Create create = new Create();
      create.show();
    });
  }
}
