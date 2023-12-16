-- Создание таблицы с типами животных
drop table if exists animal_types cascade;
create table animal_types (
	id serial primary key,
	type_name text not null unique
);

-- Создание таблицы с группами животных
drop table if exists animal_groups cascade;
create table animal_groups (
	id serial primary key,
	group_name text not null unique
);

-- Создание таблицы соотношения имени таблицы с видом животного
drop table if exists class_names cascade;
create table class_names (
	id serial primary key,
	ru_id int not null unique,
	eng text not null unique,
	foreign key (ru_id) references animal_types(id)
);

-- Создание таблицы соотношения групп и видов животных
drop table if exists types_groups cascade;
create table types_groups (
	id serial primary key,
	grp_id int not null,
	type_id int not null,
	foreign key (grp_id) references animal_groups(id),
	foreign key (type_id) references animal_types(id)
);

-- Создание таблицы "Собаки"
drop table if exists dog cascade;
create table dog (
	id serial primary key,
	type_id int not null,
	group_id int not null,
	name text not null,
	birthday date,
	commands text,
	foreign key (type_id) references animal_types(id) on update cascade on delete cascade,
	foreign key (group_id) references animal_groups(id) on update cascade on delete cascade
);

-- Создание таблицы "Коты"
drop table if exists cat cascade;
create table cat (
	id serial primary key,
	type_id int not null,
	group_id int not null,
	name text not null,
	birthday date,
	commands text,
	foreign key (type_id) references animal_types(id) on update cascade on delete cascade,
	foreign key (group_id) references animal_groups(id) on update cascade on delete cascade
);

-- Создание таблицы "Хомяки"
drop table if exists hamster cascade;
create table hamster (
	id serial primary key,
	type_id int not null,
	group_id int not null,
	name text not null,
	birthday date,
	commands text,
	foreign key (type_id) references animal_types(id) on update cascade on delete cascade,
	foreign key (group_id) references animal_groups(id) on update cascade on delete cascade
);

-- Создание таблицы "Верблюды"
drop table if exists camel cascade;
create table camel (
	id serial primary key,
	type_id int not null,
	group_id int not null,
	name text not null,
	birthday date,
	commands text,
	foreign key (type_id) references animal_types(id) on update cascade on delete cascade,
	foreign key (group_id) references animal_groups(id) on update cascade on delete cascade
);

-- Создание таблицы "Лошади"
drop table if exists horse cascade;
create table horse (
	id serial primary key,
	type_id int not null,
	group_id int not null,
	name text not null,
	birthday date,
	commands text,
	foreign key (type_id) references animal_types(id) on update cascade on delete cascade,
	foreign key (group_id) references animal_groups(id) on update cascade on delete cascade
);

-- Создание таблицы "Ослы"
drop table if exists donkey cascade;
create table donkey (
	id serial primary key,
	type_id int not null,
	group_id int not null,
	name text not null,
	birthday date,
	commands text,
	foreign key (type_id) references animal_types(id) on update cascade on delete cascade,
	foreign key (group_id) references animal_groups(id) on update cascade on delete cascade
);

-- Заполнение таблицы "Типы животных"
insert into animal_types (type_name) values ('собака'), ('кот'), ('хомяк'), ('верблюд'), ('лошадь'), ('осёл');

-- Заполнение таблицы "Группы животных"
insert into animal_groups (group_name) values ('домашние'), ('вьючные');

-- Заполнение данными таблицы соотношения имен таблиц и типов животных
insert into class_names (ru_id, eng) values
(1, 'dog'),
(2, 'cat'),
(3, 'hamster'),
(4, 'camel'),
(5, 'horse'),
(6, 'donkey');

-- Заполнение данными таблицы соотношения типов и видов животных
insert into types_groups (grp_id, type_id) values (1, 1), (1, 2), (1, 3), (2, 4), (2, 5), (2, 6);

-- Заполнение таблицы "Собаки"
insert into dog (type_id, group_id, name, birthday, commands) values
(1, 1, 'Фидо',  '2020-01-01', 'сидеть, место, неси'),
(1, 1, 'Бадди', '2018-12-10', 'сидеть, лапу, голос'),
(1, 1, 'Белла', '2019-11-11', 'сидеть, место, перевернись');

