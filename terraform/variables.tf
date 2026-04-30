variable "location" {
  default = "germanywestcentral"
}

variable "mysql_location" {
  default = "spaincentral"
}

variable "resource_group_name" {
  default = "rg-automotive-spring-gwc"
}

variable "mysql_server_name" {
  default = "automotive-spring-mysql-rz02"
}

variable "mysql_admin_username" {
  sensitive = true
}

variable "mysql_admin_password" {
  sensitive = true
}

variable "mysql_database_name" {
  default = "automotive_db"
}

variable "app_name" {
  default = "automotive-spring-rz01"
}

variable "dockerhub_username" {
  default = "joitarazvan"
}

variable "dockerhub_token" {
  sensitive = true
}

variable "docker_image_name" {
  default = "automotive-spring-boot-app"
}