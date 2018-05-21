public class LostParcel implements IParcelState{

    private Parcel parcel;


    @Override
    public String getParcelStateMessage() {
        return " IS LOST \n\n";
    }

    public LostParcel(Parcel parcel) {
        this.parcel = parcel;
    }
}
