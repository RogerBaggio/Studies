package com.rojudo.spring_lab.config;

import com.rojudo.spring_lab.model.Category;
import com.rojudo.spring_lab.model.Permission;
import com.rojudo.spring_lab.model.Product;
import com.rojudo.spring_lab.model.Role;
import com.rojudo.spring_lab.model.User;
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