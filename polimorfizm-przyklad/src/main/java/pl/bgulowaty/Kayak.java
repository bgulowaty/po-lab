package pl.bgulowaty;

public class Kayak implements RentableItem {

    private final Price basePrice;
    private final int maxPassengers;

    public Kayak(Price basePrice, int maxPassengers) {
        this.basePrice = basePrice;
        this.maxPassengers = maxPassengers;
    }

    @Override
    public Price calculateRentalPrice(RentalRequest rentalRequest) {
        if (rentalRequest.isOrganizedGroup()) {
            return Price.of(basePrice.value() * rentalRequest.amountOfPeople() * 0.8);
        } else {
            return Price.of(basePrice.value() * rentalRequest.amountOfPeople());
        }
    }

    @Override
    public boolean canBeRentedFor(RentalRequest rentalRequest) {
        return rentalRequest.amountOfPeople() <= maxPassengers;
    }
}
