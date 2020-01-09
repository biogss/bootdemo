create table t_product(
	product_id int not null auto_increment comment '产品编号',
	product_code varchar(8) comment '产品代码',
	product_name varchar(64) not null comment '产品名称',
	product_desc varchar(200) comment '产品描述',
	product_img varchar(64) comment '产品图片',
	product_price double comment '产品价格',
	create_time datetime not null comment '创建时间',
	update_time datetime not null comment '更加时间',
	product_status varchar(8) comment '产品状态0-下架1-上架',
	product_type varchar(8) comment '产品类型',
	primary key(product_id)
)engine=innodb charset=utf8 auto_increment=11;

create table t_user(
	user_id int not null auto_increment comment '用户编号',
	user_name varchar(16) comment '用户名',
	mobile_no varchar(11) comment '电话',
	email varchar(32) comment '邮箱',
	sex varchar(8) comment '性别',
	idno varchar(18) comment '证件号码',
	create_time datetime not null comment '创建时间',
	update_time datetime not null comment '更加时间',
	birthday varchar(20) comment '生日 yyyy-mm-dd',
	photo varchar(64) comment '头像',
	password varchar(128) comment '密码',
	name varchar(32) comment '姓名',
	address varchar(200) comment '地址',
	primary key(user_id)
)engine=innodb charset=utf8 auto_increment=11;

create table t_order(
	order_id int not null auto_increment comment '订单编号',
	product_id int not null comment '产品编号',
	user_id int not null comment '用户编号',
	order_money double not null comment '订单金额',
	order_status varchar(8) not null comment '订单状态0-新建1-支付成功2-支付失败3-取消',
	payway varchar(1) comment '支付方式0-支付宝1-微信',
	create_time datetime comment '创建时间',
	update_time datetime comment '更新时间',
	reamrk varchar(200) comment '备注',
	primary key (order_id)
)engine =innodb charset =utf8 auto_increment=10;