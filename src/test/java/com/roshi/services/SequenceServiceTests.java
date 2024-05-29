package com.roshi.services;

import com.roshi.entities.Fighter;
import com.roshi.entities.Sequence;
import com.roshi.enums.SequenceTypeEnum;
import com.roshi.enums.TypeEnum;
import com.roshi.exceptions.ResourceNotFoundException;
import com.roshi.repositories.FighterzRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

public class SequenceServiceTests {

    @InjectMocks
    private SequenceService sequenceService;

    @Mock
    private FighterzRepository repository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSave() {
        String id = "1";
        Sequence sequence = new Sequence("2M > 5M > j.M > j.S > j.236L > {Sparking} > j.66 > j.M > j.S, 5M > 2S > sj.LL > j.S > j.236S(5) (hold down) > [Vanish] > j.M > j.2H > SD > j.LL > j.2H > j.LL > j.S > j.214L(2) > 1-Super (L+M) > 1-Super (H+S)", SequenceTypeEnum.TOD);
        Fighter fighter = new Fighter("Goku (SSJ)", new ArrayList<>(),TypeEnum.FLEXIBLE);
        fighter.setSequences(List.of(sequence));

        when(repository.findById(id)).thenReturn(Optional.of(fighter));

        Sequence result = sequenceService.save(sequence, id);

        assertEquals(sequence, result);
        verify(repository, times(1)).save(fighter);
    }

    @Test
    public void testSaveResourceNotFound() {
        String id = "1";
        Sequence sequence = new Sequence("2M > 5M > j.M > j.S > j.236L > {Sparking} > j.66 > j.M > j.S, 5M > 2S > sj.LL > j.S > j.236S(5) (hold down) > [Vanish] > j.M > j.2H > SD > j.LL > j.2H > j.LL > j.S > j.214L(2) > 1-Super (L+M) > 1-Super (H+S)", SequenceTypeEnum.TOD);

        when(repository.findById(id)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> sequenceService.save(sequence, id));
    }

    @Test
    public void testGetSequences() {
        String id = "1";
        Sequence sequence = new Sequence("2M > 5M > j.M > j.S > j.236L > {Sparking} > j.66 > j.M > j.S, 5M > 2S > sj.LL > j.S > j.236S(5) (hold down) > [Vanish] > j.M > j.2H > SD > j.LL > j.2H > j.LL > j.S > j.214L(2) > 1-Super (L+M) > 1-Super (H+S)", SequenceTypeEnum.TOD);
        Fighter fighter = new Fighter("Goku (SSJ)", new ArrayList<>(),TypeEnum.FLEXIBLE);
        fighter.setSequences(List.of(sequence));

        when(repository.findById(id)).thenReturn(Optional.of(fighter));

        List<Sequence> result = sequenceService.getSequences(id);

        assertEquals(1, result.size());
        assertEquals(sequence, result.get(0));
    }

    @Test
    public void testGetSequencesResourceNotFound() {
        String id = "1";

        when(repository.findById(id)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> sequenceService.getSequences(id));
    }
}
