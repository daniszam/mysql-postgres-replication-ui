package ru.darzam.mysql_postgres_replication_ui.datasource;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * @author zamaliev
 */
public class JavaFxDatasourceConfiguration {
  private SimpleStringProperty host = new SimpleStringProperty();
  private SimpleStringProperty dbName = new SimpleStringProperty();
  private SimpleIntegerProperty port = new SimpleIntegerProperty();
  private SimpleStringProperty user = new SimpleStringProperty();
  private SimpleStringProperty password = new SimpleStringProperty();
  private SimpleStringProperty dbBeanPackage = new SimpleStringProperty();
  private ObservableList<String> schemas = FXCollections.observableArrayList();

  public String getHost() {
    return host.get();
  }

  public void setHost(String host) {
    this.host.set(host);
  }

  public SimpleStringProperty hostProperty() {
    return host;
  }

  public String getDbName() {
    return dbName.get();
  }

  public void setDbName(String dbName) {
    this.dbName.set(dbName);
  }

  public SimpleStringProperty dbNameProperty() {
    return dbName;
  }

  public int getPort() {
    return port.get();
  }

  public void setPort(int port) {
    this.port.set(port);
  }

  public SimpleIntegerProperty portProperty() {
    return port;
  }

  public String getUser() {
    return user.get();
  }

  public void setUser(String user) {
    this.user.set(user);
  }

  public SimpleStringProperty userProperty() {
    return user;
  }

  public String getPassword() {
    return password.get();
  }

  public void setPassword(String password) {
    this.password.set(password);
  }

  public SimpleStringProperty passwordProperty() {
    return password;
  }

  public String getDbBeanPackage() {
    return dbBeanPackage.get();
  }

  public void setDbBeanPackage(String dbBeanPackage) {
    this.dbBeanPackage.set(dbBeanPackage);
  }

  public SimpleStringProperty dbBeanPackageProperty() {
    return dbBeanPackage;
  }

  public ObservableList<String> getSchemas() {
    return schemas;
  }

  public void setSchemas(ObservableList<String> schemas) {
    this.schemas = schemas;
  }
}
