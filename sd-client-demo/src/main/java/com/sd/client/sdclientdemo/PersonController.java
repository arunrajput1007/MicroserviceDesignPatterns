package com.sd.client.sdclientdemo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@RestController
@RequestMapping("person")
@Slf4j
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping("{personId}")
    public Person getPerson(@PathVariable("personId") Long id){
        log.info("request received to fetch person with id:"+id);
        return personRepository.findById(id).get();
    }

    @PostMapping
    public void savePerson(@RequestBody Person person){
        personRepository.save(person);
    }
}

@Data
@Table(name = "person")
@Entity
@AllArgsConstructor
@NoArgsConstructor
class Person{
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String city;
}

interface PersonRepository extends JpaRepository<Person,Long>{}