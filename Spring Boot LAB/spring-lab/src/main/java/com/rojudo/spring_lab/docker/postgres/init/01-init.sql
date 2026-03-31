-- Configurações iniciais do banco
-- Criado em: 2026-03-30

-- Definir encoding e timezone
SET TIMEZONE = 'America/Sao_Paulo';

-- Criar extensões úteis
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";      -- Para UUID v4
CREATE EXTENSION IF NOT EXISTS "pgcrypto";       -- Funções criptográficas
CREATE EXTENSION IF NOT EXISTS "pg_trgm";        -- Busca por similaridade (LIKE otimizado)

-- Criar schemas específicos
CREATE SCHEMA IF NOT EXISTS audit;               -- Schema para auditoria
CREATE SCHEMA IF NOT EXISTS report;              -- Schema para relatórios

-- Criar função para atualizar updated_at automaticamente
CREATE OR REPLACE FUNCTION update_updated_at_column()
RETURNS TRIGGER AS $$
BEGIN
    NEW.updated_at = CURRENT_TIMESTAMP;
    RETURN NEW;
END;
$$ language 'plpgsql';

-- Criar tabela de auditoria
CREATE TABLE IF NOT EXISTS audit.audit_log (
    id BIGSERIAL PRIMARY KEY,
    table_name VARCHAR(100),
    operation VARCHAR(10),
    old_data JSONB,
    new_data JSONB,
    changed_by VARCHAR(100),
    changed_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Criar índice para buscas no audit_log
CREATE INDEX IF NOT EXISTS idx_audit_log_table_operation 
ON audit.audit_log(table_name, operation);

-- Mensagem de sucesso
DO $$
BEGIN
    RAISE NOTICE 'Database initialized successfully!';
END $$;