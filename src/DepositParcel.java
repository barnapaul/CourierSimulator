public class DepositParcel implements IParcelState {

    private Parcel parcel;


    @Override
    public String getParcelStateMessage() {
        return " IS IN DEPOSIT\n\n";
    }

    public DepositParcel(Parcel parcel) {
        this.parcel = parcel;
    }
}
