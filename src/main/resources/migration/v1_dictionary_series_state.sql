------------
-- SERIES --
------------

insert into dictionary (id, name, type) values (nextval('dictionary_seq'), '104 серия', 2);
insert into dictionary (id, name, type) values (nextval('dictionary_seq'), '105 серия', 2);
insert into dictionary (id, name, type) values (nextval('dictionary_seq'), '106 серия', 2);
insert into dictionary (id, name, type) values (nextval('dictionary_seq'), 'Сталинка', 2);
insert into dictionary (id, name, type) values (nextval('dictionary_seq'), 'Гостинка / Общежитие', 2);
insert into dictionary (id, name, type) values (nextval('dictionary_seq'), 'Индивидуальный проект', 2);
insert into dictionary (id, name, type) values (nextval('dictionary_seq'), 'Хрущёвка', 2);
insert into dictionary (id, name, type) values (nextval('dictionary_seq'), 'Барачного типа', 2);
insert into dictionary (id, name, type) values (nextval('dictionary_seq'), '106 улучшенная', 2);


-----------
-- STATE --
-----------

insert into dictionary (id, name, type) values (nextval('dictionary_seq'), 'Сдан ПСО',3);
insert into dictionary (id, name, type) values (nextval('dictionary_seq'), 'Без ремонта',3);
insert into dictionary (id, name, type) values (nextval('dictionary_seq'), 'Хорошее',3);
insert into dictionary (id, name, type) values (nextval('dictionary_seq'), 'Среднее',3);
insert into dictionary (id, name, type) values (nextval('dictionary_seq'), 'Евроремонт',3);
insert into dictionary (id, name, type) values (nextval('dictionary_seq'), 'Строящийся ПСО',3);