import static org.junit.jupiter.api.Assertions.*;
/*
@author Isabelle Kramer
 */

class ProductTest {

    Product p1;
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        p1 = new Product("minecraft", "more squares", "000001", 25.00);
    }

    @org.junit.jupiter.api.Test
    void getName() {assertEquals("minecraft", p1.getName());
    }

    @org.junit.jupiter.api.Test
    void setName() {
    }

    @org.junit.jupiter.api.Test
    void getDescription() {assertEquals("more squares", p1.getDescription());
    }

    @org.junit.jupiter.api.Test
    void setDescription() {
    }

    @org.junit.jupiter.api.Test
    void getID() {assertEquals("000001", p1.getID());
    }

    @org.junit.jupiter.api.Test
    void setID() {
    }

    @org.junit.jupiter.api.Test
    void getCost() {assertEquals(25.00, p1.getCost());
    }

    @org.junit.jupiter.api.Test
    void setCost() {
    }

    @org.junit.jupiter.api.Test
    void testToString() {
    }

    @org.junit.jupiter.api.Test
    void toCSVRecord() {
    }
}