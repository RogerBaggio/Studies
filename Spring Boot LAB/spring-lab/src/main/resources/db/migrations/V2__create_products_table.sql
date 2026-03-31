-- Migration V1: Criar tabela de produtos
-- Author: Rojudo Spring Lab
-- Date: 2026-03-30

CREATE TABLE IF NOT EXISTS products (
    id BIGSERIAL PRIMARY KEY,
    sku VARCHAR(50) NOT NULL UNIQUE,
    name VARCHAR(200) NOT NULL,
    description TEXT,
    price DECIMAL(10,2) NOT NULL,
    category VARCHAR(100),
    stock_quantity INTEGER DEFAULT 0,
    active BOOLEAN DEFAULT TRUE,
    
    -- Campos JSONB para flexibilidade
    metadata JSONB,
    tags TEXT[],
    search_vector TSVECTOR,
    
    -- Campos de auditoria
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP,
    created_by VARCHAR(100),
    updated_by VARCHAR(100),
    version BIGINT DEFAULT 0,
    
    -- Constraints
    CONSTRAINT price_positive CHECK (price > 0),
    CONSTRAINT stock_non_negative CHECK (stock_quantity >= 0)
);

-- Criar índices
CREATE INDEX idx_products_name ON products(name);
CREATE INDEX idx_products_category ON products(category);
CREATE INDEX idx_products_price ON products(price);
CREATE INDEX idx_products_active ON products(active);
CREATE INDEX idx_products_metadata ON products USING gin(metadata);
CREATE INDEX idx_products_tags ON products USING gin(tags);

-- Criar índice para full-text search
CREATE INDEX idx_products_search ON products USING gin(search_vector);

COMMENT ON TABLE products IS 'Tabela de produtos do sistema';
COMMENT ON COLUMN products.sku IS 'SKU único do produto';
COMMENT ON COLUMN products.metadata IS 'Dados adicionais em formato JSON';
COMMENT ON COLUMN products.tags IS 'Tags para categorização';
COMMENT ON COLUMN products.search_vector IS 'Vetor de busca para full-text search';