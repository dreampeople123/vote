--用户表
create table VoteUser
(
  vuId   NUMBER(10) primary key,           --用户id
  vuUsername VARCHAR2(20) not null,           --用户名
  vuPassword  VARCHAR2(20) not null,           --用户密码
  vuStatus    NUMBER(6) not null,              --用户激活状态，2没有激活，1激活
  vuVersion   NUMBER(10) not null,	--用户状态
  vuEmail varchar2(50)--角色vuEmail
);
create sequence seq_voteusers_vuId
       START WITH 100010    -- 从1000开始计数 
       INCREMENT BY 1;
 select * from VOTEUSER;
 select * from VoteSubject;
 select * from VoteOption;
 select * from VoteItem;
 drop sequence seq_item;
 drop sequence seq_subject;
 drop sequence seq_option;
 create sequence seq_item start with 500;
  create sequence seq_subject start with 441;
  create sequence seq_option start with 442;
 alter table VoteItem add constraint uk_VoteItem_vuId unique(vuId,voId);
 
 alter table VoteItem 
 add cons
  drop table VOTEUSER;
  drop table VoteSubject;
  drop table VoteOption;
  drop table VoteItem;
--投票主题
create table VoteSubject
(
  vsId    NUMBER(10) primary key,            --投票主题编号
  vsTitle VARCHAR2(200) not null,         --投票主题
  vsType  NUMBER(6) not null              --投票类型:   单选  1    多选   2
);

--投票内容对应的选项表
create table VoteOption
(
  voId     NUMBER(10) primary key,  --编号
  voOption VARCHAR2(100) not null,--投票选项
  vsId     NUMBER(10) not null,  --投票主题编号
  voOrder  NUMBER(10) not null  --显示顺序
);

select distinct count(vuid) from VoteItem where
		VoteItem.vsId=103 
--查询 su.vsId ,vsTitle ,选项数,投票数 
select  su.vsId ,vsTitle ,选项数,投票数 from  VoteSubject su 
left join ( select vsId ,count(1) 选项数 from VoteOption group by vsId) a on  a.vsId=su.vsId 
left join (select vsId ,count(1) 投票数 from VoteItem group by vsId) b on su.vsId=b.vsId;
--查询 su.vsId ,vsTitle ,选项数,投票数
select vsId,vsTitle ,(select count(1) from  VoteOption where   VoteOption.vsId=s.vsId) 选项数,
(select count(1) from  VoteItem where   VoteItem.vsId=s.vsId) 选项数 from 
VoteSubject s;
select vsId ,count(*) opno from VoteOption group by vsId;
select vsId ,count(*) itno from VoteItem group by vsId;

--用户投票取值表
create table VoteItem
(
  viId      NUMBER(10) primary key, --编号
  voId      NUMBER(10) not null, --投票选项id
  vsId      NUMBER(10) not null, --投票主题编号id
  vuId	    NUMBER(10) not null --用户id
);


--添加用户
insert into VoteUser (vuUsername,vuId, vuPassword, vuStatus, vuVersion,vuEmail)
values ('ss', 100000, 'a', 1, 1,'adfasdf@qq.com');
insert into VoteUser (vuUsername,vuId, vuPassword, vuStatus, vuVersion,vuEmail)
values ('admin', 100001, 'a', 2, 1,'adfasdf@qq.com');
insert into VoteUser (vuUsername,vuId, vuPassword, vuStatus, vuVersion,vuEmail)
values ('zy', 100002, 'a', 1, 0,'adfasdf@qq.com');
insert into VoteUser (vuUsername,vuId, vuPassword, vuStatus, vuVersion,vuEmail)
values ('yc', 100003, 'a', 2, 0,'adfasdf@qq.com');
insert into VoteUser (vuUsername,vuId, vuPassword, vuStatus, vuVersion,vuEmail)
values ('yc1', 100004, 'a', 2, 1,'adfasdf@qq.com');
insert into VoteUser (vuUsername,vuId, vuPassword, vuStatus, vuVersion,vuEmail)
values ('yc2', 100005, 'a', 2, 1,'adfasdf@qq.com');
insert into VoteUser (vuUsername,vuId, vuPassword, vuStatus, vuVersion,vuEmail)
values ('yc3',100006, 'a', 2, 1,'adfasdf@qq.com');
insert into VoteUser (vuUsername,vuId, vuPassword, vuStatus, vuVersion,vuEmail)
values ('yc4',100007, 'a', 2, 1,'adfasdf@qq.com');
insert into VoteUser (vuUsername,vuId, vuPassword, vuStatus, vuVersion,vuEmail)
values ('yc5', 100008, 'a', 2, 1,'adfasdf@qq.com');
insert into VoteUser (vuUsername,vuId, vuPassword, vuStatus, vuVersion,vuEmail)
values ('yc6', 100009, 'a', 1, 0,'adfasdf@qq.com');

--添加投票主题
insert into VoteSubject (vsId, vsTitle, vsType)
values (103, '选出你心目中最好的下载工具', 2);
insert into VoteSubject (vsId, vsTitle, vsType)
values (104, '选出你心目中最好的输入法', 1);
insert into VoteSubject (vsId, vsTitle, vsType)
values (105, '选出你心目中最好的网络聊天工具', 1);
insert into VoteSubject (vsId, vsTitle, vsType)
values (440, '你最想区的地方', 1);
insert into VoteSubject (vsId, vsTitle, vsType)
values (101, '选出你心目中最好的浏览器', 1);
insert into VoteSubject (vsId, vsTitle, vsType)
values (102, '选出你心目中最好的杀毒软件', 1);

