package cookiethread.services;

import controller.Cookies;
import java.util.ArrayList;
import java.util.List;

public class CookieManagement {


    private List<String> mainArraylist = new ArrayList<>();
    private int jarSize = 0;
    private Object monitor = new Object();


    public void setJarSize(int jarSize) {
        this.jarSize = jarSize;
    }

    public int getJarSize() {
        return jarSize;
    }

    public List<String> getMainArraylist() {

        return this.mainArraylist;
    }


    public void addWhite(List<String> arrayList, Cookies cookies, int sizeOfJAr) {

        while (arrayList.size() < sizeOfJAr ) {
            try {
                synchronized (monitor) {
                    if (arrayList.size() < sizeOfJAr) {
                        arrayList.add(cookies.getWhite());
                        System.out.println("White   Cookie - > " + arrayList.size() + " Added");
                    }
                }
                Thread.sleep(25);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public void addChocolate(List<String> arrayList, Cookies cookies, int sizeOfJAr) {


        while (arrayList.size() < sizeOfJAr ) {
            try {
                synchronized (monitor) {
                    if (arrayList.size() < sizeOfJAr) {
                        arrayList.add(cookies.getChocolate());
                        System.out.println("Choco   Cookie - > " + arrayList.size() + " Added");
                    }
                }
                Thread.sleep(137);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public void addCaramel(List<String> arrayList, Cookies cookies, int sizeOfJAr) {

        while (arrayList.size() < sizeOfJAr ) {
            try {
                synchronized (monitor) {
                if (arrayList.size() < sizeOfJAr) {
                        arrayList.add(cookies.getCaramel());
                        System.out.println("Caramel Cookie - > " + arrayList.size() + " Added");
                    }
                }
                Thread.sleep(330);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}




