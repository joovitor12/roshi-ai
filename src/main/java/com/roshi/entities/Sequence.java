package com.roshi.entities;

import com.roshi.enums.SequenceTypeEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Sequence {

    private Long id;
    private String sequence;
    private SequenceTypeEnum sequenceTypeEnum;


}
