public class Data {
    String hobbies;
    String phoneNumber;
    String address;

    public Data(String hobbies, String pn, String addrs) {
        this.hobbies = hobbies;
        this.phoneNumber = pn;
        this.address = addrs;
    }

    public String toString() {
        return hobbies + " " + phoneNumber + " " + address;
    }
}
