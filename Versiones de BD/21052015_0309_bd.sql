-- MySQL Script generated by MySQL Workbench
-- 05/21/15 03:09:22
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema wms
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `wms` ;

-- -----------------------------------------------------
-- Schema wms
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `wms` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `wms` ;

-- -----------------------------------------------------
-- Table `wms`.`Pallet_State`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `wms`.`Pallet_State` ;

CREATE TABLE IF NOT EXISTS `wms`.`Pallet_State` (
  `idPallet_State` INT(11) NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(255) NULL,
  `status` INT NULL DEFAULT 1,
  `created_at` TIMESTAMP NULL,
  `updated_at` TIMESTAMP NULL DEFAULT NULL,
  `user_created` INT(8) NULL,
  `user_updated` INT(8) NULL,
  PRIMARY KEY (`idPallet_State`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `wms`.`Type_Condition`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `wms`.`Type_Condition` ;

CREATE TABLE IF NOT EXISTS `wms`.`Type_Condition` (
  `idType_Condition` INT(11) NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(255) NULL,
  `status` INT NULL DEFAULT 1,
  `created_at` TIMESTAMP NULL DEFAULT NULL,
  `updated_at` TIMESTAMP NULL DEFAULT NULL,
  `user_created` INT(8) NULL,
  `user_updated` INT(8) NULL,
  PRIMARY KEY (`idType_Condition`))
ENGINE = InnoDB
COMMENT = 'Refrigerado\nNormal';


-- -----------------------------------------------------
-- Table `wms`.`Distribution_Center`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `wms`.`Distribution_Center` ;

CREATE TABLE IF NOT EXISTS `wms`.`Distribution_Center` (
  `idDistribution_Center` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(128) NULL,
  `address` VARCHAR(255) NULL,
  `pos_x` INT NULL,
  `pos_y` INT NULL,
  `status` INT NULL DEFAULT 1,
  `created_at` TIMESTAMP NULL DEFAULT NULL,
  `updated_at` TIMESTAMP NULL DEFAULT NULL,
  `user_created` INT(8) NULL,
  `user_updated` INT(8) NULL,
  PRIMARY KEY (`idDistribution_Center`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `wms`.`Warehouse`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `wms`.`Warehouse` ;

CREATE TABLE IF NOT EXISTS `wms`.`Warehouse` (
  `idWarehouse` INT(11) NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(255) NULL,
  `status` INT NULL DEFAULT 1,
  `created_at` TIMESTAMP NULL DEFAULT NULL,
  `updated_at` TIMESTAMP NULL,
  `Type_Condition_idType_Condition` INT(11) NOT NULL COMMENT 'Se comparara con el mismo campo en la tabla Product',
  `Distribution_Center_idDistribution_Center` INT(11) NOT NULL,
  `user_created` INT(8) NULL,
  `user_updated` INT(8) NULL,
  PRIMARY KEY (`idWarehouse`, `Distribution_Center_idDistribution_Center`),
  INDEX `fk_Warehouse_Type_Condition_WareHouse1_idx` (`Type_Condition_idType_Condition` ASC),
  INDEX `fk_Warehouse_Distribution_Center1_idx` (`Distribution_Center_idDistribution_Center` ASC),
  CONSTRAINT `fk_Warehouse_Type_Condition_WareHouse1`
    FOREIGN KEY (`Type_Condition_idType_Condition`)
    REFERENCES `wms`.`Type_Condition` (`idType_Condition`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Warehouse_Distribution_Center1`
    FOREIGN KEY (`Distribution_Center_idDistribution_Center`)
    REFERENCES `wms`.`Distribution_Center` (`idDistribution_Center`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `wms`.`Rack`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `wms`.`Rack` ;

CREATE TABLE IF NOT EXISTS `wms`.`Rack` (
  `idRack` INT(11) NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(255) NULL,
  `length` DOUBLE NULL,
  `width` DOUBLE NULL,
  `floor_numbers` INT NULL,
  `height_per_floor` INT NULL,
  `resistance_weigth_per_floor` INT NULL,
  `column_number` INT NULL,
  `status` INT NULL DEFAULT 1,
  `created_at` TIMESTAMP NULL DEFAULT NULL,
  `updated_at` TIMESTAMP NULL DEFAULT NULL,
  `Warehouse_idWarehouse` INT(11) NOT NULL,
  `Warehouse_Distribution_Center_idDistribution_Center` INT(11) NOT NULL,
  `user_created` INT(8) NULL,
  `user_updated` INT(8) NULL,
  PRIMARY KEY (`idRack`, `Warehouse_idWarehouse`, `Warehouse_Distribution_Center_idDistribution_Center`),
  INDEX `fk_Rack_Warehouse1_idx` (`Warehouse_idWarehouse` ASC, `Warehouse_Distribution_Center_idDistribution_Center` ASC),
  CONSTRAINT `fk_Rack_Warehouse1`
    FOREIGN KEY (`Warehouse_idWarehouse` , `Warehouse_Distribution_Center_idDistribution_Center`)
    REFERENCES `wms`.`Warehouse` (`idWarehouse` , `Distribution_Center_idDistribution_Center`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `wms`.`Location_State`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `wms`.`Location_State` ;

CREATE TABLE IF NOT EXISTS `wms`.`Location_State` (
  `idLocation_State` INT(11) NOT NULL,
  `description` VARCHAR(255) NULL,
  `status` INT NULL DEFAULT 1,
  `created_at` TIMESTAMP NULL DEFAULT NULL,
  `updated_at` TIMESTAMP NULL DEFAULT NULL,
  `user_created` INT(8) NULL,
  `user_updated` INT(8) NULL,
  PRIMARY KEY (`idLocation_State`))
ENGINE = InnoDB
COMMENT = 'Disponble\nNo Disponible\nEn reparacion';


-- -----------------------------------------------------
-- Table `wms`.`Location_Cell`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `wms`.`Location_Cell` ;

CREATE TABLE IF NOT EXISTS `wms`.`Location_Cell` (
  `idLocation_Cell` INT(11) NOT NULL AUTO_INCREMENT,
  `width` DOUBLE NULL,
  `length` DOUBLE NULL,
  `height` DOUBLE NULL DEFAULT NULL,
  `row` INT NULL,
  `column` INT NULL,
  `status` INT NULL DEFAULT 1 COMMENT '1 habilitado\n0 deshabilitado',
  `created_at` TIMESTAMP NULL DEFAULT NULL,
  `updated_at` TIMESTAMP NULL DEFAULT NULL,
  `Location_State_idLocation_State` INT(11) NOT NULL,
  `Rack_idRack` INT(11) NOT NULL,
  `Rack_Warehouse_idWarehouse` INT(11) NOT NULL,
  `Rack_Warehouse_Distribution_Center_idDistribution_Center` INT(11) NOT NULL,
  `user_created` INT(8) NULL,
  `user_updated` INT(8) NULL,
  PRIMARY KEY (`idLocation_Cell`, `Rack_idRack`, `Rack_Warehouse_idWarehouse`, `Rack_Warehouse_Distribution_Center_idDistribution_Center`),
  INDEX `fk_Location_Cell_Rack1_idx` (`Rack_idRack` ASC, `Rack_Warehouse_idWarehouse` ASC, `Rack_Warehouse_Distribution_Center_idDistribution_Center` ASC),
  INDEX `fk_Location_Cell_Location_State1_idx` (`Location_State_idLocation_State` ASC),
  CONSTRAINT `fk_Location_Cell_Rack1`
    FOREIGN KEY (`Rack_idRack` , `Rack_Warehouse_idWarehouse` , `Rack_Warehouse_Distribution_Center_idDistribution_Center`)
    REFERENCES `wms`.`Rack` (`idRack` , `Warehouse_idWarehouse` , `Warehouse_Distribution_Center_idDistribution_Center`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Location_Cell_Location_State1`
    FOREIGN KEY (`Location_State_idLocation_State`)
    REFERENCES `wms`.`Location_State` (`idLocation_State`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `wms`.`Location_Cell_Detail`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `wms`.`Location_Cell_Detail` ;

CREATE TABLE IF NOT EXISTS `wms`.`Location_Cell_Detail` (
  `idLocation_Cell_Detail` CHAR NOT NULL,
  `availability` INT NULL DEFAULT 1,
  `created_at` TIMESTAMP NULL DEFAULT NULL,
  `updated_at` TIMESTAMP NULL DEFAULT NULL,
  `Pallet_idPallet` INT(11) NOT NULL,
  `Location_Cell_idLocation_Cell` INT(11) NOT NULL,
  `Location_Cell_Rack_idRack` INT(11) NOT NULL,
  `Location_Cell_Rack_Warehouse_idWarehouse` INT(11) NOT NULL,
  `idDistribution_Center` INT(11) NOT NULL,
  `user_created` INT(8) NULL,
  `user_updated` INT(8) NULL,
  PRIMARY KEY (`idLocation_Cell_Detail`, `Pallet_idPallet`, `Location_Cell_idLocation_Cell`, `Location_Cell_Rack_idRack`, `Location_Cell_Rack_Warehouse_idWarehouse`, `idDistribution_Center`),
  INDEX `fk_Location_Cell_Detail_Location_Cell1_idx` (`Location_Cell_idLocation_Cell` ASC, `Location_Cell_Rack_idRack` ASC, `Location_Cell_Rack_Warehouse_idWarehouse` ASC, `idDistribution_Center` ASC),
  CONSTRAINT `fk_Location_Cell_Detail_Location_Cell1`
    FOREIGN KEY (`Location_Cell_idLocation_Cell` , `Location_Cell_Rack_idRack` , `Location_Cell_Rack_Warehouse_idWarehouse` , `idDistribution_Center`)
    REFERENCES `wms`.`Location_Cell` (`idLocation_Cell` , `Rack_idRack` , `Rack_Warehouse_idWarehouse` , `Rack_Warehouse_Distribution_Center_idDistribution_Center`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `wms`.`Pallet`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `wms`.`Pallet` ;

CREATE TABLE IF NOT EXISTS `wms`.`Pallet` (
  `idPallet` INT(11) NOT NULL,
  `status` INT NULL DEFAULT 1,
  `created_at` TIMESTAMP NULL,
  `updated_at` TIMESTAMP NULL DEFAULT NULL,
  `Pallet_State_idPallet_Type` INT(11) NOT NULL,
  `Location_Cell_Detail_idLocation_Cell_Detail` CHAR NOT NULL,
  `Location_Cell_Detail_Pallet_idPallet` INT(11) NOT NULL,
  `Location_Cell_Detail_Location_Cell_idLocation_Cell` INT(11) NOT NULL,
  `Location_Cell_Detail_Location_Cell_Rack_idRack` INT(11) NOT NULL,
  `Location_Cell_Detail_Location_Cell_Rack_Warehouse_idWarehouse` INT(11) NOT NULL,
  `idDistribution_Center` INT(11) NOT NULL,
  `cod_ean128` VARCHAR(128) NULL,
  `user_created` INT(8) NULL,
  `user_updated` INT(8) NULL,
  PRIMARY KEY (`idPallet`, `Location_Cell_Detail_idLocation_Cell_Detail`, `Location_Cell_Detail_Pallet_idPallet`, `Location_Cell_Detail_Location_Cell_idLocation_Cell`, `Location_Cell_Detail_Location_Cell_Rack_idRack`, `Location_Cell_Detail_Location_Cell_Rack_Warehouse_idWarehouse`, `idDistribution_Center`),
  INDEX `fk_Pallet_Pallet_State_idx` (`Pallet_State_idPallet_Type` ASC),
  INDEX `fk_Pallet_Location_Cell_Detail1_idx` (`Location_Cell_Detail_idLocation_Cell_Detail` ASC, `Location_Cell_Detail_Pallet_idPallet` ASC, `Location_Cell_Detail_Location_Cell_idLocation_Cell` ASC, `Location_Cell_Detail_Location_Cell_Rack_idRack` ASC, `Location_Cell_Detail_Location_Cell_Rack_Warehouse_idWarehouse` ASC, `idDistribution_Center` ASC),
  CONSTRAINT `fk_Pallet_Pallet_State`
    FOREIGN KEY (`Pallet_State_idPallet_Type`)
    REFERENCES `wms`.`Pallet_State` (`idPallet_State`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Pallet_Location_Cell_Detail1`
    FOREIGN KEY (`Location_Cell_Detail_idLocation_Cell_Detail` , `Location_Cell_Detail_Pallet_idPallet` , `Location_Cell_Detail_Location_Cell_idLocation_Cell` , `Location_Cell_Detail_Location_Cell_Rack_idRack` , `Location_Cell_Detail_Location_Cell_Rack_Warehouse_idWarehouse` , `idDistribution_Center`)
    REFERENCES `wms`.`Location_Cell_Detail` (`idLocation_Cell_Detail` , `Pallet_idPallet` , `Location_Cell_idLocation_Cell` , `Location_Cell_Rack_idRack` , `Location_Cell_Rack_Warehouse_idWarehouse` , `idDistribution_Center`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `wms`.`Trademark`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `wms`.`Trademark` ;

CREATE TABLE IF NOT EXISTS `wms`.`Trademark` (
  `id_Trademark` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_Trademark`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `wms`.`Product`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `wms`.`Product` ;

CREATE TABLE IF NOT EXISTS `wms`.`Product` (
  `idProduct` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NULL,
  `quantity_per_box` INT NULL,
  `weight_per_box` INT NULL,
  `quantity_boxes_per_pallet` INT NULL,
  `physical_stock` INT NULL,
  `free_stock` INT NULL,
  `status` INT NULL DEFAULT 1,
  `created_at` TIMESTAMP NULL DEFAULT NULL,
  `updated_at` TIMESTAMP NULL DEFAULT NULL,
  `Type_Condition_idType_Condition` INT(11) NOT NULL,
  `Pallet_idPallet` INT(11) NOT NULL,
  `cod_ean13` VARCHAR(13) NULL,
  `Trademark_id_Trademark` INT NOT NULL,
  `user_created` INT(8) NULL,
  `user_updated` INT(8) NULL,
  PRIMARY KEY (`idProduct`, `Pallet_idPallet`, `Trademark_id_Trademark`),
  INDEX `fk_Product_Pallet1_idx` (`Pallet_idPallet` ASC),
  INDEX `fk_Product_Type_Condition1_idx` (`Type_Condition_idType_Condition` ASC),
  INDEX `fk_Product_Trademark1_idx` (`Trademark_id_Trademark` ASC),
  CONSTRAINT `fk_Product_Pallet1`
    FOREIGN KEY (`Pallet_idPallet`)
    REFERENCES `wms`.`Pallet` (`idPallet`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Product_Type_Condition1`
    FOREIGN KEY (`Type_Condition_idType_Condition`)
    REFERENCES `wms`.`Type_Condition` (`idType_Condition`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Product_Trademark1`
    FOREIGN KEY (`Trademark_id_Trademark`)
    REFERENCES `wms`.`Trademark` (`id_Trademark`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `wms`.`Profile`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `wms`.`Profile` ;

CREATE TABLE IF NOT EXISTS `wms`.`Profile` (
  `idProfile` INT(11) NOT NULL,
  `name` VARCHAR(128) NULL,
  `description` VARCHAR(255) NULL,
  `status` INT NULL DEFAULT 1,
  `created_at` TIMESTAMP NULL,
  `updated_at` TIMESTAMP NULL,
  `user_created` INT(8) NULL,
  `user_updated` INT(8) NULL,
  PRIMARY KEY (`idProfile`))
ENGINE = InnoDB
COMMENT = 'Perfiles para agregar usuarios';


-- -----------------------------------------------------
-- Table `wms`.`Vehicle_State`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `wms`.`Vehicle_State` ;

CREATE TABLE IF NOT EXISTS `wms`.`Vehicle_State` (
  `idVehicle_State` INT(11) NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(255) NULL,
  `status` INT NULL DEFAULT 1,
  `created_at` TIMESTAMP NULL DEFAULT NULL,
  `updated_at` TIMESTAMP NULL DEFAULT NULL,
  `user_created` INT(8) NULL,
  `user_updated` INT(8) NULL,
  PRIMARY KEY (`idVehicle_State`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `wms`.`Driver`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `wms`.`Driver` ;

CREATE TABLE IF NOT EXISTS `wms`.`Driver` (
  `idDriver` INT(8) NOT NULL,
  `name` VARCHAR(255) NULL,
  `status` INT NULL DEFAULT 1,
  `created_at` TIMESTAMP NULL DEFAULT NULL,
  `updated_at` TIMESTAMP NULL DEFAULT NULL,
  `user_created` INT(8) NULL,
  `user_updated` INT(8) NULL,
  PRIMARY KEY (`idDriver`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `wms`.`Vehicle`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `wms`.`Vehicle` ;

CREATE TABLE IF NOT EXISTS `wms`.`Vehicle` (
  `idVehicle` INT(11) NOT NULL AUTO_INCREMENT,
  `capacity` DOUBLE NULL,
  `dispatch_number` INT NULL,
  `status` INT NULL DEFAULT 1,
  `created_at` TIMESTAMP NULL DEFAULT NULL,
  `updated_up` TIMESTAMP NULL DEFAULT NULL,
  `Vehicle_State_idVehicle_State` INT(11) NOT NULL,
  `Driver_idDriver` INT(8) NOT NULL,
  `user_created` INT(8) NULL,
  `user_updated` INT(8) NULL,
  PRIMARY KEY (`idVehicle`, `Vehicle_State_idVehicle_State`, `Driver_idDriver`),
  INDEX `fk_Vehicle_Vehicle_State1_idx` (`Vehicle_State_idVehicle_State` ASC),
  INDEX `fk_Vehicle_Driver1_idx` (`Driver_idDriver` ASC),
  CONSTRAINT `fk_Vehicle_Vehicle_State1`
    FOREIGN KEY (`Vehicle_State_idVehicle_State`)
    REFERENCES `wms`.`Vehicle_State` (`idVehicle_State`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Vehicle_Driver1`
    FOREIGN KEY (`Driver_idDriver`)
    REFERENCES `wms`.`Driver` (`idDriver`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = 'Numero de despachos que va el vehiculo';


-- -----------------------------------------------------
-- Table `wms`.`Client`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `wms`.`Client` ;

CREATE TABLE IF NOT EXISTS `wms`.`Client` (
  `idClient` INT(11) NOT NULL AUTO_INCREMENT,
  `ruc` VARCHAR(11) NULL,
  `name` VARCHAR(128) NULL,
  `address` VARCHAR(255) NULL,
  `priority` INT NULL,
  `pos_x` INT NULL,
  `pos_y` INT NULL,
  `status` INT NULL DEFAULT 1,
  `created_at` TIMESTAMP NULL DEFAULT NULL,
  `updated_at` TIMESTAMP NULL DEFAULT NULL,
  `user_created` INT(8) NULL,
  `user_updated` INT(8) NULL,
  PRIMARY KEY (`idClient`),
  UNIQUE INDEX `idClient_UNIQUE` (`idClient` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `wms`.`User`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `wms`.`User` ;

CREATE TABLE IF NOT EXISTS `wms`.`User` (
  `idUser` INT(8) NOT NULL,
  `name` VARCHAR(128) NULL,
  `password` VARCHAR(255) NULL,
  `password_change` INT NULL DEFAULT 0,
  `status` INT NULL DEFAULT 1,
  `created_at` TIMESTAMP NULL DEFAULT NULL,
  `update_at` TIMESTAMP NULL DEFAULT NULL,
  `Profile_idProfile` INT(11) NOT NULL,
  `Distribution_Center_idDistribution_Center` INT(11) NOT NULL,
  `user_created` INT(8) NULL,
  `user_updated` INT(8) NULL,
  PRIMARY KEY (`idUser`, `Profile_idProfile`, `Distribution_Center_idDistribution_Center`),
  INDEX `fk_User_Profile1_idx` (`Profile_idProfile` ASC),
  INDEX `fk_User_Distribution_Center1_idx` (`Distribution_Center_idDistribution_Center` ASC),
  CONSTRAINT `fk_User_Profile1`
    FOREIGN KEY (`Profile_idProfile`)
    REFERENCES `wms`.`Profile` (`idProfile`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_User_Distribution_Center1`
    FOREIGN KEY (`Distribution_Center_idDistribution_Center`)
    REFERENCES `wms`.`Distribution_Center` (`idDistribution_Center`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = '0 - Inactivo\n1 - Activo - Cambiar password por unica vez';


-- -----------------------------------------------------
-- Table `wms`.`Type_Movement`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `wms`.`Type_Movement` ;

CREATE TABLE IF NOT EXISTS `wms`.`Type_Movement` (
  `idType_Movement` INT(11) NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(255) NULL,
  `status` INT NULL DEFAULT 1,
  `created_at` TIMESTAMP NULL DEFAULT NULL,
  `updated_at` TIMESTAMP NULL DEFAULT NULL,
  `user_created` INT(8) NULL,
  `user_updated` INT(8) NULL,
  PRIMARY KEY (`idType_Movement`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `wms`.`Movement`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `wms`.`Movement` ;

CREATE TABLE IF NOT EXISTS `wms`.`Movement` (
  `idMovement` INT NOT NULL AUTO_INCREMENT,
  `date` DATE NOT NULL,
  `created_at` TIMESTAMP NULL DEFAULT NULL,
  `updated_at` TIMESTAMP NULL DEFAULT NULL,
  `Type_Movement_idType_Movement` INT(11) NOT NULL,
  `Product_idProduct` INT(11) NOT NULL,
  `user_created` INT(8) NULL,
  `user_updated` INT(8) NULL,
  PRIMARY KEY (`idMovement`, `Product_idProduct`),
  INDEX `fk_Movement_Type_Movement1_idx` (`Type_Movement_idType_Movement` ASC),
  INDEX `fk_Movement_Product1_idx` (`Product_idProduct` ASC),
  CONSTRAINT `fk_Movement_Type_Movement1`
    FOREIGN KEY (`Type_Movement_idType_Movement`)
    REFERENCES `wms`.`Type_Movement` (`idType_Movement`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Movement_Product1`
    FOREIGN KEY (`Product_idProduct`)
    REFERENCES `wms`.`Product` (`idProduct`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `wms`.`State_Request_Order`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `wms`.`State_Request_Order` ;

CREATE TABLE IF NOT EXISTS `wms`.`State_Request_Order` (
  `idStateRequest_Order` INT(11) NOT NULL,
  `description` VARCHAR(45) NULL,
  `status` INT NULL DEFAULT 1,
  `created_at` TIMESTAMP NULL DEFAULT NULL,
  `updated_at` TIMESTAMP NULL DEFAULT NULL,
  `user_created` INT(8) NULL,
  `user_updated` INT(8) NULL,
  PRIMARY KEY (`idStateRequest_Order`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `wms`.`Picking_Order`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `wms`.`Picking_Order` ;

CREATE TABLE IF NOT EXISTS `wms`.`Picking_Order` (
  `idPicking_Order` INT(11) NOT NULL,
  `Date` DATE NULL,
  `status` INT NULL DEFAULT 1,
  `created_at` TIMESTAMP NULL DEFAULT NULL,
  `updated_at` TIMESTAMP NULL DEFAULT NULL,
  `user_created` INT(8) NULL,
  `user_updated` INT(8) NULL,
  PRIMARY KEY (`idPicking_Order`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `wms`.`Request_Order`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `wms`.`Request_Order` ;

CREATE TABLE IF NOT EXISTS `wms`.`Request_Order` (
  `idRequest_Order` INT(11) NOT NULL,
  `dateArrive` DATE NULL,
  `dateline` DATE NULL,
  `Picking_Order_idPicking_Order` INT(11) NOT NULL,
  `idClient` INT(11) NULL,
  `status` INT NULL DEFAULT 1,
  `created_at` TIMESTAMP NULL DEFAULT NULL,
  `updated_at` TIMESTAMP NULL DEFAULT NULL,
  `Client_idClient` INT(11) NOT NULL,
  `State_Request_Order_idStateRequest_Order` INT(11) NOT NULL,
  `Request_Ordercol` VARCHAR(45) NULL,
  `user_created` INT(8) NULL,
  `user_updated` INT(8) NULL,
  PRIMARY KEY (`idRequest_Order`, `Picking_Order_idPicking_Order`),
  INDEX `fk_Request_Order_Client1_idx` (`Client_idClient` ASC),
  INDEX `fk_Request_Order_StateRequest_Order1_idx` (`State_Request_Order_idStateRequest_Order` ASC),
  INDEX `fk_Request_Order_Picking_Order1_idx` (`Picking_Order_idPicking_Order` ASC),
  CONSTRAINT `fk_Request_Order_Client1`
    FOREIGN KEY (`Client_idClient`)
    REFERENCES `wms`.`Client` (`idClient`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Request_Order_StateRequest_Order1`
    FOREIGN KEY (`State_Request_Order_idStateRequest_Order`)
    REFERENCES `wms`.`State_Request_Order` (`idStateRequest_Order`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Request_Order_Picking_Order1`
    FOREIGN KEY (`Picking_Order_idPicking_Order`)
    REFERENCES `wms`.`Picking_Order` (`idPicking_Order`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `wms`.`Dispatch_Order`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `wms`.`Dispatch_Order` ;

CREATE TABLE IF NOT EXISTS `wms`.`Dispatch_Order` (
  `idDispatch_Order` INT(11) NOT NULL,
  `departure_date` DATETIME NULL,
  `arrival_date` DATETIME NULL,
  `status` INT NULL DEFAULT 1,
  `created_at` TIMESTAMP NULL DEFAULT NULL,
  `updated_at` TIMESTAMP NULL DEFAULT NULL,
  `Vehicle_idVehicle` INT(11) NOT NULL,
  `Vehicle_Vehicle_State_idVehicle_State` INT(11) NOT NULL,
  `Vehicle_Driver_iddriver` INT(8) NOT NULL,
  `Picking_Order_idPicking_Order` INT(11) NOT NULL,
  `user_created` INT(8) NULL,
  `user_updated` INT(8) NULL,
  PRIMARY KEY (`idDispatch_Order`, `Vehicle_idVehicle`, `Vehicle_Vehicle_State_idVehicle_State`, `Vehicle_Driver_iddriver`, `Picking_Order_idPicking_Order`),
  INDEX `fk_Dispatch_Order_Vehicle1_idx` (`Vehicle_idVehicle` ASC, `Vehicle_Vehicle_State_idVehicle_State` ASC, `Vehicle_Driver_iddriver` ASC),
  INDEX `fk_Dispatch_Order_Picking_Order1_idx` (`Picking_Order_idPicking_Order` ASC),
  CONSTRAINT `fk_Dispatch_Order_Vehicle1`
    FOREIGN KEY (`Vehicle_idVehicle` , `Vehicle_Vehicle_State_idVehicle_State` , `Vehicle_Driver_iddriver`)
    REFERENCES `wms`.`Vehicle` (`idVehicle` , `Vehicle_State_idVehicle_State` , `Driver_idDriver`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Dispatch_Order_Picking_Order1`
    FOREIGN KEY (`Picking_Order_idPicking_Order`)
    REFERENCES `wms`.`Picking_Order` (`idPicking_Order`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `wms`.`Request_Order_Detail`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `wms`.`Request_Order_Detail` ;

CREATE TABLE IF NOT EXISTS `wms`.`Request_Order_Detail` (
  `idRequest_Order_Detail` INT(11) NOT NULL,
  `idProduct` INT(11) NULL,
  `quantity` INT NULL,
  `status` INT NULL DEFAULT 1,
  `created_at` TIMESTAMP NULL DEFAULT NULL,
  `updated_at` TIMESTAMP NULL DEFAULT NULL,
  `Request_Order_idRequest_Order` INT(11) NOT NULL,
  `Product_idProduct` INT(11) NOT NULL,
  `delivered` INT NULL,
  `remaining` INT NULL,
  `user_created` INT(8) NULL,
  `user_updated` INT(8) NULL,
  PRIMARY KEY (`idRequest_Order_Detail`, `Request_Order_idRequest_Order`),
  INDEX `fk_Request_Order_Detail_Request_Order1_idx` (`Request_Order_idRequest_Order` ASC),
  INDEX `fk_Request_Order_Detail_Product1_idx` (`Product_idProduct` ASC),
  CONSTRAINT `fk_Request_Order_Detail_Request_Order1`
    FOREIGN KEY (`Request_Order_idRequest_Order`)
    REFERENCES `wms`.`Request_Order` (`idRequest_Order`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Request_Order_Detail_Product1`
    FOREIGN KEY (`Product_idProduct`)
    REFERENCES `wms`.`Product` (`idProduct`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `wms`.`Picking_Order_Detail`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `wms`.`Picking_Order_Detail` ;

CREATE TABLE IF NOT EXISTS `wms`.`Picking_Order_Detail` (
  `idPicking_Order_Detail` INT(11) NOT NULL,
  `delivered` INT NULL,
  `status` INT NULL DEFAULT 1,
  `created_at` TIMESTAMP NULL DEFAULT NULL,
  `updated_at` TIMESTAMP NULL DEFAULT NULL,
  `Location_Cell_Detail_idLocation_Cell_Detail` CHAR NOT NULL,
  `Location_Cell_Detail_Pallet_idPallet` INT(11) NOT NULL,
  `Picking_Order_idPicking_Order` INT(11) NOT NULL,
  `Product_idProduct` INT(11) NOT NULL,
  `user_created` INT(8) NULL,
  `user_updated` INT(8) NULL,
  PRIMARY KEY (`idPicking_Order_Detail`, `Picking_Order_idPicking_Order`, `Product_idProduct`),
  INDEX `fk_Picking_Order_Detail_Location_Cell_Detail1_idx` (`Location_Cell_Detail_idLocation_Cell_Detail` ASC, `Location_Cell_Detail_Pallet_idPallet` ASC),
  INDEX `fk_Picking_Order_Detail_Picking_Order1_idx` (`Picking_Order_idPicking_Order` ASC),
  INDEX `fk_Picking_Order_Detail_Product1_idx` (`Product_idProduct` ASC),
  CONSTRAINT `fk_Picking_Order_Detail_Location_Cell_Detail1`
    FOREIGN KEY (`Location_Cell_Detail_idLocation_Cell_Detail` , `Location_Cell_Detail_Pallet_idPallet`)
    REFERENCES `wms`.`Location_Cell_Detail` (`idLocation_Cell_Detail` , `Pallet_idPallet`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Picking_Order_Detail_Picking_Order1`
    FOREIGN KEY (`Picking_Order_idPicking_Order`)
    REFERENCES `wms`.`Picking_Order` (`idPicking_Order`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Picking_Order_Detail_Product1`
    FOREIGN KEY (`Product_idProduct`)
    REFERENCES `wms`.`Product` (`idProduct`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `wms`.`Motive_Return`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `wms`.`Motive_Return` ;

CREATE TABLE IF NOT EXISTS `wms`.`Motive_Return` (
  `idMotive_Return` INT(11) NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(255) NULL,
  `status` INT NULL DEFAULT 1,
  `created_at` TIMESTAMP NULL DEFAULT NULL,
  `updated_at` TIMESTAMP NULL DEFAULT NULL,
  `user_created` INT(8) NULL,
  `user_updated` INT(8) NULL,
  PRIMARY KEY (`idMotive_Return`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `wms`.`Product_Return`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `wms`.`Product_Return` ;

CREATE TABLE IF NOT EXISTS `wms`.`Product_Return` (
  `idProduct_Return` INT NOT NULL,
  `quantity` INT NULL,
  `status` INT NULL DEFAULT 1,
  `created_at` TIMESTAMP NULL DEFAULT NULL,
  `updated_at` TIMESTAMP NULL DEFAULT NULL,
  `Motive_Return_idMotive_Return` INT(11) NOT NULL,
  `Picking_Order_Detail_idPicking_Order_Detail` INT(11) NOT NULL,
  `Picking_Order_Detail_Picking_Order_idPicking_Order` INT(11) NOT NULL,
  `Picking_Order_Detail_Product_idProduct` INT(11) NOT NULL,
  `user_created` INT(8) NULL,
  `user_updated` INT(8) NULL,
  PRIMARY KEY (`idProduct_Return`, `Picking_Order_Detail_idPicking_Order_Detail`, `Picking_Order_Detail_Picking_Order_idPicking_Order`, `Picking_Order_Detail_Product_idProduct`),
  INDEX `fk_Product_Return_Motive_Return1_idx` (`Motive_Return_idMotive_Return` ASC),
  INDEX `fk_Product_Return_Picking_Order_Detail1_idx` (`Picking_Order_Detail_idPicking_Order_Detail` ASC, `Picking_Order_Detail_Picking_Order_idPicking_Order` ASC, `Picking_Order_Detail_Product_idProduct` ASC),
  CONSTRAINT `fk_Product_Return_Motive_Return1`
    FOREIGN KEY (`Motive_Return_idMotive_Return`)
    REFERENCES `wms`.`Motive_Return` (`idMotive_Return`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Product_Return_Picking_Order_Detail1`
    FOREIGN KEY (`Picking_Order_Detail_idPicking_Order_Detail` , `Picking_Order_Detail_Picking_Order_idPicking_Order` , `Picking_Order_Detail_Product_idProduct`)
    REFERENCES `wms`.`Picking_Order_Detail` (`idPicking_Order_Detail` , `Picking_Order_idPicking_Order` , `Product_idProduct`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `wms`.`Log_security`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `wms`.`Log_security` ;

CREATE TABLE IF NOT EXISTS `wms`.`Log_security` (
  `idLog_security` INT(11) NOT NULL AUTO_INCREMENT,
  `date` DATE NULL,
  `action` VARCHAR(255) NULL,
  `idUser` INT(8) NULL,
  `User_idUser` INT(8) NOT NULL,
  PRIMARY KEY (`idLog_security`, `User_idUser`),
  INDEX `fk_Log_security_User1_idx` (`User_idUser` ASC),
  CONSTRAINT `fk_Log_security_User1`
    FOREIGN KEY (`User_idUser`)
    REFERENCES `wms`.`User` (`idUser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `wms`.`Internment_Order`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `wms`.`Internment_Order` ;

CREATE TABLE IF NOT EXISTS `wms`.`Internment_Order` (
  `idInternment_Order` INT(11) NOT NULL,
  `date` DATE NULL,
  `status` INT NULL DEFAULT 1,
  `created_at` TIMESTAMP NULL DEFAULT NULL,
  `updated_at` TIMESTAMP NULL DEFAULT NULL,
  `user_created` INT(8) NULL,
  `user_updated` INT(8) NULL,
  PRIMARY KEY (`idInternment_Order`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `wms`.`Internment_Order_Detail`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `wms`.`Internment_Order_Detail` ;

CREATE TABLE IF NOT EXISTS `wms`.`Internment_Order_Detail` (
  `idInternment_Order_Detail` INT(11) NOT NULL,
  `quantity` INT NULL,
  `status` INT NULL DEFAULT 1,
  `created_at` TIMESTAMP NULL DEFAULT NULL,
  `updated_at` TIMESTAMP NULL DEFAULT NULL,
  `Product_idProduct` INT(11) NOT NULL,
  `Internment_Order_idInternment_Order` INT(11) NOT NULL,
  `user_created` INT(8) NULL,
  `user_updated` INT(8) NULL,
  PRIMARY KEY (`idInternment_Order_Detail`, `Product_idProduct`, `Internment_Order_idInternment_Order`),
  INDEX `fk_Internment_Order_Detail_Product1_idx` (`Product_idProduct` ASC),
  INDEX `fk_Internment_Order_Detail_Internment_Order1_idx` (`Internment_Order_idInternment_Order` ASC),
  CONSTRAINT `fk_Internment_Order_Detail_Product1`
    FOREIGN KEY (`Product_idProduct`)
    REFERENCES `wms`.`Product` (`idProduct`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Internment_Order_Detail_Internment_Order1`
    FOREIGN KEY (`Internment_Order_idInternment_Order`)
    REFERENCES `wms`.`Internment_Order` (`idInternment_Order`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `wms`.`Distribution_Center`
-- -----------------------------------------------------
START TRANSACTION;
USE `wms`;
INSERT INTO `wms`.`Distribution_Center` (`idDistribution_Center`, `name`, `address`, `pos_x`, `pos_y`, `status`, `created_at`, `updated_at`, `user_created`, `user_updated`) VALUES (1, 'PUCPWMS', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `wms`.`Profile`
-- -----------------------------------------------------
START TRANSACTION;
USE `wms`;
INSERT INTO `wms`.`Profile` (`idProfile`, `name`, `description`, `status`, `created_at`, `updated_at`, `user_created`, `user_updated`) VALUES (1, 'administrator', 'It is the system administrator profile', NULL, NULL, NULL, NULL, NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `wms`.`User`
-- -----------------------------------------------------
START TRANSACTION;
USE `wms`;
INSERT INTO `wms`.`User` (`idUser`, `name`, `password`, `password_change`, `status`, `created_at`, `update_at`, `Profile_idProfile`, `Distribution_Center_idDistribution_Center`, `user_created`, `user_updated`) VALUES (72299021, 'Luis Miranda', '$2a$12$Z8kyoYj/BVeERiceNdWll.RFi42l/twQSCvJzdA5KzMpNXapKrXy6', NULL, 1, NULL, NULL, 1, 1, NULL, NULL);
INSERT INTO `wms`.`User` (`idUser`, `name`, `password`, `password_change`, `status`, `created_at`, `update_at`, `Profile_idProfile`, `Distribution_Center_idDistribution_Center`, `user_created`, `user_updated`) VALUES (42103543, 'Ronald Zavala', '$2a$12$Z8kyoYj/BVeERiceNdWll.RFi42l/twQSCvJzdA5KzMpNXapKrXy6', NULL, 1, NULL, NULL, 1, 1, NULL, NULL);
INSERT INTO `wms`.`User` (`idUser`, `name`, `password`, `password_change`, `status`, `created_at`, `update_at`, `Profile_idProfile`, `Distribution_Center_idDistribution_Center`, `user_created`, `user_updated`) VALUES (44872634, 'Gustavo Coronado', '$2a$12$Z8kyoYj/BVeERiceNdWll.RFi42l/twQSCvJzdA5KzMpNXapKrXy6', NULL, 1, NULL, NULL, 1, 1, NULL, NULL);
INSERT INTO `wms`.`User` (`idUser`, `name`, `password`, `password_change`, `status`, `created_at`, `update_at`, `Profile_idProfile`, `Distribution_Center_idDistribution_Center`, `user_created`, `user_updated`) VALUES (46474578, 'Alejandro Rodriguez', '$2a$12$Z8kyoYj/BVeERiceNdWll.RFi42l/twQSCvJzdA5KzMpNXapKrXy6', NULL, 1, NULL, NULL, 1, 1, NULL, NULL);
INSERT INTO `wms`.`User` (`idUser`, `name`, `password`, `password_change`, `status`, `created_at`, `update_at`, `Profile_idProfile`, `Distribution_Center_idDistribution_Center`, `user_created`, `user_updated`) VALUES (49778049, 'Karina Chacon', '$2a$12$Z8kyoYj/BVeERiceNdWll.RFi42l/twQSCvJzdA5KzMpNXapKrXy6', NULL, 1, NULL, NULL, 1, 1, NULL, NULL);
INSERT INTO `wms`.`User` (`idUser`, `name`, `password`, `password_change`, `status`, `created_at`, `update_at`, `Profile_idProfile`, `Distribution_Center_idDistribution_Center`, `user_created`, `user_updated`) VALUES (45946510, 'Luigi Limaylla', '$2a$12$Z8kyoYj/BVeERiceNdWll.RFi42l/twQSCvJzdA5KzMpNXapKrXy6', NULL, 1, NULL, NULL, 1, 1, NULL, NULL);

COMMIT;

