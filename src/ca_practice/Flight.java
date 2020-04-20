package ca_practice;

public class Flight {
    Integer capacity;
    Double duration;
    Passenger[] passengers;
    int i = 0;

    public Flight(Integer capacity, Double duration) {
        this.capacity = capacity;
        this.duration = duration;
        this.passengers = new Passenger[4];
    }

    public void fillList(Passenger passenger){
        passengers[i] = passenger;
        i++;
    }

    public void print(){
        System.out.println("Passenger list");
        System.out.printf("%-20s %-20s %s%n", "Name", "Age", "Baggage charge");
        for (Passenger passenger: passengers){
            System.out.printf("%-20s %-20d %,.2f%n", passenger.getName(), passenger.getAge(), passenger.calculateBaggage());
        }
    }

    public Integer checkAvailability(){
        return capacity - passengers.length;
    }

    public String calcOldestPassenger(){
        String oldest_person = passengers[0].getName();
        Integer highest_age = passengers[0].getAge();
        String oldest_return;

        for (Passenger passenger: passengers){
            if (passenger.getAge() > highest_age){
                highest_age = passenger.getAge();
                oldest_person = passenger.getName();
            }
        }

        oldest_return = oldest_person + " aged " + highest_age;

        return oldest_return;
    }

    public class Passenger{
        String name;
        Integer age;
        Double[] weight_of_bags;
        char[] size_of_bags;

        public Passenger(String name, Integer age, Double[] weight_of_bags, char[] size_of_bags) {
            this.name = name;
            this.age = age;
            this.weight_of_bags = weight_of_bags;
            this.size_of_bags = size_of_bags;
        }

        public String getName() {
            return name;
        }

        public Integer getAge() {
            return age;
        }

        public Double[] getWeight_of_bags() {
            return weight_of_bags;
        }

        public char[] getSize_of_bags() {
            return size_of_bags;
        }

        public Double calculateBaggage(){
            Double bag_charge = 0.0;
            Double initial_charge;
            Double extra_charge;

            for (Double bag_weight: weight_of_bags){
                if (bag_weight > 20){
                    initial_charge = 40.0;
                    extra_charge = (bag_weight - 20) * 10;
                    bag_charge += (initial_charge + extra_charge);

                } else if (bag_weight > 15){
                    bag_charge += 40.0;
                } else if (bag_weight <= 15){
                    bag_charge += 30.0;
                } else {
                    bag_charge += 0.0;
                }
            }

            return bag_charge;
        }
    }
}
