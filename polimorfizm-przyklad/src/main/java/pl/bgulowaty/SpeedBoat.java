package pl.bgulowaty;

public class SpeedBoat implements RentableItem {
    private final Price basePrice;
    private final int maxPassengers;

    public SpeedBoat(Price basePrice, int maxPassengers) {
        this.basePrice = basePrice;
        this.maxPassengers = maxPassengers;
    }

    @Override
    public Price calculateRentalPrice(RentalRequest rentalRequest) {
        return basePrice;
    }

    @Override
    public boolean canBeRentedFor(RentalRequest rentalRequest) {
        return rentalRequest.amountOfPeople() <= maxPassengers ||
                (rentalRequest.isOrganizedGroup() && (rentalRequest.amountOfPeople() - 2 <= maxPassengers));
    }
}
