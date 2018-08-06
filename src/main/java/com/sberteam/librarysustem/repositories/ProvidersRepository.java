package com.sberteam.librarysustem.repositories;

import com.sberteam.librarysustem.models.Providers;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvidersRepository extends CrudRepository<Providers,Long> {
}
