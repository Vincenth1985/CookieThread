package main;

import controller.Cookies;
import cookiethread.services.CookieManagement;
import cookiethread.services.DataWriterAndReader;

public class Main {

    public static void main(String[] args) {

        CookieManagement cookieManagement = new CookieManagement();
        cookieManagement.setJarSize(500);
        DataWriterAndReader dataWriterAndReader = new DataWriterAndReader();

        Cookies cookies = new Cookies();

        Thread thread = new Thread(() -> cookieManagement.addWhite(cookieManagement.getMainArraylist(), cookies
                , cookieManagement.getJarSize()));

        Thread thread2 = new Thread(() -> cookieManagement.addCaramel(cookieManagement.getMainArraylist(), cookies
                , cookieManagement.getJarSize()));

        Thread thread3 = new Thread(() -> cookieManagement.addChocolate(cookieManagement.getMainArraylist(), cookies
                , cookieManagement.getJarSize()));

        thread.start();
        thread2.start();
        thread3.start();

        try {
            System.out.println("Adding  is starting");
            System.out.println("=".repeat(25));
            thread.join();
            thread2.join();
            thread3.join();
            System.out.println("\nJar Is Full : " + cookieManagement.getMainArraylist().size() + " Cookies added");
            dataWriterAndReader.writeData(cookieManagement.getMainArraylist());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}



