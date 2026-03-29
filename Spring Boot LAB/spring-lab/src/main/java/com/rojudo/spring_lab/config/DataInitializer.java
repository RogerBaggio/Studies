package com.rojudo.spring_lab.config;

import com.rojudo.spring_lab.model.Product;
import com.rojudo.spring_lab.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/*
  DATA INITIALIZER
  
  Executado automaticamente após a aplicação iniciar
  Util para:
  - Popular dados de desenvolvimento
  - Criar usuários administrativos
  - Inicializar configurações padrão
  - Testes de carga iniciais
  
  @Profile("dev") - Só executa em ambiente de desenvolvimento
 */
@Component
@Profile("dev") // Executa apenas quando o profile "dev" está ativo
public class DataInitializer implements CommandLineRunner {
    
    private static final Logger logger = LoggerFactory.getLogger(DataInitializer.class);
    
    private final ProductRepository productRepository;
    
    @Autowired
    public DataInitializer(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    
    // Método executado após a aplicação iniciar
    @Override
    public void run(String... args) throws Exception {
        logger.info("🚀 Iniciando DataInitializer...");
        
        // Verifica se já existem dados
        if (productRepository.count() > 0) {
            logger.info("Banco já possui {} produtos. Pulando inicialização.", productRepository.count());
            return;
        }
        
        // Cria produtos de exemplo
        createSampleProducts();
        
        logger.info("DataInitializer finalizado com sucesso!");
    }
    
    //Cria produtos de exemplo
    private void createSampleProducts() {
        logger.info("Criando produtos de exemplo...");
        
        // Eletrônicos
        Product notebook = new Product("NOTE-DELL-XPS13", "Notebook Dell XPS 13", new BigDecimal("7899.99"));
        notebook.setDescription("Notebook Dell XPS 13, Intel Core i7, 16GB RAM, 512GB SSD, Windows 11");
        notebook.setCategory("Eletrônicos");
        notebook.setStockQuantity(15);
        
        Product macbook = new Product("MAC-MBA-M1", "MacBook Air M1", new BigDecimal("8999.99"));
        macbook.setDescription("MacBook Air com chip M1, 8GB RAM, 256GB SSD");
        macbook.setCategory("Eletrônicos");
        macbook.setStockQuantity(10);
        
        Product monitor = new Product("MON-DELL-U2723", "Monitor Dell UltraSharp U2723", new BigDecimal("3299.99"));
        monitor.setDescription("Monitor 27 polegadas, 4K, USB-C, 60Hz");
        monitor.setCategory("Eletrônicos");
        monitor.setStockQuantity(8);
        
        // Acessórios
        Product mouse = new Product("MOU-LOG-MX3", "Mouse Logitech MX Master 3S", new BigDecimal("549.99"));
        mouse.setDescription("Mouse sem fio, ergonômico, 3 dispositivos, silencioso");
        mouse.setCategory("Acessórios");
        mouse.setStockQuantity(50);
        
        Product teclado = new Product("TEC-KEY-K2", "Teclado Keychron K2", new BigDecimal("699.99"));
        teclado.setDescription("Teclado mecânico, wireless, RGB, 75%");
        teclado.setCategory("Acessórios");
        teclado.setStockQuantity(25);
        
        Product webcam = new Product("WEBCAM-LOG-C920", "Webcam Logitech C920", new BigDecimal("399.99"));
        webcam.setDescription("Webcam Full HD, microfone integrado, gravação 1080p");
        webcam.setCategory("Acessórios");
        webcam.setStockQuantity(12);
        
        // Periféricos
        Product headset = new Product("HEAD-SON-WH4", "Headset Sony WH-1000XM4", new BigDecimal("1899.99"));
        headset.setDescription("Headset com cancelamento de ruído, Bluetooth, 30h de bateria");
        headset.setCategory("Áudio");
        headset.setStockQuantity(20);
        
        Product caixaSom = new Product("SPK-JBL-FLIP6", "Caixa de Som JBL Flip 6", new BigDecimal("599.99"));
        caixaSom.setDescription("Caixa de som Bluetooth, resistente à água, 12h de bateria");
        caixaSom.setCategory("Áudio");
        caixaSom.setStockQuantity(30);
        
        // Armazena todos os produtos
        List<Product> products = Arrays.asList(
            notebook, macbook, monitor,
            mouse, teclado, webcam,
            headset, caixaSom
        );
        
        // Salva no banco de dados
        List<Product> savedProducts = productRepository.saveAll(products);
        
        logger.info("{} produtos criados com sucesso!", savedProducts.size());
        
        // Log detalhado dos produtos criados
        savedProducts.forEach(product -> {
            logger.debug("   - ID: {}, SKU: {}, Nome: {}, Preço: R$ {}",
                product.getId(),
                product.getSku(),
                product.getName(),
                product.getPrice()
            );
        });
    }
    
}