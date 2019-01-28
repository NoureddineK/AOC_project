package test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import main.canal.Canal;
import main.diffusion.*;
import main.generator.*;
/**
 * @author Noureddine KADRI  
 * @author Fahim MERZOUK
 * 
 * Testing Causal Diffusion
 */
@RunWith(MockitoJUnitRunner.class)
class CausalDiffusionTest {

	@Mock
	private Canal mockCanal;
	@Mock
	private AtomicDiffusion mockAtomicDiffusion;
	@Mock
	private Generator generator;
	@Mock
	private Generator mockGenerator;
	@Mock
	private CausalDiffusion causalDiffusion;
	@Mock
	private CausalDiffusion mockCausalDiffusion;

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Before
	public void beforeCausalDiffTest() {
		causalDiffusion = new CausalDiffusion();
	}
	
	@Test
	public void testCausalDiffusion() {
		generator = new GeneratorAsync();
		mockGenerator = mock(GeneratorAsync.class);
		
		causalDiffusion = new CausalDiffusion();
		mockCausalDiffusion = mock(CausalDiffusion.class);
		
		generator.setDiffusion(mockCausalDiffusion);
		verify(mockCausalDiffusion).configureDiffusion(generator, 0);
		
		causalDiffusion.setGenerator(mockGenerator);
		causalDiffusion.executeDiffusion();
		
		verify(mockGenerator).getDiffusionValue();
		verify(mockGenerator).getCycleValue();
	}

	@After
	public void end() throws Exception {
		generator = null;
		mockGenerator = null;
		mockAtomicDiffusion = null;
		causalDiffusion = null;
		mockCausalDiffusion = null;
	}

}
