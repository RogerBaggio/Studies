package com.rojudo.spring_lab.config;

import com.rojudo.spring_lab.model.Product;
import com.rojudo.spring_lab.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
  DATA INITIALIZER
  
  Executado automaticamente após a aplicação iniciar
  Util para:
  - Popular dados de desenvolvimento
  - Criar usuários administrativos
  - Inicializar configurações padrão
  - Testes de carga iniciais
  
  @Profile("dev") - Para só executar em ambiente de desenvolvimento etc...
 */
@Component
@Profile("!test")  // Não executa em testes
public class DataInitializer implements CommandLineRunner {
    
    private static final Logger log = LoggerFactory.getLogger(DataInitializer.class);
    
    @Autowired
    private ProductRepository productRepository;
    
    @Value("${app.data.initialize:true}")
    private boolean shouldInitialize;
    
    @Value("${app.data.load-sample:true}")
    private boolean loadSampleData;
    
    @Override
    @Transactional
    public void run(String... args) {
        if (!shouldInitialize) {
            log.info("Data initialization disabled");
            return;
        }
        
        long count = productRepository.count();
        if (count > 0) {
            log.info("Database already contains {} products. Skipping initialization.", count);
            return;
        }
        
        log.info("Initializing database with sample data...");
        
        if (loadSampleData) {
            loadSampleProducts();
        }
        
        log.info("✅ Database initialized with {} products", productRepository.count());
    }
    
    private void loadSampleProducts() {
        List<Product> products = Arrays.asList(
            createProduct("NOTE-001", "Notebook Dell XPS 13", 
                "Notebook Dell XPS 13, Intel Core i7, 16GB RAM, 512GB SSD", 
                new BigDecimal("4599.99"), "Eletrônicos", 15,
                new String[]{"notebook", "dell", "premium"},
                createMetadata("color", "prata", "warranty", "12 meses")),
            
            createProduct("MOUSE-001", "Mouse Logitech MX Master 3S", 
                "Mouse sem fio, ergonômico, 8K DPI, compatível com Mac e Windows",
                new BigDecimal("349.90"), "Acessórios", 50,
                new String[]{"mouse", "logitech", "wireless"},
                createMetadata("color", "preto", "battery", "70 dias")),
            
            createProduct("MON-001", "Monitor Dell UltraSharp U2723QE", 
                "Monitor 27 polegadas, 4K, USB-C Hub, 100% sRGB",
                new BigDecimal("3299.00"), "Eletrônicos", 8,
                new String[]{"monitor", "dell", "4k", "usb-c"},
                createMetadata("resolution", "4K", "size", "27 polegadas")),
            
            createProduct("TEC-001", "Teclado Keychron K2 V2", 
                "Teclado mecânico, wireless, RGB, switches Gateron",
                new BigDecimal("599.00"), "Acessórios", 25,
                new String[]{"teclado", "keychron", "mecânico"},
                createMetadata("layout", "75%", "switches", "Gateron Red")),
            
            createProduct("WEBCAM-001", "Webcam Logitech C920s", 
                "Webcam Full HD 1080p, microfone estéreo, proteção de privacidade",
                new BigDecimal("399.90"), "Acessórios", 30,
                new String[]{"webcam", "logitech", "1080p"},
                createMetadata("resolution", "1080p", "fov", "78°"))
        );
        
        productRepository.saveAll(products);
        log.debug("Saved {} products", products.size());
    }
    
    private Product createProduct(String sku, String name, String description, 
                                  BigDecimal price, String category, int stock,
                                  String[] tags, Map<String, Object> metadata) {
        Product product = new Product(sku, name, price);
        product.setDescription(description);
        product.setCategory(category);
        product.setStockQuantity(stock);
        product.setTags(tags);
        product.setMetadata(metadata);
        return product;
    }
    
    private Map<String, Object> createMetadata(Object... pairs) {
        Map<String, Object> metadata = new HashMap<>();
        for (int i = 0; i < pairs.length; i += 2) {
            metadata.put(pairs[i].toString(), pairs[i + 1]);
        }
        return metadata;
    }
}