-- Заполнение таблицы "Коты"
insert into cat (type_id, group_id, name, birthday, commands) values
(2, 1, 'Вискерс', '2019-05-15', 'сидеть, прыжок'),
(2, 1, 'Смудж', '2020-02-20', 'сидеть, прыжок, поцарапать'),
(2, 1, 'Оливер', '2020-06-30', 'мяукнуть, поцарапать, прыжок');

-- Заполнение таблицы "Хомяки"
insert into hamster (type_id, group_id, name, birthday, commands) values
(3, 1, 'Хамми', '2021-03-10', 'перевернуться, спрятаться'),
(3, 1, 'Пинат', '2021-08-01', 'перевернуться, закрутиться');

-- Заполнение таблицы "Верблюды"
insert into camel (type_id, group_id, name, birthday, commands) values
(4, 2, 'Сэнди', '2016-11-03', 'прогуляться, нести груз'),
(4, 2, 'Дюна', '2018-12-12', 'прогуляться, сидеть'),
(4, 2, 'Сахара', '2015-08-14', 'прогуляться, бежать');

-- Заполнение таблицы "Лошади"
insert into horse (type_id, group_id, name, birthday, commands) values
(5, 2, 'Гром', '2015-07-21', 'трусца, галоп'),
(5, 2, 'Шторм', '2014-05-05', 'трусца, галоп'),
(5, 2, 'Блейз', '2016-02-29', 'трусца, галоп, прыжок');

-- Заполнение таблицы "Ослы"
insert into donkey (type_id, group_id, name, birthday, commands) values
(6, 2, 'Иа', '2017-09-18', 'прогуляться, нести груз, реветь'),
(6, 2, 'Бурро', '2019-01-23', 'прогуляться, реветь, легнуть');

-- Создание функции получения всех животных по виду
-- Вход: имя таблицы
-- Выход: таблица
create or replace function sp_get_animals(_table text)
returns table(id int, group_name text, type_name text, name text, birthday date, commands text) as $$
begin
    return query execute 'select t.id, group_name, type_name, name, birthday, commands
	from ' ||_table|| ' t
	join animal_groups ag on t.group_id = ag.id
	join animal_types "at" on t.type_id = "at".id;';
end;
$$ language plpgsql;

-- Создание функции получения всех животных c заданной сортировкой
-- Вход: поле, по которому сортируются данные
-- Выход: таблица
create or replace function sp_get_all_animals(_field_name text)
returns table(id int, group_name text, type_name text, name text, birthday date, commands text) as $$
begin
	return query execute 'select * from sp_get_animals(''camel'')
	union
	select * from sp_get_animals(''cat'')
	union
	select * from sp_get_animals(''dog'')
	union
	select * from sp_get_animals(''donkey'')
	union
	select * from sp_get_animals(''hamster'')
	union
	select * from sp_get_animals(''horse'')
	order by ' || _field_name;
end;
$$ language plpgsql;

-- Создание функции получения животного по виду с указанием ID
-- Вход: имя таблицы, id
-- Выход: таблица
create or replace function sp_get_animal(_table text, _id int)
returns table(id int, group_name text, type_name text, name text, birthday date, commands text) as $$
begin
    return query execute 'select t.id, group_name, type_name, name, birthday, commands
	from ' ||_table|| ' t
	join animal_groups ag on t.group_id = ag.id
	join animal_types "at" on t.type_id = "at".id
	where t.id = ' ||_id;
end;
$$ language plpgsql;

-- Создание функции, вычисляющей доступные id в таблице
-- Вход: имя таблицы
-- Выход: таблица id
create or replace function sp_get_busy_id(_table text)
returns table(id int) as $$
begin
	execute 'create or replace view v_seq as
	(select generate_series(1, (select max(id) from ' ||_table|| ')) as id)';
	
    return query execute 'select v.id from v_seq v 
	full join ' ||_table|| ' t on v.id = t.id
	where v.id is null or t.id is null;';
