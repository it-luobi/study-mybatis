CREATE DATABASE IF NOT EXISTS `study_test`;


USE `study_test`;


DROP TABLE IF EXISTS `hero`;


CREATE TABLE `hero` (
  `id` int(10) NOT NULL,
  `name` varchar(30) DEFAULT NULL,
  `city` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


insert  into `hero`
(`id`,`name`,`city`)
values
(1,'刘备','河北'),
(2,'庞统','湖北'),
(3,'曹操','安徽'),
(4,'黄忠','河南'),
(5,'庞德','甘肃'),
(6,'孔明','山东');


DROP TABLE IF EXISTS `teacher`;


CREATE TABLE `teacher` (
  `id` int(10) NOT NULL,
  `name` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


insert  into `teacher`
(`id`,`name`)
values
(1,'刘老师'),
(2,'罗老师'),
(3,'陈老师');


DROP TABLE IF EXISTS `student`;


CREATE TABLE `student` (
  `id` int(10) NOT NULL,
  `name` varchar(30) DEFAULT NULL,
  `tid` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fktid` (`tid`),
  CONSTRAINT `fktid` FOREIGN KEY (`tid`) REFERENCES `teacher` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


insert  into `student`
(`id`,`name`,`tid`)
values
(1,'张三',1),
(2,'李四',1),
(3,'王五',2),
(4,'赵六',3),
(5,'钱七',2);


DROP TABLE IF EXISTS `member`;


CREATE TABLE `member` (
  `member_id` int unsigned NOT NULL COMMENT '会员ID',
  `member_nick` varchar(20) NOT NULL COMMENT '会员昵称',
  `member_gender` char(2) NOT NULL COMMENT '会员性别',
  `member_age` int NOT NULL COMMENT '会员年龄',
  `member_city` varchar(20) DEFAULT NULL COMMENT '会员所在城市',
  PRIMARY KEY (`member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


insert  into `member`
(`member_id`,`member_nick`,`member_gender`,`member_age`,`member_city`)
values
(1,'赵春花','女',22,'成都'),
(2,'罗小弟','男',26,'上海'),
(3,'王夏花','女',24,'武汉'),
(4,'陈阿姨','女',43,'南京'),
(5,'李冬花','女',33,'成都'),
(6,'杜二哥','男',32,'苏州'),
(7,'张小帅','男',27,'成都'),
(8,'周秋花','女',28,'成都'),
(9,'刘大叔','男',46,'成都');

