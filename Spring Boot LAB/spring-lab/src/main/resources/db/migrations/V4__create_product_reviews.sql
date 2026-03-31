-- Migration V4: Criar tabela de avaliações
-- Author: Rojudo Spring Lab
-- Date: 2026-03-30

CREATE TABLE IF NOT EXISTS product_reviews (
    id BIGSERIAL PRIMARY KEY,
    product_id BIGINT NOT NULL REFERENCES products(id) ON DELETE CASCADE,
    rating INTEGER NOT NULL CHECK (rating BETWEEN 1 AND 5),
    comment TEXT,
    reviewer_name VARCHAR(100),
    reviewer_email VARCHAR(255),
    verified_purchase BOOLEAN DEFAULT FALSE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP
);

-- Criar índices
CREATE INDEX idx_reviews_product_id ON product_reviews(product_id);
CREATE INDEX idx_reviews_rating ON product_reviews(rating);

-- Criar view para estatísticas de produtos
CREATE OR REPLACE VIEW product_statistics AS
SELECT 
    p.id,
    p.sku,
    p.name,
    p.price,
    p.stock_quantity,
    COUNT(r.id) as total_reviews,
    AVG(r.rating) as avg_rating,
    COUNT(CASE WHEN r.rating >= 4 THEN 1 END) as positive_reviews
FROM products p
LEFT JOIN product_reviews r ON p.id = r.product_id
WHERE p.active = true
GROUP BY p.id, p.sku, p.name, p.price, p.stock_quantity;