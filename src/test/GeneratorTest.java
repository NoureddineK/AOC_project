package test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import main.diffusion.*;
import main.generator.*;
import main.instruction.DisplayController;
/**
 * @author Noureddine KADRI  
 * @author Fahim MERZOUK
 * Testing Generator
 */
@RunWith(MockitoJUnitRunner.class)
public class GeneratorTest {

	private Generator generator;
	@Mock
	private DisplayController mockDisplayController;
	private Diffusion diffusion;
	@Mock
	private Diffusion mockDiffusion;

	@Before
	public void beforeTestingGenerator() throws Exception {
		generator = new GeneratorAsync();
		mockDisplayController = mock(DisplayController.class);
		diffusion = new AtomicDiffusion();
		mockDiffusion = mock(AtomicDiffusion.class);
	}
	
	@Test
	public void testingGenerator() {
		generator.setDiffusion(diffusion);	
		assertEquals(diffusion, generator.getDiffusion());
		
		generator.setDiffusion(mockDiffusion);
		generator.getValue();
		verify(mockDiffusion).getDiffusionValue();
		
		generator.executeGenerator();
		verify(mockDiffusion).executeDiffusion();
		((GeneratorAsync) generator).setHologe(mockDisplayController);
		
		generator.start();
		verify(mockDisplayController).startDisplaying();
		
		generator.stop();
		verify(mockDisplayController).stopDisplaying();
	}

	@After
	public void end() throws Exception {
		generator = null;
		mockDisplayController = null;
		diffusion = null;
		mockDiffusion = null;
	}

}
