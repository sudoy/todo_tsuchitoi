
create table todo(
	id int primary key auto_increment,
	title varchar(255) not null,
	detail varchar(255) not null,
	importance int not null,
	limit_date date
);

insert into todo(
	title, detail, importance, limit_date
)values(
	'テストテスト', 'SQL確認テストの採点と報告書の作成をする。', '3', '2015/06/15'
);
insert into todo(
	title, detail, importance, limit_date
)values(
	'jsp/サーブレット', 'Todoリストのjsp/サーブレットの作成', '2', '2015/06/15'
);
insert into todo(
	title, detail, importance, limit_date
)values(
	'table作成', 'Todoリストのデータベース、テーブル作成', '1', null
);