--添加主题中的选项
insert into VoteOption (voId, voOption, vsId, voOrder)
values (397, '腾讯QQ', 105, 1);
insert into VoteOption (voId, voOption, vsId, voOrder)
values (398, 'MSN', 105, 2);
insert into VoteOption (voId, voOption, vsId, voOrder)
values (380, '迅雷', 103, 1);
insert into VoteOption (voId, voOption, vsId, voOrder)
values (399, '新浪UC', 105, 3);
insert into VoteOption (voId, voOption, vsId, voOrder)
values (400, '飞信', 105, 4);
insert into VoteOption (voId, voOption, vsId, voOrder)
values (401, 'Skype', 105, 5);
insert into VoteOption (voId, voOption, vsId, voOrder)
values (402, '阿里旺旺', 105, 6);
insert into VoteOption (voId, voOption, vsId, voOrder)
values (403, '百度HI', 105, 7);
insert into VoteOption (voId, voOption, vsId, voOrder)
values (404, '微软IE浏览器', 101, 1);
insert into VoteOption (voId, voOption, vsId, voOrder)
values (405, '火狐（Firefox）浏览器', 101, 2);
insert into VoteOption (voId, voOption, vsId, voOrder)
values (381, '网际快车', 103, 2);
insert into VoteOption (voId, voOption, vsId, voOrder)
values (382, '电驴', 103, 3);
insert into VoteOption (voId, voOption, vsId, voOrder)
values (383, '比特精灵', 103, 4);
insert into VoteOption (voId, voOption, vsId, voOrder)
values (384, '超级旋风', 103, 5);
insert into VoteOption (voId, voOption, vsId, voOrder)
values (385, '搜狗拼音', 104, 1);
insert into VoteOption (voId, voOption, vsId, voOrder)
values (386, '搜狗五笔', 104, 2);
insert into VoteOption (voId, voOption, vsId, voOrder)
values (387, 'QQ拼音', 104, 3);
insert into VoteOption (voId, voOption, vsId, voOrder)
values (388, 'QQ五笔', 104, 4);
insert into VoteOption (voId, voOption, vsId, voOrder)
values (389, '谷歌拼音', 104, 5);
insert into VoteOption (voId, voOption, vsId, voOrder)
values (390, '紫光拼音', 104, 6);
insert into VoteOption (voId, voOption, vsId, voOrder)
values (391, '智能ABC', 104, 7);
insert into VoteOption (voId, voOption, vsId, voOrder)
values (392, '微软拼音', 104, 8);
insert into VoteOption (voId, voOption, vsId, voOrder)
values (393, '万能拼音', 104, 9);
insert into VoteOption (voId, voOption, vsId, voOrder)
values (394, '万能五笔', 104, 10);
insert into VoteOption (voId, voOption, vsId, voOrder)
values (395, '极品拼音', 104, 11);
insert into VoteOption (voId, voOption, vsId, voOrder)
values (396, '极品五笔', 104, 12);
insert into VoteOption (voId, voOption, vsId, voOrder)
values (406, '世界之窗浏览器', 101, 3);
insert into VoteOption (voId, voOption, vsId, voOrder)
values (407, '360浏览器', 101, 4);
insert into VoteOption (voId, voOption, vsId, voOrder)
values (408, '傲游浏览器', 101, 5);
insert into VoteOption (voId, voOption, vsId, voOrder)
values (409, '谷歌（Chrome）浏览器', 101, 6);
insert into VoteOption (voId, voOption, vsId, voOrder)
values (410, '卡巴斯基', 102, 1);
insert into VoteOption (voId, voOption, vsId, voOrder)
values (411, '360杀毒', 102, 2);
insert into VoteOption (voId, voOption, vsId, voOrder)
values (412, 'McAfee', 102, 3);
insert into VoteOption (voId, voOption, vsId, voOrder)
values (413, 'AVG', 102, 4);
insert into VoteOption (voId, voOption, vsId, voOrder)
values (414, '诺顿杀毒', 102, 5);
insert into VoteOption (voId, voOption, vsId, voOrder)
values (415, '瑞星杀毒', 102, 6);
insert into VoteOption (voId, voOption, vsId, voOrder)
values (416, '金山毒霸', 102, 7);
insert into VoteOption (voId, voOption, vsId, voOrder)
values (417, '江民杀毒', 102, 8);
insert into VoteOption (voId, voOption, vsId, voOrder)
values (418, '微点防御', 102, 9);
insert into VoteOption (voId, voOption, vsId, voOrder)
values (419, '趋势杀毒', 102, 10);
insert into VoteOption (voId, voOption, vsId, voOrder)
values (441, '地域', 440, 1);
insert into VoteOption (voId, voOption, vsId, voOrder)
values (442, '天堂', 440, 2);

--添加选择结果
insert into VoteItem (viId, voId, vsId,vuId)
values (422, 405, 101,100004);
insert into VoteItem (viId, voId, vsId,vuId)
values (423, 405, 101, 100005);
insert into VoteItem (viId, voId, vsId,vuId)
values (424, 404, 101, 100006);
insert into VoteItem (viId, voId, vsId,vuId)
values (425, 407, 101, 100007);
insert into VoteItem (viId, voId, vsId,vuId)
values (426, 408, 101, 100008);
insert into VoteItem (viId, voId, vsId,vuId)
values (427, 409, 101, 100003);
insert into VoteItem (viId, voId, vsId,vuId)
values (445, 404, 101, 100002);
insert into VoteItem (viId, voId, vsId,vuId)
values (367, 136, 135, 100001);
insert into VoteItem (viId, voId, vsId,vuId)
values (420, 405, 101, 100001);
insert into VoteItem (viId, voId, vsId,vuId)
values (421, 406, 101, 100000);














