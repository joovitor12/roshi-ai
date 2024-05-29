package com.roshi.services;

import com.roshi.entities.Fighter;
import com.roshi.enums.TypeEnum;
import com.roshi.repositories.FighterzRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class FighterServiceTests {

    @InjectMocks
    FighterService service;

    @Mock
    FighterzRepository repository;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void getAllTest() {
        Fighter fighter1 = new Fighter("Goku (SSJ)", new ArrayList<>(), TypeEnum.FLEXIBLE);
        Fighter fighter2 = new Fighter("Vegeta (SSJ)", new ArrayList<>(), TypeEnum.POINT);
        List<Fighter> expectedFighters = Arrays.asList(fighter1, fighter2);

        when(repository.findAll()).thenReturn(expectedFighters);

        List<Fighter> actualFighters = service.getAll();

        assertEquals(expectedFighters, actualFighters);
    }

    @Test
    public void saveTest() {
        Fighter fighter = new Fighter("Goku (SSJ)", new ArrayList<>(), TypeEnum.FLEXIBLE);

        when(repository.save(Mockito.any(Fighter.class))).thenReturn(fighter);

        Fighter savedFighter = service.save(fighter);

        assertEquals(fighter, savedFighter);
    }

    @Test
    public void getByIdTest() {
        Fighter fighter = new Fighter("Goku (SSJ)", new ArrayList<>(), TypeEnum.FLEXIBLE);
        String id = "123";

        when(repository.findById(id)).thenReturn(Optional.of(fighter));

        Fighter foundFighter = service.getById(id);

        assertEquals(fighter, foundFighter);
    }
}