end;
$$ language plpgsql;

-- Создание функции для получения имен всех таблиц
-- Вход: нет
-- Выход: имена всех таблиц в базе (исключая временные таблицы и представления)
create or replace function sp_check_table(_table text)
returns boolean as $$
begin
    return exists (
    	select 1 
		from information_schema.tables
		where table_schema = 'public' and table_type = 'BASE TABLE' and table_name::text = $1
	);
end;
$$ language plpgsql;

-- Создание функции для получения ID записи по заданному типу из таблицы animal_types
-- Вход: имя типа
-- Выход: ID
create or replace function sp_get_id_from_animal_types(_type_name text)
returns int as $$
begin
	return (select id from animal_types where type_name = $1);
end;
$$ language plpgsql;

-- Создание функции для получения ID записи по заданной группе из таблицы animal_groups
-- Вход: имя типа
-- Выход: ID
create or replace function sp_get_id_from_animal_groups(_type_name text)
returns int as $$
begin
	return (select id from animal_groups where group_name = $1);
end;
$$ language plpgsql;

-- Создание функции для получения записи по заданному ID из таблицы animal_types
-- Вход: ID
-- Выход: имя типа
create or replace function sp_get_type_from_animal_types(_id int)
returns text as $$
begin
	return (select type_name from animal_types where id = $1);
end;
$$ language plpgsql;

-- Создание функции для получения записи по заданному ID из таблицы animal_groups
-- Вход: ID
-- Выход: имя группы
create or replace function sp_get_group_from_animal_groups(_id int)
returns text as $$
begin
	return (select group_name from animal_groups where id = $1);
end;
$$ language plpgsql;

-- Создание функции для получения всех видов животных
-- Вход: нет
-- Выход: таблица видов животных
create or replace function sp_get_animal_types()
returns table(type_name text) as $$
begin
	return query execute 'select type_name from animal_types order by type_name';
end;
$$ language plpgsql;

-- Создание функции для получения всех групп животных
-- Вход: нет
-- Выход: таблица видов животных
create or replace function sp_get_animal_groups()
returns table(group_name text) as $$
begin
	return query execute 'select group_name from animal_groups order by group_name';
end;
$$ language plpgsql;

-- Создание функции получения имени таблицы по виду животного
-- Вход: вид животного
-- Выход: имя таблицы
create or replace function sp_get_table(_ru text)
returns text as $$
begin
	return (select cn.eng from animal_types at2
	join class_names cn on at2.id = cn.ru_id
	where at2.type_name = $1::text);
end;
$$ language plpgsql;

-- Создание функции получения вида животного по имени таблицы
-- Вход: имя таблицы
-- Выход: вид животного
create or replace function sp_get_type(_eng text)
returns text as $$
begin
	return (select type_name from animal_types at2
	join class_names cn on at2.id = cn.ru_id
	where cn.eng = $1::text);
end;
$$ language plpgsql;

-- Создание функции получения id группы животных по его виду
-- Вход: вид животного
-- Выход: группа животного
create or replace function sp_get_group_by_type(_type text)
returns text as $$
begin
	return (select group_name from animal_groups ag
	join types_groups tg on ag.id = tg.grp_id
	join animal_types at2 on at2.id = tg.type_id
	where at2.type_name = $1::text);
end;
$$ language plpgsql;

-- Создание функции получения всех соответствий имени класса виду животного
-- Вход: нет
-- Выход: таблица соответствий
create or replace function sp_get_all_ru_eng_animals()
returns table(ru text, eng text) as $$
begin
	return query execute 'select at2.type_name as ru, cn.eng
	from class_names cn
	join animal_types at2 on cn.ru_id = at2.id;';
end;
$$ language plpgsql;

-- Создание функции проверки наличия животного с заданными ID и типом
-- Вход: имя таблицы, id
-- Выход: boolean
create or replace function sp_if_exists_animal(_table text, _id int)
returns boolean as $$
declare _exists boolean;
begin
	execute 'select exists (select 1 from ' || _table || ' where id = ' || _id || ')' into _exists;
    return _exists;
end;
$$ language plpgsql;