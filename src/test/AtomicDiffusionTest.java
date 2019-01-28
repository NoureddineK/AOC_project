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
 * Testing Atomic Diffusion
 */
@RunWith(MockitoJUnitRunner.class)
class AtomicDiffusionTest {

	@Mock
	private Canal mockCanal;
	@Mock
	private AtomicDiffusion atomicDiffusion;
	@Mock
	private AtomicDiffusion mockAtomicDiffusion;
	@Mock
	private Generator generator;
	@Mock
	private Generator mockGenerator;
	@Mock
	private SequentialDiffusion sequentialDiffusion;
	@Mock
	private SequentialDiffusion mockSequentialDiffusion;
	@Mock
	private CausalDiffusion causalDiffusion;
	@Mock
	private CausalDiffusion mockCausalDiffusion;

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Before
	public void beforeAtomicDiffTest() {
		atomicDiffusion = new AtomicDiffusion();
	}

	@Test
	public void testAtomicDiffusion() {
		generator = new GeneratorAsync();
		mockGenerator = mock(Generator.class);
		
		atomicDiffusion = new AtomicDiffusion();
		mockAtomicDiffusion = mock(AtomicDiffusion.class);
		
		generator.setDiffusion(mockAtomicDiffusion);
		verify(mockAtomicDiffusion).configureDiffusion(generator, 0);
		
		atomicDiffusion.setGenerator(mockGenerator);
		atomicDiffusion.executeDiffusion();
		
		verify(mockGenerator).getDiffusionValue();
		verify(mockGenerator).notifyObservers();
	}

	@After
	public void end() throws Exception {
		generator = null;
		mockGenerator = null;
		atomicDiffusion = null;
		mockAtomicDiffusion = null;
		sequentialDiffusion = null;
		mockSequentialDiffusion = null;
		causalDiffusion = null;
		mockCausalDiffusion = null;
	}
}
