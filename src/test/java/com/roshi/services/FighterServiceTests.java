package com.roshi.services;

import com.roshi.entities.Fighter;
import com.roshi.enums.TypeEnum;
import com.roshi.repositories.FighterzRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

        // Act
        List<Fighter> actualFighters = service.getAll();

        // Assert
        assertEquals(expectedFighters, actualFighters);
    }
}
