package pl.bgulowaty;

public interface RentableItem {

    Price calculateRentalPrice(RentalRequest rentalRequest);


    boolean canBeRentedFor(RentalRequest rentalRequest);
}
