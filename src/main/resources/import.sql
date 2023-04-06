insert into authors(first_name, last_name) values('Jan', 'Kowalski'), ('Adam', 'Mickiewicz');

insert into publishers(name) values ('Helion'), ('Atena'), ('PWN'), ('WKiŁ');

insert into categories(name) values ('Podróże'), ('Programowanie');

insert into books(description, pages, rating, title, category_id, publisher_id) values ('Fajna książka o programowaniu', 500, 6, 'Java techniki kodowania', 2, 1);
insert into books_authors(book_id, author_id) values (1, 2);

insert into users(first_name, last_name, login, password, email) values ('Jan', 'Kowalski', 'admin', '{noop}admin', 'admin@admin.pl')