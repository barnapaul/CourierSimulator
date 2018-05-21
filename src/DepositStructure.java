import java.util.ArrayList;
import java.util.Scanner;

public class DepositStructure {

    public static StringBuilder compositeBuilder = new StringBuilder();
    private ArrayList productState = new ArrayList();
    private String userNameParcel = " ";


    private void addObject(Object obj) {
        productState.add(obj);
    }

    public void ListDepositStructure() {

        Parcel europe = new Parcel("EUROPE");


        Parcel parcel1 = new Parcel("GREECE");
        Product product1 = new Product("ATHENS");
        TransitParcel transit1 = new TransitParcel(parcel1);

        Parcel parcel2 = new Parcel("ROMANIA");
        Product product2 = new Product("ORADEA");
        DepositParcel deposit1 = new DepositParcel(parcel2);


        parcel1.add(product1);
        parcel2.add(product2);

        parcel1.setParcelState(transit1);
        parcel2.setParcelState(deposit1);

        addObject(parcel1);
        addObject(parcel2);


        System.out.print("SHOW ALL PARCELS FROM DEPOSIT\n");
        parcel1.lsParcel();
        parcel2.lsParcel();

        findParcel();

    }

    private void findParcel() {
        do {
            System.out.print("\n\nENTER YOUR PARCEL NAME\n");
            getUserInput();
            boolean parcelExist = false;

            for (Object obj : productState) {
                IStorageParcel parcel = (IStorageParcel) obj;

                if (userNameParcel.equals(parcel.getName()) && parcel.getParcelState() != null) {
                    System.out.print("THE PARCEL WITH DESTINATION " + parcel.getName() + parcel.getParcelState().getParcelStateMessage());
                    parcelExist = true;
                    break;
                }

                // Incercare pentru a spune starea produsul in functie de colet
//                else {
//                    for (Object object : Parcel.getProducts()) {
//                        IStorageParcel file = (IStorageParcel) object;
//                        if (userNameParcel.equals(file.getName()) && parcel.getParcelState() != null) {
//                            System.out.print("THE PARCEL WITH DESTINATION " + file.getName() + parcel.getParcelState().getParcelStateMessage());
//                            parcelExist = true;
//                            break;
//                        }
//                    }
//
//                }
            }
            if (!parcelExist) {
                Parcel lost = new Parcel(userNameParcel);
                LostParcel lostParcel = new LostParcel(lost);
                lost.setParcelState(lostParcel);
                System.out.print("THE PARCEL WITH DESTINATION " + lost.getName() + lost.getParcelState().getParcelStateMessage());
                break;
            }

        } while (!userNameParcel.equals("EXIT"));
    }

    private String getUserInput() throws NumberFormatException {
        Scanner in = new Scanner(System.in);
        userNameParcel = String.valueOf(in.nextLine());

        return userNameParcel + "\n";
    }


}