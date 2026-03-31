-- Migration V3: Criar tabela de categorias
-- Author: Rojudo Spring Lab
-- Date: 2026-03-30

CREATE TABLE IF NOT EXISTS categories (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL UNIQUE,
    description TEXT,
    parent_id BIGINT REFERENCES categories(id),
    active BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP
);

-- Adicionar categoria_id na tabela products
ALTER TABLE products ADD COLUMN category_id BIGINT REFERENCES categories(id);

-- Migrar dados existentes (se houver)
UPDATE products SET category_id = (
    SELECT id FROM categories WHERE categories.name = products.category LIMIT 1
) WHERE category IS NOT NULL;

-- Criar índices
CREATE INDEX idx_products_category_id ON products(category_id);
CREATE INDEX idx_categories_parent ON categories(parent_id);