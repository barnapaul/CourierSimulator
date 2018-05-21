import java.util.ArrayList;

public class Parcel implements IStorageParcel {


    public ArrayList products = new ArrayList<>();
    private String name;
    private IParcelState parcelState;

    public void setParcelState(IParcelState parcelState) {
        this.parcelState = parcelState;
    }

    public IParcelState getParcelState() {
        return parcelState;
    }


    public ArrayList getProducts() {
        return products;
    }

    public String getName() {
        return name;
    }

    public Parcel(String name) {
        this.name = name;

    }

    public void add(Object obj) {
        products.add(obj);
    }


    @Override
    public void lsParcel() {
        System.out.println(DepositStructure.compositeBuilder + name);
        DepositStructure.compositeBuilder.append("   ");
        for (Object obj : products) {
            IStorageParcel storageObject = (IStorageParcel) obj;
            storageObject.lsParcel();
        }

        DepositStructure.compositeBuilder.setLength(DepositStructure.compositeBuilder.length() - 3);
    }


}
