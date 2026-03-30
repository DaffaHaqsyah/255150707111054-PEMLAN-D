public class laprakvehicle1 {

    private double load;
    private static final double maxLoad;

    public laprakvehicle1(double max) {
        this.maxLoad = max; // ERROR disini
    }

    public double getLoad() {
        return this.load;
    }

    public double getMaxLoad() {
        return this.maxLoad;
    }

    public boolean addBox(double weight) {
        double temp = 0.0D;
        temp = this.load + weight;

        if (temp <= maxLoad) {
            this.load = this.load + weight;
            return true;
        } else {
            return false;
        }
    }
}

