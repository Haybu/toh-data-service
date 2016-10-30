package io.agilehandy.heroes;

import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Created by hxm3459 on 10/29/16.
 */
@RestController
public class HeroController {

    HeroRepository repository;

    public HeroController(HeroRepository repo) {
        repository = repo;
    }

    @GetMapping("/data/heroes")
    public Collection<Hero> getAll() {
        return repository.findAll();
    }

    @GetMapping("/data/heroes/{id}")
    public Hero getById(@PathVariable("id") Long id) {
        return repository.findOne(id);
    }

    @PostMapping("/data/heroes")
    public Hero add(@RequestBody Hero hero) {
        return repository.save(hero);
    }

    @PutMapping("/data/heroes")
    public Hero update(@RequestBody Hero hero) {
        return repository.save(hero);
    }

    @DeleteMapping("/data/heroes/{id}")
    public Hero removeById(@PathVariable("id") Long id) {
        Hero hero = getById(id);
        if (hero != null) {
            repository.delete(hero);
        }
        return hero;
    }

}
