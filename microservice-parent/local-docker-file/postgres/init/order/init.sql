-- Create the database
CREATE DATABASE "order-service";

-- Grant privileges to the admin user
GRANT ALL PRIVILEGES ON DATABASE "order-service" TO "admin";

-- Switch to the newly created database
\c "order-service"

-- Create the orders table
CREATE TABLE t_orders (
                          id SERIAL PRIMARY KEY,
                          order_number VARCHAR(255) NOT NULL,
                          sku_code VARCHAR(255) NOT NULL,
                          price DECIMAL(10, 2) NOT NULL,
                          quantity INT NOT NULL
);
