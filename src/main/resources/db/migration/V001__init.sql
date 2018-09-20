create table product (
  id INTEGER PRIMARY KEY,
  name VARCHAR(50),
  price FLOAT,
  unit VARCHAR(20),
  total_amount INTEGER,
  img_url VARCHAR(50)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;