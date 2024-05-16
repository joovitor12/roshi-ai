package com.roshi.entities;

import com.roshi.enums.AssistanceEnum;
import com.roshi.enums.TypeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Document(collection = "fighters")
public class Fighter {

    private String id;
    private String name;
    private List<Sequence> sequence; // bnb, blockstring, okizeme, tod e optimal
    private AssistanceEnum assistanceEnum; // a | b | c
    private TypeEnum typeEnum; // point | mid | anchor


}
