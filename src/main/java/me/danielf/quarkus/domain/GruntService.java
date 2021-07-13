package me.danielf.quarkus.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GruntService {
    private final List<Grunt> grunts = new ArrayList<>();
    private static long gruntId = 1;

    public List<Grunt> findAll() {
        return grunts;
    }

    public Grunt create(Grunt grunt) {
        grunt.setId(gruntId++);
        grunts.add(grunt);
        return grunt;
    }

    public Optional<Grunt> modify(Grunt grunt) {
        Optional<Grunt> opt = retrieve(grunt.getId());
        opt.ifPresent(g -> g.setNoise(grunt.getNoise()));
        return opt;
    }

    public boolean remove(Long id) {
        return grunts.removeIf(g -> g.getId().equals(id));
    }

    public Optional<Grunt> retrieve(Long id) {
        return grunts.stream().filter(g -> g.getId().equals(id)).findFirst();
    }


}
