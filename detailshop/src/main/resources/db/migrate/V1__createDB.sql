CREATE TABLE IF NOT EXISTS `autoparts`.`seller` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `phoneNumber` VARCHAR(45) NOT NULL,
  `firstName` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `autoparts`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(100) NOT NULL,
  `firstName` VARCHAR(45) NOT NULL,
  `secName` VARCHAR(45) NOT NULL,
  `number` VARCHAR(45) NOT NULL,
  `email` 	VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `autoparts`.`brand` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nameOfBrand` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `autoparts`.`model` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `brandId` INT NOT NULL,
  `yearOfRelease` INT NOT NULL,
  `model` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_model_brand1_idx` (`brandId` ASC),
  CONSTRAINT `fk_model_brand1`
    FOREIGN KEY (`brandId`)
    REFERENCES `autoparts`.`brand` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `autoparts`.`modification` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `modelId` INT NOT NULL,
  `fuel` VARCHAR(45) NOT NULL,
  `engine` VARCHAR(45) NOT NULL,
  `wheelDrive` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Modification_model1_idx` (`modelId` ASC),
  CONSTRAINT `fk_Modification_model1`
    FOREIGN KEY (`modelId`)
    REFERENCES `autoparts`.`model` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `autoparts`.`detail` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `modificationId` INT NOT NULL,
  `article_code` INT NOT NULL,
  `description` VARCHAR(45) NOT NULL,
  `delivery_period` INT NOT NULL,
  `weight` DOUBLE NOT NULL,
  `price` DOUBLE NOT NULL,
  `avaliability` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_detail_Modification1_idx` (`modificationId` ASC),
  CONSTRAINT `fk_detail_Modification1`
    FOREIGN KEY (`modificationId`)
    REFERENCES `autoparts`.`modification` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `autoparts`.`cart` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `userId` INT NOT NULL,
  `detailId` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Cart_user1_idx` (`userId` ASC),
  INDEX `fk_Cart_detail1_idx` (`detailId` ASC),
  CONSTRAINT `fk_Cart_user1`
    FOREIGN KEY (`userId`)
    REFERENCES `autoparts`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Cart_detail1`
    FOREIGN KEY (`detailId`)
    REFERENCES `autoparts`.`detail` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `autoparts`.`orderHistory` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `userId` INT NOT NULL,
  `detailId` INT NOT NULL,
  `deliveryTime` INT NOT NULL,
  `count` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_order_user2_idx` (`userId` ASC),
  INDEX `fk_order_detail2_idx` (`detailId` ASC),
  CONSTRAINT `fk_order_user2`
    FOREIGN KEY (`userId`)
    REFERENCES `autoparts`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_order_detail2`
    FOREIGN KEY (`detailId`)
    REFERENCES `autoparts`.`detail` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;