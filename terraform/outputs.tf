output "app_url" {
  value = "https://${azurerm_linux_web_app.app.default_hostname}"
}

output "mysql_host" {
  value = azurerm_mysql_flexible_server.mysql.fqdn
}

output "jdbc_url" {
  value     = "jdbc:mysql://${azurerm_mysql_flexible_server.mysql.fqdn}:3306/${var.mysql_database_name}?useSSL=true&requireSSL=true&serverTimezone=UTC"
  sensitive = true
}