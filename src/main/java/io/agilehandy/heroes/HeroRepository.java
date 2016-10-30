package io.agilehandy.heroes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.Collection;

/**
 * Created by hxm3459 on 10/29/16.
 */
@RepositoryRestResource
public interface HeroRepository extends JpaRepository<Hero,Long> {

    @RestResource(path = "by-name")
    public Collection<Hero> findByName(@Param("name") String name);

}
