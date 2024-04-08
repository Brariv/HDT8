import static org.junit.Assert.assertEquals;
import java.util.ArrayList;

import org.junit.Test;

import com.Paciente;
import com.VectorHeap;

public class Test {

    private VectorHeap<Paciente> vector = new VectorHeap<Paciente>(new ArrayList<Paciente>());
    private Paciente paciente1 = new Paciente("Juan", "Fiebre", "A");

    @Test
    public void testAdd() {
        vector.add(paciente1);
        assertEquals(1, vector.size());
    }

    @Test
    public void testRemove() {
        vector.add(paciente1);
        vector.remove();
        assertEquals(0, vector.size());
    }

    @Test
    public void testGetFirst() {
        vector.add(paciente1);
        assertEquals(paciente1, vector.getFirst());
    }
    
}
