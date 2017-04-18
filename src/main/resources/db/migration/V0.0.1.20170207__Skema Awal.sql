/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since Feb 07, 2017
 * @Time 10:27:33 AM
 * @Encoding UTF-8
 * @Project Spring-OAuth2-Custom
 * @Package 
 *
 */
CREATE TABLE oauth_count_access (
    oauth_count_access VARCHAR(255) NOT NULL,
    client_id VARCHAR(255) DEFAULT NULL,
    count_access INT(11) DEFAULT NULL
)  ENGINE=INNODB;

CREATE TABLE oauth_client_details (
  client_id varchar(255) NOT NULL,
  authorities varchar(255) NOT NULL,
  access_token_validity int(11) NOT NULL,
  additional_information longtext NOT NULL,
  authorized_grant_types varchar(255) NOT NULL,
  autoapprove bit(1) NOT NULL,
  client_secret varchar(255) NOT NULL,
  refresh_token_validity int(11) NOT NULL,
  resource_ids varchar(255) NOT NULL,
  scope varchar(255) NOT NULL,
  web_server_redirect_uri varchar(255) NOT NULL
) ENGINE=InnoDB;

CREATE TABLE tb_buku (
    id_buku VARCHAR(36) NOT NULL,
    judul_buku VARCHAR(50) NOT NULL,
    jumlah_buku VARCHAR(255) NOT NULL,
    nama_pengarang VARCHAR(50) NOT NULL,
    nomor_rak_buku VARCHAR(15) NOT NULL,
    penerbit VARCHAR(25) NOT NULL,
    tahun_terbit INT(11) NOT NULL
)  ENGINE=INNODB;

CREATE TABLE tb_mahasiswa (
    npm VARCHAR(255) NOT NULL,
    alamat LONGTEXT,
    jenis_kelamin VARCHAR(255) DEFAULT NULL,
    kelas VARCHAR(6) NOT NULL,
    nama VARCHAR(50) NOT NULL
)  ENGINE=INNODB;

CREATE TABLE tb_peminjaman (
    id_peminjaman VARCHAR(36) NOT NULL,
    tanggal_batas_pengembalian DATE DEFAULT NULL,
    tanggal_peminjaman DATE DEFAULT NULL,
    id_buku VARCHAR(36) DEFAULT NULL,
    npm VARCHAR(255) NOT NULL
)  ENGINE=INNODB;

CREATE TABLE tb_user (
    username VARCHAR(50) NOT NULL,
    is_active BIT(1) NOT NULL,
    password VARCHAR(100) NOT NULL
)  ENGINE=INNODB;

CREATE TABLE tb_user_role (
    user_role_id VARCHAR(36) NOT NULL,
    role VARCHAR(15) NOT NULL,
    username VARCHAR(50) NOT NULL
)  ENGINE=INNODB;

ALTER TABLE oauth_count_access
  ADD PRIMARY KEY (oauth_count_access);

ALTER TABLE oauth_client_details
  ADD PRIMARY KEY (client_id);

ALTER TABLE tb_buku
  ADD PRIMARY KEY (id_buku);

ALTER TABLE tb_mahasiswa
  ADD PRIMARY KEY (npm);

ALTER TABLE tb_peminjaman
  ADD PRIMARY KEY (id_peminjaman),
  ADD KEY fk_id_buku (id_buku),
  ADD KEY fk_npm (npm);

ALTER TABLE tb_user
  ADD PRIMARY KEY (username);

ALTER TABLE tb_user_role
  ADD PRIMARY KEY (user_role_id),
  ADD KEY fk_username (username);

ALTER TABLE tb_peminjaman
  ADD CONSTRAINT fk_id_buku FOREIGN KEY (id_buku) REFERENCES tb_buku (id_buku),
  ADD CONSTRAINT fk_npm FOREIGN KEY (npm) REFERENCES tb_mahasiswa (npm);

ALTER TABLE tb_user_role
  ADD CONSTRAINT fk_username FOREIGN KEY (username) REFERENCES tb_user (username);