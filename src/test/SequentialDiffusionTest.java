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

@RunWith(MockitoJUnitRunner.class)
class SequentialDiffusionTest {

	@Mock
	private Canal mockCanal;
	@Mock
	private Generator generator;
	@Mock
	private Generator mockGenerator;
	@Mock
	private SequentialDiffusion sequentialDiffusion;
	@Mock
	private SequentialDiffusion mockSequentialDiffusion;

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Before
	public void beforeSeqDiffTest() {
		sequentialDiffusion = new SequentialDiffusion();
	}

	@Test
	public void testSequentialDiffusion() {
		generator = new GeneratorAsync();
		mockGenerator = mock(GeneratorAsync.class);
		
		sequentialDiffusion = new SequentialDiffusion();
		mockSequentialDiffusion = mock(SequentialDiffusion.class);
		
		generator.setDiffusion(mockSequentialDiffusion);
		verify(mockSequentialDiffusion).configureDiffusion(generator, 0);
		
		sequentialDiffusion.setGenerator(mockGenerator);
		sequentialDiffusion.executeDiffusion();
		
		verify(mockGenerator).getDiffusionValue();
		verify(mockGenerator).notifyObservers();
	}

	@After
	public void end() throws Exception {
		generator = null;
		mockGenerator = null;
		sequentialDiffusion = null;
		mockSequentialDiffusion = null;
	}
}
