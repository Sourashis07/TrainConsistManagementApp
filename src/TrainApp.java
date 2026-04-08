import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrainConsistManagementAppTest_UC15 {

    static class CargoSafetyException extends RuntimeException {
        public CargoSafetyException(String message) {
            super(message);
        }
    }

    static class GoodsBogie {
        private String shape;
        private String cargo;
        private boolean finallyExecuted;

        public GoodsBogie(String shape) {
            this.shape = shape;
        }

        public void assignCargo(String cargo) {
            try {
                if (shape.equalsIgnoreCase("Rectangular") && cargo.equalsIgnoreCase("Petroleum")) {
                    throw new CargoSafetyException("Petroleum cannot be assigned to a Rectangular bogie");
                }
                this.cargo = cargo;
            } catch (CargoSafetyException e) {
                System.out.println("Error: " + e.getMessage());
            } finally {
                finallyExecuted = true;
                System.out.println("Cargo assignment attempt completed.");
            }
        }

        public String getShape() {
            return shape;
        }

        public String getCargo() {
            return cargo;
        }

        public boolean isFinallyExecuted() {
            return finallyExecuted;
        }
    }

    @Test
    void testCargo_SafeAssignment() {
        GoodsBogie bogie = new GoodsBogie("Cylindrical");
        bogie.assignCargo("Petroleum");

        assertEquals("Petroleum", bogie.getCargo());
    }

    @Test
    void testCargo_UnsafeAssignmentHandled() {
        GoodsBogie bogie = new GoodsBogie("Rectangular");

        assertDoesNotThrow(() -> bogie.assignCargo("Petroleum"));
        assertNull(bogie.getCargo());
    }

    @Test
    void testCargo_CargoNotAssignedAfterFailure() {
        GoodsBogie bogie = new GoodsBogie("Rectangular");
        bogie.assignCargo("Petroleum");

        assertNull(bogie.getCargo());
    }

    @Test
    void testCargo_ProgramContinuesAfterException() {
        GoodsBogie bogie1 = new GoodsBogie("Rectangular");
        GoodsBogie bogie2 = new GoodsBogie("Cylindrical");

        assertDoesNotThrow(() -> {
            bogie1.assignCargo("Petroleum");
            bogie2.assignCargo("Petroleum");
        });

        assertNull(bogie1.getCargo());
        assertEquals("Petroleum", bogie2.getCargo());
    }

    @Test
    void testCargo_FinallyBlockExecution() {
        GoodsBogie bogie1 = new GoodsBogie("Rectangular");
        GoodsBogie bogie2 = new GoodsBogie("Cylindrical");

        bogie1.assignCargo("Petroleum");
        bogie2.assignCargo("Coal");

        assertTrue(bogie1.isFinallyExecuted());
        assertTrue(bogie2.isFinallyExecuted());
    }
}