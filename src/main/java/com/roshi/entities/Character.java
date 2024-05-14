package com.roshi.entities;

import com.roshi.enums.AssistanceEnum;
import com.roshi.enums.TypeEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Character {

    private Long id;
    private String name;
    private Sequence sequence; // bnb, blockstring, okizeme, tod e optimal
    private AssistanceEnum assistanceEnum; // a | b | c
    private TypeEnum typeEnum; // point | mid | anchor


}
