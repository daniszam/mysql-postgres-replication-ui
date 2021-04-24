package ru.darzam.mysql_postgres_replication_ui.datasource;

import java.util.List;

/**
 * @author zamaliev
 */
public class DatasourceConfiguration {
  private String host;
  private String dbName;
  private Integer port;
  private String user;
  private String password;
  private String driverClassName;
  private String url;
  private String dbBeanPackage;
  private List<String> schemas;
  private List<String> replicaJndiNames;

  public String getHost() {
    return host;
  }

  public void setHost(String host) {
    this.host = host;
  }

  public String getDbName() {
    return dbName;
  }

  public void setDbName(String dbName) {
    this.dbName = dbName;
  }

  public Integer getPort() {
    return port;
  }

  public void setPort(Integer port) {
    this.port = port;
  }

  public String getUser() {
    return user;
  }

  public void setUser(String user) {
    this.user = user;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getDriverClassName() {
    return driverClassName;
  }

  public void setDriverClassName(String driverClassName) {
    this.driverClassName = driverClassName;
  }

  public String getDbBeanPackage() {
    return dbBeanPackage;
  }

  public void setDbBeanPackage(String dbBeanPackage) {
    this.dbBeanPackage = dbBeanPackage;
  }

  public List<String> getSchemas() {
    return schemas;
  }

  public void setSchemas(List<String> schemas) {
    this.schemas = schemas;
  }

  public List<String> getReplicaJndiNames() {
    return replicaJndiNames;
  }

  public void setReplicaJndiNames(List<String> replicaJndiNames) {
    this.replicaJndiNames = replicaJndiNames;
  }

}
