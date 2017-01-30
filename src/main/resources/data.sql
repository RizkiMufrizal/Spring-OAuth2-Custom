INSERT INTO oauth_client_details(
            client_id, resource_ids, client_secret, scope, authorized_grant_types, 
            web_server_redirect_uri, authorities, access_token_validity, 
            refresh_token_validity, additional_information, autoapprove)
    VALUES ('fooClientIdPassword', 'customoauth2', 'secret', 'foo,read,write', 'password,client_credentials,refresh_token', 
            null, null, 3600, 
            3600, null, true);