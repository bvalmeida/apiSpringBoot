package br.com.covid.controller;

import br.com.covid.ports.input.InputPort;
import br.com.covid.ports.interfaces.input.Input;
import br.com.covid.request.Request;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hospitais")
public class Controller {

    private final Input input;

    public Controller(Input input) {
        this.input = input;
    }

    @PostMapping
    public void save(@RequestBody Request request){
        this.input.save(request.converteInputPort(request));
    }
}
