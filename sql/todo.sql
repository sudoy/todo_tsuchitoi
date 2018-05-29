
create table todo(
	id int primary key auto_increment,
	題名 varchar(255) not null,
	詳細 varchar(255) not null,
	重要度 int not null,
	期限 date
);

insert into todo(
	題名, 詳細, 重要度, 期限
)values(
	'テストテスト', 'SQL確認テストの採点と報告書の作成をする。', '3', '2015/06/15'
);
insert into todo(
	題名, 詳細, 重要度, 期限
)values(
	'jsp/サーブレット', 'Todoリストのjsp/サーブレットの作成', '2', '2015/06/15'
);
insert into todo(
	題名, 詳細, 重要度, 期限
)values(
	'table作成', 'Todoリストのデータベース、テーブル作成', '1', null
);