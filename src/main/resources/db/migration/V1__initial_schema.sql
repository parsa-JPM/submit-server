CREATE TABLE test.`user` (
  id      INT          NOT NULL AUTO_INCREMENT,
  name    varchar(100) NULL,
  family  varchar(100) NULL,
  email   varchar(100) NULL,
  service varchar(100) NULL,
  CONSTRAINT user_PK PRIMARY KEY (id)
)

  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COLLATE = utf8_general_ci;