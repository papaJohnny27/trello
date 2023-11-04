create table task_category(
                              id bigserial primary key ,
                              name text not null
);
create table folder(
                       id bigserial primary key ,
                       name text not null
);
create table folder_task_category(
                                     task_category_id bigint references task_category(id),
                                     folder_id bigint references folder(id)
);
create table task(
                     id bigserial primary key ,
                     title text not null ,
                     description text not null ,
                     status smallint not null ,
                     folder_id bigint references folder(id)
);

create table comment(
                        id bigserial primary key ,
                        comment text not null ,
                        task_id bigint references task(id)
);