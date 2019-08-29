package guru.koksoya.spring5webfluxrest.bootstrap;

import guru.koksoya.spring5webfluxrest.domain.Category;
import guru.koksoya.spring5webfluxrest.domain.Vendor;
import guru.koksoya.spring5webfluxrest.repositories.CategoryRepository;
import guru.koksoya.spring5webfluxrest.repositories.VendorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final VendorRepository vendorRepository;

    public Bootstrap(CategoryRepository categoryRepository, VendorRepository vendorRepository) {
        this.categoryRepository = categoryRepository;
        this.vendorRepository = vendorRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        if (categoryRepository.count().block() == 0) {
            //load data
            System.out.println("##### LOADING DATA ON BOOTSTRAP #####");

            loadCategory();
            loadVendors();
        }
    }

    private void loadVendors() {
        vendorRepository.save(Vendor.builder()
                .firstName("John")
                .lastName("Doe").build()).block();

        vendorRepository.save(Vendor.builder()
                .firstName("Berat")
                .lastName("Köksoya").build()).block();

        vendorRepository.save(Vendor.builder()
                .firstName("Amy")
                .lastName("Winehouse").build()).block();

        vendorRepository.save(Vendor.builder()
                .firstName("Michael")
                .lastName("Ballack").build()).block();

        System.out.println("Loaded Vendors: " + vendorRepository.count().block());
    }

    private void loadCategory() {
        categoryRepository.save(Category.builder()
                .description("Nuts").build()).block();

        categoryRepository.save(Category.builder()
                .description("Fruits").build()).block();

        categoryRepository.save(Category.builder()
                .description("Breads").build()).block();

        categoryRepository.save(Category.builder()
                .description("Meats").build()).block();

        System.out.println("Loaded Categories: " + categoryRepository.count().block());
    }
}
