----------------------------------
-- CRIA TABELA SITE
----------------------------------
CREATE TABLE IF NOT EXISTS domains.site(
    site_id uuid not null,

    constraint site_id_pk primary key (site_id)
);