package ataraszkiewicz.repo;

import ataraszkiewicz.documents.Noise;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoiseRepo extends CrudRepository<Noise, String> {

    List<Noise> findAll();
}