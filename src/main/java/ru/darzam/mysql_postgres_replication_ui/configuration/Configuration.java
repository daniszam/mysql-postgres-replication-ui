package ru.darzam.mysql_postgres_replication_ui;

import java.nio.file.Path;

/**
 * @author zamaliev
 */
public class Configuration {

  private String name;
  private Path errorFile;
  private List<MySqlConfiguration> from;
  private PostgreSqlConfiguration to;
  
}
