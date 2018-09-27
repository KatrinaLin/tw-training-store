create table product (
  id INTEGER PRIMARY KEY,
  name text,
  price FLOAT,
  unit VARCHAR(20),
  total_amount INTEGER,
  img_url VARCHAR(50)
) DEFAULT CHARSET=utf8;