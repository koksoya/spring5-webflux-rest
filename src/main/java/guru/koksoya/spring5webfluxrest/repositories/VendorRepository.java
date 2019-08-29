package guru.koksoya.spring5webfluxrest.repositories;

import guru.koksoya.spring5webfluxrest.domain.Vendor;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface VendorRepository extends ReactiveMongoRepository<Vendor, String> {
}
