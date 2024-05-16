package com.roshi.entities;


import com.roshi.enums.TypeEnum;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Document(collection = "fighters")
public class Fighter {

    @Id
    private String id;
    private String name;
    private List<Sequence> sequences; // bnb, blockstring, okizeme, tod e optimal
    private TypeEnum type; // point | mid | anchor


    public Fighter (String name, List<Sequence> sequences, TypeEnum type) {
        this.name = name;
        this.sequences = new ArrayList<>();
        this.type = type;
    }


}
