DROP TABLE IF EXISTS user;

CREATE TABLE user
(
    id    BIGINT(20)  NOT NULL COMMENT '主键ID',
    name  VARCHAR(30) NULL DEFAULT NULL COMMENT '姓名',
    age   INT(11)     NULL DEFAULT NULL COMMENT '年龄',
    email VARCHAR(50) NULL DEFAULT NULL COMMENT '邮箱',
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS `T_UPLOAD_RECORD`;
CREATE TABLE `T_UPLOAD_RECORD`
(
    `FILE_ID`       varchar(64)   NOT NULL COMMENT '文件的唯一标识',
    `PATH`          varchar(4000) NULL DEFAULT NULL COMMENT '全路径',
    `ORIGINAL_NAME` varchar(500)  NULL DEFAULT NULL COMMENT '原文件名',
    `UPLOAD_TIME`   datetime(0)   NULL DEFAULT NULL COMMENT '上传时间',
    `UPLOAD_BY`     varchar(255)  NULL DEFAULT NULL COMMENT '上传人',
    PRIMARY KEY (`FILE_ID`)
);

DROP TABLE IF EXISTS `T_COLUMN_CONFIG`;
CREATE TABLE `T_COLUMN_CONFIG`
(
    `ID`          varchar(255) NOT NULL COMMENT '主键id',
    `CELL_INDEX`  varchar(255) NULL DEFAULT NULL COMMENT '对应的excel列序号',
    `COLUMN_NAME` varchar(255) NULL DEFAULT NULL COMMENT '对应的excel列标题',
    `JAVA_NAME`   varchar(255) NULL DEFAULT NULL COMMENT '对应的java字段名',
    `JAVA_TYPE`   varchar(255) NULL DEFAULT NULL COMMENT '对应java字段的数据类型',
    `TEMPLATE_ID` varchar(255) NULL DEFAULT NULL COMMENT '模板id',
    PRIMARY KEY (`ID`)
)