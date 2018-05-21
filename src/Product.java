
public class Product implements IStorageParcel {

    private String name;
    private Parcel parcel;

    public Product(String name) {
        this.name = name;
    }

    @Override
    public void lsParcel() {
        System.out.println(DepositStructure.compositeBuilder + name);
    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public IParcelState getParcelState() {
        return parcel.getParcelState();
    }


}
