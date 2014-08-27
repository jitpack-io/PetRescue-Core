package com.systemsinmotion.petrescue.datamanager;

import static org.mockito.Mockito.*;

import java.util.Random;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.junit.Before;
import org.junit.Test;

import com.systemsinmotion.petrescue.data.BreedRepository;
import com.systemsinmotion.petrescue.datamanager.BreedManager;
import com.systemsinmotion.petrescue.entity.Breed;


public class BreedManagerTest {
	Random random = new Random();
	
	@InjectMocks
	private BreedManager breedService;
	
	@Mock
	private Breed mockBreed;
	
	@Mock
	private BreedRepository mockBreedRepository;
	
	@Before
	public void intialize(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void findAllBreedsByAnimalType() throws Exception {
		String animalType = mockBreed.getAnimalType();
		breedService.findAllBreedsByAnimalType(animalType);
		verify(mockBreedRepository).findAllBreedsByAnimalType(animalType);
	}

	@Test
	public void findById() throws Exception {
		int id = random.nextInt();
		breedService.findById(id);
		verify(mockBreedRepository).findOne(id);
	}

	@Test
	public void findAllBreeds() throws Exception {
		breedService.findAllBreeds();
		verify(mockBreedRepository).findAll();
	}
	
	@Test
	public void storeBreed() throws Exception {
		breedService.storeBreed(mockBreed);
		verify(mockBreedRepository).saveAndFlush(mockBreed);
	}

	@Test
	public void removeBreed() throws Exception {
		breedService.removeBreed(mockBreed);
		verify(mockBreedRepository).delete(mockBreed);
	}

}