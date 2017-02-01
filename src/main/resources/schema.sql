drop table if exists oauth_client_details;
create table oauth_client_details (
    client_id VARCHAR(255) PRIMARY KEY,
    resource_ids VARCHAR(255),
    client_secret VARCHAR(255),
    scope VARCHAR(255),
    authorized_grant_types VARCHAR(255),
    web_server_redirect_uri VARCHAR(255),
    authorities VARCHAR(255),
    access_token_validity INTEGER,
    refresh_token_validity INTEGER,
    additional_information VARCHAR(4096),
    autoapprove VARCHAR(255)
);

drop table if exists oauth_access;
create table oauth_access (
    id VARCHAR(50) NOT NULL PRIMARY KEY,
    client_id VARCHAR(255),
    count_access INTEGER,
    FOREIGN KEY(client_id) REFERENCES oauth_client_details(client_id)
);