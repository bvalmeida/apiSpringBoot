package br.com.covid.ports.usecase;

import br.com.covid.ports.input.InputPort;
import br.com.covid.ports.interfaces.input.Input;
import br.com.covid.ports.interfaces.output.Output;
import org.springframework.stereotype.Service;

@Service
public class InputImpl implements Input {

    private final Output output;

    public InputImpl(Output output) {
        this.output = output;
    }


    @Override
    public void save(InputPort inputPort){
        this.output.save(inputPort.converteOutputPort(inputPort));
    }
}
