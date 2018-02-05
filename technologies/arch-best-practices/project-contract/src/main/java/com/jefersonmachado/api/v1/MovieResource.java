package com.jefersonmachado.api.v1;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

public interface MovieResource {

    List<Movie> list();

    ResponseBody find(@PathVariable("movies") List<String> movies);

    ResponseBody save(@RequestBody Movie movie);

}
