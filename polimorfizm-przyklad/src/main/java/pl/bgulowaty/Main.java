package pl.bgulowaty;

import java.util.List;

public class Main {
    private static final List<RentableItem> rentalCatalogue = List.of(
            new Kayak(Price.of(20d), 4),
            new Kayak(Price.of(10d), 5),
            new Kayak(Price.of(10d), 3),
            new SpeedBoat(Price.of(60d), 60),
            new SpeedBoat(Price.of(60d), 25)
    );

    public static void main(String[] args) {
        RentalRequest rentalRequest = new RentalRequest(20, true);
        RentableItem rentableItem = findFirstRentable(rentalRequest);

        if (rentableItem != null) {
            Price price = rentableItem.calculateRentalPrice(rentalRequest);

            System.out.println("You need to pay " + price);
            // process payment

            rentalCatalogue.remove(rentableItem);
        } else {
            System.out.println("Sorry, we dont have available boats atm");
        }
    }

    private static RentableItem findFirstRentable(RentalRequest rentalRequest) {
        return rentalCatalogue.stream()
                .filter(it -> it.canBeRentedFor(rentalRequest))
                .findFirst()
                .orElse(null);
    }
}
