# Contexto Completo do Projeto

**Gerado em:** 15/04/2026 17:53:34
**Diretório base:** `E:\Projects & Studies\Studies\Spring Boot LAB`
**Total de arquivos:** 70

---

## 📑 Índice

1. [`gerar_contexto_ia.py`](#gerar_contexto_ia-py)
2. [`spring-lab\docker-compose-prod.yml`](#spring-lab-docker-compose-prod-yml)
3. [`spring-lab\docker-compose.commands.sh`](#spring-lab-docker-compose-commands-sh)
4. [`spring-lab\docker-compose.yml`](#spring-lab-docker-compose-yml)
5. [`spring-lab\HELP.md`](#spring-lab-HELP-md)
6. [`spring-lab\pom.xml`](#spring-lab-pom-xml)
7. [`spring-lab\src\main\docker\postgres\init\01-init.sql`](#spring-lab-src-main-docker-postgres-init-01-init-sql)
8. [`spring-lab\src\main\java\com\rojudo\spring_lab\config\CustomAuthenticationEntryPoint.java`](#spring-lab-src-main-java-com-rojudo-spring_lab-config-CustomAuthenticationEntryPoint-java)
9. [`spring-lab\src\main\java\com\rojudo\spring_lab\config\DataInitializer.java`](#spring-lab-src-main-java-com-rojudo-spring_lab-config-DataInitializer-java)
10. [`spring-lab\src\main\java\com\rojudo\spring_lab\config\HealthCheckConfig.java`](#spring-lab-src-main-java-com-rojudo-spring_lab-config-HealthCheckConfig-java)
11. [`spring-lab\src\main\java\com\rojudo\spring_lab\config\JpaAuditingConfig.java`](#spring-lab-src-main-java-com-rojudo-spring_lab-config-JpaAuditingConfig-java)
12. [`spring-lab\src\main\java\com\rojudo\spring_lab\config\JwtAuthenticationFilter.java`](#spring-lab-src-main-java-com-rojudo-spring_lab-config-JwtAuthenticationFilter-java)
13. [`spring-lab\src\main\java\com\rojudo\spring_lab\config\JwtService.java`](#spring-lab-src-main-java-com-rojudo-spring_lab-config-JwtService-java)
14. [`spring-lab\src\main\java\com\rojudo\spring_lab\config\LoggingAspect.java`](#spring-lab-src-main-java-com-rojudo-spring_lab-config-LoggingAspect-java)
15. [`spring-lab\src\main\java\com\rojudo\spring_lab\config\MdcFilter.java`](#spring-lab-src-main-java-com-rojudo-spring_lab-config-MdcFilter-java)
16. [`spring-lab\src\main\java\com\rojudo\spring_lab\config\OpenAPIConfig.java`](#spring-lab-src-main-java-com-rojudo-spring_lab-config-OpenAPIConfig-java)
17. [`spring-lab\src\main\java\com\rojudo\spring_lab\config\SecurityAuditListener.java`](#spring-lab-src-main-java-com-rojudo-spring_lab-config-SecurityAuditListener-java)
18. [`spring-lab\src\main\java\com\rojudo\spring_lab\config\SecurityConfig.java`](#spring-lab-src-main-java-com-rojudo-spring_lab-config-SecurityConfig-java)
19. [`spring-lab\src\main\java\com\rojudo\spring_lab\controller\AuthController.java`](#spring-lab-src-main-java-com-rojudo-spring_lab-controller-AuthController-java)
20. [`spring-lab\src\main\java\com\rojudo\spring_lab\controller\ProductController.java`](#spring-lab-src-main-java-com-rojudo-spring_lab-controller-ProductController-java)
21. [`spring-lab\src\main\java\com\rojudo\spring_lab\controller\TestController.java`](#spring-lab-src-main-java-com-rojudo-spring_lab-controller-TestController-java)
22. [`spring-lab\src\main\java\com\rojudo\spring_lab\domain\Category.java`](#spring-lab-src-main-java-com-rojudo-spring_lab-domain-Category-java)
23. [`spring-lab\src\main\java\com\rojudo\spring_lab\domain\Permission.java`](#spring-lab-src-main-java-com-rojudo-spring_lab-domain-Permission-java)
24. [`spring-lab\src\main\java\com\rojudo\spring_lab\domain\Product.java`](#spring-lab-src-main-java-com-rojudo-spring_lab-domain-Product-java)
25. [`spring-lab\src\main\java\com\rojudo\spring_lab\domain\Role.java`](#spring-lab-src-main-java-com-rojudo-spring_lab-domain-Role-java)
26. [`spring-lab\src\main\java\com\rojudo\spring_lab\domain\User.java`](#spring-lab-src-main-java-com-rojudo-spring_lab-domain-User-java)
27. [`spring-lab\src\main\java\com\rojudo\spring_lab\dto\request\AuthLoginRequest.java`](#spring-lab-src-main-java-com-rojudo-spring_lab-dto-request-AuthLoginRequest-java)
28. [`spring-lab\src\main\java\com\rojudo\spring_lab\dto\request\AuthRegisterRequest.java`](#spring-lab-src-main-java-com-rojudo-spring_lab-dto-request-AuthRegisterRequest-java)
29. [`spring-lab\src\main\java\com\rojudo\spring_lab\dto\request\ProductRequest.java`](#spring-lab-src-main-java-com-rojudo-spring_lab-dto-request-ProductRequest-java)
30. [`spring-lab\src\main\java\com\rojudo\spring_lab\dto\response\AuthLoginResponse.java`](#spring-lab-src-main-java-com-rojudo-spring_lab-dto-response-AuthLoginResponse-java)
31. [`spring-lab\src\main\java\com\rojudo\spring_lab\dto\response\ProductResponse.java`](#spring-lab-src-main-java-com-rojudo-spring_lab-dto-response-ProductResponse-java)
32. [`spring-lab\src\main\java\com\rojudo\spring_lab\dto\response\UserInfoResponse.java`](#spring-lab-src-main-java-com-rojudo-spring_lab-dto-response-UserInfoResponse-java)
33. [`spring-lab\src\main\java\com\rojudo\spring_lab\dto\response\UserResponse.java`](#spring-lab-src-main-java-com-rojudo-spring_lab-dto-response-UserResponse-java)
34. [`spring-lab\src\main\java\com\rojudo\spring_lab\exception\BusinessException.java`](#spring-lab-src-main-java-com-rojudo-spring_lab-exception-BusinessException-java)
35. [`spring-lab\src\main\java\com\rojudo\spring_lab\exception\ErrorResponse.java`](#spring-lab-src-main-java-com-rojudo-spring_lab-exception-ErrorResponse-java)
36. [`spring-lab\src\main\java\com\rojudo\spring_lab\exception\GlobalExceptionHandler.java`](#spring-lab-src-main-java-com-rojudo-spring_lab-exception-GlobalExceptionHandler-java)
37. [`spring-lab\src\main\java\com\rojudo\spring_lab\exception\ResourceNotFoundException.java`](#spring-lab-src-main-java-com-rojudo-spring_lab-exception-ResourceNotFoundException-java)
38. [`spring-lab\src\main\java\com\rojudo\spring_lab\exception\TraceIdGenerator.java`](#spring-lab-src-main-java-com-rojudo-spring_lab-exception-TraceIdGenerator-java)
39. [`spring-lab\src\main\java\com\rojudo\spring_lab\exception\ValidationException.java`](#spring-lab-src-main-java-com-rojudo-spring_lab-exception-ValidationException-java)
40. [`spring-lab\src\main\java\com\rojudo\spring_lab\mapper\ProductMapper.java`](#spring-lab-src-main-java-com-rojudo-spring_lab-mapper-ProductMapper-java)
41. [`spring-lab\src\main\java\com\rojudo\spring_lab\repository\CategoryRepository.java`](#spring-lab-src-main-java-com-rojudo-spring_lab-repository-CategoryRepository-java)
42. [`spring-lab\src\main\java\com\rojudo\spring_lab\repository\PermissionRepository.java`](#spring-lab-src-main-java-com-rojudo-spring_lab-repository-PermissionRepository-java)
43. [`spring-lab\src\main\java\com\rojudo\spring_lab\repository\ProductRepository.java`](#spring-lab-src-main-java-com-rojudo-spring_lab-repository-ProductRepository-java)
44. [`spring-lab\src\main\java\com\rojudo\spring_lab\repository\ProductRepositoryCustom.java`](#spring-lab-src-main-java-com-rojudo-spring_lab-repository-ProductRepositoryCustom-java)
45. [`spring-lab\src\main\java\com\rojudo\spring_lab\repository\ProductRepositoryCustomImpl.java`](#spring-lab-src-main-java-com-rojudo-spring_lab-repository-ProductRepositoryCustomImpl-java)
46. [`spring-lab\src\main\java\com\rojudo\spring_lab\repository\RoleRepository.java`](#spring-lab-src-main-java-com-rojudo-spring_lab-repository-RoleRepository-java)
47. [`spring-lab\src\main\java\com\rojudo\spring_lab\repository\UserRepository.java`](#spring-lab-src-main-java-com-rojudo-spring_lab-repository-UserRepository-java)
48. [`spring-lab\src\main\java\com\rojudo\spring_lab\service\AuthService.java`](#spring-lab-src-main-java-com-rojudo-spring_lab-service-AuthService-java)
49. [`spring-lab\src\main\java\com\rojudo\spring_lab\service\CustomUserDetailsService.java`](#spring-lab-src-main-java-com-rojudo-spring_lab-service-CustomUserDetailsService-java)
50. [`spring-lab\src\main\java\com\rojudo\spring_lab\service\ProductService.java`](#spring-lab-src-main-java-com-rojudo-spring_lab-service-ProductService-java)
51. [`spring-lab\src\main\java\com\rojudo\spring_lab\SpringLabApplication.java`](#spring-lab-src-main-java-com-rojudo-spring_lab-SpringLabApplication-java)
52. [`spring-lab\src\main\java\com\rojudo\spring_lab\validation\UniqueSku.java`](#spring-lab-src-main-java-com-rojudo-spring_lab-validation-UniqueSku-java)
53. [`spring-lab\src\main\java\com\rojudo\spring_lab\validation\UniqueSkuValidator.java`](#spring-lab-src-main-java-com-rojudo-spring_lab-validation-UniqueSkuValidator-java)
54. [`spring-lab\src\main\java\com\rojudo\spring_lab\validation\ValidationGroups.java`](#spring-lab-src-main-java-com-rojudo-spring_lab-validation-ValidationGroups-java)
55. [`spring-lab\src\main\resources\application-dev.yml`](#spring-lab-src-main-resources-application-dev-yml)
56. [`spring-lab\src\main\resources\application-prod.yml`](#spring-lab-src-main-resources-application-prod-yml)
57. [`spring-lab\src\main\resources\application.yml`](#spring-lab-src-main-resources-application-yml)
58. [`spring-lab\src\main\resources\db\migration\V1__create_products_table.sql`](#spring-lab-src-main-resources-db-migration-V1__create_products_table-sql)
59. [`spring-lab\src\main\resources\db\migration\V2__create_categories_table.sql`](#spring-lab-src-main-resources-db-migration-V2__create_categories_table-sql)
60. [`spring-lab\src\main\resources\db\migration\V3__create_product_reviews.sql`](#spring-lab-src-main-resources-db-migration-V3__create_product_reviews-sql)
61. [`spring-lab\src\main\resources\db\migration\V4__create_security_tables.sql`](#spring-lab-src-main-resources-db-migration-V4__create_security_tables-sql)
62. [`spring-lab\src\main\resources\logback-spring.xml`](#spring-lab-src-main-resources-logback-spring-xml)
63. [`spring-lab\src\main\resources\validation-messages.properties`](#spring-lab-src-main-resources-validation-messages-properties)
64. [`spring-lab\src\test\java\com\rojudo\spring_lab\config\TestConfig.java`](#spring-lab-src-test-java-com-rojudo-spring_lab-config-TestConfig-java)
65. [`spring-lab\src\test\java\com\rojudo\spring_lab\controller\ProductControllerTest.java`](#spring-lab-src-test-java-com-rojudo-spring_lab-controller-ProductControllerTest-java)
66. [`spring-lab\src\test\java\com\rojudo\spring_lab\repository\ProductRepositoryTest.java`](#spring-lab-src-test-java-com-rojudo-spring_lab-repository-ProductRepositoryTest-java)
67. [`spring-lab\src\test\java\com\rojudo\spring_lab\resources\application-test.yml`](#spring-lab-src-test-java-com-rojudo-spring_lab-resources-application-test-yml)
68. [`spring-lab\src\test\java\com\rojudo\spring_lab\resources\testcontainers.properties`](#spring-lab-src-test-java-com-rojudo-spring_lab-resources-testcontainers-properties)
69. [`spring-lab\src\test\java\com\rojudo\spring_lab\service\ProductServiceTest.java`](#spring-lab-src-test-java-com-rojudo-spring_lab-service-ProductServiceTest-java)
70. [`spring-lab\src\test\java\com\rojudo\spring_lab\SpringLabApplicationTests.java`](#spring-lab-src-test-java-com-rojudo-spring_lab-SpringLabApplicationTests-java)

---

## 📄 Arquivo: `gerar_contexto_ia.py`

**Caminho completo:** `E:\Projects & Studies\Studies\Spring Boot LAB\gerar_contexto_ia.py`
**Tamanho:** 8,133 bytes
**Extensão:** `.py`

```py
#!/usr/bin/env python3
"""
Gerador de Contexto para IA
Converte múltiplos arquivos de código em um único documento de texto para fornecer contexto completo do projeto.
"""

import os
import sys
from pathlib import Path
from datetime import datetime

# Configurações
EXTENSOES_SUPORTADAS = {
    # Linguagens de programação
    '.py', '.js', '.ts', '.jsx', '.tsx', '.java', '.c', '.cpp', '.h', '.hpp',
    '.cs', '.go', '.rs', '.rb', '.php', '.swift', '.kt', '.kts', '.scala',
    # Web
    '.html', '.css', '.scss', '.sass', '.less', '.vue', '.svelte',
    # Configuração
    '.json', '.xml', '.yaml', '.yml', '.toml', '.ini', '.cfg', '.conf', '.properties',
    # Documentação
    '.md', '.rst', '.txt',
    # Outros
    '.sql', '.sh', '.bash', '.zsh', '.ps1', '.bat', '.dockerfile', '.makefile'
}

# Pastas e arquivos a ignorar
IGNORAR_PASTAS = {
    '.git', 'node_modules', 'target', '.vscode', '.idea', '.mvn',
    '__pycache__', 'dist', 'build', 'venv', 'env', 'virtualenv',
    '.venv', '.env', '.pytest_cache', '.coverage', 'htmlcov',
    '.tox', '.eggs', '*.egg-info', '.mypy_cache', '.ruff_cache',
    '.next', 'out', '.nuxt', '.cache', 'tmp', 'temp', 'logs',
    'vendor', 'bower_components', 'jspm_packages', 'lib', 'libs'
}

IGNORAR_ARQUIVOS = {
    '.DS_Store', 'Thumbs.db', 'desktop.ini', '*.pyc', '*.pyo',
    '*.so', '*.dll', '*.dylib', '*.exe', '*.obj', '*.o', '*.class',
    '*.log', '*.tmp', '*.temp', '*.cache', '*.min.js', '*.min.css',
    '*.map', '*.lock', 'package-lock.json', 'yarn.lock', 'poetry.lock',
    '*.png', '*.jpg', '*.jpeg', '*.gif', '*.ico', '*.svg', '*.pdf',
    '*.zip', '*.tar', '*.gz', '*.rar', '*.7z', '*.mp4', '*.mp3'
}

def should_ignore_path(path: Path) -> bool:
    """Verifica se um caminho deve ser ignorado."""
    # Ignorar pastas
    for parte in path.parts:
        if parte in IGNORAR_PASTAS:
            return True
        # Verificar padrões com wildcard
        if any(padrao.endswith('*') and parte.startswith(padrao.rstrip('*')) 
               for padrao in IGNORAR_PASTAS if padrao.endswith('*')):
            return True
    
    # Verificar se é um arquivo para ignorar
    if path.is_file():
        nome = path.name
        if nome in IGNORAR_ARQUIVOS:
            return True
        # Verificar padrões com wildcard
        for padrao in IGNORAR_ARQUIVOS:
            if padrao.endswith('*') and nome.startswith(padrao.rstrip('*')):
                return True
            if padrao.startswith('*') and nome.endswith(padrao.lstrip('*')):
                return True
    
    return False

def get_all_files(diretorio_base: Path) -> list:
    """Retorna lista recursiva de todos os arquivos de código."""
    arquivos = []
    
    try:
        for caminho in diretorio_base.rglob('*'):
            if should_ignore_path(caminho):
                continue
            
            if caminho.is_file() and caminho.suffix.lower() in EXTENSOES_SUPORTADAS:
                # Verificar tamanho do arquivo (ignorar arquivos muito grandes > 1MB)
                if caminho.stat().st_size > 1024 * 1024:
                    print(f"  ⚠️  Ignorando arquivo muito grande: {caminho.relative_to(diretorio_base)}")
                    continue
                arquivos.append(caminho)
    except PermissionError:
        print(f"  ⚠️  Sem permissão para acessar: {diretorio_base}")
    
    return sorted(arquivos)  # Ordenar para consistência

def read_file_content(caminho: Path) -> str:
    """Lê o conteúdo de um arquivo com tratamento de encoding."""
    encodings = ['utf-8', 'latin-1', 'cp1252', 'iso-8859-1']
    
    for encoding in encodings:
        try:
            with open(caminho, 'r', encoding=encoding) as f:
                return f.read()
        except (UnicodeDecodeError, PermissionError):
            continue
    
    return f"[Erro: Não foi possível ler o arquivo {caminho.name} com nenhum encoding suportado]"

def gerar_documento(arquivos: list, diretorio_base: Path, output_path: Path):
    """Gera o documento final com todos os arquivos."""
    
    with open(output_path, 'w', encoding='utf-8') as out:
        # Cabeçalho
        out.write("# Contexto Completo do Projeto\n\n")
        out.write(f"**Gerado em:** {datetime.now().strftime('%d/%m/%Y %H:%M:%S')}\n")
        out.write(f"**Diretório base:** `{diretorio_base.absolute()}`\n")
        out.write(f"**Total de arquivos:** {len(arquivos)}\n\n")
        out.write("---\n\n")
        
        # Índice
        out.write("## 📑 Índice\n\n")
        for i, caminho in enumerate(arquivos, 1):
            rel_path = caminho.relative_to(diretorio_base)
            out.write(f"{i}. [`{rel_path}`](#{rel_path.as_posix().replace('/', '-').replace('.', '-')})\n")
        out.write("\n---\n\n")
        
        # Conteúdo dos arquivos
        for i, caminho in enumerate(arquivos, 1):
            rel_path = caminho.relative_to(diretorio_base)
            try:
                conteudo = read_file_content(caminho)
                
                # Título do arquivo
                out.write(f"## 📄 Arquivo: `{rel_path}`\n\n")
                out.write(f"**Caminho completo:** `{caminho.absolute()}`\n")
                out.write(f"**Tamanho:** {caminho.stat().st_size:,} bytes\n")
                out.write(f"**Extensão:** `{caminho.suffix}`\n\n")
                
                # Conteúdo formatado
                out.write("```" + caminho.suffix[1:] if caminho.suffix else "")
                out.write("\n")
                out.write(conteudo)
                if not conteudo.endswith('\n'):
                    out.write('\n')
                out.write("```\n\n")
                
                # Separador
                if i < len(arquivos):
                    out.write("---\n\n")
                
                # Progresso
                print(f"  ✅ {i}/{len(arquivos)}: {rel_path}")
                
            except Exception as e:
                print(f"  ❌ Erro ao processar {rel_path}: {e}")
                out.write(f"## ⚠️ Arquivo: `{rel_path}`\n\n")
                out.write(f"**Erro ao ler arquivo:** {str(e)}\n\n---\n\n")

def main():
    """Função principal."""
    print("\n" + "="*60)
    print("🔧 GERADOR DE CONTEXTO PARA IA".center(60))
    print("="*60 + "\n")
    
    # Diretório onde o script está sendo executado
    diretorio_base = Path.cwd()
    print(f"📁 Diretório base: {diretorio_base}\n")
    
    # Nome do arquivo de saída
    timestamp = datetime.now().strftime("%Y%m%d_%H%M%S")
    output_name = f"contexto_projeto_{timestamp}.md"
    output_path = diretorio_base / output_name
    
    # Coletar arquivos
    print("🔍 Escaneando arquivos...")
    arquivos = get_all_files(diretorio_base)
    
    if not arquivos:
        print("\n❌ Nenhum arquivo de código encontrado!")
        print("📝 Verifique se as extensões suportadas estão configuradas corretamente.")
        sys.exit(1)
    
    print(f"\n📊 Encontrados {len(arquivos)} arquivos para processar:\n")
    
    # Gerar documento
    print("📝 Gerando documento de contexto...\n")
    gerar_documento(arquivos, diretorio_base, output_path)
    
    # Estatísticas finais
    tamanho_mb = output_path.stat().st_size / (1024 * 1024)
    print("\n" + "="*60)
    print("✅ PROCESSAMENTO CONCLUÍDO!".center(60))
    print("="*60)
    print(f"\n📄 Documento gerado: {output_name}")
    print(f"📏 Tamanho: {tamanho_mb:.2f} MB")
    print(f"📁 Localização: {output_path.parent}")
    print(f"📊 Total de arquivos incluídos: {len(arquivos)}")
    print("\n✨ O documento está pronto para ser usado com ferramentas de IA!\n")

if __name__ == "__main__":
    try:
        main()
    except KeyboardInterrupt:
        print("\n\n⚠️  Processamento interrompido pelo usuário.\n")
        sys.exit(1)
    except Exception as e:
        print(f"\n❌ Erro inesperado: {e}\n")
        sys.exit(1)
```

---

## 📄 Arquivo: `spring-lab\docker-compose-prod.yml`

**Caminho completo:** `E:\Projects & Studies\Studies\Spring Boot LAB\spring-lab\docker-compose-prod.yml`
**Tamanho:** 1,044 bytes
**Extensão:** `.yml`

```yml
services:
  app:
    build: .
    ports:
      - "8080:8080"
    environment:
      - SPRING_PROFILES_ACTIVE=prod
      - DB_URL=jdbc:postgresql://postgres:5432/springlab_db
      - DB_USERNAME=springlab_user
      - DB_PASSWORD=${DB_PASSWORD}
      - DB_POOL_MAX=20
      - DB_POOL_MIN=10
    depends_on:
      postgres:
        condition: service_healthy
    healthcheck:
      test: ["CMD", "wget", "--no-verbose", "--tries=1", "--spider", "http://localhost:8080/actuator/health/readiness"]
      interval: 30s
      timeout: 10s
      retries: 3
    restart: unless-stopped

  postgres:
    image: postgres:16-alpine
    environment:
      POSTGRES_DB: springlab_db
      POSTGRES_USER: springlab_user
      POSTGRES_PASSWORD: ${DB_PASSWORD}
    volumes:
      - postgres_data:/var/lib/postgresql/data
    healthcheck:
      test: ["CMD-SHELL", "pg_isready -U springlab_user -d springlab_db"]
      interval: 10s
      timeout: 5s
      retries: 5
    restart: unless-stopped

volumes:
  postgres_data:
```

---

## 📄 Arquivo: `spring-lab\docker-compose.commands.sh`

**Caminho completo:** `E:\Projects & Studies\Studies\Spring Boot LAB\spring-lab\docker-compose.commands.sh`
**Tamanho:** 2,302 bytes
**Extensão:** `.sh`

```sh
#!/bin/bash

# Cores para output
RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
NC='\033[0m' # No Color

echo -e "${GREEN}🐘 SpringLab - PostgreSQL Management${NC}"

case "$1" in
    start)
        echo -e "${YELLOW}Starting Docker containers...${NC}"
        docker-compose up -d
        echo -e "${GREEN}✅ Containers started!${NC}"
        echo -e "PostgreSQL: ${GREEN}localhost:5432${NC}"
        echo -e "pgAdmin: ${GREEN}http://localhost:5050${NC}"
        echo -e "Redis: ${GREEN}localhost:6379${NC}"
        ;;
    
    stop)
        echo -e "${YELLOW}Stopping Docker containers...${NC}"
        docker-compose down
        echo -e "${GREEN}✅ Containers stopped!${NC}"
        ;;
    
    logs)
        docker-compose logs -f postgres
        ;;
    
    psql)
        echo -e "${YELLOW}Connecting to PostgreSQL...${NC}"
        docker exec -it springlab-postgres psql -U springlab_user -d springlab_db
        ;;
    
    backup)
        BACKUP_FILE="backups/backup_$(date +%Y%m%d_%H%M%S).sql"
        echo -e "${YELLOW}Creating backup: ${BACKUP_FILE}${NC}"
        docker exec springlab-postgres pg_dump -U springlab_user springlab_db > ${BACKUP_FILE}
        echo -e "${GREEN}✅ Backup created!${NC}"
        ;;
    
    restore)
        if [ -z "$2" ]; then
            echo -e "${RED}Usage: $0 restore <backup_file>${NC}"
            exit 1
        fi
        echo -e "${YELLOW}Restoring from: $2${NC}"
        cat $2 | docker exec -i springlab-postgres psql -U springlab_user springlab_db
        echo -e "${GREEN}✅ Restore completed!${NC}"
        ;;
    
    clean)
        echo -e "${RED}⚠️  This will delete ALL data! Continue? (y/N)${NC}"
        read -r response
        if [[ "$response" =~ ^[Yy]$ ]]; then
            docker-compose down -v
            echo -e "${GREEN}✅ Cleaned up!${NC}"
        else
            echo -e "${YELLOW}Cancelled${NC}"
        fi
        ;;
    
    status)
        docker-compose ps
        ;;
    
    migrate)
        echo -e "${YELLOW}Running Flyway migrations...${NC}"
        ./mvnw flyway:migrate -Dspring.profiles.active=dev
        echo -e "${GREEN}✅ Migrations completed!${NC}"
        ;;
    
    *)
        echo "Usage: $0 {start|stop|logs|psql|backup|restore|clean|status|migrate}"
        exit 1
        ;;
esac
```

---

## 📄 Arquivo: `spring-lab\docker-compose.yml`

**Caminho completo:** `E:\Projects & Studies\Studies\Spring Boot LAB\spring-lab\docker-compose.yml`
**Tamanho:** 1,753 bytes
**Extensão:** `.yml`

```yml
services:
  # PostgreSQL Database
  postgres:
    image: postgres:16-alpine
    container_name: springlab-postgres
    environment:
      POSTGRES_DB: springlab_db
      POSTGRES_USER: springlab_user
      POSTGRES_PASSWORD: springlab_password
      POSTGRES_INITDB_ARGS: "--encoding=UTF-8 --locale=pt_BR.UTF-8"
    ports:
      - "5432:5432"
    volumes:
      # Persistência dos dados
      - postgres_data:/var/lib/postgresql/data
      # Scripts de inicialização customizados
      #- ./docker/postgres/init:/docker-entrypoint-initdb.d
      # Backup directory
      #- ./backups:/backups
    networks:
      - springlab-network
    healthcheck:
      test: ["CMD-SHELL", "pg_isready -U springlab_user -d springlab_db"]
      interval: 10s
      timeout: 5s
      retries: 5
    restart: unless-stopped

  # pgAdmin - GUI para PostgreSQL (opcional)
  pgadmin:
    image: dpage/pgadmin4:latest
    container_name: springlab-pgadmin
    environment:
      PGADMIN_DEFAULT_EMAIL: admin@springlab.com
      PGADMIN_DEFAULT_PASSWORD: admin
      PGADMIN_CONFIG_SERVER_MODE: 'False'
    ports:
      - "5050:80"
    volumes:
      - pgadmin_data:/var/lib/pgadmin
    networks:
      - springlab-network
    depends_on:
      - postgres
    restart: unless-stopped

  # Redis (para cache - opcional)
  redis:
    image: redis:7-alpine
    container_name: springlab-redis
    ports:
      - "6379:6379"
    volumes:
      - redis_data:/data
    command: redis-server --appendonly yes --requirepass redis_password
    networks:
      - springlab-network
    restart: unless-stopped

networks:
  springlab-network:
    driver: bridge

volumes:
  postgres_data:
  pgadmin_data:
  redis_data:
```

---

## 📄 Arquivo: `spring-lab\HELP.md`

**Caminho completo:** `E:\Projects & Studies\Studies\Spring Boot LAB\spring-lab\HELP.md`
**Tamanho:** 1,442 bytes
**Extensão:** `.md`

```md
# Read Me First
The following was discovered as part of building this project:

* The original package name 'com.rojudo.spring-lab' is invalid and this project uses 'com.rojudo.spring_lab' instead.

# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/4.0.3/maven-plugin)
* [Create an OCI image](https://docs.spring.io/spring-boot/4.0.3/maven-plugin/build-image.html)
* [Spring Web](https://docs.spring.io/spring-boot/4.0.3/reference/web/servlet.html)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)

### Maven Parent overrides

Due to Maven's design, elements are inherited from the parent POM to the project POM.
While most of the inheritance is fine, it also inherits unwanted elements like `<license>` and `<developers>` from the parent.
To prevent this, the project POM contains empty overrides for these elements.
If you manually switch to a different parent and actually want the inheritance, you need to remove those overrides.

```

---

## 📄 Arquivo: `spring-lab\pom.xml`

**Caminho completo:** `E:\Projects & Studies\Studies\Spring Boot LAB\spring-lab\pom.xml`
**Tamanho:** 5,694 bytes
**Extensão:** `.xml`

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>

	<parent>
		<groupId>org.springframework.boot</groupId>	
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>3.2.4</version>
		<relativePath/>
	</parent>

	<groupId>com.rojudo</groupId>
	<artifactId>spring-lab</artifactId>
	<version>0.0.2</version>
	<name>spring-lab</name>
	<description>REST API Lab with Spring Boot</description>
	<url/>

	<properties>
		<java.version>21</java.version>
		<flyway.version>10.11.0</flyway.version>
		<testcontainers.version>1.21.0</testcontainers.version>
	</properties>
	
	<dependencies>
		
		<!-- Web MVC - Core REST capabilities -->
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<!-- JPA -->
        <dependency>
           	<groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        
		<!-- Logging Aspect (AOP) -->
		<dependency>
    		<groupId>org.springframework.boot</groupId>
    		<artifactId>spring-boot-starter-aop</artifactId>
		</dependency>

		<!-- PostgreSQL for production -->
        <dependency>
            <groupId>org.postgresql</groupId>
            <artifactId>postgresql</artifactId>
            <scope>runtime</scope>
        </dependency>
        
		<!-- H2 Database para testes -->
		<dependency>
    		<groupId>com.h2database</groupId>
    		<artifactId>h2</artifactId>
    		<scope>test</scope>
		</dependency>

        <!-- Validation -->
		<dependency>
    		<groupId>org.springframework.boot</groupId>
    		<artifactId>spring-boot-starter-validation</artifactId>
		</dependency>
        
        <!-- OpenAPI/Swagger Documentation -->
        <dependency>
            <groupId>org.springdoc</groupId>
            <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
            <version>2.3.0</version>
        </dependency>

		<dependency>
    		<groupId>org.springframework.boot</groupId>
    		<artifactId>spring-boot-starter-actuator</artifactId>
		</dependency>

		<!-- Development Tools -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <scope>runtime</scope>
            <optional>true</optional>
        </dependency>

		<!-- Test Dependencies -->
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>

		<!-- Spring Security Test (para @WithMockUser, csrf(), etc.) -->
		<dependency>
    		<groupId>org.springframework.security</groupId>
    		<artifactId>spring-security-test</artifactId>
    		<scope>test</scope>
		</dependency>

	    <!-- Flyway for Database Migrations -->
    	<dependency>
        	<groupId>org.flywaydb</groupId>
        	<artifactId>flyway-core</artifactId>
    	</dependency>
		
		<dependency>
    		<groupId>org.flywaydb</groupId>
    		<artifactId>flyway-database-postgresql</artifactId>
    		<version>10.11.0</version>
		</dependency>
    
    	<!-- Para suporte a JSON no PostgreSQL -->
    	<dependency>
        	<groupId>com.vladmihalcea</groupId>
        	<artifactId>hibernate-types-60</artifactId>
        	<version>2.21.1</version>
    	</dependency>

		<dependency>
    		<groupId>io.hypersistence</groupId>
    		<artifactId>hypersistence-utils-hibernate-60</artifactId>
    		<version>3.7.0</version>
		</dependency>

		<!-- Spring Security -->
		<dependency>
		    <groupId>org.springframework.boot</groupId>
    		<artifactId>spring-boot-starter-security</artifactId>
		</dependency>

		 <!-- JWT Support -->
    	<dependency>
        	<groupId>io.jsonwebtoken</groupId>
        	<artifactId>jjwt-api</artifactId>
        	<version>0.12.6</version>
    	</dependency>
    	
		<dependency>
        	<groupId>io.jsonwebtoken</groupId>
        	<artifactId>jjwt-impl</artifactId>
        	<version>0.12.6</version>
        	<scope>runtime</scope>
    	</dependency>
   	
		<dependency>
        	<groupId>io.jsonwebtoken</groupId>
        	<artifactId>jjwt-jackson</artifactId>
        	<version>0.12.6</version>
        	<scope>runtime</scope>
    	</dependency>

		<!-- Testcontainers para PostgreSQL real -->
		<dependency>
    		<groupId>org.testcontainers</groupId>
    		<artifactId>testcontainers</artifactId>
    		<scope>test</scope>
		</dependency>

		<dependency>
    		<groupId>org.testcontainers</groupId>
    		<artifactId>postgresql</artifactId>
    		<scope>test</scope>
		</dependency>
		
		<dependency>
    		<groupId>org.testcontainers</groupId>
    		<artifactId>junit-jupiter</artifactId>
    		<scope>test</scope>
		</dependency>

		

	</dependencies>

	<build>
	
		<plugins>
			<!-- Plugin para limpar target antes do build -->
        	<plugin>
            	<groupId>org.apache.maven.plugins</groupId>
            	<artifactId>maven-clean-plugin</artifactId>
            	<version>3.3.2</version>
            	<executions>
                	<execution>
                    	<id>auto-clean</id>
                    	<phase>initialize</phase>
                    	<goals>
                        	<goal>clean</goal>
                    	</goals>
                	</execution>
            	</executions>
        	</plugin>

			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
			</plugin>

		</plugins>
	</build>

</project>
```

---

## 📄 Arquivo: `spring-lab\src\main\docker\postgres\init\01-init.sql`

**Caminho completo:** `E:\Projects & Studies\Studies\Spring Boot LAB\spring-lab\src\main\docker\postgres\init\01-init.sql`
**Tamanho:** 1,370 bytes
**Extensão:** `.sql`

```sql
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
```

---

## 📄 Arquivo: `spring-lab\src\main\java\com\rojudo\spring_lab\config\CustomAuthenticationEntryPoint.java`

**Caminho completo:** `E:\Projects & Studies\Studies\Spring Boot LAB\spring-lab\src\main\java\com\rojudo\spring_lab\config\CustomAuthenticationEntryPoint.java`
**Tamanho:** 1,745 bytes
**Extensão:** `.java`

```java
package com.rojudo.spring_lab.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rojudo.spring_lab.exception.ErrorResponse;
import com.rojudo.spring_lab.exception.TraceIdGenerator;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * CUSTOM AUTHENTICATION ENTRY POINT
 * 
 * Trata requisições não autenticadas
 */
@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {
    
    private final ObjectMapper objectMapper = new ObjectMapper();
    
    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException) throws IOException {
        
        String traceId = TraceIdGenerator.generate();
        
        // NOVA ASSINATURA: traceId, status, error, message, path
        ErrorResponse errorResponse = new ErrorResponse(
            traceId,
            HttpStatus.UNAUTHORIZED.value(),
            "Authentication Error",
            "Você precisa estar autenticado para acessar este recurso",
            request.getRequestURI()
        );
        
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        objectMapper.writeValue(response.getOutputStream(), errorResponse);
    }
}
```

---

## 📄 Arquivo: `spring-lab\src\main\java\com\rojudo\spring_lab\config\DataInitializer.java`

**Caminho completo:** `E:\Projects & Studies\Studies\Spring Boot LAB\spring-lab\src\main\java\com\rojudo\spring_lab\config\DataInitializer.java`
**Tamanho:** 29,633 bytes
**Extensão:** `.java`

```java
package com.rojudo.spring_lab.config;

import com.rojudo.spring_lab.domain.Category;
import com.rojudo.spring_lab.domain.Permission;
import com.rojudo.spring_lab.domain.Product;
import com.rojudo.spring_lab.domain.Role;
import com.rojudo.spring_lab.domain.User;
import com.rojudo.spring_lab.repository.CategoryRepository;
import com.rojudo.spring_lab.repository.PermissionRepository;
import com.rojudo.spring_lab.repository.ProductRepository;
import com.rojudo.spring_lab.repository.RoleRepository;
import com.rojudo.spring_lab.repository.UserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
  DATA INITIALIZER
  
  =================================================================================
  PROPÓSITO:
  =================================================================================
  Esta classe é executada automaticamente APÓS a aplicação iniciar completamente.
  É utilizada para popular o banco de dados com dados iniciais para desenvolvimento.
  
  POR QUE USAR?
  - Evita ter que cadastrar dados manualmente a cada nova instalação
  - Garante um ambiente consistente para desenvolvimento e testes
  - Permite testar funcionalidades com dados realistas
  - Cria usuários administrativos padrão
  
  QUANDO EXECUTA?
  - Executa apenas no perfil "dev" (desenvolvimento)
  - NÃO executa em produção (graças ao @Profile)
  - Executa APÓS as migrations do Flyway
  
  @Profile("dev") - Garante que só roda em desenvolvimento, seguro para produção!
  @Component - Permite que o Spring gerencie o ciclo de vida
  @Transactional - Tudo em uma única transação (se algo falhar, tudo é revertido)
 */

@Component
@Profile("dev")  // Só executa no perfil de desenvolvimento!
public class DataInitializer implements CommandLineRunner {
    
    private static final Logger log = LoggerFactory.getLogger(DataInitializer.class);
    
    // =================================================================================
    // DEPENDÊNCIAS INJETADAS
    // =================================================================================
    // Usamos injeção por construtor (melhor prática para testes e imutabilidade)
    
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PermissionRepository permissionRepository;
    private final PasswordEncoder passwordEncoder;
    
    // Propriedades configuráveis via application.yml
    @Value("${app.data.initialize:true}")
    private boolean shouldInitialize;
    
    @Value("${app.data.load-sample:true}")
    private boolean loadSampleData;
    
    // =================================================================================
    // CONSTRUTOR - INJEÇÃO DE DEPENDÊNCIA
    // =================================================================================
    // Por que injeção por construtor?
    // 1. Imutabilidade (campos final)
    // 2. Facilita testes unitários (mock injection)
    // 3. Dependências explicitamente declaradas
    
    @Autowired
    public DataInitializer(
            ProductRepository productRepository,
            CategoryRepository categoryRepository,
            UserRepository userRepository,
            RoleRepository roleRepository,
            PermissionRepository permissionRepository,
            PasswordEncoder passwordEncoder) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.permissionRepository = permissionRepository;
        this.passwordEncoder = passwordEncoder;
    }
    
    // =================================================================================
    // MÉTODO PRINCIPAL - EXECUTADO PELO SPRING APÓS A INICIALIZAÇÃO
    // =================================================================================
    
    @Override
    @Transactional  // Tudo em uma única transação atômica
    public void run(String... args) {
        // Log de início da aplicação (estilo profissional)
        log.info("✅ Application initialized successfully. Starting DataInitializer...");
        
        // Verifica se a inicialização está habilitada via configuração
        if (!shouldInitialize) {
            log.info("Data initialization disabled by configuration (app.data.initialize=false)");
            return;
        }
        
        log.info("========================================");
        log.info("🚀 DATA INITIALIZER - Starting...");
        log.info("========================================");
        
        // Inicializa em ordem correta (respeitando dependências)
        // A ordem é CRUCIAL para evitar erros de chave estrangeira!
        initializeCategories();      // 1º: Categorias (independentes)
        initializeProducts();         // 2º: Produtos (dependem de categorias)
        initializeSecurityData();     // 3º: Dados de segurança (roles, permissions, users)
        
        // Relatório final com estatísticas
        log.info("========================================");
        log.info("✅ Data initialization completed!");
        log.info("   - Categories: {}", categoryRepository.count());
        log.info("   - Products: {}", productRepository.count());
        log.info("   - Roles: {}", roleRepository.count());
        log.info("   - Permissions: {}", permissionRepository.count());
        log.info("   - Users: {}", userRepository.count());
        log.info("========================================");
        
        // Credenciais de acesso (útil para desenvolvimento)
        log.info("🔐 Default credentials:");
        log.info("   - Admin:    admin@springlab.com / Admin123!");
        log.info("   - Manager:  gerente@springlab.com / Manager123!");
        log.info("   - User:     usuario@springlab.com / User123!");
        log.info("========================================");
    }
    
    // =================================================================================
    // ==================== CATEGORIES (Categorias de Produtos) ====================
    // =================================================================================
    
    /*
      INICIALIZAÇÃO DE CATEGORIAS
      
      Por que categorias primeiro?
      - Produtos têm FK para categorias
      - Categories não dependem de outras tabelas (excuto auto-relacionamento parent_id)
      
      Estrutura hierárquica:
      Eletrônicos
        └── Computadores
      Acessórios
        └── Periféricos
     */
    
    private void initializeCategories() {
        // Evita recriar se já existirem (importante para múltiplas execuções)
        if (categoryRepository.count() > 0) {
            log.info("Categories already exist, skipping...");
            return;
        }
        
        log.info("📁 Creating categories...");
        
        // Criação das categorias com hierarquia
        Category electronics = createCategory("Eletrônicos", "Produtos eletrônicos em geral", null);
        Category computers = createCategory("Computadores", "Notebooks, desktops e componentes", electronics);
        Category accessories = createCategory("Acessórios", "Periféricos e acessórios para computadores", null);
        Category peripherals = createCategory("Periféricos", "Mouses, teclados, monitores", accessories);
        
        categoryRepository.saveAll(Arrays.asList(electronics, computers, accessories, peripherals));
        
        log.info("✅ Created {} categories", categoryRepository.count());
    }
    
    /**
     * Cria uma categoria com suporte a hierarquia
     * @param name Nome da categoria
     * @param description Descrição
     * @param parent Categoria pai (null para categoria raiz)
     */
    private Category createCategory(String name, String description, Category parent) {
        Category category = new Category(name, description, parent);
        category.setActive(true);
        category.setCreatedAt(LocalDateTime.now());
        return category;
    }
    
    // =================================================================================
    // ==================== PRODUCTS (Produtos) ====================
    // =================================================================================
    
    /*
      INICIALIZAÇÃO DE PRODUTOS
      
      Por que produtos depois das categorias?
      - Produtos têm foreign key (category_id) para categories
      - Precisamos que as categorias existam primeiro
      
      Nota: A versão antiga usava String para category (texto puro).
      A versão nova usa relacionamento @ManyToOne com Category (normalizado).
      Isso é uma BOA PRÁTICA de modelagem de dados!
     */
    
    private void initializeProducts() {
        // Verifica se já existem produtos (evita duplicação)
        if (productRepository.count() > 0) {
            log.info("Products already exist, skipping...");
            return;
        }
        
        // Só carrega se a flag estiver ativa
        if (!loadSampleData) {
            log.info("Sample data loading disabled by configuration (app.data.load-sample=false)");
            return;
        }
        
        log.info("📦 Creating products...");
        
        // Busca as categorias que acabamos de criar
        Category electronics = categoryRepository.findByName("Eletrônicos").orElse(null);
        Category computers = categoryRepository.findByName("Computadores").orElse(null);
        Category accessories = categoryRepository.findByName("Acessórios").orElse(null);
        Category peripherals = categoryRepository.findByName("Periféricos").orElse(null);
        
        // Lista de produtos com categorias associadas (relacionamento correto!)
        List<Product> products = Arrays.asList(
            // Eletrônicos / Computadores
            createProduct("NOTE-001", "Notebook Dell XPS 13", 
                "Notebook Dell XPS 13, Intel Core i7, 16GB RAM, 512GB SSD", 
                new BigDecimal("4599.99"), computers, 15,
                new String[]{"notebook", "dell", "premium"},
                createMetadata("color", "prata", "warranty", "12 meses", "processor", "Intel i7-1360P")),
            
            createProduct("MAC-001", "MacBook Air M3", 
                "Apple MacBook Air com chip M3, 8GB RAM, 256GB SSD", 
                new BigDecimal("7499.99"), computers, 8,
                new String[]{"macbook", "apple", "m3"},
                createMetadata("color", "midnight", "chip", "M3", "ram", "8GB")),
            
            // Periféricos
            createProduct("MOUSE-001", "Mouse Logitech MX Master 3S", 
                "Mouse sem fio, ergonômico, 8K DPI, compatível com Mac e Windows",
                new BigDecimal("349.90"), peripherals, 50,
                new String[]{"mouse", "logitech", "wireless", "ergonomic"},
                createMetadata("color", "preto", "battery", "70 dias", "sensor", "8K DPI")),
            
            createProduct("MOUSE-002", "Mouse Razer DeathAdder V3", 
                "Mouse gamer, 30K DPI, switches ópticos",
                new BigDecimal("499.90"), peripherals, 30,
                new String[]{"mouse", "razer", "gamer"},
                createMetadata("color", "preto", "sensor", "30K DPI", "rgb", "true")),
            
            createProduct("TEC-001", "Teclado Keychron K2 V2", 
                "Teclado mecânico, wireless, RGB, switches Gateron",
                new BigDecimal("599.00"), peripherals, 25,
                new String[]{"teclado", "keychron", "mecânico", "wireless"},
                createMetadata("layout", "75%", "switches", "Gateron Red", "rgb", "true")),
            
            createProduct("TEC-002", "Teclado Logitech MX Keys", 
                "Teclado wireless, iluminado, recarregável",
                new BigDecimal("499.90"), peripherals, 40,
                new String[]{"teclado", "logitech", "wireless", "office"},
                createMetadata("layout", "full", "backlight", "true")),
            
            // Monitores
            createProduct("MON-001", "Monitor Dell UltraSharp U2723QE", 
                "Monitor 27 polegadas, 4K, USB-C Hub, 100% sRGB",
                new BigDecimal("3299.00"), electronics, 8,
                new String[]{"monitor", "dell", "4k", "usb-c"},
                createMetadata("resolution", "4K", "size", "27 polegadas", "panel", "IPS")),
            
            createProduct("MON-002", "Monitor LG UltraGear 27", 
                "Monitor gamer 27 polegadas, QHD, 165Hz, 1ms",
                new BigDecimal("1899.00"), electronics, 12,
                new String[]{"monitor", "lg", "gamer", "165hz"},
                createMetadata("resolution", "QHD", "refresh", "165Hz", "response", "1ms")),
            
            // Acessórios
            createProduct("WEBCAM-001", "Webcam Logitech C920s", 
                "Webcam Full HD 1080p, microfone estéreo, proteção de privacidade",
                new BigDecimal("399.90"), accessories, 30,
                new String[]{"webcam", "logitech", "1080p"},
                createMetadata("resolution", "1080p", "fov", "78°", "microphone", "stereo")),
            
            createProduct("HEAD-001", "Headset Sony WH-1000XM5", 
                "Headset sem fio com cancelamento de ruído, 30h de bateria",
                new BigDecimal("1899.00"), electronics, 20,
                new String[]{"headset", "sony", "wireless", "noise-cancelling"},
                createMetadata("color", "prata", "battery", "30h", "noise-cancelling", "true"))
        );
        
        productRepository.saveAll(products);
        log.info("✅ Created {} products", products.size());
    }
    
    /**
     * Cria um produto com todos os atributos
     * Versão melhorada: agora usa Category (objeto) em vez de String
     */
    private Product createProduct(String sku, String name, String description, 
                                  BigDecimal price, Category category, int stock,
                                  String[] tags, Map<String, Object> metadata) {
        Product product = new Product(sku, name, price);
        product.setDescription(description);
        product.setCategory(category);  // ← Agora é Category, não mais String!
        product.setStockQuantity(stock);
        product.setTags(tags);
        product.setMetadata(metadata);
        product.setActive(true);
        product.setCreatedAt(LocalDateTime.now());
        return product;
    }
    
    /**
     * Cria um mapa de metadados a partir de pares chave-valor
     * Exemplo: createMetadata("color", "red", "size", "large")
     */
    private Map<String, Object> createMetadata(Object... pairs) {
        Map<String, Object> metadata = new HashMap<>();
        for (int i = 0; i < pairs.length; i += 2) {
            metadata.put(pairs[i].toString(), pairs[i + 1]);
        }
        return metadata;
    }
    
    // =================================================================================
    // ==================== SECURITY DATA (Roles, Permissions, Users) ====================
    // =================================================================================
    
    /*
      INICIALIZAÇÃO DOS DADOS DE SEGURANÇA
      
      Estrutura de autorização:
      ┌─────────────┐     ┌─────────────┐     ┌───────────────┐
      │    USER     │────<│    ROLE     │────<│  PERMISSION   │
      └─────────────┘     └─────────────┘     └───────────────┘
      
      - Um usuário pode ter vários papéis (roles)
      - Um papel pode ter várias permissões (permissions)
      - Permissões são granulares: PRODUCT_READ, PRODUCT_CREATE, etc.
      
      Por que isso é importante?
      - RBAC (Role-Based Access Control) é padrão da indústria
      - Permissões granulares permitem controle fino de acesso
      - Separa o QUE o usuário pode fazer (permission) de QUEM ele é (role)
     */
    
    private void initializeSecurityData() {
        log.info("🔐 Initializing security data...");
        
        // Ordem correta: permissions → roles → role-permissions → users
        initializePermissions();      // 1º: Permissões (independents)
        initializeRoles();            // 2º: Papéis (dependem de permissões)
        assignPermissionsToRoles();   // 3º: Associa permissões aos papéis
        initializeUsers();            // 4º: Usuários (dependem de papéis)
        
        log.info("✅ Security data initialized");
    }
    
    // -----------------------------------------------------------------------------
    // PERMISSIONS (Permissões Granulares)
    // -----------------------------------------------------------------------------
    
    /*
      PERMISSIONS: O que o usuário pode fazer
      
      Exemplos:
      - PRODUCT_READ: Pode visualizar produtos
      - PRODUCT_CREATE: Pode criar produtos
      - PRODUCT_UPDATE: Pode editar produtos
      - PRODUCT_DELETE: Pode deletar produtos
      
      Princípio do Menor Privilégio: Cada usuário recebe APENAS as permissões
      necessárias para sua função.
     */
    
    private void initializePermissions() {
        if (permissionRepository.count() > 0) {
            log.info("Permissions already exist, skipping...");
            return;
        }
        
        List<Permission> permissions = Arrays.asList(
            // Permissões de Produtos
            createPermission("PRODUCT_READ", "Visualizar produtos"),
            createPermission("PRODUCT_CREATE", "Criar novos produtos"),
            createPermission("PRODUCT_UPDATE", "Atualizar produtos existentes"),
            createPermission("PRODUCT_DELETE", "Excluir produtos"),
            
            // Permissões de Usuários
            createPermission("USER_READ", "Visualizar usuários"),
            createPermission("USER_CREATE", "Criar novos usuários"),
            createPermission("USER_UPDATE", "Atualizar usuários"),
            createPermission("USER_DELETE", "Excluir usuários"),
            
            // Permissões Administrativas
            createPermission("ROLE_MANAGE", "Gerenciar papéis e permissões"),
            createPermission("REPORT_VIEW", "Visualizar relatórios")
        );
        
        permissionRepository.saveAll(permissions);
        log.info("✅ Created {} permissions", permissions.size());
    }
    
    private Permission createPermission(String name, String description) {
        Permission permission = new Permission(name, description);
        return permission;
    }
    
    // -----------------------------------------------------------------------------
    // ROLES (Papéis)
    // -----------------------------------------------------------------------------
    
    /*
      ROLES: Quem o usuário é (grupo de permissões)
      
      Hierarquia de papéis:
      - ROLE_ADMIN: Acesso total (todas as permissões)
      - ROLE_MANAGER: Acesso administrativo limitado (produtos + leitura usuários)
      - ROLE_USER: Acesso básico (apenas leitura de produtos)
     */
    
    private void initializeRoles() {
        if (roleRepository.count() > 0) {
            log.info("Roles already exist, skipping...");
            return;
        }
        
        List<Role> roles = Arrays.asList(
            createRole("ROLE_ADMIN", "Administrador do sistema - Acesso total"),
            createRole("ROLE_MANAGER", "Gerente - Acesso administrativo limitado"),
            createRole("ROLE_USER", "Usuário comum - Acesso básico")
        );
        
        roleRepository.saveAll(roles);
        log.info("✅ Created {} roles", roles.size());
    }
    
    private Role createRole(String name, String description) {
        Role role = new Role(name, description);
        return role;
    }
    
    // -----------------------------------------------------------------------------
    // ROLE-PERMISSION ASSIGNMENTS (Atribuição de Permissões aos Papéis)
    // -----------------------------------------------------------------------------
    
    /*
      ATRIBUIÇÃO DE PERMISSÕES A PAPÉIS
      
      Define quais permissões cada papel tem acesso.
      Esta é a "matriz de autorização" do sistema.
     */
    
    private void assignPermissionsToRoles() {
        log.info("Assigning permissions to roles...");
        
        Role admin = roleRepository.findByName("ROLE_ADMIN").orElse(null);
        Role manager = roleRepository.findByName("ROLE_MANAGER").orElse(null);
        Role user = roleRepository.findByName("ROLE_USER").orElse(null);
        
        // ADMIN: Todas as permissões
        if (admin != null && admin.getPermissions().isEmpty()) {
            List<Permission> allPermissions = permissionRepository.findAll();
            admin.setPermissions(new HashSet<>(allPermissions));
            roleRepository.save(admin);
            log.info("✅ Assigned {} permissions to ADMIN", allPermissions.size());
        }
        
        // MANAGER: Permissões de produtos + leitura de usuários
        if (manager != null && manager.getPermissions().isEmpty()) {
            List<Permission> managerPermissions = permissionRepository.findAllByNameIn(
                Arrays.asList("PRODUCT_READ", "PRODUCT_CREATE", "PRODUCT_UPDATE", "USER_READ")
            );
            manager.setPermissions(new HashSet<>(managerPermissions));
            roleRepository.save(manager);
            log.info("✅ Assigned {} permissions to MANAGER", managerPermissions.size());
        }
        
        // USER: Apenas leitura de produtos
        if (user != null && user.getPermissions().isEmpty()) {
            Permission readPermission = permissionRepository.findByName("PRODUCT_READ").orElse(null);
            if (readPermission != null) {
                Set<Permission> userPermissions = new HashSet<>();
                userPermissions.add(readPermission);
                user.setPermissions(userPermissions);
                roleRepository.save(user);
                log.info("✅ Assigned PRODUCT_READ permission to USER");
            }
        }
    }
    
    // -----------------------------------------------------------------------------
    // USERS (Usuários)
    // -----------------------------------------------------------------------------
    
    /*
      USUÁRIOS INICIAIS
      
      Cria usuários com diferentes níveis de acesso para testes:
      - admin@springlab.com: Acesso administrativo total
      - gerente@springlab.com: Acesso de gerência
      - usuario@springlab.com: Acesso de usuário comum
      
      As senhas são armazenadas com BCrypt (hash + salt) - SEGURANÇA!
     */
    
    private void initializeUsers() {
        if (userRepository.count() > 0) {
            log.info("Users already exist, skipping...");
            return;
        }
        
        Role adminRole = roleRepository.findByName("ROLE_ADMIN").orElse(null);
        Role managerRole = roleRepository.findByName("ROLE_MANAGER").orElse(null);
        Role userRole = roleRepository.findByName("ROLE_USER").orElse(null);
        
        // Usuários com diferentes níveis de acesso
        List<User> users = Arrays.asList(
            createUser("admin@springlab.com", "Admin123!", "Administrador do Sistema", "11999999999", Set.of(adminRole)),
            createUser("gerente@springlab.com", "Manager123!", "Gerente de Produtos", "11988888888", Set.of(managerRole)),
            createUser("usuario@springlab.com", "User123!", "Usuário Comum", "11977777777", Set.of(userRole)),
            createUser("joao.silva@email.com", "Senha123!", "João Silva", "11966666666", Set.of(userRole)),
            createUser("maria.santos@email.com", "Senha123!", "Maria Santos", "11955555555", Set.of(userRole))
        );
        
        userRepository.saveAll(users);
        log.info("✅ Created {} users", users.size());
    }
    
    /**
     * Cria um usuário com senha codificada (BCrypt)
     * A senha NUNCA é armazenada em texto puro!
     */
    private User createUser(String email, String rawPassword, String fullName, 
                            String phone, Set<Role> roles) {
        User user = new User(email, passwordEncoder.encode(rawPassword), fullName);
        user.setPhone(phone);
        user.setEmailVerified(true);  // Em desenvolvimento, já verificado
        user.setRoles(roles);
        user.setCreatedAt(LocalDateTime.now());
        return user;
    }
}

/*
  =================================================================================
  RESUMO DAS MELHORIAS IMPLEMENTADAS
  =================================================================================
  
  VERSÃO ANTIGA (Apenas produtos):
  ✅ Produtos com categoria como String (desnormalizado)
  ✅ Apenas 5 produtos de exemplo
  
  VERSÃO NOVA (Completa):
  ✅ Categorias com hierarquia (auto-relacionamento)
  ✅ Produtos com relacionamento @ManyToOne para Category (normalizado)
  ✅ RBAC completo (Roles, Permissions, Users)
  ✅ Usuários com senhas BCrypt (segurança!)
  ✅ 10+ produtos de exemplo
  ✅ Logging profissional
  ✅ Código comentado e documentado
  
  POR QUE ESTAS MUDANÇAS SÃO IMPORTANTES?
  
  1. NORMALIZAÇÃO:
     - Antes: category VARCHAR(100) (texto puro, repetido)
     - Agora: category_id BIGINT FK (referência normalizada)
     - Benefício: Integridade referencial, evita inconsistências
  
  2. RBAC (Role-Based Access Control):
     - Permite controle granular de acesso
     - Segue princípios de segurança de mercado
     - Facilita evolução das regras de negócio
  
  3. BCrypt:
     - Senhas NUNCA em texto puro
     - Hash com salt automático
     - Proteção contra rainbow tables
  
  4. Hierarquia de Categorias:
     - Suporte a categorias aninhadas
     - Exemplo: Eletrônicos > Computadores > Notebooks
     - Útil para sistemas de e-commerce
*/

/*
  =================================================================================
  CREDENCIAIS PARA TESTE
  =================================================================================
  
  Use estas credenciais para testar a API:
  
  ┌─────────────────┬───────────────────┬─────────────────────────────────┐
  │ PAPEL           │ EMAIL             │ SENHA                           │
  ├─────────────────┼───────────────────┼─────────────────────────────────┤
  │ ADMIN           │ admin@springlab.com│ Admin123!                       │
  ├─────────────────┼───────────────────┼─────────────────────────────────┤
  │ MANAGER         │ gerente@springlab.com│ Manager123!                   │
  ├─────────────────┼───────────────────┼─────────────────────────────────┤
  │ USER            │ usuario@springlab.com│ User123!                      │
  └─────────────────┴───────────────────┴─────────────────────────────────┘
  
  TESTANDO OS ENDPOINTS:
  
  1. Login como ADMIN:
     POST /api/v1/auth/login
     {"email": "admin@springlab.com", "password": "Admin123!"}
  
  2. Criar produto (apenas ADMIN/MANAGER):
     POST /api/v1/products
     Authorization: Bearer <token>
  
  3. Listar produtos (qualquer usuário autenticado):
     GET /api/v1/products
     Authorization: Bearer <token>
*/
```

---

## 📄 Arquivo: `spring-lab\src\main\java\com\rojudo\spring_lab\config\HealthCheckConfig.java`

**Caminho completo:** `E:\Projects & Studies\Studies\Spring Boot LAB\spring-lab\src\main\java\com\rojudo\spring_lab\config\HealthCheckConfig.java`
**Tamanho:** 1,268 bytes
**Extensão:** `.java`

```java
package com.rojudo.spring_lab.config;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;

/**
 * HEALTH CHECK PERSONALIZADO
 * 
 * Endpoints:
 * - /actuator/health/liveness  → App está viva?
 * - /actuator/health/readiness → App está pronta para receber tráfego?
 */
@Component
public class HealthCheckConfig implements HealthIndicator {
    
    private final MemoryMXBean memoryBean = ManagementFactory.getMemoryMXBean();
    
    @Override
    public Health health() {
        long heapUsed = memoryBean.getHeapMemoryUsage().getUsed();
        long heapMax = memoryBean.getHeapMemoryUsage().getMax();
        double heapUsagePercent = (double) heapUsed / heapMax * 100;
        
        return Health.up()
            .withDetail("memory.heap.used", String.format("%.2f MB", heapUsed / 1024.0 / 1024.0))
            .withDetail("memory.heap.max", String.format("%.2f MB", heapMax / 1024.0 / 1024.0))
            .withDetail("memory.heap.usage", String.format("%.2f%%", heapUsagePercent))
            .build();
    }
}
```

---

## 📄 Arquivo: `spring-lab\src\main\java\com\rojudo\spring_lab\config\JpaAuditingConfig.java`

**Caminho completo:** `E:\Projects & Studies\Studies\Spring Boot LAB\spring-lab\src\main\java\com\rojudo\spring_lab\config\JpaAuditingConfig.java`
**Tamanho:** 1,216 bytes
**Extensão:** `.java`

```java
package com.rojudo.spring_lab.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class JpaAuditingConfig {
    
    @Bean
    public AuditorAware<String> auditorProvider() {
        return () -> {
            // Pega usuário atual do Security Context
            if (SecurityContextHolder.getContext().getAuthentication() != null) {
                Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
                
                if (principal instanceof UserDetails) {
                    return Optional.of(((UserDetails) principal).getUsername());
                }
                return Optional.of(principal.toString());
            }
            return Optional.of("system");
        };
    }
}
```

---

## 📄 Arquivo: `spring-lab\src\main\java\com\rojudo\spring_lab\config\JwtAuthenticationFilter.java`

**Caminho completo:** `E:\Projects & Studies\Studies\Spring Boot LAB\spring-lab\src\main\java\com\rojudo\spring_lab\config\JwtAuthenticationFilter.java`
**Tamanho:** 3,999 bytes
**Extensão:** `.java`

```java
package com.rojudo.spring_lab.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * JWT AUTHENTICATION FILTER
 * 
 * Intercepta cada requisição e valida o token JWT
 */
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    
    private static final Logger log = LoggerFactory.getLogger(JwtAuthenticationFilter.class);
    
    private static final String BEARER_PREFIX = "Bearer ";
    private static final String AUTHORIZATION_HEADER = "Authorization";
    
    @Autowired
    private JwtService jwtService;
    
    @Autowired
    private UserDetailsService userDetailsService;
    
    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException {
        
        try {
            String jwt = extractJwtFromRequest(request);
            
            if (StringUtils.hasText(jwt) && SecurityContextHolder.getContext().getAuthentication() == null) {
                String username = jwtService.extractUsername(jwt);
                
                if (username != null) {
                    UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                    
                    if (jwtService.isTokenValid(jwt, userDetails)) {
                        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                            userDetails,
                            null,
                            userDetails.getAuthorities()
                        );
                        
                        authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                        SecurityContextHolder.getContext().setAuthentication(authToken);
                        
                        log.debug("Authenticated user: {} with authorities: {}", 
                            username, userDetails.getAuthorities());
                    }
                }
            }
        } catch (Exception e) {
            log.error("Cannot set user authentication: {}", e.getMessage());
        }
        
        filterChain.doFilter(request, response);
    }
    
    /**
     * Extrai JWT do header Authorization
     */
    private String extractJwtFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader(AUTHORIZATION_HEADER);
        
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith(BEARER_PREFIX)) {
            return bearerToken.substring(BEARER_PREFIX.length());
        }
        
        return null;
    }
    
    /**
     * Opcional: pular filtro para endpoints públicos
     */
    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        String path = request.getRequestURI();
        return path.startsWith("/api/v1/auth/") || 
               path.startsWith("/actuator/health") ||
               path.startsWith("/swagger-ui/") ||
               path.startsWith("/v3/api-docs/");
    }
}
```

---

## 📄 Arquivo: `spring-lab\src\main\java\com\rojudo\spring_lab\config\JwtService.java`

**Caminho completo:** `E:\Projects & Studies\Studies\Spring Boot LAB\spring-lab\src\main\java\com\rojudo\spring_lab\config\JwtService.java`
**Tamanho:** 5,422 bytes
**Extensão:** `.java`

```java
package com.rojudo.spring_lab.config;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * JWT SERVICE - Geração e validação de tokens
 * 
 * PRINCÍPIOS:
 * - Tokens são assinados com HMAC-SHA256
 * - Claims incluem usuário, roles e expiração
 * - Stateless: não armazenamos tokens no servidor
 */
@Service
public class JwtService {
    
    private static final Logger log = LoggerFactory.getLogger(JwtService.class);
    
    @Value("${jwt.secret:404E635266556A586E3272357538782F413F4428472B4B6250645367566B5970}")
    private String secret;
    
    @Value("${jwt.expiration:3600000}")  // 1 hora em milissegundos
    private long expiration;
    
    @Value("${jwt.refresh-expiration:86400000}")  // 24 horas
    private long refreshExpiration;
    
    /**
     * Gera token JWT a partir do Authentication
     */
    public String generateToken(Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        
        Map<String, Object> claims = new HashMap<>();
        claims.put("authorities", userDetails.getAuthorities().stream()
            .map(GrantedAuthority::getAuthority)
            .collect(Collectors.toList()));
        
        return generateToken(claims, userDetails.getUsername());
    }
    
    /**
     * Gera token com claims customizadas
     */
    public String generateToken(Map<String, Object> extraClaims, String subject) {
        return Jwts.builder()
            .claims(extraClaims)
            .subject(subject)
            .issuedAt(new Date())
            .expiration(new Date(System.currentTimeMillis() + expiration))
            .signWith(getSigningKey())
            .compact();
    }
    
    /**
     * Gera refresh token (maior duração)
     */
    public String generateRefreshToken(String subject) {
        return Jwts.builder()
            .subject(subject)
            .issuedAt(new Date())
            .expiration(new Date(System.currentTimeMillis() + refreshExpiration))
            .signWith(getSigningKey())
            .compact();
    }
    
    /**
     * Extrai username (email) do token
     */
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }
    
    /**
     * Extrai data de expiração
     */
    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }
    
    /**
     * Extrai claim específico
     */
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }
    
    /**
     * Valida token
     */
    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }
    
    /**
     * Verifica se token está expirado
     */
    public boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }
    
    /**
     * Extrai todos os claims
     */
    private Claims extractAllClaims(String token) {
        try {
            return Jwts.parser()
                .verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
        } catch (ExpiredJwtException e) {
            log.warn("Token expired: {}", e.getMessage());
            throw e;
        } catch (SignatureException e) {
            log.warn("Invalid token signature: {}", e.getMessage());
            throw e;
        } catch (MalformedJwtException e) {
            log.warn("Malformed token: {}", e.getMessage());
            throw e;
        } catch (Exception e) {
            log.error("Error validating token: {}", e.getMessage());
            throw new RuntimeException("Invalid token");
        }
    }
    
    /**
     * Retorna chave de assinatura
     */
    private SecretKey getSigningKey() {
        byte[] keyBytes = secret.getBytes(StandardCharsets.UTF_8);
        return Keys.hmacShaKeyFor(keyBytes);
    }
    
    /**
     * Extrai tempo restante do token em segundos
     */
    public Long getRemainingTime(String token) {
        Date expiration = extractExpiration(token);
        long remainingMillis = expiration.getTime() - System.currentTimeMillis();
        return Math.max(0, remainingMillis / 1000);
    }
    
    /**
     * Verifica se token pode ser renovado
     */
    public boolean canBeRefreshed(String token) {
        return !isTokenExpired(token);
    }
}
```

---

## 📄 Arquivo: `spring-lab\src\main\java\com\rojudo\spring_lab\config\LoggingAspect.java`

**Caminho completo:** `E:\Projects & Studies\Studies\Spring Boot LAB\spring-lab\src\main\java\com\rojudo\spring_lab\config\LoggingAspect.java`
**Tamanho:** 3,264 bytes
**Extensão:** `.java`

```java
package com.rojudo.spring_lab.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

/**
 * LOGGING ASPECT
 * 
 * Log automático de métodos:
 * - Service: DEBUG (parâmetros + tempo)
 * - Controller: INFO (requisições)
 * - Repository: TRACE (queries)
 * 
 * USO DE TOKENS: Mínimo impacto (logs condicionais)
 */
@Aspect
@Component
public class LoggingAspect {
    
    // ===== SERVICE LAYER =====
    
    @Around("execution(* com.rojudo.spring_lab.service..*.*(..))")
    public Object logService(ProceedingJoinPoint joinPoint) throws Throwable {
        Logger log = LoggerFactory.getLogger(joinPoint.getTarget().getClass());
        
        if (!log.isDebugEnabled()) {
            return joinPoint.proceed();
        }
        
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        
        log.debug("→ {}() - Args: {}", methodName, args);
        
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        
        Object result = joinPoint.proceed();
        
        stopWatch.stop();
        log.debug("← {}() - Return: {} - Time: {}ms", 
            methodName, result, stopWatch.getTotalTimeMillis());
        
        return result;
    }
    
    // ===== CONTROLLER LAYER =====
    
    @Around("execution(* com.rojudo.spring_lab.controller..*.*(..))")
    public Object logController(ProceedingJoinPoint joinPoint) throws Throwable {
        Logger log = LoggerFactory.getLogger(joinPoint.getTarget().getClass());
        
        String methodName = joinPoint.getSignature().getName();
        
        log.info("→ {}", methodName);
        
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        
        Object result = joinPoint.proceed();
        
        stopWatch.stop();
        
        if (stopWatch.getTotalTimeMillis() > 1000) {
            log.warn("← {}() - SLOW ({}ms)", methodName, stopWatch.getTotalTimeMillis());
        } else {
            log.info("← {}() - {}ms", methodName, stopWatch.getTotalTimeMillis());
        }
        
        return result;
    }
    
    // ===== REPOSITORY LAYER (apenas se necessário) =====
    
    @Around("execution(* com.rojudo.spring_lab.repository..*.*(..))")
    public Object logRepository(ProceedingJoinPoint joinPoint) throws Throwable {
        Logger log = LoggerFactory.getLogger(joinPoint.getTarget().getClass());
        
        if (!log.isTraceEnabled()) {
            return joinPoint.proceed();
        }
        
        String methodName = joinPoint.getSignature().getName();
        log.trace("→ {}", methodName);
        
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        
        Object result = joinPoint.proceed();
        
        stopWatch.stop();
        log.trace("← {} - {}ms", methodName, stopWatch.getTotalTimeMillis());
        
        return result;
    }
}
```

---

## 📄 Arquivo: `spring-lab\src\main\java\com\rojudo\spring_lab\config\MdcFilter.java`

**Caminho completo:** `E:\Projects & Studies\Studies\Spring Boot LAB\spring-lab\src\main\java\com\rojudo\spring_lab\config\MdcFilter.java`
**Tamanho:** 2,154 bytes
**Extensão:** `.java`

```java
package com.rojudo.spring_lab.config;

import com.rojudo.spring_lab.exception.TraceIdGenerator;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * MDC FILTER
 * 
 * Adiciona Trace ID ao contexto de log para toda requisição
 * Permite rastrear todas as operações de uma mesma requisição
 */
@Component
@Order(1)
public class MdcFilter extends OncePerRequestFilter {

    private static final Logger log = LoggerFactory.getLogger(MdcFilter.class);
    
    private static final String TRACE_ID_HEADER = "X-Trace-Id";
    private static final String MDC_TRACE_KEY = "traceId";
    
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        
        try {
            // Tenta obter Trace ID do header, ou gera novo
            String traceId = request.getHeader(TRACE_ID_HEADER);
            if (traceId == null || traceId.isBlank()) {
                traceId = TraceIdGenerator.generateForMdc();
            }
            
            // Adiciona ao MDC (será incluído em todos os logs da requisição)
            MDC.put(MDC_TRACE_KEY, traceId);
            
            // Adiciona ao response header para o cliente
            response.setHeader(TRACE_ID_HEADER, traceId);
            
            // Log da requisição
            log.info("→ {} {}", request.getMethod(), request.getRequestURI());
            
            filterChain.doFilter(request, response);
            
        } finally {
            // Remove do MDC após a requisição
            MDC.clear();
        }
    }
}
```

---

## 📄 Arquivo: `spring-lab\src\main\java\com\rojudo\spring_lab\config\OpenAPIConfig.java`

**Caminho completo:** `E:\Projects & Studies\Studies\Spring Boot LAB\spring-lab\src\main\java\com\rojudo\spring_lab\config\OpenAPIConfig.java`
**Tamanho:** 2,604 bytes
**Extensão:** `.java`

```java
package com.rojudo.spring_lab.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class OpenAPIConfig {
    
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("Spring Lab API")
                .version("0.0.2")
                .description("""
                    REST API Lab para e-commerce com Spring Boot.
                    
                    ## Funcionalidades:
                    * CRUD completo de produtos
                    * Autenticação JWT
                    * Controle de permissões (RBAC)
                    * Paginação e filtros
                    
                    ## Fluxo de autenticação:
                    1. Faça login em `/api/v1/auth/login`
                    2. Copie o token recebido
                    3. Clique no botão "Authorize" abaixo e insira: `Bearer {seu-token}`
                    """)
                .contact(new Contact()
                    .name("Roger Baggio")
                    .email("fakecontato@email.com")
                    .url("https://github.com/RogerBaggio"))
                .license(new License()
                    .name("MIT License")
                    .url("https://opensource.org/licenses/MIT")))
            .servers(List.of(
                new Server()
                    .url("http://localhost:8080")
                    .description("Servidor de Desenvolvimento"),
                new Server()
                    .url("https://api.prod.springlabfakesite.com")
                    .description("Servidor de Produção fake")))
            .components(new Components()
                .addSecuritySchemes("bearerAuth", new SecurityScheme()
                    .type(SecurityScheme.Type.HTTP)
                    .scheme("bearer")
                    .bearerFormat("JWT")
                    .description("Insira o token JWT obtido no login. Exemplo: Bearer eyJhbGciOiJIUzI1...")))
            .addSecurityItem(new SecurityRequirement().addList("bearerAuth"));
    }
}
```

---

## 📄 Arquivo: `spring-lab\src\main\java\com\rojudo\spring_lab\config\SecurityAuditListener.java`

**Caminho completo:** `E:\Projects & Studies\Studies\Spring Boot LAB\spring-lab\src\main\java\com\rojudo\spring_lab\config\SecurityAuditListener.java`
**Tamanho:** 1,832 bytes
**Extensão:** `.java`

```java
package com.rojudo.spring_lab.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AbstractAuthenticationFailureEvent;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;

@Component
public class SecurityAuditListener {
    
    private static final Logger auditLog = LoggerFactory.getLogger("AUDIT");
    
    @EventListener
    public void onAuthenticationSuccess(AuthenticationSuccessEvent event) {
        String username = event.getAuthentication().getName();
        String ip = getClientIp(event);
        
        auditLog.info("LOGIN_SUCCESS - User: {}, IP: {}", username, ip);
    }
    
    @EventListener
    public void onAuthenticationFailure(AbstractAuthenticationFailureEvent event) {
        String username = event.getAuthentication().getName();
        String ip = getClientIp(event);
        String reason = event.getException().getMessage();
        
        auditLog.warn("LOGIN_FAILURE - User: {}, IP: {}, Reason: {}", username, ip, reason);
    }
    
    private String getClientIp(AuthenticationSuccessEvent event) {
        if (event.getAuthentication().getDetails() instanceof WebAuthenticationDetails details) {
            return details.getRemoteAddress();
        }
        return "unknown";
    }
    
    private String getClientIp(AbstractAuthenticationFailureEvent event) {
        if (event.getAuthentication().getDetails() instanceof WebAuthenticationDetails details) {
            return details.getRemoteAddress();
        }
        return "unknown";
    }
}
```

---

## 📄 Arquivo: `spring-lab\src\main\java\com\rojudo\spring_lab\config\SecurityConfig.java`

**Caminho completo:** `E:\Projects & Studies\Studies\Spring Boot LAB\spring-lab\src\main\java\com\rojudo\spring_lab\config\SecurityConfig.java`
**Tamanho:** 5,945 bytes
**Extensão:** `.java`

```java
package com.rojudo.spring_lab.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.List;

/**
 * SECURITY CONFIGURATION
 * 
 * PRINCÍPIOS:
 * - Stateless: Não usamos sessões
 * - JWT: Autenticação via token
 * - CORS: Configurado para frontend
 * - Method Security: @PreAuthorize em controllers
 */
@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)  // Habilita @PreAuthorize
public class SecurityConfig {
    
    private final JwtAuthenticationFilter jwtAuthFilter;
    private final CustomAuthenticationEntryPoint authenticationEntryPoint;
    
    @Autowired
    public SecurityConfig(JwtAuthenticationFilter jwtAuthFilter,
                          CustomAuthenticationEntryPoint authenticationEntryPoint) {
        this.jwtAuthFilter = jwtAuthFilter;
        this.authenticationEntryPoint = authenticationEntryPoint;
    }
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            // Desabilita CSRF (stateless API)
            .csrf(AbstractHttpConfigurer::disable)
            
            // CORS configuration
            .cors(cors -> cors.configurationSource(corsConfigurationSource()))
            
            // Session management - STATELESS
            .sessionManagement(session -> session
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            )
            
            // Exception handling
            .exceptionHandling(exception -> exception
                .authenticationEntryPoint(authenticationEntryPoint)
            )
            
            // Authorization rules
            .authorizeHttpRequests(auth -> auth
                // Public endpoints
                .requestMatchers(
                    "/api/v1/auth/**",           // Login/Register
                    "/api/v1/public/**",          // Public resources
                    "/actuator/health",           // Health check
                    "/swagger-ui/**",              // Swagger UI
                    "/v3/api-docs/**",             // OpenAPI docs
                    "/h2-console/**"               // H2 console (dev only)
                ).permitAll()
                
                // Protected endpoints - role based
                .requestMatchers("/api/v1/admin/**").hasRole("ADMIN")
                .requestMatchers("/api/v1/users/**").hasAnyRole("ADMIN", "USER")
                
                // Product endpoints - permission based
                .requestMatchers("/api/v1/products/**").hasAnyAuthority("PRODUCT_READ")
                .requestMatchers("/api/v1/products", "/api/v1/products/*").hasAuthority("PRODUCT_CREATE")
                .requestMatchers("/api/v1/products/*/edit").hasAuthority("PRODUCT_UPDATE")
                .requestMatchers("/api/v1/products/*/delete").hasAuthority("PRODUCT_DELETE")
                
                // Any other request requires authentication
                .anyRequest().authenticated()
            )
            
            // Add JWT filter before UsernamePasswordAuthenticationFilter
            .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
        
        return http.build();
    }
    
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(List.of(
            "http://localhost:3000",     // React dev
            "http://localhost:4200",     // Angular dev
            "http://localhost:8081"      // Outros frontends
        ));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type", "X-Requested-With"));
        configuration.setExposedHeaders(List.of("Authorization"));
        configuration.setAllowCredentials(true);
        configuration.setMaxAge(3600L);
        
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
    
    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();  // Força de trabalho padrão: 10
    }
}
```

---

## 📄 Arquivo: `spring-lab\src\main\java\com\rojudo\spring_lab\controller\AuthController.java`

**Caminho completo:** `E:\Projects & Studies\Studies\Spring Boot LAB\spring-lab\src\main\java\com\rojudo\spring_lab\controller\AuthController.java`
**Tamanho:** 3,327 bytes
**Extensão:** `.java`

```java
package com.rojudo.spring_lab.controller;

import com.rojudo.spring_lab.dto.request.AuthLoginRequest;
import com.rojudo.spring_lab.dto.request.AuthRegisterRequest;
import com.rojudo.spring_lab.dto.response.AuthLoginResponse;
import com.rojudo.spring_lab.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@Tag(name = "Autenticação", description = "Endpoints de autenticação e registro")
public class AuthController {
    
    private final AuthService authService;
    
    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }
    
    @PostMapping("/login")
    @Operation(summary = "Login", description = "Autentica usuário e retorna token JWT")
    @ApiResponse(responseCode = "200", description = "Login realizado com sucesso")
    @ApiResponse(responseCode = "401", description = "Credenciais inválidas")
    public ResponseEntity<AuthLoginResponse> login(@Valid @RequestBody AuthLoginRequest request) {
        AuthLoginResponse response = authService.login(request);
        return ResponseEntity.ok(response);
    }
    
    @PostMapping("/register")
    @Operation(summary = "Registro", description = "Registra novo usuário")
    @ApiResponse(responseCode = "201", description = "Usuário registrado com sucesso")
    @ApiResponse(responseCode = "400", description = "Dados inválidos")
    @ApiResponse(responseCode = "409", description = "Email já cadastrado")
    public ResponseEntity<AuthLoginResponse> register(@Valid @RequestBody AuthRegisterRequest request) {
        AuthLoginResponse response = authService.register(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    
    @PostMapping("/refresh")
    @Operation(summary = "Refresh Token", description = "Renova token JWT")
    public ResponseEntity<AuthLoginResponse> refresh(@RequestHeader("Authorization") String refreshToken) {
        AuthLoginResponse response = authService.refreshToken(refreshToken);
        return ResponseEntity.ok(response);
    }
    
    @PostMapping("/logout")
    @Operation(summary = "Logout", description = "Realiza logout (invalida token no client)")
    public ResponseEntity<Void> logout() {
        // Cliente deve remover o token localmente
        // Como é stateless, não precisamos invalidar no servidor
        return ResponseEntity.noContent().build();
    }
    
    @PostMapping("/change-password")
    @Operation(summary = "Alterar senha", description = "Altera senha do usuário autenticado")
    public ResponseEntity<Void> changePassword(
            @RequestHeader("Authorization") String token,
            @RequestParam String oldPassword,
            @RequestParam String newPassword) {
        authService.changePassword(token, oldPassword, newPassword);
        return ResponseEntity.noContent().build();
    }
}
```

---

## 📄 Arquivo: `spring-lab\src\main\java\com\rojudo\spring_lab\controller\ProductController.java`

**Caminho completo:** `E:\Projects & Studies\Studies\Spring Boot LAB\spring-lab\src\main\java\com\rojudo\spring_lab\controller\ProductController.java`
**Tamanho:** 19,355 bytes
**Extensão:** `.java`

```java
package com.rojudo.spring_lab.controller;

import com.rojudo.spring_lab.dto.request.ProductRequest;
import com.rojudo.spring_lab.dto.response.ProductResponse;
import com.rojudo.spring_lab.service.ProductService;
import com.rojudo.spring_lab.validation.ValidationGroups;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.net.URI;
import java.util.List;

import jakarta.validation.constraints.Max;

/*CONTROLLER: Camada de apresentação (REST endpoints)
  
  POR QUE CONTROLLER?
  - Expor funcionalidades via HTTP
  - Validação de entrada
  - Mapeamento de status HTTP
  - Documentação da API
  
  PRINCÍPIOS:
  - @RestController = @Controller + @ResponseBody
  - @RequestMapping define base path
  - @Tag documenta no Swagger
  
  SEGURANÇA:
  - @PreAuthorize: Controla acesso baseado em roles/permissões
  - hasAuthority(): Verifica permissões específicas (ex: PRODUCT_READ)
  - hasRole(): Verifica papéis (ex: ROLE_ADMIN)
  - Expressões podem combinar condições com operadores lógicos
  
  VALIDAÇÃO POR GRUPOS:
  - @Validated(OnCreate.class): Usado para CREATE - valida todos os campos obrigatórios
  - @Validated(OnUpdate.class): Usado para UPDATE - SKU, nome e preço são opcionais
  - @Valid: Usado para operações específicas como PATCH /stock
  
  VALIDAÇÃO DE PARÂMETROS:
  - @Min, @Max, @Positive, @Size: Valida parâmetros de URL e query string
  - @Validated a nível de classe habilita estas validações
 */
@RestController
@RequestMapping("/api/v1/products")
@Validated  // Habilita validação de parâmetros (@RequestParam, @PathVariable)
@Tag(name = "Produtos", description = "API para gerenciamento de produtos")
public class ProductController {
    
    private final ProductService productService;
    
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    
    // ==================== ENDPOINTS DE LEITURA (READ) ====================
    
    /*
      GET - Listar todos produtos (paginado)
      
      @PageableDefault: Configuração padrão de paginação
      
      SEGURANÇA: Qualquer usuário autenticado com permissão PRODUCT_READ
      - Usuários comuns (ROLE_USER) têm esta permissão via role padrão
      - Admins e Managers também têm acesso
     */
    @GetMapping
    @PreAuthorize("hasAuthority('PRODUCT_READ')")
    @Operation(summary = "Listar produtos", description = "Retorna lista paginada de produtos")
    public ResponseEntity<Page<ProductResponse>> findAll(
            @PageableDefault(
                size = 20,
                sort = "createdAt",
                direction = Sort.Direction.DESC
            ) Pageable pageable) {
        
        Page<ProductResponse> products = productService.findAll(pageable);
        
        return ResponseEntity.ok(products);
    }
    
    /*
      GET - Produtos ativos (paginado)
      
      SEGURANÇA: Requer permissão PRODUCT_READ
      - Filtro por produtos ativos, útil para catálogos públicos
     */
    @GetMapping("/active")
    @PreAuthorize("hasAuthority('PRODUCT_READ')")
    @Operation(summary = "Listar produtos ativos", description = "Retorna produtos ativos (com estoque > 0)")
    public ResponseEntity<Page<ProductResponse>> findActiveProducts(
            @PageableDefault(size = 20) Pageable pageable) {
        
        Page<ProductResponse> products = productService.findActiveProducts(pageable);
        
        return ResponseEntity.ok(products);
    }
    
    /*
      GET - Buscar por ID
      
      SEGURANÇA: Requer permissão PRODUCT_READ
      - Acesso detalhado a um produto específico
      
      VALIDAÇÃO: ID deve ser maior que 0 (positivo)
     */
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('PRODUCT_READ')")
    @Operation(summary = "Buscar produto por ID", description = "Retorna um produto específico pelo ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Produto encontrado"),
        @ApiResponse(responseCode = "404", description = "Produto não encontrado")
    })
    public ResponseEntity<ProductResponse> findById(
            @Parameter(description = "ID do produto", example = "1")
            @PathVariable @Positive(message = "ID do produto deve ser um número positivo") Long id) {
        
        ProductResponse product = productService.findById(id);
        
        return ResponseEntity.ok(product);
    }
    
    /*
      GET - Buscar por SKU
      
      SEGURANÇA: Requer permissão PRODUCT_READ
      - Busca por SKU (identificador único do produto)
      
      VALIDAÇÃO: SKU deve ter entre 3 e 50 caracteres
     */
    @GetMapping("/sku/{sku}")
    @PreAuthorize("hasAuthority('PRODUCT_READ')")
    public ResponseEntity<ProductResponse> findBySku(
            @PathVariable @Size(min = 3, max = 50, message = "SKU deve ter entre 3 e 50 caracteres") 
            String sku) {
        
        ProductResponse product = productService.findBySku(sku);
        return ResponseEntity.ok(product);
    }
    
    /*
      GET - Buscar por nome
      
      SEGURANÇA: Requer permissão PRODUCT_READ
      - Busca textual por nome do produto (case insensitive)
      
      VALIDAÇÃO: Nome deve ter entre 2 e 100 caracteres
     */
    @GetMapping("/search")
    @PreAuthorize("hasAuthority('PRODUCT_READ')")
    public ResponseEntity<List<ProductResponse>> searchByName(
            @RequestParam @Size(min = 2, max = 100, message = "Nome para busca deve ter entre 2 e 100 caracteres") 
            String name) {
        
        List<ProductResponse> products = productService.findByName(name);
        return ResponseEntity.ok(products);
    }
    
    /*
      GET - Buscar por faixa de preço
      
      SEGURANÇA: Requer permissão PRODUCT_READ
      - Filtro por intervalo de preços (minPrice e maxPrice)
      
      VALIDAÇÃO: 
      - minPrice deve ser maior que 0
      - maxPrice deve ser maior que 0
     */
    @GetMapping("/price-range")
    @PreAuthorize("hasAuthority('PRODUCT_READ')")
    public ResponseEntity<List<ProductResponse>> findByPriceRange(
            @RequestParam @Positive(message = "Preço mínimo deve ser maior que zero") 
            BigDecimal minPrice,
            @RequestParam @Positive(message = "Preço máximo deve ser maior que zero") 
            BigDecimal maxPrice) {
        
        List<ProductResponse> products = productService.findByPriceRange(minPrice, maxPrice);
        return ResponseEntity.ok(products);
    }
    
    // ==================== ENDPOINTS DE ESCRITA (WRITE) ====================
    
    /*
      POST - Criar novo produto
      
      @ResponseStatus(201) - Created
      Location header com URI do recurso criado
      
      SEGURANÇA: Requer permissão PRODUCT_CREATE
      - Apenas ADMIN e MANAGER têm esta permissão
      - Usuários comuns NÃO podem criar produtos
      
      VALIDAÇÃO: Usa grupo OnCreate
      - SKU: obrigatório e único
      - Nome: obrigatório
      - Preço: obrigatório e > 0
     */
    @PostMapping
    @PreAuthorize("hasAuthority('PRODUCT_CREATE')")
    @Operation(summary = "Criar novo produto", description = "Cria um produto com os dados fornecidos")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Produto criado com sucesso"),
        @ApiResponse(responseCode = "400", description = "Dados inválidos"),
        @ApiResponse(responseCode = "403", description = "Acesso negado"),
        @ApiResponse(responseCode = "409", description = "SKU já existe")
    })
    public ResponseEntity<ProductResponse> create(
            @Validated(ValidationGroups.OnCreate.class) 
            @RequestBody ProductRequest request) {
        
        ProductResponse response = productService.create(request);
        
        // Padrão REST: retornar URI do recurso criado
        URI location = URI.create(String.format("/api/v1/products/%d", response.id()));
        
        return ResponseEntity.created(location).body(response);
    }
    
    /*
      PUT - Atualizar produto (completo)
      
      SEGURANÇA: Requer permissão PRODUCT_UPDATE
      - Apenas ADMIN e MANAGER podem atualizar produtos
      - Atualização completa (todos os campos)
      
      VALIDAÇÃO: Usa grupo OnUpdate
      - SKU: opcional, mas se fornecido deve ser único (ignorando o próprio ID)
      - Nome: opcional, mas se fornecido não pode ser vazio
      - Preço: opcional, mas se fornecido deve ser > 0
      
      VALIDAÇÃO DE PARÂMETRO: ID deve ser maior que 0
     */
    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('PRODUCT_UPDATE')")
    public ResponseEntity<ProductResponse> update(
            @PathVariable @Positive(message = "ID do produto deve ser um número positivo") 
            Long id,
            @Validated(ValidationGroups.OnUpdate.class) 
            @RequestBody ProductRequest request) {
        
        ProductResponse response = productService.update(id, request);
        return ResponseEntity.ok(response);
    }
    
    /*
      PATCH - Atualizar estoque (operação específica)
      
      SEGURANÇA: Requer permissão PRODUCT_UPDATE
      - Operação específica para controle de estoque
      - Útil para sistemas de inventário
      
      VALIDAÇÃO: Usa @Valid (validação padrão, sem grupos especiais)
      - ID deve ser positivo
      - Quantidade pode ser positiva (adicionar) ou negativa (remover)
     */
    @PatchMapping("/{id}/stock")
    @PreAuthorize("hasAuthority('PRODUCT_UPDATE')")
    @Operation(summary = "Atualizar estoque", description = "Adiciona ou remove unidades do estoque")
    public ResponseEntity<Void> updateStock(
            @PathVariable @Positive(message = "ID do produto deve ser um número positivo") 
            Long id,
            @RequestParam int quantity) {
        
        productService.updateStock(id, quantity);
        return ResponseEntity.noContent().build(); // 204 No Content
    }
    
    /*
      PATCH - Ativar/desativar produto
      
      SEGURANÇA: Requer permissão PRODUCT_UPDATE
      - Permite ativar ou desativar um produto (soft delete controlado)
      
      VALIDAÇÃO: ID deve ser positivo
     */
    @PatchMapping("/{id}/toggle-active")
    @PreAuthorize("hasAuthority('PRODUCT_UPDATE')")
    public ResponseEntity<Void> toggleActive(
            @PathVariable @Positive(message = "ID do produto deve ser um número positivo") 
            Long id) {
        
        productService.toggleActive(id);
        return ResponseEntity.noContent().build();
    }
    
    /*
      PATCH - Atualização em lote (exemplo de operação complexa)
      
      SEGURANÇA: Requer permissão PRODUCT_UPDATE
      - Atualiza preços de todos produtos de uma categoria
      - Operação administrativa em lote
      
      VALIDAÇÃO: 
      - Categoria deve ter entre 3 e 100 caracteres
      - Percentual deve estar entre -100 e 1000 (evita valores absurdos)
     */
    @PatchMapping("/bulk/price-update")
    @PreAuthorize("hasAuthority('PRODUCT_UPDATE')")
    public ResponseEntity<Integer> bulkPriceUpdate(
            @RequestParam @Size(min = 3, max = 100, message = "Nome da categoria deve ter entre 3 e 100 caracteres") 
            String category,
            @RequestParam @Min(value = -100, message = "Percentual não pode ser menor que -100% (redução máxima)") 
                         @Max(value = 1000, message = "Percentual não pode ser maior que 1000% (aumento máximo)")
            BigDecimal percentage) {
        
        int updatedCount = productService.bulkPriceUpdate(category, percentage);
        return ResponseEntity.ok(updatedCount);
    }
    
    // ==================== ENDPOINTS DE EXCLUSÃO (DELETE) ====================
    
    /*
      DELETE - Soft delete (desativa)
      
      SEGURANÇA: Requer permissão PRODUCT_DELETE
      - Apenas ADMIN pode deletar produtos
      - Soft delete: apenas desativa, mantém histórico
      
      VALIDAÇÃO: ID deve ser positivo
     */
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('PRODUCT_DELETE')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Desativar produto", description = "Desativa o produto (soft delete)")
    public void delete(
            @PathVariable @Positive(message = "ID do produto deve ser um número positivo") 
            Long id) {
        
        productService.delete(id);
    }
    
    /*
      DELETE - Hard delete (uso restrito)
      
      SEGURANÇA: Requer permissão PRODUCT_DELETE (nível ADMIN)
      - Em produção, normalmente NÃO expor este endpoint
      - Remove permanentemente do banco de dados
      - Use com EXTREMO CUIDADO!
      
      @PreAuthorize("hasRole('ADMIN')") - Restrição adicional por role
      
      VALIDAÇÃO: ID deve ser positivo
     */
    @DeleteMapping("/{id}/hard")
    @PreAuthorize("hasRole('ADMIN') and hasAuthority('PRODUCT_DELETE')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Remover permanentemente", description = "Remove o produto do banco de dados (uso restrito - apenas ADMIN)")
    public void hardDelete(
            @PathVariable @Positive(message = "ID do produto deve ser um número positivo") 
            Long id) {
        
        productService.hardDelete(id);
    }
    
    // ==================== ENDPOINTS EXTRAS COM CONTROLE DE ACESSO ====================
    
    /*
      EXEMPLO: Acesso baseado no próprio usuário
      
      GET - Buscar produtos por usuário (exemplo de controle de acesso)
      
      SEGURANÇA: Apenas o próprio usuário ou ADMIN podem ver
      - Expressão: hasRole('ADMIN') or #userId == authentication.principal.id
      - #userId referencia o parâmetro do método
      - authentication.principal.id acessa o ID do usuário autenticado
      
      NOTA: Este é um exemplo didático. Em um cenário real, você teria um
      relacionamento entre usuários e produtos (ex: produtos criados por usuário)
      
      VALIDAÇÃO: userId deve ser positivo
     */
    @GetMapping("/user/{userId}")
    @PreAuthorize("hasRole('ADMIN') or #userId == authentication.principal.id")
    @Operation(summary = "Produtos por usuário", description = "Retorna produtos associados a um usuário específico")
    public ResponseEntity<List<ProductResponse>> findProductsByUser(
            @PathVariable @Positive(message = "ID do usuário deve ser um número positivo") 
            Long userId) {
        
        // Implementação: productService.findByUserId(userId)
        // Por enquanto, retorna lista vazia como exemplo
        return ResponseEntity.ok(List.of());
    }
}

/*
  RESUMO DAS PERMISSÕES IMPLEMENTADAS:
  
  | Endpoint                    | Método | Permissão Necessária | Roles que têm acesso           |
  |-----------------------------|--------|---------------------|--------------------------------|
  | /products                   | GET    | PRODUCT_READ        | USER, MANAGER, ADMIN           |
  | /products/active            | GET    | PRODUCT_READ        | USER, MANAGER, ADMIN           |
  | /products/{id}              | GET    | PRODUCT_READ        | USER, MANAGER, ADMIN           |
  | /products/sku/{sku}         | GET    | PRODUCT_READ        | USER, MANAGER, ADMIN           |
  | /products/search            | GET    | PRODUCT_READ        | USER, MANAGER, ADMIN           |
  | /products/price-range       | GET    | PRODUCT_READ        | USER, MANAGER, ADMIN           |
  | /products                   | POST   | PRODUCT_CREATE      | MANAGER, ADMIN                 |
  | /products/{id}              | PUT    | PRODUCT_UPDATE      | MANAGER, ADMIN                 |
  | /products/{id}/stock        | PATCH  | PRODUCT_UPDATE      | MANAGER, ADMIN                 |
  | /products/{id}/toggle-active| PATCH  | PRODUCT_UPDATE      | MANAGER, ADMIN                 |
  | /products/bulk/price-update | PATCH  | PRODUCT_UPDATE      | MANAGER, ADMIN                 |
  | /products/{id}              | DELETE | PRODUCT_DELETE      | ADMIN (apenas)                 |
  | /products/{id}/hard         | DELETE | ADMIN + DELETE      | ADMIN (apenas)                 |
  | /products/user/{userId}     | GET    | USER_OWN or ADMIN   | Usuário dono ou ADMIN          |
  
  PRINCÍPIOS DE SEGURANÇA APLICADOS:
  
  1. PRINCÍPIO DO MENOR PRIVILÉGIO:
     - Cada endpoint concede apenas as permissões mínimas necessárias
     - Usuários comuns têm apenas permissão de leitura (PRODUCT_READ)
  
  2. DEFESA EM PROFUNDIDADE:
     - Múltiplas camadas de segurança:
       * Filter chain (autenticação)
       * @PreAuthorize (autorização)
       * Validações de negócio no Service
  
  3. SEPARAÇÃO DE RESPONSABILIDADES:
     - Controller: Responsável apenas por receber requisições e aplicar autorização
     - Service: Contém regras de negócio
     - Repository: Acesso a dados
  
  4. AUDITABILIDADE:
     - Operações críticas (delete, create) são logadas
     - Possibilidade de rastrear quem fez o quê
  
  VALIDAÇÃO POR GRUPOS:
  
  | Grupo | Uso | Campos validados |
  |-------|-----|------------------|
  | OnCreate | POST /products | SKU (obrigatório, único), Nome (obrigatório), Preço (obrigatório, >0) |
  | OnUpdate | PUT /products/{id} | SKU (opcional, único ignorando próprio ID), Nome (opcional), Preço (opcional, >0 se fornecido) |
  
  VALIDAÇÃO DE PARÂMETROS (NOVO):
  
  | Parâmetro | Validação | Endpoint |
  |-----------|-----------|----------|
  | id (path) | @Positive | /{id}, /{id}/stock, /{id}/toggle-active, etc. |
  | sku (path) | @Size(min=3, max=50) | /sku/{sku} |
  | name (query) | @Size(min=2, max=100) | /search |
  | minPrice, maxPrice (query) | @Positive | /price-range |
  | category (query) | @Size(min=3, max=100) | /bulk/price-update |
  | percentage (query) | @Min(-100), @Max(1000) | /bulk/price-update |
  | userId (path) | @Positive | /user/{userId} |
*/
```

---

## 📄 Arquivo: `spring-lab\src\main\java\com\rojudo\spring_lab\controller\TestController.java`

**Caminho completo:** `E:\Projects & Studies\Studies\Spring Boot LAB\spring-lab\src\main\java\com\rojudo\spring_lab\controller\TestController.java`
**Tamanho:** 237 bytes
**Extensão:** `.java`

```java
package com.rojudo.spring_lab.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {

    @GetMapping("/ping")
    public String ping() {
        return "Pong!";
    }

}
```

---

## 📄 Arquivo: `spring-lab\src\main\java\com\rojudo\spring_lab\domain\Category.java`

**Caminho completo:** `E:\Projects & Studies\Studies\Spring Boot LAB\spring-lab\src\main\java\com\rojudo\spring_lab\domain\Category.java`
**Tamanho:** 6,540 bytes
**Extensão:** `.java`

```java
package com.rojudo.spring_lab.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * CATEGORY ENTITY
 * 
 * Representa categorias de produtos com suporte a hierarquia (auto-relacionamento)
 * 
 * ESTRUTURA:
 * - Eletrônicos (parent = null)
 *   └── Computadores (parent = Eletrônicos)
 *       └── Notebooks (parent = Computadores)
 * 
 * ANOTAÇÕES JPA:
 * @Entity → Mapeia para tabela no banco
 * @Table → Configurações da tabela (nome, índices, constraints)
 * @ManyToOne → Relacionamento com categoria pai
 * @OneToMany → Relacionamento com categorias filhas
 */
@Entity
@Table(name = "categories", 
       indexes = {
           @Index(name = "idx_categories_name", columnList = "name"),
           @Index(name = "idx_categories_parent", columnList = "parent_id"),
           @Index(name = "idx_categories_active", columnList = "active")
       })
public class Category {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, unique = true, length = 100)
    private String name;
    
    @Column(length = 500)
    private String description;
    
    /**
     * AUTO-RELACIONAMENTO PARA HIERARQUIA
     * 
     * @ManyToOne → Muitas categorias podem ter o mesmo pai
     * parent_id → Chave estrangeira para a própria tabela
     * 
     * Exemplo: "Notebooks" tem parent = "Computadores"
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Category parent;
    
    /**
     * LISTA DE SUB-CATEGORIAS
     * 
     * mappedBy = "parent" → Campo na classe filha que mapeia o relacionamento
     * cascade = ALL → Operaçoes em cascata (persist, merge, remove, refresh)
     * orphanRemoval = true → Remove filhas se removidas da lista
     */
    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Category> children = new ArrayList<>();
    
    @Column(nullable = false)
    private Boolean active = true;
    
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
    
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    
    // ===== CONSTRUTORES =====
    
    protected Category() {} // JPA requer construtor padrão
    
    public Category(String name) {
        this.name = name;
    }
    
    public Category(String name, String description) {
        this.name = name;
        this.description = description;
    }
    
    public Category(String name, String description, Category parent) {
        this.name = name;
        this.description = description;
        this.parent = parent;
    }

    // ===== MÉTODOS DE NEGÓCIO =====
    
    /**
     * Adiciona uma sub-categoria
     * Mantém consistência bidirecional do relacionamento
     */
    public void addChild(Category child) {
        children.add(child);
        child.setParent(this);
    }
    
    /**
     * Remove uma sub-categoria
     */
    public void removeChild(Category child) {
        children.remove(child);
        child.setParent(null);
    }
    
    /**
     * Verifica se é uma categoria raiz (não tem pai)
     */
    public boolean isRoot() {
        return parent == null;
    }
    
    /**
     * Obtém o nível na hierarquia (0 = raiz)
     */
    public int getLevel() {
        int level = 0;
        Category current = this;
        while (current.getParent() != null) {
            level++;
            current = current.getParent();
        }
        return level;
    }
    
    /**
     * Obtém o caminho completo da categoria
     * Exemplo: "Eletrônicos > Computadores > Notebooks"
     */
    public String getFullPath() {
        if (parent == null) {
            return name;
        }
        return parent.getFullPath() + " > " + name;
    }
    
    public void activate() {
        this.active = true;
    }
    
    public void deactivate() {
        this.active = false;
    }
    
    // ===== LIFECYCLE CALLBACKS =====
    
    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        if (this.active == null) {
            this.active = true;
        }
    }
    
    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
    
    // ===== GETTERS E SETTERS =====
    
    public Long getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public Category getParent() {
        return parent;
    }
    
    public void setParent(Category parent) {
        this.parent = parent;
    }
    
    public List<Category> getChildren() {
        return children;
    }
    
    public void setChildren(List<Category> children) {
        this.children = children;
    }
    
    public Boolean getActive() {
        return active;
    }
    
    public void setActive(Boolean active) {
        this.active = active;
    }
    
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
    
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
    
    // ===== equals/hashCode =====
    // Baseado no ID para entidades JPA
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Category category)) return false;
        return id != null && Objects.equals(id, category.id);
    }
    
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
    
    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", active=" + active +
                '}';
    }
}
```

---

## 📄 Arquivo: `spring-lab\src\main\java\com\rojudo\spring_lab\domain\Permission.java`

**Caminho completo:** `E:\Projects & Studies\Studies\Spring Boot LAB\spring-lab\src\main\java\com\rojudo\spring_lab\domain\Permission.java`
**Tamanho:** 2,022 bytes
**Extensão:** `.java`

```java
package com.rojudo.spring_lab.domain;

import jakarta.persistence.*;
import java.util.Objects;
import java.util.HashSet;
import java.util.Set;

/**
 * PERMISSION ENTITY - Permissões granulares
 * 
 * Exemplos: 
 * - PRODUCT_CREATE
 * - PRODUCT_READ
 * - PRODUCT_UPDATE
 * - PRODUCT_DELETE
 * - USER_MANAGE
 */
@Entity
@Table(name = "permissions")
public class Permission {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, unique = true, length = 100)
    private String name;  // Ex: PRODUCT_CREATE
    
    @Column(length = 200)
    private String description;
    
    @ManyToMany(mappedBy = "permissions")
    private Set<Role> roles = new HashSet<>();

    // ===== CONSTRUTORES =====

    protected Permission() {} // JPA constructor
    
    public Permission(String name) {
        this.name = name;
    }
    
    public Permission(String name, String description) {
        this.name = name;
        this.description = description;
    }

    // Getters/Setters
    public Long getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Set<Role> getRoles() { return roles; }
    public void setRoles(Set<Role> roles) { this.roles = roles; }
    public void addRole(Role role) { this.roles.add(role); role.getPermissions().add(this); }
    public void removeRole(Role role) { this.roles.remove(role); role.getPermissions().remove(this);}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Permission that)) return false;
        return id != null && Objects.equals(id, that.id);
    }
    
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
```

---

## 📄 Arquivo: `spring-lab\src\main\java\com\rojudo\spring_lab\domain\Product.java`

**Caminho completo:** `E:\Projects & Studies\Studies\Spring Boot LAB\spring-lab\src\main\java\com\rojudo\spring_lab\domain\Product.java`
**Tamanho:** 11,486 bytes
**Extensão:** `.java`

```java
package com.rojudo.spring_lab.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.persistence.Index;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Version;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.SQLRestriction;
import org.hibernate.annotations.Where;
import org.hibernate.annotations.Type;
import org.hibernate.type.SqlTypes;

import io.hypersistence.utils.hibernate.type.array.StringArrayType;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Objects;

import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

/*
  ENTITY: Representa a tabela no banco de dados
  
  POR QUE USAR ENTITY?
  - Mapeamento objeto-relacional (ORM)
  - Ciclo de vida gerenciado pelo EntityManager
  - Identidade rastreável (ID)
  - Pode ter comportamento de negócio
  
  PRINCÍPIOS:
  - POJO (Plain Old Java Object)
  - Anotações JPA para mapeamento
  - Encapsulamento com getters/setters
  - equals/hashCode baseado em ID
*/
@Entity
@Table(
    name = "products",
    uniqueConstraints = {
        @UniqueConstraint(name = "uk_products_sku", columnNames = "sku")
    },
    indexes = {
        @Index(name = "idx_products_name", columnList = "name"),
        @Index(name = "idx_products_price", columnList = "price"),
        @Index(name = "idx_products_active", columnList = "active")
    }
)

/*
  HIBERNATE AVANÇADO:
  
  @DynamicUpdate  -> Atualiza apenas campos alterados (melhora performance)
  @DynamicInsert  -> Insere apenas campos não nulos
*/
@DynamicUpdate
@DynamicInsert

/*
  CACHE:
  - Segundo nível (Hibernate)
  - READ_WRITE garante consistência
*/
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "products")

/*
  SOFT DELETE:
  - Filtra automaticamente registros ativos
*/
@SQLRestriction("active = true")
@Where(clause = "active = true")

/*
  AUDITORIA AUTOMÁTICA (Spring Data)
*/
@EntityListeners(AuditingEntityListener.class)
public class Product {

    /*
      ID - Identificador único da entidade
      
      ESTRATÉGIAS:
      - IDENTITY (usado aqui): auto-increment (PostgreSQL)
      - SEQUENCE: melhor para batch
      - UUID: distribuído
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*
      Campos obrigatórios
      
      - unique = true → constraint no banco
      - nullable = false → NOT NULL
     */
    @Column(nullable = false, unique = true, length = 50)
    private String sku;

    @Column(nullable = false, length = 200)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    /*
      BigDecimal para valores monetários!
      
      POR QUE NÃO double/float?
      - Problemas de precisão
      - BigDecimal é imutável
      - Padrão financeiro
     */
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    /**
      Relacionamento Many-to-One com Category
      @ManyToOne → Muitos produtos podem pertencer a uma categoria
      @JoinColumn → Define a chave estrangeira (category_id)
      fetch = FetchType.LAZY → Carregamento preguiçoso (performance)
    */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(name = "stock_quantity")
    private Integer stockQuantity = 0;

    /*
      SOFT DELETE FLAG
     */
    @Column(nullable = false)
    private Boolean active = true;

    // ============================================
    // POSTGRESQL FEATURES (AVANÇADO)
    // ============================================

    /*
      JSONB (PostgreSQL)
      - Estrutura flexível
      - Alta performance para leitura
     */
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "metadata", columnDefinition = "jsonb")
    private Map<String, Object> metadata;

    /*
      ARRAY PostgreSQL
     */
    @Type(StringArrayType.class)
    @JdbcTypeCode(SqlTypes.ARRAY)
    @Column(name = "tags", columnDefinition = "text[]")
    private String[] tags;

    /*
      FULL-TEXT SEARCH (PostgreSQL)
     
    @Column(name = "search_vector", columnDefinition = "tsvector")
    private String searchVector;*/

    // ============================================
    // AUDITORIA
    // ============================================

    /*
      Auditoria automática com Spring
      
      @CreatedDate / @LastModifiedDate
      - Gerenciados automaticamente
      
      @CreatedBy / @LastModifiedBy
      - Requer configuração de AuditorAware
     */
    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @CreatedBy
    @Column(name = "created_by", updatable = false)
    private String createdBy;

    @LastModifiedBy
    private String updatedBy;

    /*
      CONTROLE DE CONCORRÊNCIA
      
      @Version:
      - Evita sobrescrita concorrente
      - Optimistic locking
     */
    @Version
    private Long version;

    // ============================================
    // CONSTRUTORES
    // ============================================

    /*
      Construtor padrão (obrigatório para JPA)
     */
    protected Product() {}

    /*
      Construtor mínimo válido
     */
    public Product(String sku, String name, BigDecimal price) {
        this.sku = sku;
        this.name = name;
        this.price = price;
    }

    // ============================================
    // MÉTODOS DE NEGÓCIO (DOMAIN LOGIC)
    // ============================================
    /*
      Regra de estoque
     */
    public void updateStock(int quantity) {
        if (this.stockQuantity + quantity < 0) {
            throw new IllegalStateException(
                "Estoque insuficiente. Disponível: " + this.stockQuantity
            );
        }
        this.stockQuantity += quantity;
    }

    public boolean isAvailable() {
        return this.active && this.stockQuantity > 0;
    }

    public void deactivate() {
        this.active = false;
    }

    public void activate() {
        this.active = true;
    }

    public void updatePrice(BigDecimal newPrice) {
        if (newPrice == null || newPrice.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Preço deve ser maior que zero");
        }
        this.price = newPrice;
    }

    // ============================================
    // LIFECYCLE CALLBACKS (JPA HOOKS)
    // ============================================

    /*
      @PrePersist → antes de inserir
      @PreUpdate → antes de atualizar
     */
    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();

        if (this.stockQuantity == null) this.stockQuantity = 0;
        if (this.active == null) this.active = true;

        updateSearchVector();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
        updateSearchVector();
    }

    /*
      FULL-TEXT SEARCH PREPARATION
     */
    private void updateSearchVector() {
        /*this.searchVector = String.format(
            "%s %s %s",
            this.name,
            this.description != null ? this.description : "",
            this.category != null ? this.category : ""
        );*/
    }

    // ============================================
    // GETTERS / SETTERS
    // ============================================

    public Long getId() { return id; }

    public String getSku() { return sku; }
    public void setSku(String sku) { this.sku = sku; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }

    public Category getCategory() { return category; }
    public void setCategory(Category category) { this.category = category; }

    public Integer getStockQuantity() { return stockQuantity; }
    public void setStockQuantity(Integer stockQuantity) { this.stockQuantity = stockQuantity; }

    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }

    public Map<String, Object> getMetadata() { return metadata; }
    public void setMetadata(Map<String, Object> metadata) { this.metadata = metadata; }

    public String[] getTags() { return tags; }
    public void setTags(String[] tags) { this.tags = tags; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

    public String getCreatedBy() { return createdBy; }
    public void setCreatedBy(String createdBy) { this.createdBy = createdBy; }
    public String getUpdatedBy() { return updatedBy; }
    public void setUpdatedBy(String updatedBy) { this.updatedBy = updatedBy; }

    public Long getVersion() { return version; }

    // ============================================
    // EQUALS / HASHCODE
    // ============================================

    /*
      Baseado em ID (JPA best practice)
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product product)) return false;
        return id != null && Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    // ============================================
    // DEBUG
    // ============================================

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", sku='" + sku + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", active=" + active +
                '}';
    }
}
```

---

## 📄 Arquivo: `spring-lab\src\main\java\com\rojudo\spring_lab\domain\Role.java`

**Caminho completo:** `E:\Projects & Studies\Studies\Spring Boot LAB\spring-lab\src\main\java\com\rojudo\spring_lab\domain\Role.java`
**Tamanho:** 3,523 bytes
**Extensão:** `.java`

```java
package com.rojudo.spring_lab.domain;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * ROLE ENTITY - Papéis do usuário
 * 
 * Exemplos: ROLE_ADMIN, ROLE_USER, ROLE_MANAGER
 
 Relacionamentos:
 - Role ←→ Permission (ManyToMany)
 - User ←→ Role (ManyToMany) - Bidirecional
 */
@Entity
@Table(name = "roles")
public class Role {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, unique = true, length = 50)
    private String name;  // Ex: ROLE_ADMIN
    
    @Column(length = 100)
    private String description;
    
    /*
      RELACIONAMENTO COM PERMISSIONS (ManyToMany)
      Dono do relacionamento (contém a @JoinTable)
    */
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "role_permissions",
        joinColumns = @JoinColumn(name = "role_id"),
        inverseJoinColumns = @JoinColumn(name = "permission_id")
    )
    private Set<Permission> permissions = new HashSet<>();
    
    /*
      User é o dono do relacionamento (contém a @JoinTable)
      mappedBy = "roles" → Refere-se ao campo 'roles' na classe User
     */
    @ManyToMany(mappedBy = "roles")
    private Set<User> users = new HashSet<>();

    // Construtores
    protected Role() {}
    
    public Role(String name) {
        this.name = name;
    }
    
    public Role(String name, String description) {
        this.name = name;
        this.description = description;
    }

    // ===== MÉTODOS UTILITÁRIOS PARA CONSISTÊNCIA =====
     
    // Adiciona um usuário a este papel
    public void addUser(User user) {
        this.users.add(user);
        user.getRoles().add(this);
    }
    
    // Remove um usuário deste papel
    public void removeUser(User user) {
        this.users.remove(user);
        user.getRoles().remove(this);
    }
    
    // Adiciona uma permissão a este papel
    public void addPermission(Permission permission) {
        this.permissions.add(permission);
        permission.getRoles().add(this);
    }
    
    // Remove uma permissão deste papel
    public void removePermission(Permission permission) {
        this.permissions.remove(permission);
        permission.getRoles().remove(this);
    }

    // Getters/Setters
    public Long getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Set<Permission> getPermissions() { return permissions; }
    public void setPermissions(Set<Permission> permissions) { this.permissions = permissions; }
    public Set<User> getUsers() { return users; }
    public void setUsers(Set<User> users) { this.users = users; }
    
    // ===== equals/hashCode =====
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Role role)) return false;
        return id != null && Objects.equals(id, role.id);
    }
    
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
    
    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
```

---

## 📄 Arquivo: `spring-lab\src\main\java\com\rojudo\spring_lab\domain\User.java`

**Caminho completo:** `E:\Projects & Studies\Studies\Spring Boot LAB\spring-lab\src\main\java\com\rojudo\spring_lab\domain\User.java`
**Tamanho:** 7,790 bytes
**Extensão:** `.java`

```java
package com.rojudo.spring_lab.domain;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * USER ENTITY - Implementa UserDetails do Spring Security
 * 
 * PRINCÍPIOS:
 * - UserDetails: Interface do Spring Security para autenticação
 * - Separação: Entidade de domínio NÃO deve ter anotações de segurança
 *   Mas implementamos UserDetails para facilitar integração
 */
@Entity
@Table(
    name = "users",
    uniqueConstraints = {
        @UniqueConstraint(name = "uk_users_email", columnNames = "email")
    },
    indexes = {
        @Index(name = "idx_users_email", columnList = "email"),
        @Index(name = "idx_users_active", columnList = "active")
    }
)
public class User implements UserDetails {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, unique = true, length = 100)
    private String email;
    
    @Column(nullable = false, length = 100)
    private String password;  // Será armazenada com BCrypt
    
    @Column(nullable = false, length = 100)
    private String fullName;
    
    @Column(length = 20)
    private String phone;
    
    @Column(nullable = false)
    private Boolean active = true;
    
    @Column(nullable = false)
    private Boolean emailVerified = false;
    
    // Mapeamento de roles (muitos-para-muitos)
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "user_roles",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();
    
    // Campos de auditoria
    @Column(name = "last_login")
    private LocalDateTime lastLogin;
    
    @Column(name = "failed_attempts")
    private Integer failedAttempts = 0;
    
    @Column(name = "account_locked")
    private Boolean accountLocked = false;
    
    @Column(name = "lock_expiry")
    private LocalDateTime lockExpiry;
    
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
    
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    
    // ===== CONSTRUTORES =====
    
    protected User() {}
    
    // Construtor público para criação
    public User(String email, String password, String fullName) {
        this.email = email;
        this.password = password;
        this.fullName = fullName;
        this.active = true;
        this.emailVerified = false;
        this.failedAttempts = 0;
        this.accountLocked = false;
    }
    
    // Construtor sem parâmetros para uso interno
    public static User createNew() {
        return new User();
    }

    // ===== MÉTODOS DE NEGÓCIO =====
    
    public void incrementFailedAttempts() {
        this.failedAttempts++;
        if (this.failedAttempts >= 5) {
            this.accountLocked = true;
            this.lockExpiry = LocalDateTime.now().plusMinutes(30);
        }
    }
    
    public void resetFailedAttempts() {
        this.failedAttempts = 0;
        this.accountLocked = false;
        this.lockExpiry = null;
    }
    
    public void recordSuccessfulLogin() {
        this.lastLogin = LocalDateTime.now();
        this.resetFailedAttempts();
    }
    
    public boolean isAccountLocked() {
        if (accountLocked && lockExpiry != null && LocalDateTime.now().isAfter(lockExpiry)) {
            // Desbloqueia automaticamente após expiração
            this.accountLocked = false;
            this.lockExpiry = null;
            return false;
        }
        return accountLocked;
    }
    
    public void verifyEmail() {
        this.emailVerified = true;
    }
    
    // ===== USERDETAILS IMPLEMENTATION =====
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Converte roles para GrantedAuthority
        return roles.stream()
            .flatMap(role -> role.getPermissions().stream())
            .map(permission -> new SimpleGrantedAuthority(permission.getName()))
            .collect(Collectors.toSet());
    }
    
    @Override
    public String getPassword() {
        return this.password;
    }
    
    @Override
    public String getUsername() {
        return this.email;  // Usamos email como username
    }
    
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    
    @Override
    public boolean isAccountNonLocked() {
        return !isAccountLocked();
    }
    
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    
    @Override
    public boolean isEnabled() {
        return this.active && this.emailVerified;
    }
    
    // ===== LIFECYCLE CALLBACKS =====
    
    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        if (this.failedAttempts == null) this.failedAttempts = 0;
        if (this.active == null) this.active = true;
        if (this.emailVerified == null) this.emailVerified = false;
    }
    
    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
    
    // ===== GETTERS/SETTERS =====
    
    public Long getId() { return id; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public void setPassword(String password) { this.password = password; }
    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }
    public Boolean getEmailVerified() { return emailVerified; }
    public void setEmailVerified(Boolean emailVerified) { this.emailVerified = emailVerified; }
    public Set<Role> getRoles() { return roles; }
    public void setRoles(Set<Role> roles) { this.roles = roles; }
    public LocalDateTime getLastLogin() { return lastLogin; }
    public void setLastLogin(LocalDateTime lastLogin) { this.lastLogin = lastLogin; }
    public Integer getFailedAttempts() { return failedAttempts; }
    public void setFailedAttempts(int failedAttempts) { this.failedAttempts = failedAttempts; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setAccountLocked(boolean accountLocked) { this.accountLocked = accountLocked; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return id != null && Objects.equals(id, user.id);
    }
    
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
    
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", fullName='" + fullName + '\'' +
                ", active=" + active +
                '}';
    }
}
```

---

## 📄 Arquivo: `spring-lab\src\main\java\com\rojudo\spring_lab\dto\request\AuthLoginRequest.java`

**Caminho completo:** `E:\Projects & Studies\Studies\Spring Boot LAB\spring-lab\src\main\java\com\rojudo\spring_lab\dto\request\AuthLoginRequest.java`
**Tamanho:** 367 bytes
**Extensão:** `.java`

```java
package com.rojudo.spring_lab.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record AuthLoginRequest(
    @NotBlank(message = "Email é obrigatório")
    @Email(message = "Email inválido")
    String email,
    
    @NotBlank(message = "Senha é obrigatória")
    String password
) {}
```

---

## 📄 Arquivo: `spring-lab\src\main\java\com\rojudo\spring_lab\dto\request\AuthRegisterRequest.java`

**Caminho completo:** `E:\Projects & Studies\Studies\Spring Boot LAB\spring-lab\src\main\java\com\rojudo\spring_lab\dto\request\AuthRegisterRequest.java`
**Tamanho:** 1,324 bytes
**Extensão:** `.java`

```java
package com.rojudo.spring_lab.dto.request;

import jakarta.validation.constraints.*;
import com.rojudo.spring_lab.validation.ValidationGroups;

public record AuthRegisterRequest(
    
    @NotBlank(message = "{auth.fullname.notblank}")
    @Size(min = 3, max = 100, message = "{auth.fullname.size}")
    String fullName,
    
    @NotBlank(message = "{auth.email.notblank}")
    @Email(message = "{auth.email.invalid}")
    String email,
    
    // Validação de senha: mínimo 8 caracteres, pelo menos uma letra maiúscula, uma letra minúscula, um número e um caractere especial
    @NotBlank(message = "{auth.password.notblank}")
    @Size(min = 8, message = "{auth.password.size}")
    @Pattern(
        regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
        message = "{auth.password.pattern}"
    )
    String password,
    
    @Size(max = 20, message = "{auth.phone.size}")
    String phone
    
) {
    // Validação: Se telefone for fornecido, deve ter formato válido
    @AssertTrue(message = "Telefone deve conter apenas números e ter entre 10 e 11 dígitos")
    public boolean isPhoneValid() {
        if (phone == null || phone.isBlank()) {
            return true;
        }
        return phone.matches("^[0-9]{10,11}$");
    }
}
```

---

## 📄 Arquivo: `spring-lab\src\main\java\com\rojudo\spring_lab\dto\request\ProductRequest.java`

**Caminho completo:** `E:\Projects & Studies\Studies\Spring Boot LAB\spring-lab\src\main\java\com\rojudo\spring_lab\dto\request\ProductRequest.java`
**Tamanho:** 3,353 bytes
**Extensão:** `.java`

```java
package com.rojudo.spring_lab.dto.request;

import com.rojudo.spring_lab.validation.UniqueSku;
import com.rojudo.spring_lab.validation.ValidationGroups;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;

public record ProductRequest(
    
    // CREATE: SKU obrigatório e único
    // UPDATE: SKU opcional, mas se fornecido deve ser único (ignorando o próprio ID)
    @NotBlank(groups = ValidationGroups.OnCreate.class, message = "{product.sku.notblank}")
    @Size(groups = {ValidationGroups.OnCreate.class, ValidationGroups.OnUpdate.class}, 
          min = 3, max = 50, message = "{product.sku.size}")
    @Pattern(groups = {ValidationGroups.OnCreate.class, ValidationGroups.OnUpdate.class},
             regexp = "^[A-Z0-9-]+$", message = "{product.sku.pattern}")
    @UniqueSku(groups = {ValidationGroups.OnCreate.class, ValidationGroups.OnUpdate.class},
               message = "{product.sku.unique}")
    String sku,
    
    // CREATE: nome obrigatório
    // UPDATE: nome opcional
    @NotBlank(groups = ValidationGroups.OnCreate.class, message = "{product.name.notblank}")
    @Size(groups = {ValidationGroups.OnCreate.class, ValidationGroups.OnUpdate.class},
          min = 3, max = 200, message = "{product.name.size}")
    String name,
    
    @Size(max = 1000, message = "{product.description.size}")
    String description,
    
    // CREATE: preço obrigatório
    // UPDATE: preço opcional (se não fornecido, mantém o atual)
    @NotNull(groups = ValidationGroups.OnCreate.class, message = "{product.price.notnull}")
    @DecimalMin(groups = {ValidationGroups.OnCreate.class, ValidationGroups.OnUpdate.class},
                value = "0.01", message = "{product.price.min}")
    @DecimalMax(groups = {ValidationGroups.OnCreate.class, ValidationGroups.OnUpdate.class},
                value = "999999.99", message = "{product.price.max}")
    BigDecimal price,
    
    @Size(max = 100, message = "{product.category.size}")
    String category,
    
    @Min(groups = {ValidationGroups.OnCreate.class, ValidationGroups.OnUpdate.class},
         value = 0, message = "{product.stock.min}")
    @Max(groups = {ValidationGroups.OnCreate.class, ValidationGroups.OnUpdate.class},
         value = 999999, message = "{product.stock.max}")
    Integer stockQuantity
    
) {
    // Validação condicional: Se preço for fornecido no UPDATE, deve ser > 0
    @AssertTrue(groups = ValidationGroups.OnUpdate.class, 
                message = "Preço deve ser maior que zero quando fornecido")
    public boolean isPriceValidIfPresent() {
        return price == null || price.compareTo(BigDecimal.ZERO) > 0;
    }
    
    // Validação condicional: Se nome for fornecido no UPDATE, não pode ser vazio
    @AssertTrue(groups = ValidationGroups.OnUpdate.class,
                message = "Nome não pode ser vazio quando fornecido")
    public boolean isNameValidIfPresent() {
        return name == null || !name.isBlank();
    }
    
    // Validação condicional: Se SKU for fornecido no UPDATE, não pode ser vazio
    @AssertTrue(groups = ValidationGroups.OnUpdate.class,
                message = "SKU não pode ser vazio quando fornecido")
    public boolean isSkuValidIfPresent() {
        return sku == null || !sku.isBlank();
    }
}
```

---

## 📄 Arquivo: `spring-lab\src\main\java\com\rojudo\spring_lab\dto\response\AuthLoginResponse.java`

**Caminho completo:** `E:\Projects & Studies\Studies\Spring Boot LAB\spring-lab\src\main\java\com\rojudo\spring_lab\dto\response\AuthLoginResponse.java`
**Tamanho:** 1,347 bytes
**Extensão:** `.java`

```java
package com.rojudo.spring_lab.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record AuthLoginResponse( //Token JWT para autenticação nas requisições subsequentes
    String accessToken, // Deve ser enviado no header: Authorization: Bearer {token}
    String tokenType, // Tipo do token (padrão OAuth2). Sempre "Bearer"
    Long expiresIn, // Tempo de expiração do token em segundos. Padrão: 3600 segundos (1 hora)
    UserInfoResponse user
) {
    public AuthLoginResponse(String accessToken, UserInfoResponse user) {
        this(accessToken, "Bearer", 3600L, user);
    }

    // Verifica se o token está presente e não é vazio, para validações antes de usar o token
    public boolean hasToken() {
        return accessToken != null && !accessToken.isBlank();
    }

    //Retorna o token pronto para uso no header Authorization. Exemplo: "Bearer eyJhbGciOiJIUzI1NiIs..."
    public String getAuthorizationHeader() { 

        return tokenType + " " + accessToken;
    }

    @Override
    public String toString() { //Representação simplificada para logs (não expõe o token completo)
        return String.format("AuthLoginResponse{tokenType='%s', expiresIn=%d, user=%s}",
            tokenType, expiresIn, user);
    }
}
```

---

## 📄 Arquivo: `spring-lab\src\main\java\com\rojudo\spring_lab\dto\response\ProductResponse.java`

**Caminho completo:** `E:\Projects & Studies\Studies\Spring Boot LAB\spring-lab\src\main\java\com\rojudo\spring_lab\dto\response\ProductResponse.java`
**Tamanho:** 2,644 bytes
**Extensão:** `.java`

```java
package com.rojudo.spring_lab.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ProductResponse(
    Long id,
    String sku,
    String name,
    String description,
    BigDecimal price,
    String category,
    Integer stockQuantity,
    Boolean active,
    LocalDateTime createdAt,
    LocalDateTime updatedAt,
    
    // Campos calculados/dinâmicos
    Boolean available,
    String priceFormatted
    
) {
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder { // Builder pattern manual: Construtor menos confuso, nome de campos explícitos, imutabilidade mantida
        private Long id;
        private String sku;
        private String name;
        private String description;
        private BigDecimal price;
        private String category;
        private Integer stockQuantity;
        private Boolean active;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
        private Boolean available;
        private String priceFormatted;
        
        public Builder id(Long id) { this.id = id; return this; }
        public Builder sku(String sku) { this.sku = sku; return this; }
        public Builder name(String name) { this.name = name; return this; }
        public Builder description(String description) { this.description = description; return this; }
        public Builder price(BigDecimal price) { this.price = price; return this; }
        public Builder category(String category) { this.category = category; return this; }
        public Builder stockQuantity(Integer stockQuantity) { this.stockQuantity = stockQuantity; return this; }
        public Builder active(Boolean active) { this.active = active; return this; }
        public Builder createdAt(LocalDateTime createdAt) { this.createdAt = createdAt; return this; }
        public Builder updatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; return this; }
        public Builder available(Boolean available) { this.available = available; return this; }
        public Builder priceFormatted(String priceFormatted) { this.priceFormatted = priceFormatted; return this; }
        
        public ProductResponse build() {
            return new ProductResponse(
                id, sku, name, description, price, category,
                stockQuantity, active, createdAt, updatedAt,
                available, priceFormatted
            );
        }
    }
}
```

---

## 📄 Arquivo: `spring-lab\src\main\java\com\rojudo\spring_lab\dto\response\UserInfoResponse.java`

**Caminho completo:** `E:\Projects & Studies\Studies\Spring Boot LAB\spring-lab\src\main\java\com\rojudo\spring_lab\dto\response\UserInfoResponse.java`
**Tamanho:** 1,615 bytes
**Extensão:** `.java`

```java
package com.rojudo.spring_lab.dto.response;

import java.util.List;

public record UserInfoResponse(
    Long id, // ID único do usuário
    String email, // Email do usuário (usado como username)
    String fullName, // Nome completo do usuário
    List<String> roles, // Lista de roles do usuário (ex: ROLE_ADMIN, ROLE_USER)
    List<String> permissions // Lista de permissões granulares (ex: PRODUCT_READ, PRODUCT_CREATE)
) {
    
    // Construtor customizado para validação
    public UserInfoResponse { 
        if (id == null) {
            throw new IllegalArgumentException("User ID cannot be null");
        }
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Email cannot be null or blank");
        }
        if (fullName == null || fullName.isBlank()) {
            throw new IllegalArgumentException("Full name cannot be null or blank");
        }
    }
    
    // Método utilitário para verificar se usuário tem um role específico
    public boolean hasRole(String role) {
        return roles != null && roles.contains(role);
    }
    
    // Método utilitário para verificar se usuário tem uma permissão específica
    public boolean hasPermission(String permission) {
        return permissions != null && permissions.contains(permission);
    }
    
    // Retorna representação simplificada para logs
    @Override
    public String toString() {
        return String.format("UserInfoResponse{id=%d, email='%s', fullName='%s', roles=%s}",
            id, email, fullName, roles);
    }
}
```

---

## 📄 Arquivo: `spring-lab\src\main\java\com\rojudo\spring_lab\dto\response\UserResponse.java`

**Caminho completo:** `E:\Projects & Studies\Studies\Spring Boot LAB\spring-lab\src\main\java\com\rojudo\spring_lab\dto\response\UserResponse.java`
**Tamanho:** 134 bytes
**Extensão:** `.java`

```java
package com.rojudo.spring_lab.dto.response;

public record UserResponse(
    Long id,
    String name,
    String email
) {

}
```

---

## 📄 Arquivo: `spring-lab\src\main\java\com\rojudo\spring_lab\exception\BusinessException.java`

**Caminho completo:** `E:\Projects & Studies\Studies\Spring Boot LAB\spring-lab\src\main\java\com\rojudo\spring_lab\exception\BusinessException.java`
**Tamanho:** 941 bytes
**Extensão:** `.java`

```java
package com.rojudo.spring_lab.exception;

/* EXCEÇÃO DE NEGÓCIO
 * 
 * Utilizada para erros de regras de negócio que NÃO são erros de validação de campos
 * Exemplos:
 * - Estoque insuficiente
 * - Produto já desativado
 * - Operação não permitida no estado atual
 * 
 * HTTP Status: 422 Unprocessable Entity
 */
public class BusinessException extends RuntimeException {
    
    private final String errorCode;
    
    public BusinessException(String message) {
        super(message);
        this.errorCode = "BUSINESS_ERROR";
    }
    
    public BusinessException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
    
    public BusinessException(String message, Throwable cause) {
        super(message, cause);
        this.errorCode = "BUSINESS_ERROR";
    }
    
    public String getErrorCode() {
        return errorCode;
    }
}
```

---

## 📄 Arquivo: `spring-lab\src\main\java\com\rojudo\spring_lab\exception\ErrorResponse.java`

**Caminho completo:** `E:\Projects & Studies\Studies\Spring Boot LAB\spring-lab\src\main\java\com\rojudo\spring_lab\exception\ErrorResponse.java`
**Tamanho:** 2,083 bytes
**Extensão:** `.java`

```java
package com.rojudo.spring_lab.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

/* ESTRUTURA PADRÃO DE ERRO
 * 
 * POR QUE?
 * - Consistência nas respostas de erro
 * - Facilita consumo pelo cliente
 * - Inclui informações para debugging
 * 
 * CAMPOS:
 * - traceId: Identificador único para rastreamento
 * - timestamp: Data/hora do erro (ISO format)
 * - status: HTTP Status Code
 * - error: Título amigável do erro
 * - message: Mensagem detalhada
 * - path: Endpoint que gerou o erro
 * - validationErrors: Erros de validação de campos (apenas para 400)
 * - details: Detalhes adicionais
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ErrorResponse(
    String traceId,
    String timestamp,
    int status,
    String error,
    String message,
    String path,
    Map<String, String> validationErrors,
    List<String> details
) {
    
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    
    // Construtor para erros simples (sem validação)
    public ErrorResponse(String traceId, int status, String error, String message, String path) {
        this(traceId, LocalDateTime.now().format(FORMATTER), status, error, message, path, null, null);
    }
    
    // Construtor para erros de validação
    public ErrorResponse(String traceId, int status, String error, String message, 
                         String path, Map<String, String> validationErrors) {
        this(traceId, LocalDateTime.now().format(FORMATTER), status, error, message, path, validationErrors, null);
    }
    
    // Construtor para erros com detalhes adicionais
    public ErrorResponse(String traceId, int status, String error, String message, 
                         String path, List<String> details) {
        this(traceId, LocalDateTime.now().format(FORMATTER), status, error, message, path, null, details);
    }
}
```

---

## 📄 Arquivo: `spring-lab\src\main\java\com\rojudo\spring_lab\exception\GlobalExceptionHandler.java`

**Caminho completo:** `E:\Projects & Studies\Studies\Spring Boot LAB\spring-lab\src\main\java\com\rojudo\spring_lab\exception\GlobalExceptionHandler.java`
**Tamanho:** 14,156 bytes
**Extensão:** `.java`

```java
package com.rojudo.spring_lab.exception;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * GLOBAL EXCEPTION HANDLER
 * 
 * POR QUE?
 * - Tratamento centralizado de exceções
 * - Respostas consistentes
 * - Separa tratamento de erro da lógica de negócio
 * 
 * @RestControllerAdvice = @ControllerAdvice + @ResponseBody
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    
    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    
    // ==================== 400 - BAD REQUEST ====================
    
    /**
     * Erros de validação de DTOs (@Valid)
     * HTTP 400 - Bad Request
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationExceptions(
            MethodArgumentNotValidException ex,
            HttpServletRequest request) {
        
        String traceId = TraceIdGenerator.generate();
        
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        
        log.warn("[{}] Validation error on {} - Fields: {}", 
            traceId, request.getRequestURI(), errors.keySet());
        
        ErrorResponse response = new ErrorResponse(
            traceId,
            HttpStatus.BAD_REQUEST.value(),
            "Validation Error",
            "Os dados fornecidos são inválidos",
            request.getRequestURI(),
            errors
        );
        
        return ResponseEntity.badRequest().body(response);
    }
    
    /**
     * Erros de validação de parâmetros (@RequestParam, @PathVariable)
     * HTTP 400 - Bad Request
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResponse> handleConstraintViolation(
            ConstraintViolationException ex,
            HttpServletRequest request) {
        
        String traceId = TraceIdGenerator.generate();
        
        Map<String, String> errors = ex.getConstraintViolations().stream()
            .collect(Collectors.toMap(
                violation -> violation.getPropertyPath().toString(),
                ConstraintViolation::getMessage,
                (v1, v2) -> v1
            ));
        
        log.warn("[{}] Constraint violation on {} - Errors: {}", 
            traceId, request.getRequestURI(), errors);
        
        ErrorResponse response = new ErrorResponse(
            traceId,
            HttpStatus.BAD_REQUEST.value(),
            "Validation Error",
            "Parâmetros inválidos",
            request.getRequestURI(),
            errors
        );
        
        return ResponseEntity.badRequest().body(response);
    }
    
    /**
     * Erros de tipo incompatível (ex: String ao invés de Long)
     * HTTP 400 - Bad Request
     */
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErrorResponse> handleTypeMismatch(
            MethodArgumentTypeMismatchException ex,
            HttpServletRequest request) {
        
        String traceId = TraceIdGenerator.generate();
        
        String message = String.format(
            "Parâmetro '%s' deve ser do tipo %s",
            ex.getName(),
            ex.getRequiredType() != null ? ex.getRequiredType().getSimpleName() : "desconhecido"
        );
        
        log.warn("[{}] Type mismatch on {} - {}", traceId, request.getRequestURI(), message);
        
        ErrorResponse response = new ErrorResponse(
            traceId,
            HttpStatus.BAD_REQUEST.value(),
            "Type Mismatch",
            message,
            request.getRequestURI()
        );
        
        return ResponseEntity.badRequest().body(response);
    }
    
    /**
     * JSON malformado
     * HTTP 400 - Bad Request
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponse> handleMalformedJson(
            HttpMessageNotReadableException ex,
            HttpServletRequest request) {
        
        String traceId = TraceIdGenerator.generate();
        
        log.warn("[{}] Malformed JSON on {}", traceId, request.getRequestURI());
        
        ErrorResponse response = new ErrorResponse(
            traceId,
            HttpStatus.BAD_REQUEST.value(),
            "Malformed JSON",
            "O corpo da requisição contém JSON malformado. Verifique a sintaxe.",
            request.getRequestURI()
        );
        
        return ResponseEntity.badRequest().body(response);
    }
    
    /**
     * Erros de validação customizada (ex: @AssertTrue)
     * HTTP 400 - Bad Request
     */
    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ErrorResponse> handleValidation(
            ValidationException ex,
            HttpServletRequest request) {
        
        String traceId = TraceIdGenerator.generate();
        
        log.warn("[{}] Validation error on {} - {}", traceId, request.getRequestURI(), ex.getMessage());
        
        ErrorResponse response = new ErrorResponse(
            traceId,
            HttpStatus.BAD_REQUEST.value(),
            "Validation Error",
            ex.getMessage(),
            request.getRequestURI()
        );
        
        return ResponseEntity.badRequest().body(response);
    }
    
    // ==================== 401 - UNAUTHORIZED ====================
    
    /**
     * Credenciais inválidas (login)
     * HTTP 401 - Unauthorized
     */
    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ErrorResponse> handleBadCredentials(
            BadCredentialsException ex,
            HttpServletRequest request) {
        
        String traceId = TraceIdGenerator.generate();
        
        log.warn("[{}] Bad credentials attempt on {}", traceId, request.getRequestURI());
        
        ErrorResponse response = new ErrorResponse(
            traceId,
            HttpStatus.UNAUTHORIZED.value(),
            "Authentication Failed",
            "Email ou senha inválidos",
            request.getRequestURI()
        );
        
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
    }
    
    /**
     * Usuário desativado
     * HTTP 401 - Unauthorized
     */
    @ExceptionHandler(DisabledException.class)
    public ResponseEntity<ErrorResponse> handleDisabledAccount(
            DisabledException ex,
            HttpServletRequest request) {
        
        String traceId = TraceIdGenerator.generate();
        
        log.warn("[{}] Disabled account access attempt on {}", traceId, request.getRequestURI());
        
        ErrorResponse response = new ErrorResponse(
            traceId,
            HttpStatus.UNAUTHORIZED.value(),
            "Account Disabled",
            "Sua conta está desativada. Entre em contato com o administrador.",
            request.getRequestURI()
        );
        
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
    }
    
    /**
     * Usuário não encontrado
     * HTTP 401 - Unauthorized (não revelar se existe ou não por segurança)
     */
    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleUserNotFound(
            UsernameNotFoundException ex,
            HttpServletRequest request) {
        
        String traceId = TraceIdGenerator.generate();
        
        log.warn("[{}] User not found attempt on {}", traceId, request.getRequestURI());
        
        // Mesma mensagem do BadCredentialsException para não revelar existência
        ErrorResponse response = new ErrorResponse(
            traceId,
            HttpStatus.UNAUTHORIZED.value(),
            "Authentication Failed",
            "Email ou senha inválidos",
            request.getRequestURI()
        );
        
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
    }
    
    // ==================== 403 - FORBIDDEN ====================
    
    /**
     * Acesso negado (usuário autenticado mas sem permissão)
     * HTTP 403 - Forbidden
     */
    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ErrorResponse> handleAccessDenied(
            AccessDeniedException ex,
            HttpServletRequest request) {
        
        String traceId = TraceIdGenerator.generate();
        
        log.warn("[{}] Access denied on {} - User lacks required permission", 
            traceId, request.getRequestURI());
        
        ErrorResponse response = new ErrorResponse(
            traceId,
            HttpStatus.FORBIDDEN.value(),
            "Access Denied",
            "Você não tem permissão para acessar este recurso",
            request.getRequestURI()
        );
        
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
    }
    
    // ==================== 404 - NOT FOUND ====================
    
    /**
     * Recurso não encontrado
     * HTTP 404 - Not Found
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFound(
            ResourceNotFoundException ex,
            HttpServletRequest request) {
        
        String traceId = TraceIdGenerator.generate();
        
        log.info("[{}] Resource not found on {} - {}", traceId, request.getRequestURI(), ex.getMessage());
        
        ErrorResponse response = new ErrorResponse(
            traceId,
            HttpStatus.NOT_FOUND.value(),
            "Resource Not Found",
            ex.getMessage(),
            request.getRequestURI()
        );
        
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
    
    // ==================== 409 - CONFLICT ====================
    
    /**
     * Conflito (ex: SKU duplicado, email já existe)
     * HTTP 409 - Conflict
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleConflict(
            IllegalArgumentException ex,
            HttpServletRequest request) {
        
        String traceId = TraceIdGenerator.generate();
        
        log.info("[{}] Business conflict on {} - {}", traceId, request.getRequestURI(), ex.getMessage());
        
        ErrorResponse response = new ErrorResponse(
            traceId,
            HttpStatus.CONFLICT.value(),
            "Business Conflict",
            ex.getMessage(),
            request.getRequestURI()
        );
        
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }
    
    // ==================== 422 - UNPROCESSABLE ENTITY ====================
    
    /**
     * Erro de regra de negócio (operação não permitida no estado atual)
     * HTTP 422 - Unprocessable Entity
     */
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorResponse> handleBusinessException(
            BusinessException ex,
            HttpServletRequest request) {
        
        String traceId = TraceIdGenerator.generate();
        
        log.warn("[{}] Business rule violation on {} - Code: {}, Message: {}", 
            traceId, request.getRequestURI(), ex.getErrorCode(), ex.getMessage());
        
        ErrorResponse response = new ErrorResponse(
            traceId,
            HttpStatus.UNPROCESSABLE_ENTITY.value(),
            "Business Rule Violation",
            ex.getMessage(),
            request.getRequestURI()
        );
        
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(response);
    }
    
    // ==================== 500 - INTERNAL SERVER ERROR ====================
    
    /**
     * Erros não tratados
     * HTTP 500 - Internal Server Error
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericException(
            Exception ex,
            HttpServletRequest request) {
        
        String traceId = TraceIdGenerator.generate();
        
        log.error("[{}] Unhandled exception on {} - {}: {}", 
            traceId, request.getRequestURI(), ex.getClass().getSimpleName(), ex.getMessage(), ex);
        
        ErrorResponse response = new ErrorResponse(
            traceId,
            HttpStatus.INTERNAL_SERVER_ERROR.value(),
            "Internal Server Error",
            "Ocorreu um erro inesperado. Tente novamente mais tarde.",
            request.getRequestURI()
        );
        
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
}
```

---

## 📄 Arquivo: `spring-lab\src\main\java\com\rojudo\spring_lab\exception\ResourceNotFoundException.java`

**Caminho completo:** `E:\Projects & Studies\Studies\Spring Boot LAB\spring-lab\src\main\java\com\rojudo\spring_lab\exception\ResourceNotFoundException.java`
**Tamanho:** 492 bytes
**Extensão:** `.java`

```java
package com.rojudo.spring_lab.exception;

/*
  EXCEPTION PERSONALIZADA
  
  POR QUE?
  - Semântica específica do domínio
  - Tratamento diferenciado por tipo
  - Facilita logging e monitoramento
 */
public class ResourceNotFoundException extends RuntimeException {
    
    public ResourceNotFoundException(String message) {
        super(message);
    }
    
    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
```

---

## 📄 Arquivo: `spring-lab\src\main\java\com\rojudo\spring_lab\exception\TraceIdGenerator.java`

**Caminho completo:** `E:\Projects & Studies\Studies\Spring Boot LAB\spring-lab\src\main\java\com\rojudo\spring_lab\exception\TraceIdGenerator.java`
**Tamanho:** 897 bytes
**Extensão:** `.java`

```java
package com.rojudo.spring_lab.exception;

import org.springframework.stereotype.Component;

import java.util.UUID;

/* GERADOR DE TRACE ID 
   Responsável por gerar identificadores únicos para cada erro
   Útil para rastreamento em logs e debugging
 */
@Component
public class TraceIdGenerator {
    
    /* Gera um Trace ID único
       Formato: TIMESTAMP-UUID (ex: 20260406-123456-abc123def)
     */
    public static String generate() {
        return String.format("%s-%s", 
            java.time.LocalDateTime.now().format(java.time.format.DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss")),
            UUID.randomUUID().toString().substring(0, 8)
        );
    }
    
    // Gera Trace ID para ser usado no MDC (Mapped Diagnostic Context) do SLF4J
    public static String generateForMdc() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
```

---

## 📄 Arquivo: `spring-lab\src\main\java\com\rojudo\spring_lab\exception\ValidationException.java`

**Caminho completo:** `E:\Projects & Studies\Studies\Spring Boot LAB\spring-lab\src\main\java\com\rojudo\spring_lab\exception\ValidationException.java`
**Tamanho:** 890 bytes
**Extensão:** `.java`

```java
package com.rojudo.spring_lab.exception;

/* EXCEÇÃO DE VALIDAÇÃO DE PARÂMETROS
 * 
 * Utilizada para erros de validação de parâmetros de requisição
 * (ex: @RequestParam, @PathVariable)
 * 
 * HTTP Status: 400 Bad Request
 */
public class ValidationException extends RuntimeException {
    
    private final String field;
    private final String rejectedValue;
    
    public ValidationException(String message) {
        super(message);
        this.field = null;
        this.rejectedValue = null;
    }
    
    public ValidationException(String field, String rejectedValue, String message) {
        super(message);
        this.field = field;
        this.rejectedValue = rejectedValue;
    }
    
    public String getField() {
        return field;
    }
    
    public String getRejectedValue() {
        return rejectedValue;
    }
}
```

---

## 📄 Arquivo: `spring-lab\src\main\java\com\rojudo\spring_lab\mapper\ProductMapper.java`

**Caminho completo:** `E:\Projects & Studies\Studies\Spring Boot LAB\spring-lab\src\main\java\com\rojudo\spring_lab\mapper\ProductMapper.java`
**Tamanho:** 4,415 bytes
**Extensão:** `.java`

```java
package com.rojudo.spring_lab.mapper;

import com.rojudo.spring_lab.domain.Category;
import com.rojudo.spring_lab.domain.Product;
import com.rojudo.spring_lab.dto.request.ProductRequest;
import com.rojudo.spring_lab.dto.response.ProductResponse;
import com.rojudo.spring_lab.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.NumberFormat;
import java.util.Locale;

/* IMPORTANTE:
  - Request DTO recebe String (nome da categoria)
  - Entity trabalha com Category (objeto JPA)
  - Response DTO retorna String (nome da categoria)
 */
@Component
public class ProductMapper {
    
    private final CategoryRepository categoryRepository;
    
    @Autowired
    public ProductMapper(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    
    /* Converte Request para Entity
       IMPORTANTE: O request.category é uma String (nome da categoria), é necessario buscar o objeto Category no banco
     */
    public Product toEntity(ProductRequest request) {
        Product product = new Product(
            request.sku(),
            request.name(),
            request.price()
        );
        
        // Campos opcionais
        if (request.description() != null) {
            product.setDescription(request.description());
        }
        
        // Converte String (nome da categoria) para Category (objeto JPA)
        if (request.category() != null && !request.category().isBlank()) {
            Category category = categoryRepository.findByName(request.category())
                .orElseThrow(() -> new RuntimeException(
                    "Categoria não encontrada: " + request.category()
                ));
            product.setCategory(category);
        }
        
        if (request.stockQuantity() != null) {
            product.setStockQuantity(request.stockQuantity());
        }
        
        return product;
    }
    
    /* Converte Entity para Response
       IMPORTANTE: product.getCategory() retorna Category, é preciso extrair o nome como String para o DTO
     */
    public ProductResponse toResponse(Product product) {
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        
        // Extrai o nome da categoria (se existir) ou null
        String categoryName = product.getCategory() != null 
            ? product.getCategory().getName() 
            : null;
        
        return ProductResponse.builder()
            .id(product.getId())
            .sku(product.getSku())
            .name(product.getName())
            .description(product.getDescription())
            .price(product.getPrice())
            .category(categoryName)  // ← String, não Category!
            .stockQuantity(product.getStockQuantity())
            .active(product.getActive())
            .createdAt(product.getCreatedAt())
            .updatedAt(product.getUpdatedAt())
            .available(product.isAvailable())
            .priceFormatted(currencyFormatter.format(product.getPrice()))
            .build();
    }
    
    /* Atualiza entity existente com dados do request (patch) 
       IMPORTANTE: Mesma lógica de conversão String → Category
     */
    public void updateEntity(Product product, ProductRequest request) {
        if (request.name() != null) {
            product.setName(request.name());
        }
        if (request.description() != null) {
            product.setDescription(request.description());
        }
        
        // Converte String (nome da categoria) para Category (objeto JPA)
        if (request.category() != null) {
            if (request.category().isBlank()) {
                product.setCategory(null);  // Remove categoria
            } else {
                Category category = categoryRepository.findByName(request.category())
                    .orElseThrow(() -> new RuntimeException(
                        "Categoria não encontrada: " + request.category()
                    ));
                product.setCategory(category);
            }
        }
        
        if (request.stockQuantity() != null) {
            product.setStockQuantity(request.stockQuantity());
        }
    }
}
```

---

## 📄 Arquivo: `spring-lab\src\main\java\com\rojudo\spring_lab\repository\CategoryRepository.java`

**Caminho completo:** `E:\Projects & Studies\Studies\Spring Boot LAB\spring-lab\src\main\java\com\rojudo\spring_lab\repository\CategoryRepository.java`
**Tamanho:** 4,706 bytes
**Extensão:** `.java`

```java
package com.rojudo.spring_lab.repository;

import com.rojudo.spring_lab.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * CATEGORY REPOSITORY
 * 
 * Camada de acesso a dados para entidade Category
 * 
 * Spring Data JPA fornece implementação automática!
 * Basta estender JpaRepository e declarar métodos
 * 
 * MÉTODOS DERIVADOS (Spring Data JPA interpreta pelo nome):
 * - findByName(String name) → SELECT * FROM categories WHERE name = ?
 * - findByActiveTrue() → SELECT * FROM categories WHERE active = true
 * - findByParentIsNull() → SELECT * FROM categories WHERE parent_id IS NULL
 * 
 * @Repository → Indica bean de repositório, trata exceções JPA
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    
    // ===== MÉTODOS DERIVADOS (Spring Data JPA implementa automaticamente) =====
    
    /**
     * Busca categoria por nome (case-sensitive)
     * Usado no DataInitializer para encontrar categorias por nome
     */
    Optional<Category> findByName(String name);
    
    /**
     * Verifica se existe categoria com determinado nome
     * Útil para validações antes de criar
     */
    boolean existsByName(String name);
    
    /**
     * Busca todas categorias ativas
     */
    List<Category> findByActiveTrue();
    
    /**
     * Busca categorias inativas
     */
    List<Category> findByActiveFalse();
    
    /**
     * Busca categorias raiz (sem categoria pai)
     */
    List<Category> findByParentIsNull();
    
    /**
     * Busca categorias por categoria pai
     * Exemplo: todas sub-categorias de "Eletrônicos"
     */
    List<Category> findByParent(Category parent);
    
    /**
     * Busca categorias por nome ignorando maiúsculas/minúsculas
     */
    List<Category> findByNameContainingIgnoreCase(String name);
    
    // ===== QUERIES JPQL =====
    
    /**
     * Busca todas categorias com suas sub-categorias (carregamento eager)
     * Usado quando precisamos da hierarquia completa
     */
    @Query("SELECT c FROM Category c LEFT JOIN FETCH c.children WHERE c.active = true")
    List<Category> findAllWithChildren();
    
    /**
     * Busca categoria por ID com suas sub-categorias
     */
    @Query("SELECT c FROM Category c LEFT JOIN FETCH c.children WHERE c.id = :id")
    Optional<Category> findByIdWithChildren(@Param("id") Long id);
    
    /**
     * Busca categorias por nível na hierarquia
     * Implementado com CTE (Common Table Expression) nativo
     */
    @Query(value = """
        WITH RECURSIVE category_tree AS (
            SELECT id, name, parent_id, 0 as level
            FROM categories
            WHERE id = :categoryId
            UNION ALL
            SELECT c.id, c.name, c.parent_id, ct.level + 1
            FROM categories c
            INNER JOIN category_tree ct ON c.parent_id = ct.id
        )
        SELECT * FROM category_tree ORDER BY level
        """, nativeQuery = true)
    List<Object[]> findCategoryHierarchy(@Param("categoryId") Long categoryId);
    
    /**
     * Busca todas categorias descendentes de uma categoria
     * Exemplo: Todas sub-categorias de "Eletrônicos" (incluindo netos)
     */
    @Query(value = """
        WITH RECURSIVE descendants AS (
            SELECT id, name, parent_id
            FROM categories
            WHERE id = :categoryId
            UNION ALL
            SELECT c.id, c.name, c.parent_id
            FROM categories c
            INNER JOIN descendants d ON c.parent_id = d.id
        )
        SELECT * FROM descendants WHERE id != :categoryId
        """, nativeQuery = true)
    List<Object[]> findAllDescendants(@Param("categoryId") Long categoryId);
    
    // ===== QUERIES PARA ESTATÍSTICAS =====
    
    /**
     * Conta quantos produtos existem em cada categoria
     * Retorna: [category_name, product_count]
     */
    @Query("""
        SELECT c.name, COUNT(p.id) 
        FROM Category c 
        LEFT JOIN Product p ON p.category = c 
        GROUP BY c.id, c.name
        ORDER BY COUNT(p.id) DESC
        """)
    List<Object[]> countProductsByCategory();
    
    /**
     * Busca categorias com seus produtos (otimizado)
     */
    @Query("SELECT DISTINCT c FROM Category c LEFT JOIN FETCH c.children WHERE c.active = true")
    List<Category> findAllActiveWithChildren();
}
```

---

## 📄 Arquivo: `spring-lab\src\main\java\com\rojudo\spring_lab\repository\PermissionRepository.java`

**Caminho completo:** `E:\Projects & Studies\Studies\Spring Boot LAB\spring-lab\src\main\java\com\rojudo\spring_lab\repository\PermissionRepository.java`
**Tamanho:** 4,122 bytes
**Extensão:** `.java`

```java
package com.rojudo.spring_lab.repository;

import com.rojudo.spring_lab.domain.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * PERMISSION REPOSITORY
 * 
 * Camada de acesso a dados para entidade Permission
 * 
 * Permissões são granulares e representam ações específicas no sistema:
 * - PRODUCT_READ: Pode visualizar produtos
 * - PRODUCT_CREATE: Pode criar produtos
 * - PRODUCT_UPDATE: Pode editar produtos
 * - PRODUCT_DELETE: Pode deletar produtos
 * 
 * Usado pelo Spring Security para verificar @PreAuthorize("hasAuthority('PRODUCT_READ')")
 */
@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {
    
    // ===== MÉTODOS DERIVADOS =====
    
    /**
     * Busca permissão por nome
     * Usado no DataInitializer para encontrar permissões por nome
     * Exemplo: findByName("PRODUCT_READ")
     */
    Optional<Permission> findByName(String name);
    
    /**
     * Verifica se permissão existe
     */
    boolean existsByName(String name);
    
    /**
     * Busca múltiplas permissões por nomes
     * Usado no DataInitializer para atribuir permissões a roles
     * Exemplo: findAllByNameIn(["PRODUCT_READ", "PRODUCT_CREATE"])
     */
    List<Permission> findAllByNameIn(List<String> names);
    
    /**
     * Busca todas permissões que contêm determinada string no nome
     * Exemplo: findAllByNameContaining("PRODUCT") → todas permissões de produto
     */
    List<Permission> findByNameContaining(String keyword);
    
    /**
     * Busca permissões por descrição
     */
    List<Permission> findByDescriptionContainingIgnoreCase(String description);
    
    // ===== QUERIES JPQL =====
    
    /**
     * Busca todas permissões associadas a um usuário específico
     * Útil para montar lista de authorities para o Spring Security
     * 
     * A query navega na direção correta do relacionamento:
     * User (dono) → roles → permissions
     */
    @Query("""
    SELECT DISTINCT p 
    FROM User u 
    JOIN u.roles r 
    JOIN r.permissions p 
    WHERE u.id = :userId
    """)
Set<Permission> findPermissionsByUserId(@Param("userId") Long userId);
    
    /**
     * Busca todas permissões associadas a uma role específica
     */
    @Query("SELECT r.permissions FROM Role r WHERE r.id = :roleId")
    List<Permission> findPermissionsByRoleId(@Param("roleId") Long roleId);
    
    /**
     * Busca permissões agrupadas por categoria (prefixo do nome)
     * Exemplo: Permissões começando com "PRODUCT_" são do módulo Produtos
     */
    @Query("""
        SELECT 
            SUBSTRING(p.name, 1, POSITION('_' IN p.name) - 1) as module,
            COUNT(p) as count
        FROM Permission p
        GROUP BY module
        ORDER BY module
        """)
    List<Object[]> countPermissionsByModule();
    
    // ===== QUERIES NATIVAS =====
    
    /**
     * Busca permissões de um usuário via SQL nativo (mais performático)
     * Usado internamente pelo Spring Security
     */
    @Query(value = """
        SELECT DISTINCT p.* 
        FROM permissions p
        JOIN role_permissions rp ON p.id = rp.permission_id
        JOIN user_roles ur ON rp.role_id = ur.role_id
        WHERE ur.user_id = :userId
        """, nativeQuery = true)
    List<Permission> findUserPermissionsNative(@Param("userId") Long userId);
    
    // ===== MÉTODOS PARA INICIALIZAÇÃO =====
    
    /**
     * Verifica se todas as permissões essenciais existem
     * Usado para validação na inicialização
     */
    @Query("""
        SELECT COUNT(p) FROM Permission p 
        WHERE p.name IN ('PRODUCT_READ', 'PRODUCT_CREATE', 'PRODUCT_UPDATE', 'PRODUCT_DELETE')
        """)
    long countEssentialPermissions();
}
```

---

## 📄 Arquivo: `spring-lab\src\main\java\com\rojudo\spring_lab\repository\ProductRepository.java`

**Caminho completo:** `E:\Projects & Studies\Studies\Spring Boot LAB\spring-lab\src\main\java\com\rojudo\spring_lab\repository\ProductRepository.java`
**Tamanho:** 9,695 bytes
**Extensão:** `.java`

```java
package com.rojudo.spring_lab.repository;

import com.rojudo.spring_lab.domain.Category;
import com.rojudo.spring_lab.domain.Product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.QueryHint;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/*
  REPOSITORY: Camada de acesso a dados
  
  POR QUE REPOSITORY?
  - Abstrai a persistência
  - Spring Data JPA implementa automaticamente
  - Métodos customizados podem ser adicionados
  - Facilita testes (mock)
  
  PRINCÍPIOS:
  - Interface (desacoplamento)
  - Nomes de métodos seguem convenção
  - @Repository para tratamento de exceções
  
  ESTA INTERFACE:
  - Estende JpaRepository para operações CRUD padrão
  - Estende ProductRepositoryCustom para queries complexas com Specification
  - Combina queries derivadas, JPQL e Native SQL
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long>, ProductRepositoryCustom {
    
    // ===== QUERIES BÁSICAS DERIVADAS =====
    // Spring Data JPA implementa baseado no nome do método
    // "where sku = ?1" - busca por SKU (único)
    
    /*
      Busca por SKU (único)
      Query derivada: "where sku = ?1"
     */
    Optional<Product> findBySku(String sku);
    
    /*
      Verifica existência por SKU
      Retorna boolean ao invés de entidade (mais eficiente)
     */
    boolean existsBySku(String sku);
    
    /*
      Busca por nome contendo (case insensitive)
      Query: "where lower(name) like lower(?1)"
     */
    List<Product> findByNameContainingIgnoreCase(String name);
    
    /*
      Busca produtos ativos com paginação
      Pageable automaticamente adiciona limit/offset
     */
    Page<Product> findByActiveTrue(Pageable pageable);
    
    // ===== QUERIES COM JPQL AVANÇADO =====
    // Para consultas mais complexas que as queries derivadas
    
    /**
     * Busca produtos com preço entre valores
     * Usando named parameters e paginação
     * Between é suportado nativamente no JPQL
     */
    @Query("SELECT p FROM Product p WHERE p.price BETWEEN :minPrice AND :maxPrice")
    Page<Product> findByPriceRange(
        @Param("minPrice") BigDecimal minPrice,
        @Param("maxPrice") BigDecimal maxPrice,
        Pageable pageable
    );
    
    /**
     * Busca produtos com full-text search usando PostgreSQL
     * Usando native query para TSVECTOR (funcionalidade específica do banco)
     * Exemplo de como usar features específicas do SGBD
     */
    @Query(
        value = "SELECT * FROM products WHERE search_vector @@ to_tsquery('portuguese', :query)",
        nativeQuery = true
    )
    List<Product> fullTextSearch(@Param("query") String query);
    
    /**
     * Busca produtos com filtros dinâmicos
     * Parâmetros opcionais: se NULL, a condição é ignorada
     * Alternativa ao uso de Specifications para queries menos complexas
     */
    @Query("""
        SELECT p FROM Product p 
        WHERE (:category IS NULL OR p.category = :category)
          AND (:minPrice IS NULL OR p.price >= :minPrice)
          AND (:maxPrice IS NULL OR p.price <= :maxPrice)
          AND (:inStock IS NULL OR p.stockQuantity > 0)
          AND p.active = true
        ORDER BY p.createdAt DESC
        """)
    Page<Product> findWithFilters(
        @Param("category") Category category,
        @Param("minPrice") BigDecimal minPrice,
        @Param("maxPrice") BigDecimal maxPrice,
        @Param("inStock") Boolean inStock,
        Pageable pageable
    );
    
    // ===== QUERIES COM HINTS DE PERFORMANCE =====
    // Otimizações de cache e performance
    
    @QueryHints({
        @QueryHint(name = "org.hibernate.cacheable", value = "true"),
        @QueryHint(name = "org.hibernate.cacheRegion", value = "products"),
        @QueryHint(name = "org.hibernate.readOnly", value = "true")
    })
    @Query("SELECT p FROM Product p WHERE p.id = :id")
    Optional<Product> findByIdWithCache(@Param("id") Long id);
    
    // ===== OPERAÇÕES EM LOTE =====
    // Atualizações que afetam múltiplos registros
    
    @Modifying  // Indica que não é SELECT (executa UPDATE/DELETE)
    @Transactional  // Garante atomicidade da operação
    @Query("UPDATE Product p SET p.price = p.price * :multiplier WHERE p.category = :category")
    int bulkUpdatePriceByCategory(
        @Param("category") Category category,
        @Param("multiplier") BigDecimal multiplier
    );
    
    @Modifying
    @Transactional
    @Query("UPDATE Product p SET p.active = false WHERE p.id = :id")
    int softDelete(@Param("id") Long id);
    
    // ===== QUERIES COM AGREGADOS =====
    // Consultas que retornam dados calculados
    
    /**
      Estatísticas por categoria
      Usando GROUP BY com JPQL
      Retorna array de Object quando campos específicos
     */
    @Query("""
        SELECT 
            p.category, 
            COUNT(p), 
            AVG(p.price), 
            SUM(p.stockQuantity),
            MIN(p.price),
            MAX(p.price)
        FROM Product p 
        WHERE p.active = true 
        GROUP BY p.category
        """)
    List<Object[]> getCategoryStatistics();
    
    /**
      Estatísticas de criação de produtos agrupadas por data
      Usando FUNCTION() para chamar funções específicas do banco (DATE)
      Útil para dashboards e relatórios
     */
    @Query("""
        SELECT 
            FUNCTION('DATE', p.createdAt) as date,
            COUNT(p) as total,
            SUM(CASE WHEN p.active = true THEN 1 ELSE 0 END) as active
        FROM Product p 
        WHERE p.createdAt >= :since 
        GROUP BY FUNCTION('DATE', p.createdAt)
        ORDER BY date DESC
        """)
    List<Object[]> getProductCreationStats(@Param("since") LocalDateTime since);
    
    // ===== QUERIES NATIVAS AVANÇADAS =====
    // Quando precisa de performance ou features específicas do banco
    
    /*
      Busca produtos por hierarquia de categorias
      Usando Common Table Expression (CTE) recursiva
      Exemplo de feature específica do PostgreSQL/MySQL 8+
      Retorna produtos de uma categoria e todas suas subcategorias
     */
    @Query(
        value = """
            WITH RECURSIVE category_tree AS (
                SELECT id, name, parent_id, 1 as level
                FROM categories
                WHERE id = :categoryId
                UNION ALL
                SELECT c.id, c.name, c.parent_id, ct.level + 1
                FROM categories c
                INNER JOIN category_tree ct ON c.parent_id = ct.id
            )
            SELECT p.* FROM products p
            WHERE p.category_id IN (SELECT id FROM category_tree)
            AND p.active = true
            """,
        nativeQuery = true
    )
    List<Product> findByCategoryHierarchy(@Param("categoryId") Long categoryId);
    
    /**
      Busca produtos com full-text search usando PostgreSQL
      Alternativa mais performática que LIKE para buscas textuais
     */
    @Query(
        value = "SELECT * FROM products WHERE search_vector @@ to_tsquery('portuguese', :query)",
        nativeQuery = true
    )
    List<Product> fullTextSearchWindowFunctions(@Param("query") String query);
    
    // ===== QUERIES COM WINDOW FUNCTIONS =====
    // Análise avançada sem perder detalhes dos registros
    
    @Query(
        value = """
            SELECT 
                id, name, price, category,
                RANK() OVER (PARTITION BY category ORDER BY price DESC) as price_rank,
                PERCENT_RANK() OVER (ORDER BY price) as percentile
            FROM products 
            WHERE active = true
            """,
        nativeQuery = true
    )
    List<Object[]> getProductRankings();
    
    // ===== MÉTODOS ADICIONAIS DO REPOSITÓRIO ORIGINAL =====
    // Mantidos para compatibilidade e funcionalidades adicionais
    
    /**
      Busca produtos ativos por categoria
      Múltiplas condições: active = true AND category = ?
     */
    List<Product> findByActiveTrueAndCategory(Category category);
    
    /**
      Busca produtos com preço entre valores (versão simples)
      Between é suportado nativamente
     */
    List<Product> findByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice);
    
    /**
      Busca produtos com estoque baixo
      JPQL usa a entity, não a tabela
     */
    @Query("SELECT p FROM Product p WHERE p.stockQuantity < :threshold AND p.active = true")
    List<Product> findLowStockProducts(@Param("threshold") int threshold);
    
    /**
      Busca produtos com informações agregadas simplificadas
      Retorna array de Object quando campos específicos
     */
    @Query("""
        SELECT p.id, p.name, p.sku, p.price 
        FROM Product p 
        WHERE p.category = :category AND p.active = true
        ORDER BY p.price DESC
        """)
    List<Object[]> findProductSummariesByCategory(@Param("category") Category category);
}
```

---

## 📄 Arquivo: `spring-lab\src\main\java\com\rojudo\spring_lab\repository\ProductRepositoryCustom.java`

**Caminho completo:** `E:\Projects & Studies\Studies\Spring Boot LAB\spring-lab\src\main\java\com\rojudo\spring_lab\repository\ProductRepositoryCustom.java`
**Tamanho:** 386 bytes
**Extensão:** `.java`

```java
package com.rojudo.spring_lab.repository;

import com.rojudo.spring_lab.domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

public interface ProductRepositoryCustom {
    Page<Product> findAllWithSpecification(Specification<Product> spec, Pageable pageable);
}
```

---

## 📄 Arquivo: `spring-lab\src\main\java\com\rojudo\spring_lab\repository\ProductRepositoryCustomImpl.java`

**Caminho completo:** `E:\Projects & Studies\Studies\Spring Boot LAB\spring-lab\src\main\java\com\rojudo\spring_lab\repository\ProductRepositoryCustomImpl.java`
**Tamanho:** 1,928 bytes
**Extensão:** `.java`

```java
package com.rojudo.spring_lab.repository;

import com.rojudo.spring_lab.domain.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class ProductRepositoryCustomImpl implements ProductRepositoryCustom {
    
    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public Page<Product> findAllWithSpecification(Specification<Product> spec, Pageable pageable) {
        var cb = entityManager.getCriteriaBuilder();
        var query = cb.createQuery(Product.class);
        var root = query.from(Product.class);
        
        var predicates = new ArrayList<Predicate>();
        if (spec != null) {
            predicates.add(spec.toPredicate(root, query, cb));
        }
        
        query.where(predicates.toArray(new Predicate[0]));
        
        var typedQuery = entityManager.createQuery(query);
        typedQuery.setFirstResult((int) pageable.getOffset());
        typedQuery.setMaxResults(pageable.getPageSize());
        
        var products = typedQuery.getResultList();
        
        // Count query
        var countQuery = cb.createQuery(Long.class);
        var countRoot = countQuery.from(Product.class);
        countQuery.select(cb.count(countRoot));
        if (spec != null) {
            countQuery.where(spec.toPredicate(countRoot, countQuery, cb));
        }
        
        Long total = entityManager.createQuery(countQuery).getSingleResult();
        
        return new PageImpl<>(products, pageable, total);
    }
}
```

---

## 📄 Arquivo: `spring-lab\src\main\java\com\rojudo\spring_lab\repository\RoleRepository.java`

**Caminho completo:** `E:\Projects & Studies\Studies\Spring Boot LAB\spring-lab\src\main\java\com\rojudo\spring_lab\repository\RoleRepository.java`
**Tamanho:** 298 bytes
**Extensão:** `.java`

```java
package com.rojudo.spring_lab.repository;

import com.rojudo.spring_lab.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);
}
```

---

## 📄 Arquivo: `spring-lab\src\main\java\com\rojudo\spring_lab\repository\UserRepository.java`

**Caminho completo:** `E:\Projects & Studies\Studies\Spring Boot LAB\spring-lab\src\main\java\com\rojudo\spring_lab\repository\UserRepository.java`
**Tamanho:** 927 bytes
**Extensão:** `.java`

```java
package com.rojudo.spring_lab.repository;

import com.rojudo.spring_lab.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    Optional<User> findByEmail(String email);
    
    boolean existsByEmail(String email);
    
    @Modifying
    @Transactional
    @Query("UPDATE User u SET u.failedAttempts = 0, u.accountLocked = false WHERE u.email = :email")
    void resetFailedAttempts(String email);
    
    @Modifying
    @Transactional
    @Query("UPDATE User u SET u.active = false WHERE u.id = :id")
    void softDelete(Long id);
}
```

---

## 📄 Arquivo: `spring-lab\src\main\java\com\rojudo\spring_lab\service\AuthService.java`

**Caminho completo:** `E:\Projects & Studies\Studies\Spring Boot LAB\spring-lab\src\main\java\com\rojudo\spring_lab\service\AuthService.java`
**Tamanho:** 8,485 bytes
**Extensão:** `.java`

```java
package com.rojudo.spring_lab.service;

import com.rojudo.spring_lab.dto.request.AuthLoginRequest;
import com.rojudo.spring_lab.dto.request.AuthRegisterRequest;
import com.rojudo.spring_lab.dto.response.AuthLoginResponse;
import com.rojudo.spring_lab.dto.response.UserInfoResponse;
import com.rojudo.spring_lab.domain.Role;
import com.rojudo.spring_lab.domain.User;
import com.rojudo.spring_lab.repository.RoleRepository;
import com.rojudo.spring_lab.repository.UserRepository;
import com.rojudo.spring_lab.config.JwtService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class AuthService {
    
    private static final Logger log = LoggerFactory.getLogger(AuthService.class);
    
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;
    
    @Autowired
    public AuthService(AuthenticationManager authenticationManager,
                       UserRepository userRepository,
                       RoleRepository roleRepository,
                       PasswordEncoder passwordEncoder,
                       JwtService jwtService,
                       UserDetailsService userDetailsService) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.userDetailsService = userDetailsService;
    }
    
    /**
     * Login - Autentica usuário e gera token
     */
    public AuthLoginResponse login(AuthLoginRequest request) {
        log.info("Login attempt for user: {}", request.email());
        
        try {
            // Autentica usando AuthenticationManager
            Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                    request.email(),
                    request.password()
                )
            );
            
            // Carrega usuário completo
            User user = userRepository.findByEmail(request.email())
                .orElseThrow(() -> new RuntimeException("User not found"));
            
            // Registra login bem-sucedido
            user.recordSuccessfulLogin();
            userRepository.save(user);
            
            // Gera token
            String token = jwtService.generateToken(authentication);
            
            log.info("User logged in successfully: {}", user.getEmail());
            
            return buildLoginResponse(token, user);
            
        } catch (BadCredentialsException e) {
            // Registra tentativa falha
            userRepository.findByEmail(request.email()).ifPresent(user -> {
                user.incrementFailedAttempts();
                userRepository.save(user);
                log.warn("Failed login attempt for user: {}. Attempts: {}", 
                    user.getEmail(), user.getFailedAttempts());
            });
            
            log.warn("Invalid credentials for user: {}", request.email());
            throw new BadCredentialsException("Email ou senha inválidos");
        }
    }
    
    /**
     * Registro de novo usuário
     */
    public AuthLoginResponse register(AuthRegisterRequest request) {
        log.info("Register attempt for user: {}", request.email());
        
        // Verifica se email já existe
        if (userRepository.existsByEmail(request.email())) {
            throw new RuntimeException("Email já cadastrado");
        }
        
        // Cria novo usuário - Usar construtor público em vez de new User()
        User user = new User(
            request.email(),
            passwordEncoder.encode(request.password()),
            request.fullName()
        );
        user.setPhone(request.phone());
        user.setActive(true);           // Em desenvolvimento, já ativo
        user.setEmailVerified(true);    // Em desenvolvimento, já verificado
        user.setAccountLocked(false);   // Em desenvolvimento, já desbloqueado
        user.setFailedAttempts(0);

        // Atribui role padrão USER
        Role defaultRole = roleRepository.findByName("ROLE_USER")
            .orElseThrow(() -> new RuntimeException("Default role not found"));
        user.setRoles(Set.of(defaultRole));
        
        User savedUser = userRepository.save(user);
        
        log.info("User registered successfully: {}", savedUser.getEmail());
        
        // Autentica e gera token
        UserDetails userDetails = savedUser;  // User implementa UserDetails
        Authentication authentication = new UsernamePasswordAuthenticationToken(
            userDetails,                    // ← UserDetails
            request.password(),             // ← Credenciais
            userDetails.getAuthorities()    // ← Authorities
        );
        
        String token = jwtService.generateToken(authentication);
        
        return buildLoginResponse(token, savedUser);
    }
    
    /**
     * Refresh token
     */
    public AuthLoginResponse refreshToken(String token) {
        // Remove prefixo "Bearer " se existir
        if (token.startsWith("Bearer ")) {
            token = token.substring(7);
        }
        
        String username = jwtService.extractUsername(token);
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        
        if (jwtService.isTokenValid(token, userDetails)) {
            Authentication authentication = new UsernamePasswordAuthenticationToken(
                userDetails,
                null,
                userDetails.getAuthorities()
            );


            String newToken = jwtService.generateToken(authentication);
            
            User user = userRepository.findByEmail(username).orElseThrow();
            return buildLoginResponse(newToken, user);
        }
        
        throw new RuntimeException("Invalid refresh token");
    }
    
    /**
     * Altera senha
     */
    public void changePassword(String token, String oldPassword, String newPassword) {
        String username = jwtService.extractUsername(token.replace("Bearer ", ""));
        User user = userRepository.findByEmail(username)
            .orElseThrow(() -> new RuntimeException("User not found"));
        
        if (!passwordEncoder.matches(oldPassword, user.getPassword())) {
            throw new BadCredentialsException("Senha atual inválida");
        }
        
        user.setPassword(passwordEncoder.encode(newPassword));
        userRepository.save(user);
        
        log.info("Password changed for user: {}", user.getEmail());
    }
    
    /**
     * Constrói resposta de login
     */
    private AuthLoginResponse buildLoginResponse(String token, User user) {
        return new AuthLoginResponse(
            token,
            new UserInfoResponse(
                user.getId(),
                user.getEmail(),
                user.getFullName(),
                user.getRoles().stream()
                    .map(Role::getName)
                    .collect(Collectors.toList()),
                user.getAuthorities().stream()
                    .map(Object::toString)
                    .collect(Collectors.toList())
            )
        );
    }
}
```

---

## 📄 Arquivo: `spring-lab\src\main\java\com\rojudo\spring_lab\service\CustomUserDetailsService.java`

**Caminho completo:** `E:\Projects & Studies\Studies\Spring Boot LAB\spring-lab\src\main\java\com\rojudo\spring_lab\service\CustomUserDetailsService.java`
**Tamanho:** 1,786 bytes
**Extensão:** `.java`

```java
package com.rojudo.spring_lab.service;

import com.rojudo.spring_lab.domain.User;
import com.rojudo.spring_lab.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * CUSTOM USER DETAILS SERVICE
 * 
 * Responsável por carregar usuário do banco para autenticação
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {
    
    private static final Logger log = LoggerFactory.getLogger(CustomUserDetailsService.class);
    
    private final UserRepository userRepository;
    
    @Autowired
    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        log.debug("Loading user by email: {}", email);
        
        User user = userRepository.findByEmail(email)
            .orElseThrow(() -> {
                log.warn("User not found with email: {}", email);
                return new UsernameNotFoundException("Usuário não encontrado com email: " + email);
            });
        
        log.debug("User loaded: {} - Active: {} - Locked: {}", 
            user.getEmail(), user.isEnabled(), user.isAccountNonLocked());
        
        return user;
    }
}
```

---

## 📄 Arquivo: `spring-lab\src\main\java\com\rojudo\spring_lab\service\ProductService.java`

**Caminho completo:** `E:\Projects & Studies\Studies\Spring Boot LAB\spring-lab\src\main\java\com\rojudo\spring_lab\service\ProductService.java`
**Tamanho:** 13,445 bytes
**Extensão:** `.java`

```java
package com.rojudo.spring_lab.service;

import com.rojudo.spring_lab.mapper.ProductMapper;
import com.rojudo.spring_lab.dto.request.ProductRequest;
import com.rojudo.spring_lab.dto.response.ProductResponse;
import com.rojudo.spring_lab.domain.Category;
import com.rojudo.spring_lab.domain.Product;
import com.rojudo.spring_lab.repository.CategoryRepository;
import com.rojudo.spring_lab.repository.ProductRepository;
import com.rojudo.spring_lab.exception.ResourceNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/*
  SERVICE: Camada de negócio
  
  POR QUE SERVICE?
  - Lógica de negócio complexa
  - Orquestração de múltiplos repositórios
  - Controle transacional
  - Regras de validação de negócio
  
  PRINCÍPIOS:
  - @Service indica componente de negócio
  - @Transactional gerencia transações
  - Singleton (uma instância por aplicação)
  - Coesão (operações relacionadas)
 */
@Service
@Transactional(readOnly = true) // Leitura por padrão, transações de escrita sobrescrevem
public class ProductService {
    
    private static final Logger log = LoggerFactory.getLogger(ProductService.class);
    
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final CategoryRepository categoryRepository;

    /*
      Injeção por construtor
      
      POR QUE?
     - Imutabilidade (final fields)
      - Testabilidade (mock fácil)
      - Dependências explícitas
     */
    @Autowired
    public ProductService(ProductRepository productRepository, ProductMapper productMapper, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
        this.categoryRepository = categoryRepository;
    }
    
    /*
      CREATE - Cria um novo produto
      
      REGRAS DE NEGÓCIO:
      1. SKU deve ser único
      2. Produto é criado ativo por padrão
      3. Categoria deve existir se fornecida
      4. Validação de regras de negócio
     */
    @Transactional // Sobrescreve readOnly = true
    public ProductResponse create(ProductRequest request) {
        log.info("Creating new product with SKU: {}", request.sku());
        
        // 1. Validação de negócio: SKU único
        if (productRepository.existsBySku(request.sku())) {
            log.warn("Attempt to create product with existing SKU: {}", request.sku());
            throw new IllegalArgumentException("Produto com SKU " + request.sku() + " já existe");
        }
        
        // 2. Validação de negócio: Verificar se a categoria existe (se fornecida)
        Category category = null;
        if (request.category() != null && !request.category().isBlank()) {
            category = categoryRepository.findByName(request.category())
                .orElseThrow(() -> {
                    log.warn("Category not found: {}", request.category());
                    return new IllegalArgumentException("Categoria não encontrada: " + request.category());
                });
            log.debug("Category found: {} (ID: {})", category.getName(), category.getId());
        }
        
        // 3. Converter DTO para Entity
        Product product = productMapper.toEntity(request);
        
        // 4. Se a categoria foi validada, associar ao produto
        if (category != null) {
            product.setCategory(category);
        }
        
        // 5. Regras de negócio adicionais
        if (product.getStockQuantity() == null) {
            product.setStockQuantity(0);
        }
        
        // 6. Persistir
        Product savedProduct = productRepository.save(product);
        log.info("Product created successfully with ID: {}", savedProduct.getId());
        
        // 7. Converter para Response DTO
        return productMapper.toResponse(savedProduct);
    }
    
    // READ - Busca todos produtos (paginado)
    public Page<ProductResponse> findAll(Pageable pageable) {
        log.debug("Finding all products - Page: {}, Size: {}", pageable.getPageNumber(), pageable.getPageSize());
        return productRepository.findAll(pageable)
            .map(productMapper::toResponse);
    }
    
    // READ - Busca produtos ativos (paginado)
    public Page<ProductResponse> findActiveProducts(Pageable pageable) {
        log.debug("Finding active products - Page: {}, Size: {}", pageable.getPageNumber(), pageable.getPageSize());
        return productRepository.findByActiveTrue(pageable)
            .map(productMapper::toResponse);
    }
    
    /*
      READ - Busca por ID
      
      @throws ResourceNotFoundException se não encontrar
     */
    public ProductResponse findById(Long id) {
        log.debug("Finding product by ID: {}", id);
        Product product = findProductEntityById(id);
        return productMapper.toResponse(product);
    }
    
    // READ - Busca por SKU 
    public ProductResponse findBySku(String sku) {
        log.debug("Finding product by SKU: {}", sku);
        Product product = productRepository.findBySku(sku)
            .orElseThrow(() -> {
                log.warn("Product not found with SKU: {}", sku);
                return new ResourceNotFoundException("Produto com SKU " + sku + " não encontrado");
            });
        return productMapper.toResponse(product);
    }
    
    // READ - Busca por nome (case insensitive)
    public List<ProductResponse> findByName(String name) {
        log.debug("Finding products by name containing: {}", name);
        return productRepository.findByNameContainingIgnoreCase(name)
            .stream()
            .map(productMapper::toResponse)
            .collect(Collectors.toList());
    }
    
    // READ - Busca por faixa de preço
    public List<ProductResponse> findByPriceRange(BigDecimal minPrice, BigDecimal maxPrice) {
        log.debug("Finding products by price range: {} - {}", minPrice, maxPrice);
        
        // Validação de negócio
        if (minPrice.compareTo(maxPrice) > 0) {
            log.warn("Invalid price range: minPrice > maxPrice ({} > {})", minPrice, maxPrice);
            throw new IllegalArgumentException("Preço mínimo não pode ser maior que máximo");
        }
        
        return productRepository.findByPriceBetween(minPrice, maxPrice)
            .stream()
            .map(productMapper::toResponse)
            .collect(Collectors.toList());
    }
    
    // UPDATE - Atualiza produto completo
    @Transactional
    public ProductResponse update(Long id, ProductRequest request) {
        log.info("Updating product with ID: {}", id);
        
        // 1. Verificar se produto existe
        Product product = findProductEntityById(id);
        
        // 2. Se SKU mudou, verificar conflito
        if (request.sku() != null && !product.getSku().equals(request.sku())) {
            if (productRepository.existsBySku(request.sku())) {
                log.warn("Attempt to update product with existing SKU: {}", request.sku());
                throw new IllegalArgumentException("SKU " + request.sku() + " já está em uso");
            }
            product.setSku(request.sku());
            log.debug("SKU updated from {} to {}", product.getSku(), request.sku());
        }
        
        // 3. Validar categoria se fornecida
        if (request.category() != null) {
            if (request.category().isBlank()) {
                product.setCategory(null);
                log.debug("Category removed from product ID: {}", id);
            } else {
                Category category = categoryRepository.findByName(request.category())
                    .orElseThrow(() -> {
                        log.warn("Category not found for update: {}", request.category());
                        return new IllegalArgumentException("Categoria não encontrada: " + request.category());
                    });
                product.setCategory(category);
                log.debug("Category updated to: {}", category.getName());
            }
        }
        
        // 4. Atualizar outros campos
        productMapper.updateEntity(product, request);
        
        // 5. Persistir (JPA faz merge automático dentro da transação)
        Product updatedProduct = productRepository.save(product);
        log.info("Product updated successfully with ID: {}", updatedProduct.getId());
        
        // 6. Retornar resposta
        return productMapper.toResponse(updatedProduct);
    }
    
    /*
      DELETE - Remove produto (soft delete)
      
      POR QUE SOFT DELETE?
      - Manter histórico
      - Evitar perda de dados
      - Referências de integridade
     */
    @Transactional
    public void delete(Long id) {
        log.info("Soft deleting product with ID: {}", id);
        Product product = findProductEntityById(id);
        product.deactivate(); // Método de domínio
        productRepository.save(product);
        log.info("Product deactivated successfully: {}", id);
    }
    
    // DELETE - Remove produto (hard delete - uso controlado)
    @Transactional
    public void hardDelete(Long id) {
        log.warn("HARD DELETING product with ID: {}", id);
        if (!productRepository.existsById(id)) {
            throw new ResourceNotFoundException("Produto com ID " + id + " não encontrado");
        }
        productRepository.deleteById(id);
        log.info("Product permanently deleted: {}", id);
    }
    
    /*
      BUSINESS OPERATION - Atualiza estoque
      
      Exemplo de operação de negócio complexa
     */
    @Transactional
    public void updateStock(Long id, int quantity) {
        log.info("Updating stock for product ID: {}, quantity change: {}", id, quantity);
        Product product = findProductEntityById(id);
        product.updateStock(quantity); // Método de domínio
        productRepository.save(product);
        log.info("Stock updated successfully. New stock: {}", product.getStockQuantity());
    }
    
    // BUSINESS OPERATION - Ativa/Desativa produto
    @Transactional
    public void toggleActive(Long id) {
        log.info("Toggling active status for product ID: {}", id);
        Product product = findProductEntityById(id);
        if (product.getActive()) {
            product.deactivate();
            log.info("Product deactivated: {}", id);
        } else {
            product.activate();
            log.info("Product activated: {}", id);
        }
        productRepository.save(product);
    }
    
    // BUSINESS OPERATION - Bulk price update
    @Transactional
    public int bulkPriceUpdate(String categoryName, BigDecimal percentage) {
        log.info("Bulk price update for category: {}, percentage: {}%", categoryName, percentage);
        
        // 1. Buscar a categoria pelo nome (converter String → Category)
        Category category = categoryRepository.findByName(categoryName)
            .orElseThrow(() -> {
                log.warn("Category not found for bulk update: {}", categoryName);
                return new IllegalArgumentException("Categoria não encontrada: " + categoryName);
            });
    
        // 2. Buscar produtos ativos da categoria
        List<Product> products = productRepository.findByActiveTrueAndCategory(category);
        
        if (products.isEmpty()) {
            log.info("No products found in category: {}", categoryName);
            return 0;  // Nenhum produto encontrado
        }
        
        log.info("Found {} products in category: {}", products.size(), categoryName);
    
        // 3. Aplicar novo preço
        for (Product product : products) {
            BigDecimal multiplier = BigDecimal.ONE.add(percentage.divide(new BigDecimal(100)));
            BigDecimal newPrice = product.getPrice().multiply(multiplier);
            BigDecimal oldPrice = product.getPrice();
            product.updatePrice(newPrice);
            log.debug("Product {} price updated: {} → {}", product.getSku(), oldPrice, newPrice);
        }
    
        // 4. Salvar todos
        productRepository.saveAll(products);
        log.info("Bulk price update completed. {} products updated.", products.size());
    
        return products.size();
    }
    
    /*
      Helper method - Busca entity ou lança exceção
      
      POR QUE?
      - Evitar duplicação de código
      - Tratamento consistente de "not found"
      - Útil para métodos que precisam da entity
     */
    private Product findProductEntityById(Long id) {
        return productRepository.findById(id)
            .orElseThrow(() -> {
                log.warn("Product not found with ID: {}", id);
                return new ResourceNotFoundException("Produto com ID " + id + " não encontrado");
            });
    }
}
```

---

## 📄 Arquivo: `spring-lab\src\main\java\com\rojudo\spring_lab\SpringLabApplication.java`

**Caminho completo:** `E:\Projects & Studies\Studies\Spring Boot LAB\spring-lab\src\main\java\com\rojudo\spring_lab\SpringLabApplication.java`
**Tamanho:** 320 bytes
**Extensão:** `.java`

```java
package com.rojudo.spring_lab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringLabApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringLabApplication.class, args);
	}

}
```

---

## 📄 Arquivo: `spring-lab\src\main\java\com\rojudo\spring_lab\validation\UniqueSku.java`

**Caminho completo:** `E:\Projects & Studies\Studies\Spring Boot LAB\spring-lab\src\main\java\com\rojudo\spring_lab\validation\UniqueSku.java`
**Tamanho:** 610 bytes
**Extensão:** `.java`

```java
package com.rojudo.spring_lab.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueSkuValidator.class)
@Documented
public @interface UniqueSku {
    
    String message() default "{product.sku.unique}";
    
    Class<?>[] groups() default {};
    
    Class<? extends Payload>[] payload() default {};
    
    /**
     * Se true, ignora o ID atual (para UPDATE)
     */
    long ignoreId() default 0;
}
```

---

## 📄 Arquivo: `spring-lab\src\main\java\com\rojudo\spring_lab\validation\UniqueSkuValidator.java`

**Caminho completo:** `E:\Projects & Studies\Studies\Spring Boot LAB\spring-lab\src\main\java\com\rojudo\spring_lab\validation\UniqueSkuValidator.java`
**Tamanho:** 1,294 bytes
**Extensão:** `.java`

```java
package com.rojudo.spring_lab.validation;

import com.rojudo.spring_lab.repository.ProductRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UniqueSkuValidator implements ConstraintValidator<UniqueSku, String> {
    
    @Autowired
    private ProductRepository productRepository;
    
    private long ignoreId;
    
    @Override
    public void initialize(UniqueSku constraintAnnotation) {
        this.ignoreId = constraintAnnotation.ignoreId();
    }
    
    @Override
    public boolean isValid(String sku, ConstraintValidatorContext context) {
        if (sku == null || sku.isBlank()) {
            return true; // Deixar @NotBlank lidar com isso
        }
        
        if (ignoreId > 0) {
            // Para UPDATE: verificar se existe outro produto com mesmo SKU
            return productRepository.findBySku(sku)
                .map(product -> product.getId().equals(ignoreId))
                .orElse(true);
        }
        
        // Para CREATE: verificar se SKU já existe
        return !productRepository.existsBySku(sku);
    }
}
```

---

## 📄 Arquivo: `spring-lab\src\main\java\com\rojudo\spring_lab\validation\ValidationGroups.java`

**Caminho completo:** `E:\Projects & Studies\Studies\Spring Boot LAB\spring-lab\src\main\java\com\rojudo\spring_lab\validation\ValidationGroups.java`
**Tamanho:** 337 bytes
**Extensão:** `.java`

```java
package com.rojudo.spring_lab.validation;

public interface ValidationGroups {
    
    // Grupo para operações de CRIAÇÃO
    interface OnCreate {}
    
    // Grupo para operações de ATUALIZAÇÃO
    interface OnUpdate {}
    
    // Grupo para operações de PATCH (atualização parcial)
    interface OnPatch {}
}
```

---

## 📄 Arquivo: `spring-lab\src\main\resources\application-dev.yml`

**Caminho completo:** `E:\Projects & Studies\Studies\Spring Boot LAB\spring-lab\src\main\resources\application-dev.yml`
**Tamanho:** 2,182 bytes
**Extensão:** `.yml`

```yml
# ============================================
# DEVELOPMENT PROFILE
# ============================================
spring:
  config:
    activate:
      on-profile: dev
  
  datasource:
    url: jdbc:postgresql://localhost:5432/springlab_db
    username: springlab_user
    password: springlab_password
    driver-class-name: org.postgresql.Driver
    hikari:
      maximum-pool-size: 10
      minimum-idle: 5
  
  messages:
    basename: validation-messages
    encoding: UTF-8
    fallback-to-system-locale: false

  jpa:
    database-platform: org.hibernate.dialect.PostgreSQLDialect
    hibernate:
      ddl-auto: create-drop
    show-sql: false
    properties:
      hibernate:
        format_sql: true
        use_sql_comments: true
        jdbc:
          batch_size: 20
          fetch_size: 100
        cache:
          use_second_level_cache: false
          use_query_cache: false
        generate_statistics: true
        enable_lazy_load_no_trans: false
  
  security:
    user:
      name: admin
      password: admin123
      roles: ADMIN,USER

  flyway:
    enabled: true
    baseline-on-migrate: true
    baseline-version: 0
    locations: classpath:db/migration
    table: flyway_schema_history
    validate-on-migrate: false
  
  devtools:
    restart:
      enabled: true
      additional-paths:
        - src/main/resources
      exclude:
        - static/**
        - public/**
    livereload:
      enabled: true

logging:
  level:
    com.rojudo.spring_lab: DEBUG
    org.hibernate.SQL: DEBUG
    org.hibernate.type.descriptor.sql.BasicBinder: TRACE
    com.zaxxer.hikari: DEBUG
    org.springframework.jdbc: DEBUG
  pattern:
    console: "%d{yyyy-MM-dd HH:mm:ss.SSS} %clr(%-5level) [%thread] %clr(%logger{36}){cyan} - %msg%n"
    file: "%d{yyyy-MM-dd HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n"
  file:
    name: logs/spring-lab-dev.log
    max-size: 50MB
    max-history: 30
  # Desabilita logs de estatísticas
    org.hibernate.stat: DEBUG
    org.hibernate.engine.internal.StatisticalLoggingSessionEventListener: OFF

data:
  initializer:
    enabled: true
```

---

## 📄 Arquivo: `spring-lab\src\main\resources\application-prod.yml`

**Caminho completo:** `E:\Projects & Studies\Studies\Spring Boot LAB\spring-lab\src\main\resources\application-prod.yml`
**Tamanho:** 899 bytes
**Extensão:** `.yml`

```yml
spring:
  config:
    activate:
      on-profile: prod
  
  datasource:
    url: ${DB_URL:jdbc:postgresql://localhost:5432/springlab_db}
    username: ${DB_USERNAME:springlab_user}
    password: ${DB_PASSWORD:springlab_password}
    hikari:
      maximum-pool-size: ${DB_POOL_MAX:20}
      minimum-idle: ${DB_POOL_MIN:10}
      connection-timeout: 30000
  
  jpa:      
    show-sql: false
    properties:
      hibernate:
        ddl-auto: validate
        jdbc.batch_size: 50
        generate_statistics: false
  
  flyway:
    enabled: true
    baseline-on-migrate: false

server:
  tomcat:
    max-connections: 10000
    threads:
      max: 200
      min-spare: 10

logging:
  level:
    com.rojudo.spring_lab: INFO
    org.springframework.web: WARN
    org.hibernate.SQL: WARN
    org.springframework.jdbc: INFO

data:
  initializer:
    enabled: false
```

---

## 📄 Arquivo: `spring-lab\src\main\resources\application.yml`

**Caminho completo:** `E:\Projects & Studies\Studies\Spring Boot LAB\spring-lab\src\main\resources\application.yml`
**Tamanho:** 1,147 bytes
**Extensão:** `.yml`

```yml
# ============================================
# SHARED CONFIGURATION (DEFAULT)
# ============================================
spring:
  profiles:
    active: dev
  application:
    name: spring-lab
  
  jpa:
    open-in-view: false
  
  jackson:
    default-property-inclusion: non_null
    serialization:
      write-dates-as-timestamps: false
      indent-output: true

# Server Configuration
server:
  port: 8080
  error:
    include-message: always
    include-binding-errors: always
    include-exception: false
    include-stacktrace: never

# OpenAPI Documentation
springdoc:
  api-docs:
    path: /api-docs
    enabled: true
  swagger-ui:
    path: /swagger-ui.html
    enabled: true

# Actuator
management:
  endpoints:
    web:
      exposure:
        include: health,info,metrics
      base-path: /actuator
  endpoint:
    health:
      probes:
        enabled: true # Habilita /liveness e /readiness
      group:
        liveness:
          include: "diskSpace,ping"
        readiness:
          include: "db,diskSpace,ping"
      show-details: always
      show-components: always
```

---

## 📄 Arquivo: `spring-lab\src\main\resources\db\migration\V1__create_products_table.sql`

**Caminho completo:** `E:\Projects & Studies\Studies\Spring Boot LAB\spring-lab\src\main\resources\db\migration\V1__create_products_table.sql`
**Tamanho:** 924 bytes
**Extensão:** `.sql`

```sql
CREATE TABLE IF NOT EXISTS products (
    id BIGSERIAL PRIMARY KEY,
    sku VARCHAR(50) NOT NULL UNIQUE,
    name VARCHAR(200) NOT NULL,
    description TEXT,
    price DECIMAL(10,2) NOT NULL,
    category_id BIGINT,  -- <-- apenas a coluna, sem FK ainda
    stock_quantity INTEGER DEFAULT 0,
    active BOOLEAN DEFAULT TRUE,
    metadata JSONB,
    tags TEXT[],
    search_vector TSVECTOR,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP,
    created_by VARCHAR(100),
    updated_by VARCHAR(100),
    version BIGINT DEFAULT 0,
    CONSTRAINT price_positive CHECK (price > 0),
    CONSTRAINT stock_non_negative CHECK (stock_quantity >= 0)
);

CREATE INDEX idx_products_name ON products(name);
CREATE INDEX idx_products_price ON products(price);
CREATE INDEX idx_products_active ON products(active);
CREATE INDEX idx_products_category_id ON products(category_id);
```

---

## 📄 Arquivo: `spring-lab\src\main\resources\db\migration\V2__create_categories_table.sql`

**Caminho completo:** `E:\Projects & Studies\Studies\Spring Boot LAB\spring-lab\src\main\resources\db\migration\V2__create_categories_table.sql`
**Tamanho:** 973 bytes
**Extensão:** `.sql`

```sql
-- Migration V2: Criar tabela de categorias e relacionar com products
-- Author: Rojudo Spring Lab
-- Date: 2026-04-01

-- 1. Criar tabela de categorias
CREATE TABLE IF NOT EXISTS categories (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL UNIQUE,
    description TEXT,
    parent_id BIGINT,
    active BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP,
    CONSTRAINT fk_categories_parent 
        FOREIGN KEY (parent_id) REFERENCES categories(id) ON DELETE SET NULL
);

-- 2. Criar índices
CREATE INDEX idx_categories_parent ON categories(parent_id);
CREATE INDEX idx_categories_name ON categories(name);

-- 3. Agora que categories existe, adicionar a FK na tabela products
ALTER TABLE products 
    ADD CONSTRAINT fk_products_category 
    FOREIGN KEY (category_id) REFERENCES categories(id) ON DELETE SET NULL;

COMMENT ON TABLE categories IS 'Tabela de categorias de produtos';
```

---

## 📄 Arquivo: `spring-lab\src\main\resources\db\migration\V3__create_product_reviews.sql`

**Caminho completo:** `E:\Projects & Studies\Studies\Spring Boot LAB\spring-lab\src\main\resources\db\migration\V3__create_product_reviews.sql`
**Tamanho:** 1,645 bytes
**Extensão:** `.sql`

```sql
-- Migration V3: Criar tabela de avaliações
-- Author: Rojudo Spring Lab
-- Date: 2026-04-01

-- Tabela de avaliações de produtos
CREATE TABLE IF NOT EXISTS product_reviews (
    id BIGSERIAL PRIMARY KEY,
    product_id BIGINT NOT NULL,
    rating INTEGER NOT NULL,
    comment TEXT,
    reviewer_name VARCHAR(100),
    reviewer_email VARCHAR(255),
    verified_purchase BOOLEAN DEFAULT FALSE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP,
    
    -- Constraints
    CONSTRAINT fk_reviews_product 
        FOREIGN KEY (product_id) REFERENCES products(id) ON DELETE CASCADE,
    CONSTRAINT chk_rating_range CHECK (rating BETWEEN 1 AND 5)
);

-- Índices
CREATE INDEX idx_reviews_product_id ON product_reviews(product_id);
CREATE INDEX idx_reviews_rating ON product_reviews(rating);
CREATE INDEX idx_reviews_created_at ON product_reviews(created_at);

-- View para estatísticas de produtos
CREATE OR REPLACE VIEW product_statistics AS
SELECT 
    p.id,
    p.sku,
    p.name,
    p.price,
    p.stock_quantity,
    c.name AS category_name,
    COUNT(r.id) AS total_reviews,
    COALESCE(AVG(r.rating), 0) AS avg_rating,
    COUNT(CASE WHEN r.rating >= 4 THEN 1 END) AS positive_reviews,
    ROUND(COALESCE(AVG(r.rating), 0) * 20, 2) AS satisfaction_percentage
FROM products p
LEFT JOIN categories c ON p.category_id = c.id
LEFT JOIN product_reviews r ON p.id = r.product_id
WHERE p.active = true
GROUP BY p.id, p.sku, p.name, p.price, p.stock_quantity, c.name;

COMMENT ON VIEW product_statistics IS 'Visão agregada com estatísticas de produtos e avaliações';
```

---

## 📄 Arquivo: `spring-lab\src\main\resources\db\migration\V4__create_security_tables.sql`

**Caminho completo:** `E:\Projects & Studies\Studies\Spring Boot LAB\spring-lab\src\main\resources\db\migration\V4__create_security_tables.sql`
**Tamanho:** 2,803 bytes
**Extensão:** `.sql`

```sql
-- Migration V4: Security tables
-- Author: Rojudo Spring Lab
-- Date: 2026-04-01

-- Tabela de usuários
CREATE TABLE IF NOT EXISTS users (
    id BIGSERIAL PRIMARY KEY,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL,
    full_name VARCHAR(100) NOT NULL,
    phone VARCHAR(20),
    active BOOLEAN DEFAULT TRUE,
    email_verified BOOLEAN DEFAULT FALSE,
    last_login TIMESTAMP,
    failed_attempts INTEGER DEFAULT 0,
    account_locked BOOLEAN DEFAULT FALSE,
    lock_expiry TIMESTAMP,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP,
    
    CONSTRAINT uk_users_email UNIQUE (email),
    CONSTRAINT chk_email_format CHECK (email ~* '^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}$')
);

-- Tabela de papéis
CREATE TABLE IF NOT EXISTS roles (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL UNIQUE,
    description VARCHAR(100),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP,
    
    CONSTRAINT uk_roles_name UNIQUE (name)
);

-- Tabela de permissões
CREATE TABLE IF NOT EXISTS permissions (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL UNIQUE,
    description VARCHAR(200),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    
    CONSTRAINT uk_permissions_name UNIQUE (name)
);

-- Relacionamento usuário-papel
CREATE TABLE IF NOT EXISTS user_roles (
    user_id BIGINT NOT NULL,
    role_id BIGINT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    
    PRIMARY KEY (user_id, role_id),
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
    FOREIGN KEY (role_id) REFERENCES roles(id) ON DELETE CASCADE
);

-- Relacionamento papel-permissão
CREATE TABLE IF NOT EXISTS role_permissions (
    role_id BIGINT NOT NULL,
    permission_id BIGINT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    
    PRIMARY KEY (role_id, permission_id),
    FOREIGN KEY (role_id) REFERENCES roles(id) ON DELETE CASCADE,
    FOREIGN KEY (permission_id) REFERENCES permissions(id) ON DELETE CASCADE
);

-- Índices
CREATE INDEX idx_users_email ON users(email);
CREATE INDEX idx_users_active ON users(active);
CREATE INDEX idx_users_account_locked ON users(account_locked);
CREATE INDEX idx_roles_name ON roles(name);
CREATE INDEX idx_permissions_name ON permissions(name);

-- Comentários
COMMENT ON TABLE users IS 'Usuários do sistema';
COMMENT ON TABLE roles IS 'Papéis de autorização (RBAC)';
COMMENT ON TABLE permissions IS 'Permissões granulares do sistema';
COMMENT ON COLUMN users.failed_attempts IS 'Número de tentativas de login falhas consecutivas';
COMMENT ON COLUMN users.account_locked IS 'Indica se a conta está bloqueada por segurança';
```

---

## 📄 Arquivo: `spring-lab\src\main\resources\logback-spring.xml`

**Caminho completo:** `E:\Projects & Studies\Studies\Spring Boot LAB\spring-lab\src\main\resources\logback-spring.xml`
**Tamanho:** 4,375 bytes
**Extensão:** `.xml`

```xml
<?xml version="1.0" encoding="UTF-8"?>
<configuration scan="true" scanPeriod="30 seconds">

    <!-- ============================================ -->
    <!-- PROPRIEDADES GLOBAIS                        -->
    <!-- ============================================ -->
    <property name="LOG_PATTERN" value="%d{yyyy-MM-dd HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n"/>
    <property name="LOG_PATTERN_COLOR" value="%d{yyyy-MM-dd HH:mm:ss.SSS} %highlight(%-5level) [%thread] %cyan(%logger{36}) - %msg%n"/>
    <property name="LOG_PATH" value="${LOG_PATH:-./logs}"/>
    <property name="APP_NAME" value="spring-lab"/>

    <!-- ============================================ -->
    <!-- CONSOLE APPENDER (COM CORES)                -->
    <!-- ============================================ -->
    <appender name="CONSOLE" class="ch.qos.logback.core.ConsoleAppender">
        <encoder>
            <pattern>${LOG_PATTERN_COLOR}</pattern>
            <charset>UTF-8</charset>
        </encoder>
    </appender>

    <!-- ============================================ -->
    <!-- FILE APPENDER (ROTAÇÃO DIÁRIA)              -->
    <!-- ============================================ -->
    <appender name="FILE" class="ch.qos.logback.core.rolling.RollingFileAppender">
        <file>${LOG_PATH}/${APP_NAME}.log</file>
        <encoder>
            <pattern>${LOG_PATTERN}</pattern>
            <charset>UTF-8</charset>
        </encoder>
        <rollingPolicy class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
            <fileNamePattern>${LOG_PATH}/${APP_NAME}.%d{yyyy-MM-dd}.log.gz</fileNamePattern>
            <maxHistory>30</maxHistory>
            <totalSizeCap>1GB</totalSizeCap>
        </rollingPolicy>
    </appender>

    <!-- ============================================ -->
    <!-- AUDIT APPENDER (ERROS E OPERAÇÕES CRÍTICAS) -->
    <!-- ============================================ -->
    <appender name="AUDIT_FILE" class="ch.qos.logback.core.rolling.RollingFileAppender">
        <file>${LOG_PATH}/audit.log</file>
        <encoder>
            <pattern>%d{yyyy-MM-dd HH:mm:ss.SSS} %msg%n</pattern>
        </encoder>
        <rollingPolicy class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
            <fileNamePattern>${LOG_PATH}/audit.%d{yyyy-MM-dd}.log.gz</fileNamePattern>
            <maxHistory>90</maxHistory>
        </rollingPolicy>
    </appender>

    <!-- ============================================ -->
    <!-- LOGGERS POR PERFIL                           -->
    <!-- ============================================ -->

    <!-- PERFIL DEV: Log completo -->
    <springProfile name="dev">
        <logger name="com.rojudo.spring_lab" level="DEBUG" additivity="false">
            <appender-ref ref="CONSOLE"/>
            <appender-ref ref="FILE"/>
        </logger>
        <logger name="org.springframework.web" level="DEBUG"/>
        <logger name="org.hibernate.SQL" level="DEBUG"/>
        <logger name="org.hibernate.type" level="TRACE"/>
        <root level="INFO">
            <appender-ref ref="CONSOLE"/>
            <appender-ref ref="FILE"/>
        </root>
    </springProfile>

    <!-- PERFIL PROD: Log mínimo -->
    <springProfile name="prod">
        <logger name="com.rojudo.spring_lab" level="INFO" additivity="false">
            <appender-ref ref="FILE"/>
        </logger>
        <logger name="org.springframework.web" level="WARN"/>
        <logger name="org.hibernate.SQL" level="WARN"/>
        <root level="WARN">
            <appender-ref ref="FILE"/>
        </root>
    </springProfile>

    <!-- PERFIL PADRÃO (sem perfil ativo) -->
    <springProfile name="default">
        <logger name="com.rojudo.spring_lab" level="INFO">
            <appender-ref ref="CONSOLE"/>
            <appender-ref ref="FILE"/>
        </logger>
        <root level="INFO">
            <appender-ref ref="CONSOLE"/>
            <appender-ref ref="FILE"/>
        </root>
    </springProfile>

    <!-- ============================================ -->
    <!-- LOGGER DE AUDITORIA                          -->
    <!-- ============================================ -->
    <logger name="AUDIT" level="INFO" additivity="false">
        <appender-ref ref="AUDIT_FILE"/>
    </logger>

</configuration>
```

---

## 📄 Arquivo: `spring-lab\src\main\resources\validation-messages.properties`

**Caminho completo:** `E:\Projects & Studies\Studies\Spring Boot LAB\spring-lab\src\main\resources\validation-messages.properties`
**Tamanho:** 1,559 bytes
**Extensão:** `.properties`

```properties
# ============================================
# VALIDATION MESSAGES
# ============================================

# Product Validation
product.sku.notblank=O SKU é obrigatório
product.sku.size=O SKU deve ter entre {min} e {max} caracteres
product.sku.pattern=O SKU deve conter apenas letras maiúsculas, números e hífen
product.sku.unique=Já existe um produto com o SKU {sku}

product.name.notblank=O nome do produto é obrigatório
product.name.size=O nome deve ter entre {min} e {max} caracteres

product.description.size=A descrição deve ter no máximo {max} caracteres

product.price.notnull=O preço é obrigatório
product.price.min=O preço deve ser maior que {value}
product.price.max=O preço excede o limite permitido de {value}

product.category.size=A categoria deve ter no máximo {max} caracteres

product.stock.min=A quantidade em estoque não pode ser negativa
product.stock.max=A quantidade em estoque excede o limite de {value}

# Auth Validation
auth.email.notblank=O email é obrigatório
auth.email.invalid=Email inválido
auth.email.exists=Já existe uma conta com este email

auth.password.notblank=A senha é obrigatória
auth.password.size=A senha deve ter no mínimo {min} caracteres
auth.password.pattern=A senha deve conter pelo menos uma letra maiúscula, uma minúscula, um número e um caractere especial

auth.fullname.notblank=O nome é obrigatório
auth.fullname.size=O nome deve ter entre {min} e {max} caracteres

auth.phone.size=O telefone deve ter no máximo {max} caracteres
```

---

## 📄 Arquivo: `spring-lab\src\test\java\com\rojudo\spring_lab\config\TestConfig.java`

**Caminho completo:** `E:\Projects & Studies\Studies\Spring Boot LAB\spring-lab\src\test\java\com\rojudo\spring_lab\config\TestConfig.java`
**Tamanho:** 715 bytes
**Extensão:** `.java`

```java
package com.rojudo.spring_lab.config;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import com.rojudo.spring_lab.validation.UniqueSkuValidator;

@TestConfiguration
public class TestConfig {

    @Bean
    @Primary  // Substitui o bean real nos testes
    public UniqueSkuValidator mockUniqueSkuValidator() {
        return new UniqueSkuValidator() {
            @Override
            public boolean isValid(String sku, jakarta.validation.ConstraintValidatorContext context) {
                return true;  // Sempre válido nos testes
            }
        };
    }
}
```

---

## 📄 Arquivo: `spring-lab\src\test\java\com\rojudo\spring_lab\controller\ProductControllerTest.java`

**Caminho completo:** `E:\Projects & Studies\Studies\Spring Boot LAB\spring-lab\src\test\java\com\rojudo\spring_lab\controller\ProductControllerTest.java`
**Tamanho:** 505 bytes
**Extensão:** `.java`

```java
package com.rojudo.spring_lab.controller;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
@Disabled("Docker não disponível - executar testes de Service e Repository apenas")
class ProductControllerTest {

    @Test
    void contextLoads() {
        // Teste mínimo para validação do contexto
    }
}
```

---

## 📄 Arquivo: `spring-lab\src\test\java\com\rojudo\spring_lab\repository\ProductRepositoryTest.java`

**Caminho completo:** `E:\Projects & Studies\Studies\Spring Boot LAB\spring-lab\src\test\java\com\rojudo\spring_lab\repository\ProductRepositoryTest.java`
**Tamanho:** 5,977 bytes
**Extensão:** `.java`

```java
package com.rojudo.spring_lab.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ActiveProfiles;

import com.rojudo.spring_lab.domain.Category;
import com.rojudo.spring_lab.domain.Product;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)  // Usa banco REAL
@ActiveProfiles("dev")  // Usa configurações do application-dev.yml (localhost:5432)
@DisplayName("ProductRepository - Testes com PostgreSQL do Docker Compose")
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private TestEntityManager entityManager;

    private Category category;
    private Product product;

    @BeforeEach
    void setUp() {
        // Cria e persiste uma categoria
        category = new Category("Eletrônicos", "Produtos eletrônicos");
        category = categoryRepository.save(category);

        // Cria um produto associado à categoria
        product = new Product("SKU-TEST-001", "Notebook Teste", new BigDecimal("2500.00"));
        product.setDescription("Notebook para testes");
        product.setCategory(category);
        product.setStockQuantity(10);
        product = productRepository.save(product);
        
        entityManager.flush();
        entityManager.clear();
    }

    @Nested
    @DisplayName("Queries derivadas (Spring Data)")
    class DerivedQueriesTests {

        @Test
        @DisplayName("findBySku - Deve encontrar produto por SKU")
        void shouldFindProductBySku() {
            Optional<Product> found = productRepository.findBySku("SKU-TEST-001");
            assertThat(found).isPresent();
            assertThat(found.get().getName()).isEqualTo("Notebook Teste");
        }

        @Test
        @DisplayName("existsBySku - Deve retornar true para SKU existente")
        void shouldReturnTrueWhenSkuExists() {
            boolean exists = productRepository.existsBySku("SKU-TEST-001");
            assertThat(exists).isTrue();
        }

        @Test
        @DisplayName("existsBySku - Deve retornar false para SKU inexistente")
        void shouldReturnFalseWhenSkuDoesNotExist() {
            boolean exists = productRepository.existsBySku("SKU-INEXISTENTE");
            assertThat(exists).isFalse();
        }

        @Test
        @DisplayName("findByActiveTrue - Deve retornar apenas produtos ativos")
        void shouldReturnOnlyActiveProducts() {
            Pageable pageable = PageRequest.of(0, 10);
            product.setActive(false);
            productRepository.save(product);
            entityManager.flush();
            entityManager.clear();

            Page<Product> activeProducts = productRepository.findByActiveTrue(pageable);
            assertThat(activeProducts.getContent()).isEmpty();
        }
    }

    @Nested
    @DisplayName("Queries JPQL customizadas")
    class JpqlQueriesTests {

        @Test
        @DisplayName("findByPriceRange - Deve encontrar produtos na faixa de preço")
        void shouldFindProductsInPriceRange() {
            Pageable pageable = PageRequest.of(0, 10);
            Page<Product> result = productRepository.findByPriceRange(
                new BigDecimal("2000.00"), 
                new BigDecimal("3000.00"), 
                pageable
            );
            assertThat(result.getContent()).hasSize(1);
        }

        @Test
        @DisplayName("findLowStockProducts - Deve encontrar produtos com estoque baixo")
        void shouldFindLowStockProducts() {
            product.setStockQuantity(3);
            productRepository.save(product);
            List<Product> lowStock = productRepository.findLowStockProducts(5);
            assertThat(lowStock).hasSize(1);
        }
    }

    @Nested
    @DisplayName("Constraints e validações de banco")
    class ConstraintsTests {

        @Test
        @DisplayName("SKU único - Não deve permitir duplicação")
        void shouldNotAllowDuplicateSku() {
            Product duplicate = new Product("SKU-TEST-001", "Produto Duplicado", new BigDecimal("100.00"));
            assertThatThrownBy(() -> productRepository.saveAndFlush(duplicate))
                .isInstanceOf(org.springframework.dao.DataIntegrityViolationException.class);
        }
    }

    @Nested
    @DisplayName("Paginação e ordenação")
    class PaginationTests {

        @Test
        @DisplayName("Deve paginar resultados corretamente")
        void shouldPaginateResults() {
            for (int i = 1; i <= 5; i++) {
                Product p = new Product("SKU-PAGE-" + i, "Produto " + i, new BigDecimal("100.00"));
                p.setCategory(category);
                productRepository.save(p);
            }
            entityManager.flush();
            entityManager.clear();

            Pageable firstPage = PageRequest.of(0, 3);
            Page<Product> page = productRepository.findAll(firstPage);
            assertThat(page.getContent()).hasSize(3);
        }
    }
}
```

---

## 📄 Arquivo: `spring-lab\src\test\java\com\rojudo\spring_lab\resources\application-test.yml`

**Caminho completo:** `E:\Projects & Studies\Studies\Spring Boot LAB\spring-lab\src\test\java\com\rojudo\spring_lab\resources\application-test.yml`
**Tamanho:** 572 bytes
**Extensão:** `.yml`

```yml
spring:
  datasource:
    url: jdbc:tc:postgresql:16-alpine:///testdb?TC_IMAGE_TAG=16-alpine
    username: test
    password: test
    driver-class-name: org.testcontainers.jdbc.ContainerDatabaseDriver
  
  jpa:
    database-platform: org.hibernate.dialect.PostgreSQLDialect
    hibernate:
      ddl-auto: create-drop
    show-sql: false
  
  flyway:
    enabled: false  # Desabilita Flyway, o Hibernate cria as tabelas

jwt:
  secret: 404E635266556A586E3272357538782F413F4428472B4B6250645367566B5970
  expiration: 3600000
  refresh-expiration: 86400000
```

---

## 📄 Arquivo: `spring-lab\src\test\java\com\rojudo\spring_lab\resources\testcontainers.properties`

**Caminho completo:** `E:\Projects & Studies\Studies\Spring Boot LAB\spring-lab\src\test\java\com\rojudo\spring_lab\resources\testcontainers.properties`
**Tamanho:** 169 bytes
**Extensão:** `.properties`

```properties
# Configura\u00e7\u00e3o para Windows com Docker Desktop
docker.host=tcp://localhost:2375
docker.tls.verify=false
testcontainers.reuse.enable=true
ryuk.disabled=true
```

---

## 📄 Arquivo: `spring-lab\src\test\java\com\rojudo\spring_lab\service\ProductServiceTest.java`

**Caminho completo:** `E:\Projects & Studies\Studies\Spring Boot LAB\spring-lab\src\test\java\com\rojudo\spring_lab\service\ProductServiceTest.java`
**Tamanho:** 8,323 bytes
**Extensão:** `.java`

```java
package com.rojudo.spring_lab.service;

import com.rojudo.spring_lab.domain.Category;
import com.rojudo.spring_lab.domain.Product;
import com.rojudo.spring_lab.dto.request.ProductRequest;
import com.rojudo.spring_lab.dto.response.ProductResponse;
import com.rojudo.spring_lab.exception.ResourceNotFoundException;
import com.rojudo.spring_lab.mapper.ProductMapper;
import com.rojudo.spring_lab.repository.CategoryRepository;
import com.rojudo.spring_lab.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)  // Habilita mocks do Mockito no JUnit 5
@DisplayName("ProductService - Testes de Unidade")
class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @Mock
    private ProductMapper productMapper;

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks  // Cria instância do ProductService e injeta os mocks
    private ProductService productService;

    private Product product;
    private ProductRequest request;
    private ProductResponse response;
    private Category category;

    @BeforeEach  // Executa antes de cada teste
    void setUp() {
        category = new Category("Eletrônicos");
        setIdViaReflection(category, 1L);

        product = new Product("SKU-001", "Notebook", new BigDecimal("3500.00"));
        setIdViaReflection(product, 1L);
        product.setCategory(category);

        request = new ProductRequest(
            "SKU-001", "Notebook", "Notebook Gamer",
            new BigDecimal("3500.00"), "Eletrônicos", 10
        );

        response = ProductResponse.builder()
            .id(1L)
            .sku("SKU-001")
            .name("Notebook")
            .price(new BigDecimal("3500.00"))
            .category("Eletrônicos")
            .stockQuantity(10)
            .build();
    }

    // Método auxiliar para definir ID via reflexão (apenas para testes)
    private void setIdViaReflection(Object entity, Long id) {
        try {
            var field = entity.getClass().getDeclaredField("id");
            field.setAccessible(true);
            field.set(entity, id);
        } catch (Exception e) {
            throw new RuntimeException("Não foi possível definir ID via reflexão", e);
        }
    }

    // ===== TESTES DE CRIAÇÃO (CREATE) =====
    
    @Nested
    @DisplayName("Testes do método create()")
    class CreateTests {

        @Test
        @DisplayName("Deve criar produto com sucesso quando SKU é único")
        void shouldCreateProductWhenSkuIsUnique() {
            // Arrange (preparação)
            when(productRepository.existsBySku(anyString())).thenReturn(false);
            when(categoryRepository.findByName("Eletrônicos")).thenReturn(Optional.of(category));
            when(productMapper.toEntity(request)).thenReturn(product);
            when(productRepository.save(any(Product.class))).thenReturn(product);
            when(productMapper.toResponse(product)).thenReturn(response);

            // Act (execução)
            ProductResponse result = productService.create(request);

            // Assert (verificação)
            assertThat(result).isNotNull();
            assertThat(result.sku()).isEqualTo("SKU-001");
            verify(productRepository, times(1)).save(product);
        }

        @Test
        @DisplayName("Deve lançar exceção quando SKU já existe")
        void shouldThrowExceptionWhenSkuAlreadyExists() {
            when(productRepository.existsBySku("SKU-001")).thenReturn(true);

            assertThatThrownBy(() -> productService.create(request))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Produto com SKU SKU-001 já existe");

            verify(productRepository, never()).save(any());
        }

        @Test
        @DisplayName("Deve lançar exceção quando categoria não existe")
        void shouldThrowExceptionWhenCategoryNotFound() {
            when(productRepository.existsBySku(anyString())).thenReturn(false);
            when(categoryRepository.findByName("Eletrônicos")).thenReturn(Optional.empty());

            assertThatThrownBy(() -> productService.create(request))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Categoria não encontrada");
        }
    }

    // ===== TESTES DE LEITURA (READ) =====
    
    @Nested
    @DisplayName("Testes do método findById()")
    class FindByIdTests {

        @Test
        @DisplayName("Deve retornar produto quando ID existe")
        void shouldReturnProductWhenIdExists() {
            when(productRepository.findById(1L)).thenReturn(Optional.of(product));
            when(productMapper.toResponse(product)).thenReturn(response);

            ProductResponse result = productService.findById(1L);

            assertThat(result).isNotNull();
            assertThat(result.id()).isEqualTo(1L);
        }

        @Test
        @DisplayName("Deve lançar ResourceNotFoundException quando ID não existe")
        void shouldThrowNotFoundWhenIdDoesNotExist() {
            when(productRepository.findById(999L)).thenReturn(Optional.empty());

            assertThatThrownBy(() -> productService.findById(999L))
                .isInstanceOf(ResourceNotFoundException.class)
                .hasMessageContaining("Produto com ID 999 não encontrado");
        }
    }

    // ===== TESTES DE ATUALIZAÇÃO DE ESTOQUE =====
    
    @Nested
    @DisplayName("Testes do método updateStock()")
    class UpdateStockTests {

        @Test
        @DisplayName("Deve aumentar estoque com sucesso")
        void shouldIncreaseStockSuccessfully() {
            product.setStockQuantity(10);
            when(productRepository.findById(1L)).thenReturn(Optional.of(product));

            productService.updateStock(1L, 5);

            assertThat(product.getStockQuantity()).isEqualTo(15);
            verify(productRepository).save(product);
        }

        @Test
        @DisplayName("Deve lançar exceção quando estoque fica negativo")
        void shouldThrowExceptionWhenStockGoesNegative() {
            product.setStockQuantity(3);
            when(productRepository.findById(1L)).thenReturn(Optional.of(product));

            assertThatThrownBy(() -> productService.updateStock(1L, -10))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("Estoque insuficiente");
        }
    }

    // ===== TESTES DE BUSCA COM PAGINAÇÃO =====
    
    @Nested
    @DisplayName("Testes de paginação")
    class PaginationTests {

        @Test
        @DisplayName("Deve retornar página de produtos ativos")
        void shouldReturnPageOfActiveProducts() {
            Pageable pageable = PageRequest.of(0, 10);
            Page<Product> productPage = new PageImpl<>(List.of(product));
            Page<ProductResponse> responsePage = new PageImpl<>(List.of(response));

            when(productRepository.findByActiveTrue(pageable)).thenReturn(productPage);
            when(productMapper.toResponse(any(Product.class))).thenReturn(response);

            Page<ProductResponse> result = productService.findActiveProducts(pageable);

            assertThat(result).isNotNull();
            assertThat(result.getContent()).hasSize(1);
        }
    }
}
```

---

## 📄 Arquivo: `spring-lab\src\test\java\com\rojudo\spring_lab\SpringLabApplicationTests.java`

**Caminho completo:** `E:\Projects & Studies\Studies\Spring Boot LAB\spring-lab\src\test\java\com\rojudo\spring_lab\SpringLabApplicationTests.java`
**Tamanho:** 216 bytes
**Extensão:** `.java`

```java
package com.rojudo.spring_lab;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringLabApplicationTests {

	@Test
	void contextLoads() {
	}

}
```

