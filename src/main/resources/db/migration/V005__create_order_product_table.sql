create table order_product (
  id INTEGER PRIMARY KEY AUTO_INCREMENT,
  product_id INTEGER,
  order_id INTEGER,
--   FOREIGN KEY (order_id) REFERENCES store_order(order_id),
  quantity INTEGER,
  name VARCHAR(50),
  price FLOAT,
  unit VARCHAR(20)
);