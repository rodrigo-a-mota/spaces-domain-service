----------------------------------
-- CRIA TABELA DOMÍNIO
----------------------------------
CREATE TABLE IF NOT EXISTS domains.domain(
    domain_id uuid not null,
    account_id uuid not null,
    domain_name varchar(32) not null,
    domain_created_at timestamp without time zone not null,
    site_id uuid not null,
    is_configured varchar(32) not null,
    has_certificate varchar(32) not null,

    constraint domain_id_pk primary key (domain_id),
    constraint account_id_fk foreign key (account_id) references domains.account (account_id) on delete cascade,
    constraint site_id_fk foreign key (site_id) references domains.site (site_id) on delete cascade
);