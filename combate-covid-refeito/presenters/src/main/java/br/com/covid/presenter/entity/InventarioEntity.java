package br.com.covid.presenter.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InventarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer pontosDoInventario = 0;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "inventario_id")
    private List<Item> itens;

    public void calculaPontos(){
        if(this.itens == null){
            return;
        }

        this.itens.forEach(item -> {
            this.pontosDoInventario = item.getTipoDoItem().calculaPontosDoItem(item);
        });
    }

    public void adicionarItens(List<Item> itens){
        this.itens.addAll(itens);
    }

    public void adicionarItem(Item item){
        this.itens.add(item);
    }

}
