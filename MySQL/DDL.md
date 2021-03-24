数据定义语言

# 创建库
```sql
create database if not exists 库名;
```

# 删除库
```sql
drop database if exists 库名
```

https://blog.csdn.net/weixin_44535476/article/details/88687795


# 建表
```SQL
CREATE TABLE IF NOT EXISTS `student`(
	`id`  INT(4) NOT NULL AUTO_INCREMENT COMMENT '序号',
	`name` VARCHAR(30) NOT NULL DEFAULT '匿名' COMMENT `姓名`,
	`pwd` VARCHAR(30) NOT NULL DEFAULT '123456' COMMENT `密码`,
	`sex` VARCHAR(2) NOT NULL DEFAULT '男' COMMENT `性别`,
	`birthday` DATETIME NOT NULL DEFAULT NULL COMMENT `生日`,
	`address` VARCHAR(100) NOT NULL DEFAULT NULL COMMENT `地址`,
	`email` VARCHAR(50) NOT NULL DEFAULT NULL COMMENT `邮箱`,
	PRIMARY KEY(`id`)
)ENGINE = INNODB DEFAULT CHARSET=utf-8mb;
```