package br.com.covid.ports.usecase;

import br.com.covid.ports.input.InputPort;
import br.com.covid.ports.interfaces.input.Input;
import br.com.covid.ports.interfaces.output.Output;
import br.com.covid.ports.output.OutputPort;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Data
public class InputImpl implements Input {

    @Autowired
    private final Output output;

    public InputImpl(Output output) {
        this.output = output;
    }


    @Override
    public void save(InputPort inputPort){
        this.output.save(OutputPort.converteOutputPort(inputPort));
    }
}
