DROP TABLE if EXISTS t_springmvc_car;

CREATE TABLE if NOT EXISTS t_springmvc_car(
	id int PRIMARY key auto_increment,
	brand VARCHAR(64) not null comment '品牌',
	series VARCHAR(64) not null comment '车系',
	price int not null comment '价格',
	licensing_time VARCHAR(7) comment '上牌时间',
	level VARCHAR(1) comment '级别',
	gearbox VARCHAR(1) comment '变速箱',
	output_volume VARCHAR(1) comment '排量',
	mileage int comment '里程 (万公里)',
	location VARCHAR(64) COMMENT '归属地',
	pic VARCHAR(128) comment '图片地址',
	summary VARCHAR(512) COMMENT '概述',
	create_time datetime comment '创建时间'
	
);
