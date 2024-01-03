CREATE DATABASE IF NOT EXISTS `study_test`;

USE `study_test`;

SET FOREIGN_KEY_CHECKS=0;

-- --------------------------------------------------------
-- 1、创建 - hero表
-- --------------------------------------------------------
DROP TABLE IF EXISTS `hero`;

CREATE TABLE `hero` (
  `id`     int(10)       NOT NULL,
  `name`   varchar(30)   DEFAULT NULL,
  `city`   varchar(20)   DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------
-- 初始化 - hero表数据
-- --------------------------------------------------------
insert into `hero` values (1, '刘备', '河北');
insert into `hero` values (2, '庞统', '湖北');
insert into `hero` values (3, '曹操', '安徽');
insert into `hero` values (4, '黄忠', '河南');
insert into `hero` values (5, '庞德', '甘肃');
insert into `hero` values (6, '孔明', '山东');

-- --------------------------------------------------------
-- 2、创建 - student表
-- --------------------------------------------------------
DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `id`     int(10)       NOT NULL,
  `name`   varchar(30)   DEFAULT NULL,
  `tid`    int(10)       DEFAULT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`tid`) REFERENCES `teacher` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------
-- 初始化 - student表数据
-- --------------------------------------------------------
insert into `student` values (1, '张三', 1);
insert into `student` values (2, '李四', 1);
insert into `student` values (3, '王五', 2);
insert into `student` values (4, '赵六', 3);
insert into `student` values (5, '钱七', 2);

-- --------------------------------------------------------
-- 3、创建 - teacher表
-- --------------------------------------------------------
DROP TABLE IF EXISTS `teacher`;

CREATE TABLE `teacher` (
  `id`     int(10)       NOT NULL,
  `name`   varchar(30)   DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------
-- 初始化 - teacher表数据
-- --------------------------------------------------------
insert into `teacher` values (1, '刘老师');
insert into `teacher` values (2, '罗老师');
insert into `teacher` values (3, '陈老师');

-- --------------------------------------------------------
-- 4、member表
-- --------------------------------------------------------
DROP TABLE IF EXISTS `member`;

CREATE TABLE `member` (
  `member_id`       int(10)        NOT NULL       COMMENT '会员ID',
  `member_nick`     varchar(30)    NOT NULL       COMMENT '会员昵称',
  `member_gender`   char(2)        NOT NULL       COMMENT '会员性别',
  `member_age`      int(10)        NOT NULL       COMMENT '会员年龄',
  `member_city`     varchar(20)    DEFAULT NULL   COMMENT '会员所在城市',
  PRIMARY KEY (`member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------
-- 初始化 - member表数据
-- --------------------------------------------------------
insert into `member` values (1, '赵春花', '女', 22, '成都');
insert into `member` values (2, '罗小弟', '男', 26, '上海');
insert into `member` values (3, '王夏花', '女', 24, '武汉');
insert into `member` values (4, '陈阿姨', '女', 43, '南京');
insert into `member` values (5, '李冬花', '女', 33, '成都');
insert into `member` values (6, '杜二哥', '男', 32, '苏州');
insert into `member` values (7, '张小帅', '男', 27, '成都');
insert into `member` values (8, '周秋花', '女', 28, '成都');
insert into `member` values (9, '刘大叔', '男', 46, '成都');

SET FOREIGN_KEY_CHECKS=1;
