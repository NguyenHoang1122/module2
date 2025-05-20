import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangleClassifierTest {

    @Test
    void testEquilateralTriangle() {
        assertEquals("Tam giác đều", TriangleClassifier.classify(3,3,3));
    }

    @Test
    void testIsoscelesTriangle() {
        assertEquals("Tam giác cân",  TriangleClassifier.classify(4,7,4));
    }

    @Test
    void testScaleneTriangle(){
        assertEquals("Tam giác thường", TriangleClassifier.classify(3,5,7));
    }

    @Test
    void testNotATriangle(){
        assertEquals("Không phải là tam giác", TriangleClassifier.classify(1,5,7));
    }

    @Test
    void testNegativeSide(){
        assertEquals("Không phải là tam giác", TriangleClassifier.classify(-1,5,7));
    }
    @Test
    void testZeroSide(){
        assertEquals("Không phải là tam giác",  TriangleClassifier.classify(0,5,7));
    }
}