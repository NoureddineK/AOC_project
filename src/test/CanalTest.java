package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.swing.JTextArea;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import main.canal.CanalImp;
import main.generator.Generator;
import main.generator.GeneratorAsync;
import main.view.Display;
/**
 * @author Noureddine KADRI  
 * @author Fahim MERZOUK
 * 
 * Testing Canal
 */
@RunWith(MockitoJUnitRunner.class)
public class CanalTest {
	private Display display;
	private Generator generator;

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Before
	public void beforeTestCanal() throws Exception {
		display = new Display(new JTextArea());
		generator = new GeneratorAsync();
	}
	
	@Test
	public void testingCanal() {
		CanalImp canal = new CanalImp(generator);
		canal.setDisplay(display);
		assertEquals(display, canal.getDisplay());
		
		canal.attach(display);
		assertEquals(display, canal.getDisplay());
		
		canal.detach(display);
		assertEquals(canal.getDisplay(), null);
		
		canal.setGenerator(generator);
		assertEquals(canal.getGenerator(), generator);
	}

	@After
	public void end() throws Exception {
		display = null;
		generator = null;
	}
}
