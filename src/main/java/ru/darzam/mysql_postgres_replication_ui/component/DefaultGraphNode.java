package ru.darzam.mysql_postgres_replication_ui.component;

import java.util.Objects;

public class DefaultGraphNode {
  private String tableName;
  private String schemaName;
  private Double x;
  private Double y;

  public DefaultGraphNode() {
  }

  public DefaultGraphNode(String schemaName, String tableName, String alias) {
    setSchemaName(schemaName);
    setTableName(tableName);
  }

  public String getTableName() {
    return tableName;
  }

  public void setTableName(String tableName) {
    this.tableName = tableName;
  }

  public String getSchemaName() {
    return schemaName;
  }

  public void setSchemaName(String schemaName) {
    this.schemaName = schemaName;
  }

  public Double getX() {
    return x;
  }

  public void setX(Double x) {
    this.x = x;
  }

  public Double getY() {
    return y;
  }

  public void setY(Double y) {
    this.y = y;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    DefaultGraphNode that = (DefaultGraphNode) o;
    return tableName.equals(that.tableName) &&
        schemaName.equals(that.schemaName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tableName, schemaName);
  }
}
