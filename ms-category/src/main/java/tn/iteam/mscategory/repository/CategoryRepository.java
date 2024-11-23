package tn.iteam.mscategory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.iteam.mscategory.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
