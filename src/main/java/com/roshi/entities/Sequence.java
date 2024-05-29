package com.roshi.entities;

import com.roshi.enums.SequenceTypeEnum;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
public class Sequence {

    private String sequence;
    private SequenceTypeEnum sequenceType;

    public Sequence(String sequence, SequenceTypeEnum sequenceType) {
        this.sequence = sequence;
        this.sequenceType = sequenceType;
    }


}
