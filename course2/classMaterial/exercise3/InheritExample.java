package exercise3;
public class InheritExample {
    
    public interface Vehicle {
        void accelerate(int amount);
        void brake(int amount);
        String getMakeModel();
        int getCurrentSpeed();
    }
    
    public static class Sedan implements Vehicle {
        int currentSpeed = 0;
        String sedanDesc;
        
        public Sedan(String sedanDesc) {
            this.sedanDesc = sedanDesc;
        }
        
        public void accelerate(int amount) {
            this.currentSpeed += amount;
        }
            
        public void brake(int amount) {
            this.currentSpeed -= amount;
        }
        
        public String getMakeModel() {
            return this.sedanDesc;
        }
        
        public int getCurrentSpeed() {
            return this.currentSpeed;
        }
    }
    
    public static class Truck implements Vehicle {
        int currentSpeed = 0;
        String truckDesc;
        
        public Truck(String truckDesc) {
            this.truckDesc = truckDesc;
        }
        
        public void accelerate(int amount) {
            this.currentSpeed += amount;
        }
            
        public void brake(int amount) {
            this.currentSpeed -= (amount / 2);
        }
        
        public String getMakeModel() {
            return this.truckDesc;
        }
        
        public int getCurrentSpeed() {
            return this.currentSpeed;
        }
    }

    public static String printCarInfo(Vehicle v) {
        return String.format("Car Make Model: %s, Current Speed %d", 
            v.getMakeModel(), v.getCurrentSpeed());
    }

    public static void main(String[] args) {
        Sedan s = new Sedan("Lexus LS");
        s.accelerate(75);
        s.brake(10);
        
        Vehicle t = new Truck("Ford F150");
        t.accelerate(75);
        t.brake(10);
        
        InheritExample.printCarInfo(t);
    }
}