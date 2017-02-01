package com.jefersonmachado.api.v1;

import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/movie")
public class MovieResourceImpl implements MovieResource {

    @RequestMapping(value = "/", method= RequestMethod.GET)
    public List<Movie> list() {
        return Collections.singletonList(new Movie("Avengers", "Action"));
    }

    public ResponseBody find(@PathVariable("movies") List<String> movies) {
        return null;
    }

    public ResponseBody save(@RequestBody Movie movie) {
        return null;
    }
}
