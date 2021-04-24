package ru.darzam.mysql_postgres_replication_ui.datasource;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author zamaliev
 */
public class DbManager {

  public void testConnection(DatasourceConfiguration datasourceConfiguration) throws Exception {
    Connection connection = getConnection(datasourceConfiguration);
    try (Statement ignored = connection.createStatement()) {
    }
  }

  public Connection getConnection(DatasourceConfiguration datasourceConfiguration) throws Exception {
    Class<? extends Driver> driver = (Class<? extends Driver>) loadClass(datasourceConfiguration.getDriverClassName());
    Properties properties = new Properties();
    String user = datasourceConfiguration.getUser() != null ? datasourceConfiguration.getUser() : "";
    String password = datasourceConfiguration.getPassword() != null ? datasourceConfiguration.getPassword() : "";
    properties.put("user", user);
    properties.put("password", password);
    return driver.newInstance().connect(datasourceConfiguration.getUrl(), properties);
  }

  private Class<?> loadClass(String className) throws ClassNotFoundException {
    return getClass().getClassLoader().loadClass(className);
  }
}
