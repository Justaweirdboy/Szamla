CREATE SEQUENCE IF NOT EXISTS invoice_model_seq START WITH 1 INCREMENT BY 50;

CREATE TABLE invoice_model
(
    id            INTEGER          NOT NULL,
    customer_name VARCHAR(255)     NOT NULL,
    issue_date    date             NOT NULL,
    due_date      date             NOT NULL,
    item_name     VARCHAR(255)     NOT NULL,
    comment       VARCHAR(1024)    NOT NULL,
    price         DOUBLE PRECISION NOT NULL,
    CONSTRAINT pk_invoicemodel PRIMARY KEY (id),
    CONSTRAINT check_due_after_issue CHECK (due_date >= issue_date)
);