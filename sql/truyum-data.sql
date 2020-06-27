-- Include table data insertion, updation, deletion and select scripts
INSERT INTO truyum.menu_item(me_name,me_price,me_active,me_date_of_launch,me_category,me_free_delivery)
	VALUES('Sandwich', 99.00, 'YES', '2017-03-15','Main Course', 'YES');
INSERT INTO truyum.menu_item(me_name,me_price,me_active,me_date_of_launch,me_category,me_free_delivery)
	VALUES('Burger', 129.00, true, '2017-12-23','Main Course', false);
INSERT INTO truyum.menu_item(me_name,me_price,me_active,me_date_of_launch,me_category,me_free_delivery)
	VALUES('Pizza', 149.00, true,'2018-03-13','Main Course', false);
INSERT INTO truyum.menu_item(me_name,me_price,me_active,me_date_of_launch,me_category,me_free_delivery)
	VALUES('French Fries', 57.00, false,'2017-07-02','Starter', true);
INSERT INTO truyum.menu_item(me_name,me_price,me_active,me_date_of_launch,me_category,me_free_delivery)
	VALUES('Chocolate Brownie', 32.00, true,'2022-11-02','Dessert', true);

SELECT * FROM truyum.menu_item;

SELECT * FROM truyum.menu_item WHERE me_date_of_launch<=CURRENT_DATE() AND me_active =1;
SELECT * FROM truyum.menu_item WHERE me_id = 1;
UPDATE truyum.menu_item SET 
me_name='New Sandwhich',
me_price=148,
me_active=true,
me_date_of_launch='2019-8-7',
me_category='Desert',
me_free_delivery=false
WHERE me_id = 1;

INSERT INTO truyum.user(us_name) VALUES('Shubham');
INSERT INTO truyum.user(us_name) VALUES('Customer 1');

INSERT INTO truyum.cart(ct_us_id) VALUES(1);
INSERT INTO truyum.cart(ct_us_id,ct_pr_id) VALUES(2,1);
INSERT INTO truyum.cart(ct_us_id,ct_pr_id) VALUES(2,2);
INSERT INTO truyum.cart(ct_us_id,ct_pr_id) VALUES(2,3);

SELECT menu_item.*
FROM cart 
JOIN menu_item ON menu_item.me_id = cart.ct_pr_id
JOIN user ON user.us_id = cart.ct_us_id
WHERE user.us_id=2;

SELECT SUM(menu_item.me_price) AS TOTAL
FROM cart 
JOIN menu_item ON menu_item.me_id = cart.ct_pr_id
JOIN user ON user.us_id = cart.ct_us_id
WHERE user.us_id=2;

DELETE FROM cart WHERE user.us_id=2 AND cart.ct_pr_id=1;



