package com.sberteam.librarysustem.repositories;

import com.sberteam.librarysustem.models.Languages;
import com.sberteam.librarysustem.models.Roles;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguagesRepository extends CrudRepository<Languages, Long> {
}
