resource "azurerm_resource_group" "rg" {
  name     = var.resource_group_name
  location = var.location
}

resource "azurerm_mysql_flexible_server" "mysql" {
  name                   = var.mysql_server_name
  resource_group_name    = azurerm_resource_group.rg.name
  location               = var.mysql_location
  administrator_login    = var.mysql_admin_username
  administrator_password = var.mysql_admin_password
  sku_name               = "B_Standard_B1ms"
  version                = "8.0.21"
  zone                   = "3"

  storage {
    size_gb = 20
  }

  backup_retention_days        = 7
  geo_redundant_backup_enabled = false
}

resource "azurerm_mysql_flexible_database" "db" {
  name                = var.mysql_database_name
  resource_group_name = azurerm_resource_group.rg.name
  server_name         = azurerm_mysql_flexible_server.mysql.name
  charset             = "utf8mb4"
  collation           = "utf8mb4_unicode_ci"
}

resource "azurerm_mysql_flexible_server_firewall_rule" "allow_azure" {
  name                = "allow-azure-services"
  resource_group_name = azurerm_resource_group.rg.name
  server_name         = azurerm_mysql_flexible_server.mysql.name
  start_ip_address    = "0.0.0.0"
  end_ip_address      = "0.0.0.0"
}

resource "azurerm_service_plan" "plan" {
  name                = "asp-${var.app_name}"
  resource_group_name = azurerm_resource_group.rg.name
  location            = azurerm_resource_group.rg.location
  os_type             = "Linux"
  sku_name            = "B1"
}

resource "azurerm_linux_web_app" "app" {
  name                = var.app_name
  resource_group_name = azurerm_resource_group.rg.name
  location            = azurerm_resource_group.rg.location
  service_plan_id     = azurerm_service_plan.plan.id

  site_config {
    application_stack {
      docker_image_name        = "${var.dockerhub_username}/${var.docker_image_name}:v1"
      docker_registry_url      = "https://index.docker.io"
      docker_registry_username = var.dockerhub_username
      docker_registry_password = var.dockerhub_token
    }

    always_on = true
  }

  app_settings = {
    WEBSITES_PORT = "8081"
    PORT          = "8081"

    SPRING_DATASOURCE_USERNAME = var.mysql_admin_username
    SPRING_DATASOURCE_PASSWORD = var.mysql_admin_password
    SPRING_DATASOURCE_URL      = "jdbc:mysql://${azurerm_mysql_flexible_server.mysql.fqdn}:3306/${var.mysql_database_name}?useSSL=true&requireSSL=true&serverTimezone=UTC"
  }

  depends_on = [
    azurerm_mysql_flexible_database.db,
    azurerm_mysql_flexible_server_firewall_rule.allow_azure
  ]
}