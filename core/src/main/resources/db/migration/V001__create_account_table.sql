----------------------------------
-- CRIA TABELA ACCOUNT
----------------------------------
CREATE TABLE IF NOT EXISTS spaces_domains.accounts(
    account_id uuid not null,

    constraint account_id_pk primary key (account_id)
);