----------------------------------
-- CRIA TABELA SITE
----------------------------------
CREATE TABLE IF NOT EXISTS spaces_domains.sites(
    site_id uuid not null,

    constraint site_id_pk primary key (site_id)
);