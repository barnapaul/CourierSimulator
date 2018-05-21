public class TransitParcel implements IParcelState {

    private Parcel parcel;


    @Override
    public String getParcelStateMessage() {
        return " IS IN TRANSIT \n\n";
    }

    public TransitParcel(Parcel parcel) {
        this.parcel = parcel;
    }


}

