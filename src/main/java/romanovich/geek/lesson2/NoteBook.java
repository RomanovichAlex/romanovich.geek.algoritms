package romanovich.geek.lesson2;


    public class NoteBook implements Comparable<NoteBook> {
        int price;
        int ramValue;
        Manufacturer manufacturer;

        public NoteBook(int price, int ramValue, Manufacturer manufacturer) {

            this.price = price;
            this.ramValue = ramValue;
            this.manufacturer = manufacturer;
        }


        public int getPrice() {
        return price;
    }


    public int getRamValue() {
        return ramValue;
    }



    public Manufacturer getManufacturer() {
        return manufacturer;
    }


    public int compareTo(NoteBook noteBook) {
        int result = Integer.compare(price,noteBook.getPrice());
        if (result == 0) {
            result =  Integer.compare(ramValue, noteBook.getRamValue());
            if (result == 0) {
                return manufacturer.compareTo(noteBook.getManufacturer());
            }
            return result;
        }
        return result;
    }


}
