package br.com.covid.presenter.entity;

import br.com.covid.core.data.output.ItemOutputPort;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int quantidade;
    private Integer pontosDoItem;
    private TipoDoItem tipoDoItem;

    public static List<Item> itemOutputPortToEntity(List<ItemOutputPort> itemOutputPort){

        List<Item> listaDeItemParaEntity = new ArrayList<>();
        itemOutputPort.forEach(item -> {
            var itemEntity = Item.builder()
                    .pontosDoItem(item.getPontosDoItem())
                    .quantidade(item.getQuantidade())
                    .tipoDoItem(TipoDoItem.valueOf(item.getTipoItem()))
                    .build();
            listaDeItemParaEntity.add(itemEntity);
        });
        return listaDeItemParaEntity;
    }

    public static List<ItemOutputPort> itemEntityToOutputPort(List<Item> item){

        List<ItemOutputPort> itensParaOutputPort = new ArrayList<>();
        item.forEach(items ->{
            ItemOutputPort itemOutputPort = ItemOutputPort.builder()
                    .id(items.getId())
                    .quantidade(items.getQuantidade())
                    .tipoItem(items.tipoDoItem.getDescricao())
                    .pontosDoItem(items.getPontosDoItem())
                    .build();
            itensParaOutputPort.add(itemOutputPort);
        });
        return itensParaOutputPort;
    }
}
