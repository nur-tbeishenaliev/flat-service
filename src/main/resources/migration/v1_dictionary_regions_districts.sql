---------------------
-- REGION_DISTRICT --
---------------------

insert into dictionary (id, name, type)
values (nextval('dictionary_seq'), 'Южные микрорайоны', 0);

insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), '3 мкр',1, (select id from dictionary where name = 'Южные микрорайоны'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), '4 мкр',1, (select id from dictionary where name = 'Южные микрорайоны'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), '5 мкр',1, (select id from dictionary where name = 'Южные микрорайоны'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), '6 мкр',1, (select id from dictionary where name = 'Южные микрорайоны'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), '7 мкр',1, (select id from dictionary where name = 'Южные микрорайоны'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), '8 мкр',1, (select id from dictionary where name = 'Южные микрорайоны'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), '9 мкр',1, (select id from dictionary where name = 'Южные микрорайоны'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), '10 мкр',1, (select id from dictionary where name = 'Южные микрорайоны'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), '11 мкр',1, (select id from dictionary where name = 'Южные микрорайоны'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), '12 мкр',1, (select id from dictionary where name = 'Южные микрорайоны'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'Асанбай мкр.',1, (select id from dictionary where name = 'Южные микрорайоны'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'Кок-Жар мкр.',1, (select id from dictionary where name = 'Южные микрорайоны'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'Улан мкр.',1, (select id from dictionary where name = 'Южные микрорайоны'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'Улан-2 мкр',1, (select id from dictionary where name = 'Южные микрорайоны'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), '7 апреля / Южная магистраль',1, (select id from dictionary where name = 'Южные микрорайоны'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'Джал мкр',1, (select id from dictionary where name = 'Южные микрорайоны'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'с. Орто-Сай',1, (select id from dictionary where name = 'Южные микрорайоны'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'жилой городок Совмин',1, (select id from dictionary where name = 'Южные микрорайоны'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'Старый Аэропорт (Ак-Кеме)',1, (select id from dictionary where name = 'Южные микрорайоны'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'Таш-Рабат торговый центр',1, (select id from dictionary where name = 'Южные микрорайоны'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'парк Ата-Тюрк',1, (select id from dictionary where name = 'Южные микрорайоны'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'Сухэ-Батора / Юж.магистраль',1, (select id from dictionary where name = 'Южные микрорайоны'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'Азия Мол',1, (select id from dictionary where name = 'Южные микрорайоны'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'БГУ',1, (select id from dictionary where name = 'Южные микрорайоны'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'Политех',1, (select id from dictionary where name = 'Южные микрорайоны'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'Киргизия-1 ж/м',1, (select id from dictionary where name = 'Южные микрорайоны'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'Южная магистраль / пр.Чынгыза Айтматова',1, (select id from dictionary where name = 'Южные микрорайоны'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'ж/м Кок-Жар',1, (select id from dictionary where name = 'Южные микрорайоны'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'село Кок-Жар',1, (select id from dictionary where name = 'Южные микрорайоны'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'Физкультурный',1, (select id from dictionary where name = 'Южные микрорайоны'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'Район Космос',1, (select id from dictionary where name = 'Южные микрорайоны'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'Ахунбаева/Чапаева',1, (select id from dictionary where name = 'Южные микрорайоны'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'Ынтымак ж/м',1, (select id from dictionary where name = 'Южные микрорайоны'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'Воронцовка',1, (select id from dictionary where name = 'Южные микрорайоны'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'Юж.Магистраль / Советская',1, (select id from dictionary where name = 'Южные микрорайоны'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'Село Байтик',1, (select id from dictionary where name = 'Южные микрорайоны'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'Физприборы',1, (select id from dictionary where name = 'Южные микрорайоны'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'Баха/Гагарина',1, (select id from dictionary where name = 'Южные микрорайоны'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'Село Арашан',1, (select id from dictionary where name = 'Южные микрорайоны'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'Село Кой-Таш',1, (select id from dictionary where name = 'Южные микрорайоны'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'Село Беш-Кунгей',1, (select id from dictionary where name = 'Южные микрорайоны'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), '7 апреля/Горького',1, (select id from dictionary where name = 'Южные микрорайоны'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'Манас айылы',1, (select id from dictionary where name = 'Южные микрорайоны'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'ж/м Киргизия-2',1, (select id from dictionary where name = 'Южные микрорайоны'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'Село Чон-Арык',1, (select id from dictionary where name = 'Южные микрорайоны'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'Ахунбаева/Карла Маркса',1, (select id from dictionary where name = 'Южные микрорайоны'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'с. Кашка-Суу',1, (select id from dictionary where name = 'Южные микрорайоны'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'Село Баш-Кара-Суу',1, (select id from dictionary where name = 'Южные микрорайоны'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'Село Сарбан',1, (select id from dictionary where name = 'Южные микрорайоны'));

insert into dictionary (id, name, type)
values(nextval('dictionary_seq'), 'Центр города', 0);

insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'ЦУМ',1, (select id from dictionary where name = 'Центр города'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'Восток-5',1, (select id from dictionary where name = 'Центр города'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'Центральная мечеть',1, (select id from dictionary where name = 'Центр города'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'Дордой Плаза',1, (select id from dictionary where name = 'Центр города'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'Моссовет',1, (select id from dictionary where name = 'Центр города'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'Бишкек-Парк',1, (select id from dictionary where name = 'Центр города'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'Дворец Спорта',1, (select id from dictionary where name = 'Центр города'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'Военторг',1, (select id from dictionary where name = 'Центр города'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'Юбилейка',1, (select id from dictionary where name = 'Центр города'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), '1000 мелочей',1, (select id from dictionary where name = 'Центр города'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'Шлагбаум',1, (select id from dictionary where name = 'Центр города'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'Ошский рынок',1, (select id from dictionary where name = 'Центр города'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'Вечерка',1, (select id from dictionary where name = 'Центр города'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'Филармония',1, (select id from dictionary where name = 'Центр города'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'Юг-2 мкр',1, (select id from dictionary where name = 'Центр города'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'Золотой квадрат (от Боконбаева до Киевской, от Советской до Орозбекова)',1, (select id from dictionary where name = 'Центр города'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'Госрегистр',1, (select id from dictionary where name = 'Центр города'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'Молодая Гвардия',1, (select id from dictionary where name = 'Центр города'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'Карпинка',1, (select id from dictionary where name = 'Центр города'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'Чуй-Алматинка',1, (select id from dictionary where name = 'Центр города'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'ТИХИЙ ЦЕНТР (от ул. Манаса до ул.Калык Акиева)',1, (select id from dictionary where name = 'Центр города'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'Боконбаева/Исанова',1, (select id from dictionary where name = 'Центр города'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'КНУ им Ж.Баласагына',1, (select id from dictionary where name = 'Центр города'));

insert into dictionary (id, name, type)
values(nextval('dictionary_seq'), 'Восточная часть города', 0);

insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'Ворошилова',1, (select id from dictionary where name = 'Восточная часть города'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'Таатан',1, (select id from dictionary where name = 'Восточная часть города'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'Тунгуч мкр',1, (select id from dictionary where name = 'Восточная часть города'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'Аламедин-1',1, (select id from dictionary where name = 'Восточная часть города'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'Городок Строителей',1, (select id from dictionary where name = 'Восточная часть города'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'Городок Энергетиков',1, (select id from dictionary where name = 'Восточная часть города'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'Учкун мкр',1, (select id from dictionary where name = 'Восточная часть города'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'Аю Гранд',1, (select id from dictionary where name = 'Восточная часть города'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'Алтын-Ордо',1, (select id from dictionary where name = 'Восточная часть города'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'Полицейский Городок',1, (select id from dictionary where name = 'Восточная часть города'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'Кара-Жыгач',1, (select id from dictionary where name = 'Восточная часть города'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'Рухий-Мурас',1, (select id from dictionary where name = 'Восточная часть города'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'ТЭЦ',1, (select id from dictionary where name = 'Восточная часть города'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'Токольдош ж/м',1, (select id from dictionary where name = 'Восточная часть города'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'Аламединский рынок',1, (select id from dictionary where name = 'Восточная часть города'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'Учкун ж/м',1, (select id from dictionary where name = 'Восточная часть города'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'Село Лебединовка',1, (select id from dictionary where name = 'Восточная часть города'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'с.Новопокровка',1, (select id from dictionary where name = 'Восточная часть города'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'Восточный Автовокзал',1, (select id from dictionary where name = 'Восточная часть города'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'Горького/Алматинка',1, (select id from dictionary where name = 'Восточная часть города'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'Оскон-Ордо',1, (select id from dictionary where name = 'Восточная часть города'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'Село Кара-Жыгач',1, (select id from dictionary where name = 'Восточная часть города'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'Село Бек-Tоо',1, (select id from dictionary where name = 'Восточная часть города'));

insert into dictionary (id, name, type)
values(nextval('dictionary_seq'), 'Западная часть города', 0);

insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'Ак-Ордо ж/м',1, (select id from dictionary where name = 'Западная часть города'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'Кудайберген',1, (select id from dictionary where name = 'Западная часть города'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'Достук мкр',1, (select id from dictionary where name = 'Западная часть города'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'Пишпек',1, (select id from dictionary where name = 'Западная часть города'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'Ала-Тоо ж/м',1, (select id from dictionary where name = 'Западная часть города'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'Новопавловка с.',1, (select id from dictionary where name = 'Западная часть города'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'Алтын-Ордо',1, (select id from dictionary where name = 'Западная часть города'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'Авторынок',1, (select id from dictionary where name = 'Западная часть города'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'Ак-Орго ж/м',1, (select id from dictionary where name = 'Западная часть города'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'Арча-Бешик ж/м',1, (select id from dictionary where name = 'Западная часть города'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'Кызыл-Аскер',1, (select id from dictionary where name = 'Западная часть города'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'Рабочий Городок',1, (select id from dictionary where name = 'Западная часть города'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), '4-Гор.больница',1, (select id from dictionary where name = 'Западная часть города'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'Кун-Туу ж/м',1, (select id from dictionary where name = 'Западная часть города'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'Киркомстром',1, (select id from dictionary where name = 'Западная часть города'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'Военно-Антоновка',1, (select id from dictionary where name = 'Западная часть города'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'Селекция',1, (select id from dictionary where name = 'Западная часть города'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'Село Орок',1, (select id from dictionary where name = 'Западная часть города'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'Село Джал',1, (select id from dictionary where name = 'Западная часть города'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'Село Байгельди',1, (select id from dictionary where name = 'Западная часть города'));

insert into dictionary (id, name, type)
values(nextval('dictionary_seq'), 'Северная часть города', 0);

insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'Дордой',1, (select id from dictionary where name = 'Северная часть города'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'Ак-Босого ж/м',1, (select id from dictionary where name = 'Северная часть города'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'Западный Автовокзал',1, (select id from dictionary where name = 'Северная часть города'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'Старый толчок',1, (select id from dictionary where name = 'Северная часть города'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'Церковь',1, (select id from dictionary where name = 'Северная часть города'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'с.Пригород',1, (select id from dictionary where name = 'Северная часть города'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'Ж/м Семетей',1, (select id from dictionary where name = 'Северная часть города'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'Село Ленинское',1, (select id from dictionary where name = 'Северная часть города'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'с.Маевка',1, (select id from dictionary where name = 'Северная часть города'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'Баят р-н',1, (select id from dictionary where name = 'Северная часть города'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'Ж/м Биримдик',1, (select id from dictionary where name = 'Северная часть города'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'Жилмассив Энесай',1, (select id from dictionary where name = 'Северная часть города'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'Гоин',1, (select id from dictionary where name = 'Северная часть города'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'Нижняя Ала-Арча',1, (select id from dictionary where name = 'Северная часть города'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'Ж/М Бакай-Ата',1, (select id from dictionary where name = 'Северная часть города'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'ж/м Красный Строитель',1, (select id from dictionary where name = 'Северная часть города'));

insert into dictionary (id, name, type)
values(nextval('dictionary_seq'), 'Чуйская Область', 0);

insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'Ущелье Кегеты',1, (select id from dictionary where name = 'Чуйская Область'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'село Арчалы',1, (select id from dictionary where name = 'Чуйская Область'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'Московский Район',1, (select id from dictionary where name = 'Чуйская Область'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'Город Сокулук',1, (select id from dictionary where name = 'Чуйская Область'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'Город Токмок',1, (select id from dictionary where name = 'Чуйская Область'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'Город Кара-Балта',1, (select id from dictionary where name = 'Чуйская Область'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'Город Кант',1, (select id from dictionary where name = 'Чуйская Область'));
insert into dictionary (id, name, type, parent_id) values (nextval('dictionary_seq'), 'Город Шопоков',1, (select id from dictionary where name = 'Чуйская Область'));

insert into dictionary (id, name, type)
values(nextval('dictionary_seq'), 'Иссык-Кульская Область', 0);

insert into dictionary (id, name, type)
values(nextval('dictionary_seq'), 'Джалал-Абадская область', 0);

insert into dictionary (id, name, type)
values(nextval('dictionary_seq'), 'Рухий Мурас-2', 0);