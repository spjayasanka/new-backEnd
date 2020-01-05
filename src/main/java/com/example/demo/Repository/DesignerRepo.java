package com.example.demo.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Designer;

import javax.persistence.Entity;
import java.util.List;


@Repository
public interface DesignerRepo extends JpaRepository<Designer, Integer> {
    //List<Designer> findById(int id);
    Designer findByFirstname(String firstname);


}