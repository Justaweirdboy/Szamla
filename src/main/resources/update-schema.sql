CREATE SEQUENCE IF NOT EXISTS invoice_model_seq START WITH 1 INCREMENT BY 50;

CREATE TABLE invoice_model
(
    id            INTEGER          NOT NULL,
    customer_name VARCHAR(255),
    issue_date    date,
    due_date      date,
    item_name     VARCHAR(255),
    comment       VARCHAR(1024),
    price         DOUBLE PRECISION NOT NULL,
    CONSTRAINT pk_invoicemodel PRIMARY KEY (id)
);

ALTER TABLE invoice_model
    ALTER COLUMN comment SET NOT NULL;

ALTER TABLE invoice_model
    ALTER COLUMN customer_name SET NOT NULL;

ALTER TABLE invoice_model
    ALTER COLUMN due_date SET NOT NULL;

ALTER TABLE invoice_model
    ALTER COLUMN issue_date SET NOT NULL;

ALTER TABLE invoice_model
    ALTER COLUMN item_name SET NOT NULL;